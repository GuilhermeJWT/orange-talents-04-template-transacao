package br.com.zupacademy.guilhermesantos.transacao.dto;

import br.com.zupacademy.guilhermesantos.transacao.model.ModelEstabelecimento;

public class ModelEstabelecimentoResponseDTO {

    private String nome;
    private String cidade;
    private String endereco;

    public ModelEstabelecimento converte(){
        return new ModelEstabelecimento(nome, cidade, endereco);
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
}
