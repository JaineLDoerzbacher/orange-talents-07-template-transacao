package transacao.transacao.dtos;

import transacao.transacao.entities.Cartao;

import javax.validation.constraints.NotBlank;

public class CartaoDTORequest {

    @NotBlank
    private String id;
    @NotBlank
    private String email;

    public Cartao converter(){
        return new Cartao(this.id, this.email);
    }

    public CartaoDTORequest() {
    }

    public CartaoDTORequest(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "CartaoDTORequest{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
