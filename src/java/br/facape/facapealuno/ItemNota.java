package br.facape.facapealuno;

/**
 * Created by claudiohenrique on 26/09/14.
 */

public class ItemNota {

    private String disciplina;
    private String primeiraNota;
    private String segundaNota;
    private String terceiraNota;
    private String finalNota;

    private String media;
    private String totalFaltas;
    private String status;

    public ItemNota(String disciplina, String primeiraNota, String segundaNota, String terceiraNota, String finalNota, String media, String totalFaltas, String status) {
        super();
        this.disciplina = disciplina;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
        this.terceiraNota = terceiraNota;
        this.finalNota = finalNota;
        this.media = media;
        this.totalFaltas = totalFaltas;
        this.status = status;
    }


    public String getDisciplina() {
        return this.disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getPrimeiraNota() {
        return this.primeiraNota;
    }

    public void setPrimeiraNota(String primeiraNota) {
        this.primeiraNota = primeiraNota;
    }

    public String getSegundaNota() {
        return this.segundaNota;
    }

    public void setSegundaNota(String segundaNota) {
        this.segundaNota = segundaNota;
    }

    public String getTerceiraNota() {
        return this.terceiraNota;
    }

    public void setTerceiraNota(String terceiraNota) {
        this.terceiraNota = terceiraNota;
    }

    public String getFinalNota() {
        return this.finalNota;
    }

    public void setFinalNota(String finalNota) {
        this.finalNota = finalNota;
    }

    public String getMedia() {
        return this.media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getTotalFaltas() {
        return this.totalFaltas;
    }

    public void setTotalFaltas(String totalFaltas) {
        this.totalFaltas = totalFaltas;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
