package br.com.zupacademy.guilhermesantos.transacao.dto;

import br.com.zupacademy.guilhermesantos.transacao.model.ModelCartao;

public class ModelCartaoResponseDTO {

    private String id;
    private String email;

    public ModelCartao converte(){
        return new ModelCartao(id, email);
    }

    public ModelCartaoResponseDTO(String numero, String email) {
        this.id = numero;
        this.email = email;
    }

    public String getNumero() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
