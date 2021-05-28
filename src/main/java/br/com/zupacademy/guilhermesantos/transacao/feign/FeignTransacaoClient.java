package br.com.zupacademy.guilhermesantos.transacao.feign;

import br.com.zupacademy.guilhermesantos.transacao.dto.ModelCartaoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "transacao", url = "${transacao.host}")
public interface FeignTransacaoClient {

    @PostMapping
    void iniciarTransacao(@RequestBody ModelCartaoDTO transacao);

    @DeleteMapping("/{id}")
    void pararTransacao(@PathVariable("id") String id);

}
