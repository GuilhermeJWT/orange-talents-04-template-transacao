package br.com.zupacademy.guilhermesantos.transacao.kafka;

import br.com.zupacademy.guilhermesantos.transacao.dto.ModelTransacaoDTO;
import br.com.zupacademy.guilhermesantos.transacao.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTransacao {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(ModelTransacaoDTO modelTransacaoDTO) {

        System.out.println("Realizando uma nova Transação");
        transacaoRepository.save(modelTransacaoDTO.converte());
        System.out.println(modelTransacaoDTO.getId());
        System.out.println(modelTransacaoDTO.getEfetivadaEm());
        System.out.println(modelTransacaoDTO.getCartao().getNumero());
        System.out.println(modelTransacaoDTO.getCartao().getEmail());
        System.out.println(modelTransacaoDTO.getEstabelecimento().getCidade());
        System.out.println(modelTransacaoDTO.getEstabelecimento().getEndereco());
        System.out.println(modelTransacaoDTO.getEstabelecimento().getNome());
        System.out.println(modelTransacaoDTO.getValor());
    }

}
