package br.com.zupacademy.guilhermesantos.transacao.dto;

import br.com.zupacademy.guilhermesantos.transacao.model.ModelEstabelecimento;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModelEstabelecimentoDTO {

    @NotNull(message = "O Nome não pode ser Vazio!")
    @NotBlank(message = "O Nome deve ser Informado!")
    private String nome;

    @NotNull(message = "A Cidade não pode ser Vázia!")
    @NotBlank(message = "A Cidade deve ser Informada!")
    private String cidade;

    @NotNull(message = "O Endereço não pode ser Nulo!")
    @NotBlank(message = "O Endereço deve ser Informado!")
    private String endereco;

    public ModelEstabelecimento converte(){
        return new ModelEstabelecimento(nome, cidade, endereco);
    }

    public ModelEstabelecimentoDTO(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
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
