package br.facape.facapealuno.br.facape.facapealuno.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.facape.facapealuno.ItemContato;
import br.facape.facapealuno.R;

/**
 * Created by claudiohenrique on 30/09/14.
 */
public class AdapterContatoTelefone extends ArrayAdapter<ItemContato> {

    private final Context context;
    private final ArrayList<ItemContato> itemsArrayList;

    public AdapterContatoTelefone(Context context, ArrayList<ItemContato> itemsArrayList) {
        super(context, R.layout.row_telefone, itemsArrayList);
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.row_telefone, parent, false);

        int color = Color.rgb(204, 204, 204); //#999

        if (position % 2 == 0) {
            rowView.setBackgroundColor(color);
        }

        TextView nomeSetor = (TextView) rowView.findViewById(R.id.setorView);
        TextView telefoneSetor = (TextView) rowView.findViewById(R.id.telefoneView);

        nomeSetor.setText(itemsArrayList.get(position).getNomeSetor());
        telefoneSetor.setText(itemsArrayList.get(position).getTelefoneSetor());

        return rowView;
    }

}
