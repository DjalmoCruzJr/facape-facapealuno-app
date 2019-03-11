package br.facape.facapealuno.slidelist;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import br.facape.facapealuno.ItemHorario;
import br.facape.facapealuno.R;
import br.facape.facapealuno.br.facape.facapealuno.adapter.AdapterHorario;


@SuppressLint("NewApi")
public class Horario extends Fragment {

    private ListView ListViewHorario;
    private HashMap<String, String> notasMAP = new HashMap<String, String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        AdapterHorario adapter = new AdapterHorario(getActivity().getApplicationContext(), generateData());

        View rootView = inflater.inflate(R.layout.horario_list, container, false);
        ListViewHorario = (ListView) rootView.findViewById(R.id.listViewHorario);
        ListViewHorario.setAdapter(adapter);
        return rootView;
    }

    public ArrayList<ItemHorario> generateData() {
        ArrayList<ItemHorario> items = new ArrayList<ItemHorario>();
        String[] diaSemana = getActivity().getIntent().getStringArrayExtra("diaSemana");
        String[] materia = getActivity().getIntent().getStringArrayExtra("materia");
        String[] professor = getActivity().getIntent().getStringArrayExtra("professor");
        String[] hora = getActivity().getIntent().getStringArrayExtra("hora");

        for (int i = 0; i < diaSemana.length; i++) {
            items.add(new ItemHorario(hora[i], diaSemana[i], materia[i], professor[i]));
        }


        return items;
    }
}
