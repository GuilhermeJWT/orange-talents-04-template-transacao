package br.com.zupacademy.guilhermesantos.transacao.dto;

import br.com.zupacademy.guilhermesantos.transacao.model.ModelTransacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ModelTransacaoDTO {

    private String id;
    private BigDecimal valor;
    private LocalDateTime efetivadaEm;
    private ModelEstabelecimentoResponseDTO estabelecimento;
    private ModelCartaoResponseDTO cartao;

    public ModelTransacao converte(){
        return new ModelTransacao(id, valor, cartao.converte(), estabelecimento.converte(), efetivadaEm);
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public ModelCartaoResponseDTO getCartao() {
        return cartao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public ModelEstabelecimentoResponseDTO getEstabelecimento() {
        return estabelecimento;
    }
}
