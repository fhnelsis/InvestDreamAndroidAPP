package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

import java.text.NumberFormat;
import java.util.Locale;

public class ResultadosCalculadora extends Activity {

    Double defaultValue = 0.0;
    private NumberFormat currencyFormat = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_calculadora);

        Button novoCalculo = (Button) findViewById(R.id.btNovoCalculo);

        novoCalculo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                novoCalculo();
            }
        });

        try {
            Bundle bundle = getIntent().getExtras();

            Double valorDoBem = Double.parseDouble(bundle.getString("valorDoBem"));
            Double valorEntradaPaga = Double.parseDouble(bundle.getString("valordaEntrada"));

            Double upgrade = (valorDoBem * 1.25);
            Double valorDoTitulo = (upgrade * 2);
            Double valorDaParcela = (upgrade / 60);
            Double saldoAPagar = (valorDoTitulo - valorEntradaPaga);
            Double valorDaParcelaFinal = (saldoAPagar / 90);

            String stringValorEntradaPaga = currencyFormat.format(valorEntradaPaga);
            String stringUpgrade = currencyFormat.format(upgrade);
            String stringValorDoTitulo = currencyFormat.format(valorDoTitulo);
            String stringValorDaParcela = currencyFormat.format(valorDaParcela);
            String stringSaldoAPagar = currencyFormat.format(saldoAPagar);
            String stringValorDaParcelaFinal = currencyFormat.format(valorDaParcelaFinal);

            TextView txtViewValorEntradaPaga = (TextView) findViewById(R.id.resultadosCalculadoraValueValorEntradaPaga);
            txtViewValorEntradaPaga.setText(stringValorEntradaPaga);

            TextView txtViewUpgrade = (TextView) findViewById(R.id.resultadosCalculadoraValueUp);
            txtViewUpgrade.setText(stringUpgrade);

            TextView txtViewValorDoTitulo = (TextView) findViewById(R.id.resultadosCalculadoraValueValorDoTitulo);
            txtViewValorDoTitulo.setText(stringValorDoTitulo);

            TextView txtViewValorDaParcela = (TextView) findViewById(R.id.resultadosCalculadoraValueValorParcela);
            txtViewValorDaParcela.setText(stringValorDaParcela);

            TextView txtViewSaldoAPagar = (TextView) findViewById(R.id.resultadosCalculadoraValueSaldoPagar);
            txtViewSaldoAPagar.setText(stringSaldoAPagar);

            TextView txtViewValorDaParcelaFinal = (TextView) findViewById(R.id.resultadosCalculadoraValueParcelaFinal);
            txtViewValorDaParcelaFinal.setText(stringValorDaParcelaFinal);

        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void novoCalculo() {
        finishActivity(0);
    }
}
