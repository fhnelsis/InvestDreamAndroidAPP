package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.investdream.investdreamandroidapp.R;


public class ResultadosCalculadora extends Activity {

    Double defaultValue = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_calculadora);

        Bundle bundle = getIntent().getExtras();

        Double valorDoBem = bundle.getDouble("valorEntragaPaga");
        Double valorEntradaPaga = bundle.getDouble("valorDoBem");

        Double upgrade =  0.0;
        Double valorDoTitulo = 0.0;
        Double valorDaParcela = 0.0;
        Double saldoAPagar = 0.0;
        Double valorDaParcelaFinal = 0.0;

//        Double valorEntradaPaga = getIntent().getDoubleExtra("intentValorEntradaPaga", defaultValue);
//        Double up = getIntent().getDoubleExtra("intentUp", defaultValue);
//        Double valorTitulo = getIntent().getDoubleExtra("intentValorTitulo", defaultValue);
//        Double valorParcela = getIntent().getDoubleExtra("intentValorParcela", defaultValue);
//        Double saldoPagar = getIntent().getDoubleExtra("intentSaldoPagar", defaultValue);
//        Double valorParcelaFinal = getIntent().getDoubleExtra("intentValorParcelaFinal", defaultValue);

//TODO Jogar valores que passei de uma activity para a outra nos campos da ResultadosCalculadora.java.
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultados_calculadora, menu);
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
}
