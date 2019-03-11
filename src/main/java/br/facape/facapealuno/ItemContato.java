package br.facape.facapealuno;

/**
 * Created by claudiohenrique on 30/09/14.
 */

public class ItemContato {

    private String nomeSetor;
    private String telefoneSetor;
    private String nomeSetorEmail;
    private String emailSetor;

    public ItemContato(String nomeSetor, String telefoneSetor, String emailSetor){
        super();
        this.nomeSetor = nomeSetor;
        this.telefoneSetor = telefoneSetor;
        this.emailSetor = emailSetor;
    }

    public ItemContato(String nomeSetor, String telefoneSetor, String nomeSetorEmail, String emailSetor){
        this.nomeSetor = nomeSetor;
        this.telefoneSetor = telefoneSetor;
        this.nomeSetorEmail = nomeSetorEmail;
        this.emailSetor = emailSetor;
    }

    public String getNomeSetor() {
        return nomeSetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomeSetor = nomeSetor;
    }

    public String getTelefoneSetor() {
        return telefoneSetor;
    }

    public void setTelefoneSetor(String telefoneSetor) {
        this.telefoneSetor = telefoneSetor;
    }

    public String getNomeSetorEmail() {
        return nomeSetorEmail;
    }

    public void setNomeSetorEmail(String nomeSetorEmail) {
        this.nomeSetorEmail = nomeSetorEmail;
    }

    public String getEmailSetor() {
        return emailSetor;
    }

    public void setEmailSetor(String emailSetor) {
        this.emailSetor = emailSetor;
    }

}
