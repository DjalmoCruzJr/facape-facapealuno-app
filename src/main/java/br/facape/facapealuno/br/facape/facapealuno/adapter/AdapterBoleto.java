package br.facape.facapealuno.br.facape.facapealuno.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.facape.facapealuno.ItemBoleto;
import br.facape.facapealuno.R;

/**
 * Created by claudiohenrique on 30/09/14.
 */
public class AdapterBoleto extends ArrayAdapter<ItemBoleto> {

    private final Context context;
    private final ArrayList<ItemBoleto> itemsArrayList;

    public AdapterBoleto(Context context, ArrayList<ItemBoleto> itemsArrayList){
        super(context, R.layout.row_boleto, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.row_boleto, parent, false);

        TextView boletoMes = (TextView) rowView.findViewById(R.id.boletoMes);
        TextView boletoVencimento = (TextView) rowView.findViewById(R.id.boletoVencimentoData);
        TextView boletoValor = (TextView) rowView.findViewById(R.id.boletoValor);
        TextView boletoCodigo = (TextView) rowView.findViewById(R.id.boletoCodigo);

        boletoMes.setText(itemsArrayList.get(position).getVencimentoFormatado());
        boletoVencimento.setText(itemsArrayList.get(position).getVencimento());
        boletoValor.setText(itemsArrayList.get(position).getValor());
        boletoCodigo.setText(itemsArrayList.get(position).getCodBarras());

        return rowView;

    }
}
