package br.facape.facapealuno.br.facape.facapealuno.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.facape.facapealuno.ItemNota;
import br.facape.facapealuno.R;

/**
 * Created by claudiohenrique on 26/09/14.
 */

public class AdapterNotas extends ArrayAdapter<ItemNota> {
    private final Context context;
    private final ArrayList<ItemNota> itemsArrayList;

    private int corAprovado = Color.rgb(0,80,178);
    private int corStatusAprovado = Color.rgb(55,214,11);
    private int corReprovado = Color.rgb(178,0,0);
    private int corNota = Color.rgb(125,125,125);

    public AdapterNotas(Context context, ArrayList<ItemNota> itemsArrayList) {

        super(context, R.layout.row, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.row, parent, false);

        int color = Color.rgb(222, 222, 222); //#F6F5F4

        if(position % 2 == 0){
            rowView.setBackgroundColor(color);
        }

        // 3. Get the two text view from the rowView
        TextView nomeDisciplinaView = (TextView) rowView.findViewById(R.id.nomeDisciplina);
        TextView notaUmView = (TextView) rowView.findViewById(R.id.notaUm);
        TextView notaDoisView = (TextView) rowView.findViewById(R.id.notaDois);
        TextView notaTresView = (TextView) rowView.findViewById(R.id.notaTres);
        TextView notaFinalView = (TextView) rowView.findViewById(R.id.notaQuatro);
        TextView notaMediaView = (TextView) rowView.findViewById(R.id.notaMedia);
        TextView numeroFaltasView = (TextView) rowView.findViewById(R.id.numFaltas);
        TextView resultadoStatusView = (TextView) rowView.findViewById(R.id.resultadoStatus);

        // 4. Set the text for textView
        nomeDisciplinaView.setText(itemsArrayList.get(position).getDisciplina());

        notaUmView.setText(itemsArrayList.get(position).getPrimeiraNota());
        setColor(notaUmView);

        notaDoisView.setText(itemsArrayList.get(position).getSegundaNota());
        setColor(notaDoisView);

        notaTresView.setText(itemsArrayList.get(position).getTerceiraNota());
        setColor(notaTresView);

        notaFinalView.setText(itemsArrayList.get(position).getFinalNota());
        setColor(notaFinalView);

        notaMediaView.setText(itemsArrayList.get(position).getMedia());
        setColorMedia(notaMediaView);

        numeroFaltasView.setText(itemsArrayList.get(position).getTotalFaltas());

        resultadoStatusView.setText(itemsArrayList.get(position).getStatus());
        setColorResultado(resultadoStatusView);

        // 5. return rowView
        return rowView;
    }

    public void setColor(TextView nota){
        if(!nota.getText().toString().equalsIgnoreCase("N/A")){
            nota.setTextColor(corNota);
        }
    }

    public void setColorMedia(TextView nota){
        if(!nota.getText().toString().equalsIgnoreCase("N/A")) {
            double value = Double.parseDouble(nota.getText().toString());
            if (value >= 7) {
                nota.setTextColor(corAprovado);
            } else {
                nota.setTextColor(corReprovado);
            }
        }
    }

    public void setColorResultado(TextView resultado){
        if(resultado.getText().toString().equalsIgnoreCase("Aprovado") || resultado.getText().toString().equalsIgnoreCase("Aprovado por Media") || resultado.getText().toString().equalsIgnoreCase("Aprovado pos Final")  || resultado.getText().toString().equalsIgnoreCase("Matriculado") ){
            resultado.setTextColor(corStatusAprovado);
        }else{
            resultado.setTextColor(corReprovado);
        }
    }

}
