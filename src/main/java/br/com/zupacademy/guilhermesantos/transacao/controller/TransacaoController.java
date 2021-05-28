package br.com.zupacademy.guilhermesantos.transacao.controller;

import br.com.zupacademy.guilhermesantos.transacao.dto.ModelCartaoDTO;
import br.com.zupacademy.guilhermesantos.transacao.dto.ModelTransacaoDTO;
import br.com.zupacademy.guilhermesantos.transacao.feign.FeignTransacaoClient;
import br.com.zupacademy.guilhermesantos.transacao.model.ModelTransacao;
import br.com.zupacademy.guilhermesantos.transacao.repository.CartaoRepository;
import br.com.zupacademy.guilhermesantos.transacao.repository.TransacaoRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    @Autowired
    private FeignTransacaoClient feignTransacaoClient;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @PostMapping(value = "/{id}")
    public ResponseEntity<?> salva(@RequestBody @Valid ModelCartaoDTO modelCartaoDTO){
        try{
            feignTransacaoClient.iniciarTransacao(modelCartaoDTO);
            return ResponseEntity.ok("Transação Realizada com Sucesso!");/*200*/
        }catch(FeignException.FeignServerException | FeignException.FeignClientException exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarRecentes(@PathVariable String id) {

        List<ModelTransacao> modelTransacao = transacaoRepository.findFirst10ByCartaoIdOrderByEfetivadaEmDesc(id);

        if(modelTransacao.isEmpty()){
            return ResponseEntity.notFound().build();/*404*/
        }

        List<ModelTransacaoDTO> transacoesDTO = modelTransacao.stream().map(ModelTransacaoDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(transacoesDTO);/*200*/
    }

}
