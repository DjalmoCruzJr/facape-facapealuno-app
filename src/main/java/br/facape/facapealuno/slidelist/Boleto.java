package br.facape.facapealuno.slidelist;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import br.facape.facapealuno.ItemBoleto;
import br.facape.facapealuno.R;
import br.facape.facapealuno.br.facape.facapealuno.adapter.AdapterBoleto;
import br.facape.facapealuno.utils.FormatarMes;

@SuppressLint("NewApi")
public class Boleto extends Fragment {

    private ListView listViewBoleto;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        AdapterBoleto adapter = new AdapterBoleto(getActivity().getApplicationContext(),generateData());
        View rootView = inflater .inflate(R.layout.boleto, container, false);
        listViewBoleto = (ListView) rootView.findViewById(R.id.listViewBoleto);
        listViewBoleto.setAdapter(adapter);
        return rootView;
    }

    private ArrayList<ItemBoleto> generateData(){
        ArrayList<ItemBoleto> items = new ArrayList<ItemBoleto>();
        String[] codBarras = getActivity().getIntent().getStringArrayExtra("codigoBarras");
        String[] vencimento = getActivity().getIntent().getStringArrayExtra("vencimento");
        String[] valor =  getActivity().getIntent().getStringArrayExtra("valorBoleto");
        String[] vencimentoFormatado = new String[vencimento.length];


        FormatarMes mes = new FormatarMes();

        if(codBarras.length >= 1) {

            for (int i = 0; i < vencimento.length; i++) {
                // Log.d("formatado", " > " + vencimento[i].substring(3, 5).toString());
                vencimentoFormatado[i] = mes.getFormated(Integer.parseInt(vencimento[i].substring(3, 5).toString()));
            }

            for (int i = 0; i < codBarras.length; i++) {
                items.add(new ItemBoleto(codBarras[i].toString(), vencimento[i].toString(), vencimentoFormatado[i].toString(), "R$" + valor[i].toString()));
            }
        }else{
            items.add(new ItemBoleto("Nenhum Boleto Cadastrado no Momento","","",""));
        }

        return  items;
    }
}
