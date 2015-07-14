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

        Double valorEntradaPaga = 0.0;

        novoCalculo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                novoCalculo();
            }
        });

        try {
            Bundle bundle = getIntent().getExtras();

            Double valorDoCarro = Double.parseDouble(bundle.getString("valorDoCarro"));
            String StringSpinnerPercentualDeEntrada = bundle.getString("StringSpinnerPercentualDeEntrada");
            //String StringSpinnerClasse = bundle.getString("StringSpinnerClasse");

            switch (StringSpinnerPercentualDeEntrada) {
                case "50%":
                    valorEntradaPaga = valorDoCarro * 0.5;
                    break;
                case "45%":
                    valorEntradaPaga = valorDoCarro * 0.45;
                    break;
                case "40%":
                    valorEntradaPaga = valorDoCarro * 0.4;
                    break;
                case "35%":
                    valorEntradaPaga = valorDoCarro * 0.35;
                    break;
                case "30%":
                    valorEntradaPaga = valorDoCarro * 0.3;
                    break;
                case "25%":
                    valorEntradaPaga = valorDoCarro * 0.25;
                    break;
                case "20%":
                    valorEntradaPaga = valorDoCarro * 0.2;
                    break;
                case "15%":
                    valorEntradaPaga = valorDoCarro * 0.15;
                    break;
                case "10%":
                    valorEntradaPaga = valorDoCarro * 0.1;
                    break;
            }

            Double upgrade = (valorDoCarro * 1.25);
            Double valorDoTitulo = (upgrade * 2);
            Double saldoAPagar = (valorDoTitulo - valorEntradaPaga);
            Double valorParcela = (saldoAPagar / 90);

            // Parcelas sempre de 3 em 3. Cada 6 parcelas = 10% / 9 parcela = 15%

            String stringValorDoCarro = currencyFormat.format(valorDoCarro);
            String stringValorEntradaPaga = currencyFormat.format(valorEntradaPaga);
            String stringUpgrade = currencyFormat.format(upgrade);
            String stringValorDoTitulo = currencyFormat.format(valorDoTitulo);
            String stringValorDaParcela = currencyFormat.format(valorParcela);
            String stringSaldoAPagar = currencyFormat.format(saldoAPagar);
            String stringValorDaParcelaFinal = currencyFormat.format(valorParcela);

            TextView txtViewValorDoCarro = (TextView) findViewById(R.id.resultadosCalculadoraValorDoCarro);
            txtViewValorDoCarro.setText(stringValorDoCarro);

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
