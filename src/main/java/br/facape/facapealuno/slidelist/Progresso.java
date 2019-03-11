package br.facape.facapealuno.slidelist;

import br.facape.facapealuno.R;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressLint("NewApi")
public class Progresso extends Fragment {

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater .inflate(R.layout.progresso, container, false);
        return rootView;
    }
}