package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

import java.text.NumberFormat;
import java.util.Locale;

public class ResultadosCalculadora extends Activity {

    private NumberFormat currencyFormat = DecimalFormat.getCurrencyInstance(new Locale("pt", "BR"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_calculadora);

        Button novoCalculo = (Button) findViewById(R.id.btNovoCalculo);
        Double valorEntrada = 0.0;
        novoCalculo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                novoCalculo();
            }
        });

        try {
            Bundle bundle = getIntent().getExtras();
            Double valorReferencia = Double.parseDouble(bundle.getString("valorCarro"));
            Double valorCarro = Double.parseDouble(bundle.getString("valorCarro"));
            String StringSpinnerPercentualEntrada = bundle.getString("StringSpinnerPercentualEntrada");
            String StringSpinnerClasse = bundle.getString("StringSpinnerClasse");

            switch (StringSpinnerClasse) {
                case "A - 0km":
                    break;
                case "B - 6 meses":
                    valorCarro = valorReferencia * 0.95;
                    break;
                case "C - 12 meses":
                    valorCarro = valorReferencia * 0.90;
                    break;
                case "D - 18 meses":
                    valorCarro = valorReferencia * 0.85;
                    break;
                case "E - 24 meses":
                    valorCarro = valorReferencia * 0.80;
                    break;
                case "F - 30 meses":
                    valorCarro = valorReferencia * 0.75;
                    break;
                case "G - 36 meses":
                    valorCarro = valorReferencia * 0.70;
                    break;
                case "H - 42 meses":
                    valorCarro = valorReferencia * 0.65;
                    break;
                case "I - 48 meses":
                    valorCarro = valorReferencia * 0.60;
                    break;
            }

            switch (StringSpinnerPercentualEntrada) {
                case "50%":
                    valorEntrada = valorCarro * 0.5;
                    break;
                case "45%":
                    valorEntrada = valorCarro * 0.45;
                    break;
                case "40%":
                    valorEntrada = valorCarro * 0.4;
                    break;
                case "35%":
                    valorEntrada = valorCarro * 0.35;
                    break;
                case "30%":
                    valorEntrada = valorCarro * 0.3;
                    break;
                case "25%":
                    valorEntrada = valorCarro * 0.25;
                    break;
                case "20%":
                    valorEntrada = valorCarro * 0.2;
                    break;
                case "15%":
                    valorEntrada = valorCarro * 0.15;
                    break;
                case "10%":
                    valorEntrada = valorCarro * 0.1;
                    break;
            }

            Double valorTitulo = (valorCarro * 2);
            Double saldoAPagar = (valorTitulo - valorEntrada);
            Double valorParcela = (saldoAPagar / 90);

            // Parcelas sempre de 3 em 3. Cada 6 parcelas = 10% / 9 parcela = 15%

            String stringValorReferencia = currencyFormat.format(valorReferencia);
            String stringValorCarro = currencyFormat.format(valorCarro);
            String stringValorEntrada = currencyFormat.format(valorEntrada);
            String stringValorTitulo = currencyFormat.format(valorTitulo);
            String stringValorParcela = currencyFormat.format(valorParcela);

            TextView txtViewValorReferencia = (TextView) findViewById(R.id.resultadosCalculadoraValueValorReferencia);
            txtViewValorReferencia.setText(stringValorReferencia);

            TextView txtViewPercentualEntrada = (TextView) findViewById(R.id.resultadosCalculadoraValuePercentualEntrada);
            txtViewPercentualEntrada.setText(StringSpinnerPercentualEntrada);

            TextView txtViewValorCarro = (TextView) findViewById(R.id.resultadosCalculadoraValueValorDoCarro);
            txtViewValorCarro.setText(stringValorCarro);

            TextView txtViewValorEntrada = (TextView) findViewById(R.id.resultadosCalculadoraValueValorEntrada);
            txtViewValorEntrada.setText(stringValorEntrada);

            TextView txtViewClasse = (TextView) findViewById(R.id.resultadosCalculadoraValueClasse);
            txtViewClasse.setText(StringSpinnerClasse);

            TextView txtViewValorTitulo = (TextView) findViewById(R.id.resultadosCalculadoraValueValorContrato);
            txtViewValorTitulo.setText(stringValorTitulo);

            TextView txtViewValorParcela = (TextView) findViewById(R.id.resultadosCalculadoraValueParcela);
            txtViewValorParcela.setText(stringValorParcela);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_resultados_calculadora, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void novoCalculo() {
        super.onBackPressed();
    }
}
