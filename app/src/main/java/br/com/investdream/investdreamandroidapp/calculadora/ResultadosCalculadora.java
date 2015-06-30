package br.com.investdream.investdreamandroidapp.calculadora;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import br.com.investdream.investdreamandroidapp.R;


public class ResultadosCalculadora extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_calculadora);

        Bundle extras = getIntent().getExtras();

        Double up = null;
        if (extras != null) {
            up = extras.getDouble("up");
        }

        Double valorTitulo = null;
        if (extras != null) {
            valorTitulo = extras.getDouble("valorTitulo");
        }

        Double valorParcela = null;
        if (extras != null) {
            valorParcela = extras.getDouble("valorParcela");
        }

        Double valorEntradaPaga = null;
        if (extras != null) {
            valorEntradaPaga = extras.getDouble("valorEntradaPaga");
        }

        Double saldoPagar = null;
        if (extras != null) {
            saldoPagar = extras.getDouble("saldoPagar");
        }

        Double valorParcelaFinal = null;
        if (extras != null) {
            valorParcelaFinal = extras.getDouble("valorParcelaFinal");
        }
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
