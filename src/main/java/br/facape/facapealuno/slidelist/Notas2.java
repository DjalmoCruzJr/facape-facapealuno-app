package br.facape.facapealuno.slidelist;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import br.facape.facapealuno.br.facape.facapealuno.adapter.AdapterNotas;
import br.facape.facapealuno.ItemNota;
import br.facape.facapealuno.R;

@SuppressLint("NewApi")
public class Notas2 extends Fragment {

    ListView listViewNotas;
    private HashMap<String, String> notasMAP = new HashMap<String, String>();
    private Parcelable notasList;

    public Notas2(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        AdapterNotas adapter = new AdapterNotas(getActivity().getApplicationContext(),generateData());

        View rootView = inflater .inflate(R.layout.notas_list, container, false);
        listViewNotas = (ListView) rootView.findViewById(R.id.listViewNotas);
        listViewNotas.setAdapter(adapter);
        Bundle args = getActivity().getIntent().getExtras();

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, android.R.id.text1, values);

        return rootView;
    }

    public ArrayList<ItemNota> generateData(){
        ArrayList<ItemNota> items = new ArrayList<ItemNota>();
        //ArrayList<HashMap<String, String>> arl = (ArrayList<HashMap<String, String>>) getActivity().getIntent().getSerializableExtra("notaList");
        String[] disciplina   = getActivity().getIntent().getStringArrayExtra("disciplina");
        String[] primeiraNota = getActivity().getIntent().getStringArrayExtra("primeiraNota");
        String[] segundaNota  = getActivity().getIntent().getStringArrayExtra("segundaNota");
        String[] terceiraNota = getActivity().getIntent().getStringArrayExtra("terceiraNota");
        String[] finalNota    = getActivity().getIntent().getStringArrayExtra("finalNota");
        String[] media        = getActivity().getIntent().getStringArrayExtra("media");
        String[] totalFaltas  = getActivity().getIntent().getStringArrayExtra("totalFaltas");
        String[] status       = getActivity().getIntent().getStringArrayExtra("status");
        //String[] diaSemana       = getActivity().getIntent().getStringArrayExtra("diaSemana");
        //String[] horarios       = getActivity().getIntent().getStringArrayExtra("horarios");

        for(int i = 0; i < disciplina.length; i++){
               items.add(new ItemNota(disciplina[i].toString(), primeiraNota[i].toString(),segundaNota[i].toString(),terceiraNota[i].toString(), finalNota[i].toString(), media[i].toString() ,totalFaltas[i].toString(),status[i].toString()));
        }

        return items;
    }

}