package br.com.zupacademy.guilhermesantos.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cartao")
public class ModelCartao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @NotNull(message = "O Número não pode ser Vazio!")
    @NotBlank(message = "O Número deve ser Informado!")
    private String numero;

    @NotEmpty(message = "O E-Mail deve ser Informado!")
    @Email(message = "E-Mail Inválido, Informe Outro!")
    private String email;

    public ModelCartao(String numero, String email){
        this.numero = numero;
        this.email = email;
    }

    public ModelCartao(String id, String numero, String email) {
        this.id = id;
        this.numero = numero;
        this.email = email;
    }

    @Deprecated
    public ModelCartao(){

    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelCartao)) return false;
        ModelCartao that = (ModelCartao) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
