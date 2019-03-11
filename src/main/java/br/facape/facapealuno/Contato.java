package br.facape.facapealuno;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import br.facape.facapealuno.br.facape.facapealuno.adapter.AdapterContatoEmail;
import br.facape.facapealuno.br.facape.facapealuno.adapter.AdapterContatoTelefone;


public class Contato extends ActionBarActivity {

    private ListView listViewTelefones;
    private ListView listViewEmail;

    //@Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contato);
       getView();
    }

    public void getView(){

        AdapterContatoTelefone adapter = new AdapterContatoTelefone(this,generateData());
        AdapterContatoEmail adapterMail = new AdapterContatoEmail(this,generateData());

        listViewTelefones = (ListView) findViewById(R.id.listViewTelefone);
        listViewEmail = (ListView) findViewById(R.id.listViewEmail);

        listViewTelefones.setAdapter(adapter);
        listViewEmail.setAdapter(adapterMail);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contato, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public ArrayList<ItemContato> generateData(){
        ArrayList<ItemContato> items = new ArrayList<ItemContato>();
        items.add(new ItemContato("NTI", "(87) 8878-4079", "nti@facape.br"));
        items.add(new ItemContato("FINANCEIRO", "(87) 8878-4079", "nti@facape.br"));
        items.add(new ItemContato("CAD", "(87) 8878-4079", "nti@facape.br"));
        items.add(new ItemContato("SEI NÃO", "(87) 8878-4079", "nti@facape.br"));
        items.add(new ItemContato("SEI NÃO", "(87) 8878-4079", "nti@facape.br"));
        items.add(new ItemContato("SEI NÃO", "(87) 8878-4079", "nti@facape.br"));

        return items;
    }


}
