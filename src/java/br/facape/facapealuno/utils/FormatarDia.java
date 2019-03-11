package br.facape.facapealuno.utils;

/**
 * Created by claudiohenrique on 28/09/14.
 */
public class FormatarDia {

    private String diaFormatado;

    public FormatarDia(String dia) {

        if (dia.equalsIgnoreCase("Seg"))
            this.diaFormatado = "Segunda-Feira";

        else if (dia.equalsIgnoreCase("Ter"))
            this.diaFormatado = "Terça-Feira";

        else if (dia.equalsIgnoreCase("Qua"))
            this.diaFormatado = "Quarta-Feira";

        else if (dia.equalsIgnoreCase("Qui"))
            this.diaFormatado = "Quinta-Feira";

        else if (dia.equalsIgnoreCase("Sex"))
            this.diaFormatado = "Sexta-Feira";
        else
            this.diaFormatado = "Sabado";

    }

    public String getDiaFormatado() {
        return this.diaFormatado;
    }
}
