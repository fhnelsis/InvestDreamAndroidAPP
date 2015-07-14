package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Calculadora extends Activity {

    private Spinner spinnerPercentualDeEntrada;
    private Spinner spinnerClasse;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        final EditText maskedValorDoBem = (EditText) findViewById(R.id.fieldValorDoBem);
        maskedValorDoBem.addTextChangedListener(new MascaraMonetaria(maskedValorDoBem));

        addListenerBtCalcular();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void addListenerBtCalcular() {
        btCalcular = (Button) findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular(view);
            }
        });
    }

    public void calcular(View view) {
        Intent intent = new Intent(this, ResultadosCalculadora.class);

        EditText valordoBem = (EditText) findViewById(R.id.fieldValorDoBem);

        spinnerPercentualDeEntrada = (Spinner) findViewById(R.id.spinnerPercentualDeEntrada);
        String StringSpinnerPercentualDeEntrada = spinnerPercentualDeEntrada.toString();

        spinnerClasse = (Spinner) findViewById(R.id.spinnerClasse);
        String StringSpinnerClasse = spinnerClasse.toString();

        Bundle bundle = new Bundle();

        //TODO Resolver as strings das spinners que entram no bundle errado.
        bundle.putString("valorDoBem", valordoBem.getText().toString().replace("R$", "").replaceAll("\\.", "").replace(",", "."));
        bundle.putString("StringSpinnerPercentualDeEntrada", StringSpinnerPercentualDeEntrada);
        bundle.putString("StringSpinnerClasse", StringSpinnerClasse);
        //bundle.putString("valordaEntrada", valordaEntrada.getText().toString().replace("R$", "").replaceAll("\\.", "").replace(",", "."));
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
