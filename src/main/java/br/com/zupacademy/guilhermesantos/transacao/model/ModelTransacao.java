package br.com.zupacademy.guilhermesantos.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "transacao")
public class ModelTransacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Positive(message = "O Valor deve ser maior que 0!")
    @NotNull(message = "O Valor deve ser Informado!")
    private BigDecimal valor;

    private LocalDateTime efetivadaEm;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private ModelEstabelecimento estabelecimento;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private ModelCartao cartao;

    public ModelTransacao(String id, BigDecimal valor,LocalDateTime efetivadaEm, ModelEstabelecimento estabelecimento, ModelCartao cartao) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    @Deprecated
    public ModelTransacao(){

    }

    public ModelTransacao(String id, BigDecimal valor, ModelCartao cartao, ModelEstabelecimento estabelecimento, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public ModelCartao getCartao() {
        return cartao;
    }

    public ModelEstabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelTransacao)) return false;
        ModelTransacao that = (ModelTransacao) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
