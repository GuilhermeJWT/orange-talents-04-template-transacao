package br.com.zupacademy.guilhermesantos.transacao.dto;

import br.com.zupacademy.guilhermesantos.transacao.model.ModelCartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ModelCartaoDTO {

    @NotBlank(message = "O Número Deve ser Informado!")
    @NotNull(message = "O Número não pode ser Vazio!")
    private String numero;

    @NotEmpty(message = "O E-Mail deve ser Informado!")
    @Email(message = "E-Mail Inválido, Informe Outro!")
    private String email;

    public ModelCartao converte(){
        return new ModelCartao(numero, email);
    }

    public ModelCartaoDTO(String numero, String email) {
        this.numero = numero;
        this.email = email;
    }

    public String getNumero() {
        return numero;
    }

    public String getEmail() {
        return email;
    }
}
