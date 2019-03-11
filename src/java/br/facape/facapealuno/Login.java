package br.facape.facapealuno;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import br.facape.facapealuno.utils.FormatarDia;


public class Login extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
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

    public void clickNotas(View v) {
        //startActivity (new Intent(Login.this, Notas.class));
        new LoginAsyncTask(Login.this).execute();
    }

    public class LoginAsyncTask extends AsyncTask<Void, Void, Void> {

        //private final String API = "http://192.241.176.128/facape/aluno.json"; // (the url for access API)
        //private final String API = "http://sistemas2.facape.br/wsfacape/aluno/"; // (the url for access API)
        private final String API = "http://sistemas2.facape.br:8080/wsfacape/aluno/8c14d06e7cc5ea54f302bf5324ee4e7/12923/123456/";
        private ProgressDialog pDialog; //Dialog object
        private Context context;
        private Activity activity;
        //for parser
        private JSONArray notas = null;
        private JSONArray horario = null;
        private JSONArray boleto = null;

        private ArrayList<HashMap<String, String>> notasList;

        //Informações sobre as notas
        private String[] disciplina;
        private String[] primeiraNota;
        private String[] segundaNota;
        private String[] terceiraNota;
        private String[] finalNota;
        private String[] media;
        private String[] totalFaltas;
        private String[] status;

        private String[] diaSemana;
        private String[] materia;
        private String[] hora;
        private String[] professor;

        //Informações sobre o boleto
        private String[] codgBarras;
        private String[] vencimento;
        private String[] valor;

        public LoginAsyncTask(Activity activity) {
            this.activity = activity;
            this.context = activity;
            this.notasList = new ArrayList<HashMap<String, String>>();

            this.pDialog = new ProgressDialog(activity);
            this.pDialog.setTitle("Aguarde");
            this.pDialog.setMessage("Logando...");
            this.pDialog.setCancelable(false);
            if (!this.pDialog.isShowing()) {
                this.pDialog.show();
            }

        }

        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (this.pDialog.isShowing()) {
                this.pDialog.dismiss();
            }

            Intent intent = new Intent(getApplicationContext(), Notas.class);
            intent.putExtra("disciplina", disciplina);
            intent.putExtra("primeiraNota", primeiraNota);
            intent.putExtra("segundaNota", segundaNota);
            intent.putExtra("terceiraNota", terceiraNota);
            intent.putExtra("finalNota", finalNota);
            intent.putExtra("media", media);
            intent.putExtra("totalFaltas", totalFaltas);
            intent.putExtra("status", status);
            //intent.putExtra("diaSemana", diaSemana);
            //intent.putExtra("horarios", horarios);

            intent.putExtra("codigoBarras", codgBarras);
            intent.putExtra("vencimento", vencimento);
            intent.putExtra("valorBoleto", valor);

            intent.putExtra("diaSemana", diaSemana);
            intent.putExtra("materia", materia);
            intent.putExtra("professor", professor);
            intent.putExtra("hora", hora);

            startActivity(intent);

        }


        protected Void doInBackground(Void... params) {
            RequestHandler request = new RequestHandler();
            String jsonStr = request.makeServiceCall(this.API, RequestHandler.GET);

            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONObject jsonBoleto = new JSONObject(jsonStr);

                this.notas = jsonObj.getJSONArray("notas");
                this.boleto = jsonBoleto.getJSONArray("boleto");
                this.horario = jsonObj.getJSONArray("horario");

                //Variaveis Referentes as Notas do Aluno
                disciplina = new String[this.notas.length()];
                primeiraNota = new String[this.notas.length()];
                segundaNota = new String[this.notas.length()];
                terceiraNota = new String[this.notas.length()];
                finalNota = new String[this.notas.length()];
                media = new String[this.notas.length()];
                totalFaltas = new String[this.notas.length()];
                status = new String[this.notas.length()];

                //Variaveis Referentes ao Horario do Aluno
                //diaSemana = new String[this.horario.length()];
                //horarios = new String[20];

                //Variaveis referente ao boleto do aluno
                codgBarras = new String[this.boleto.length()];
                vencimento = new String[this.boleto.length()];
                valor = new String[this.boleto.length()];


                diaSemana = new String[this.horario.length()];
                materia = new String[this.horario.length()];
                hora = new String[this.horario.length()];
                professor = new String[this.horario.length()];

                for (int i = 0; i < this.boleto.length(); i++) {
                    JSONObject b = this.boleto.getJSONObject(i);

                    boolean validKeyCodBarras = b.isNull("codgBarras");
                    boolean validKeyVencimento = b.isNull("vencimento");
                    boolean validKeyValor = b.isNull("valor");

                    if (!validKeyCodBarras) {
                        codgBarras[i] = b.getString("codgBarras");
                    }

                    if (!validKeyVencimento) {
                        vencimento[i] = b.getString("vencimento");
                    }

                    if (!validKeyValor) {
                        valor[i] = b.getString("valor");
                    }
                }


                for (int i = 0; i < this.notas.length(); i++) {
                    JSONObject c = this.notas.getJSONObject(i);

                    //Responsaveis por fazer a validação dos campos existentes no JSON
                    boolean validKeyPrimeiraNota = c.isNull("nota1");
                    boolean validKeySegundaNota = c.isNull("nota2");
                    boolean validKeyTerceiraNota = c.isNull("nota3");
                    boolean validKeyFinalNota = c.isNull("nota4");

                    disciplina[i] = c.getString("disciplina");
                    totalFaltas[i] = c.getString("totalfaltas");
                    status[i] = c.getString("status");

                    int tamanho = c.getString("media").length();
                    Log.d("TAMANHO", " > " + tamanho);

                    //Tratamento para formatar a media
                    if (tamanho >= 2) {
                        media[i] = c.getString("media").toString();
                    } else {
                        media[i] = c.getString("media").concat(".0");
                    }

                    //Se for verdadeiro o Camṕo não existe  no JSON
                    if (validKeyPrimeiraNota) {
                        primeiraNota[i] = "N/A";
                    } else {
                        int tamanhoPrimeiraNota = c.getString("nota1").length();
                        if (tamanhoPrimeiraNota == 1) {
                            primeiraNota[i] = c.getString("nota1").concat(".0"); //Recupero o valor da Primeira Nota
                        } else {
                            primeiraNota[i] = c.getString("nota1");
                        }

                    }

                    if (validKeySegundaNota) {
                        segundaNota[i] = "N/A";
                    } else {
                        int tamanhoSegundaNota = c.getString("nota2").length();
                        if (tamanhoSegundaNota == 1) {
                            segundaNota[i] = c.getString("nota2").concat(".0"); //Recupero o valor da Segunda Nota
                        } else {
                            segundaNota[i] = c.getString("nota2"); //Recupero o valor da Segunda Nota
                        }
                    }

                    if (validKeyTerceiraNota) {
                        terceiraNota[i] = "N/A";
                    } else {
                        int tamanhoTerceiraNota = c.getString("nota3").length();
                        if (tamanhoTerceiraNota == 1) {
                            terceiraNota[i] = c.getString("nota3").concat(".0"); //Recupero o valor da Segunda Nota
                        } else {
                            terceiraNota[i] = c.getString("nota3"); //Recupero o valor da Segunda Nota
                        }

                    }

                    if (validKeyFinalNota) {
                        finalNota[i] = "N/A";
                    } else {
                        int tamanhoFinalNota = c.getString("nota4").length();
                        if (tamanhoFinalNota == 1) {
                            finalNota[i] = c.getString("nota4").concat(".0");
                        } else {
                            finalNota[i] = c.getString("nota4");
                        }
                    }

                    if (status[i].equalsIgnoreCase("Aprov. p/Media")) {
                        status[i] = "Aprovado por Media";
                    } else if (status[i].equalsIgnoreCase("Aprov. pos Final")) {
                        status[i] = "Aprovado pos Final";
                    }
                }


                for (int i = 0; i < this.horario.length(); i++) {
                    JSONObject h = this.horario.getJSONObject(i);
                    //Recupero o dia da Semana e Formato para ficar mais Bonito!
                    FormatarDia format = new FormatarDia(h.getString("dia"));
                    String dia = format.getDiaFormatado();
                    diaSemana[i] = dia;
                    materia[i] = h.getString("materia");
                    hora[i] = h.getString("hora");
                    professor[i] = h.getString("professor");
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
