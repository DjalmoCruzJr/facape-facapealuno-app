package br.facape.facapealuno.br.facape.facapealuno.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.facape.facapealuno.ItemHorario;
import br.facape.facapealuno.R;

/**
 * Created by claudiohenrique on 28/09/14.
 */
public class AdapterHorario extends ArrayAdapter<ItemHorario> {

    private final Context context;
    private final ArrayList<ItemHorario> itemsArrayList;

    public AdapterHorario(Context context, ArrayList<ItemHorario> itemsArrayList) {

        super(context, R.layout.row_horario, itemsArrayList);

        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Create inflater
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 2. Get rowView from inflater
        View rowView = inflater.inflate(R.layout.row_horario, parent, false);

        int color = Color.rgb(204, 204, 204); //#999

        if (position % 2 == 0) {
            rowView.setBackgroundColor(color);
        }

        // 3. Get the two text view from the rowView
        TextView diaSemana = (TextView) rowView.findViewById(R.id.diaSemana);
        TextView horarioAula = (TextView) rowView.findViewById(R.id.horaAula);
        TextView nomeDisciplina = (TextView) rowView.findViewById(R.id.nomeDisciplina);
        TextView nomeProfessor = (TextView) rowView.findViewById(R.id.nomeProfessor);

        // 4. Set the text for textView
        diaSemana.setText(itemsArrayList.get(position).getDiaSemana());
        horarioAula.setText(itemsArrayList.get(position).getHorario());
        nomeDisciplina.setText(itemsArrayList.get(position).getDisciplina());
        nomeProfessor.setText(itemsArrayList.get(position).getNomeProfessor());

        // 5. retrn rowView
        return rowView;
    }

}
