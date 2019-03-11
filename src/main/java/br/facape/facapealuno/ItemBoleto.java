package br.facape.facapealuno;

import br.facape.facapealuno.utils.FormatarMes;

/**
 * Created by claudiohenrique on 30/09/14.
 */
public class ItemBoleto {

    private String codBarras;
    private String vencimento;
    private String vencimentoFormatado; // (Setembro/2014)
    private String valor;


    private FormatarMes mes = new FormatarMes();

    public ItemBoleto(){

    }

    public ItemBoleto(String codBarras, String vencimento, String vencimentoFormatado, String valor){
        this.codBarras = codBarras;
        this.vencimento = vencimento;
        this.vencimentoFormatado = vencimentoFormatado;
        this.valor = valor;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public String getVencimento() {
        return vencimento;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public void setVencimentoFormatado(String vencimentoFormatado){

    }

    public String getVencimentoFormatado(){
        return vencimentoFormatado;
    }


}
