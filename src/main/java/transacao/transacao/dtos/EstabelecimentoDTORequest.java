package transacao.transacao.dtos;

import transacao.transacao.entities.Estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoDTORequest {

    @NotBlank
    private String nome;
    @NotBlank
    private String cidade;
    @NotBlank
    private String endereco;

    public Estabelecimento converter(){
        return new Estabelecimento(this.nome,this.cidade, this.endereco);
    }

    public EstabelecimentoDTORequest() {
    }

    public EstabelecimentoDTORequest(String nome, String cidade, String endereco) {
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

    @Override
    public String toString() {
        return "EstabelecimentoDTORequest{" +
                "nome='" + nome + '\'' +
                ", cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
