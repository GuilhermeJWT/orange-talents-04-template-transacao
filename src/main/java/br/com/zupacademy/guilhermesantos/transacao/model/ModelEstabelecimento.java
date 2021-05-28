package br.com.zupacademy.guilhermesantos.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "estabelecimento")
public class ModelEstabelecimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotNull(message = "O Nome não pode ser Vazio!")
    @NotBlank(message = "O Nome deve ser Informado!")
    private String nome;

    @NotNull(message = "A Cidade não pode ser Vázia!")
    @NotBlank(message = "A Cidade deve ser Informada!")
    private String cidade;

    @NotNull(message = "O Endereço não pode ser Nulo!")
    @NotBlank(message = "O Endereço deve ser Informado!")
    private String endereco;

    public ModelEstabelecimento(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    @Deprecated
    public ModelEstabelecimento(){

    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelEstabelecimento)) return false;
        ModelEstabelecimento that = (ModelEstabelecimento) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
