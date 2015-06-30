package br.com.investdream.investdreamandroidapp.calculadora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.investdream.investdreamandroidapp.R;


public class ResultadosCalculadora extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_calculadora);

        Intent intent = getIntent();

        Double valorEntradaPaga = intent.getDoubleExtra("intentValorEntradaPaga", 0D);
        Double up = intent.getDoubleExtra("intentUp", 0D);
        Double valorTitulo = intent.getDoubleExtra("intentValorTitulo", 0D);
        Double valorParcela = intent.getDoubleExtra("intentValorParcela", 0D);
        Double saldoPagar = intent.getDoubleExtra("intentSaldoPagar", 0D);
        Double valorParcelaFinal = intent.getDoubleExtra("intentValorParcelaFinal", 0D);

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
