package br.com.zupacademy.guilhermesantos.transacao.controller;

import br.com.zupacademy.guilhermesantos.transacao.dto.ModelCartaoDTO;
import br.com.zupacademy.guilhermesantos.transacao.feign.FeignTransacaoClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/transacao")
public class TransacaoController {

    @Autowired
    private FeignTransacaoClient feignTransacaoClient;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> parar(@PathVariable("id") String id){
        try{
            feignTransacaoClient.pararTransacao(id);
            return ResponseEntity.ok("Opa deu tudo Certo!");/*200*/
        }catch (FeignException.FeignServerException | FeignException.FeignClientException exception){
            exception.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);/*400*/
        }
    }

}
