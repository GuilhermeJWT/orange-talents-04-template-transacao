package br.com.zupacademy.guilhermesantos.transacao.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "cartao")
public class ModelCartao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @NotEmpty(message = "O E-Mail deve ser Informado!")
    @Email(message = "E-Mail Inválido, Informe Outro!")
    private String email;

    @Deprecated
    public ModelCartao(){

    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
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
