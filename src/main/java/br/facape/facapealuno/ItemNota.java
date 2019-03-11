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

    public ItemNota(String disciplina,String primeiraNota, String segundaNota, String terceiraNota, String finalNota, String media, String totalFaltas, String status){
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


    public String getDisciplina(){
        return this.disciplina;
    }

    public String getPrimeiraNota(){
        return this.primeiraNota;
    }

    public String getSegundaNota(){
        return this.segundaNota;
    }

    public String getTerceiraNota(){
        return this.terceiraNota;
    }

    public String getFinalNota(){
        return this.finalNota;
    }

    public String getMedia(){
        return this.media;
    }

    public String getTotalFaltas(){
        return this.totalFaltas;
    }

    public String getStatus(){
        return this.status;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }

    public void setPrimeiraNota(String primeiraNota){
        this.primeiraNota = primeiraNota;
    }

    public void setSegundaNota(String segundaNota){
        this.segundaNota = segundaNota;
    }

    public void setTerceiraNota(String terceiraNota){
        this.terceiraNota = terceiraNota;
    }

    public void setFinalNota(String finalNota){
        this.finalNota = finalNota;
    }

    public void setMedia(String media){
        this.media = media;
    }

    public void setTotalFaltas(String totalFaltas){
        this.totalFaltas = totalFaltas;
    }

    public void setStatus(String status){
        this.status = status;
    }

}
