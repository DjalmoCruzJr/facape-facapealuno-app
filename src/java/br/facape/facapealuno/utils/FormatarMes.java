package br.facape.facapealuno.utils;

/**
 * Created by claudiohenrique on 30/09/14.
 */

public class FormatarMes {

    private String mesFormatado;

    public FormatarMes() {

    }

    public FormatarMes(int mes) {
        getFormated(mes);
    }

    public String getFormated(int mes) {
        switch (mes) {
            case 1:
                this.mesFormatado = "Janeiro";
                break;
            case 2:
                this.mesFormatado = "Fevereiro";
                break;
            case 3:
                this.mesFormatado = "Março";
                break;
            case 4:
                this.mesFormatado = "Abril";
                break;
            case 5:
                this.mesFormatado = "Maio";
                break;
            case 6:
                this.mesFormatado = "Junho";
                break;
            case 7:
                this.mesFormatado = "Julho";
                break;
            case 8:
                this.mesFormatado = "Agosto";
                break;
            case 9:
                this.mesFormatado = "Setembro";
                break;
            case 10:
                this.mesFormatado = "Outubro";
                break;
            case 11:
                this.mesFormatado = "Novembro";
                break;
            case 12:
                this.mesFormatado = "Dezembro";
                break;
        }
        return this.mesFormatado;
    }
}
