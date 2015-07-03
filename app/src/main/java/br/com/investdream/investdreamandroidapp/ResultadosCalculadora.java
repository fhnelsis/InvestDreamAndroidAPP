package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import br.com.investdream.investdreamandroidapp.R;


public class ResultadosCalculadora extends Activity {

    Double defaultValue = 0.0;

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

            round(valorDaParcela, 2);
            Math.ceil(valorDaParcela);

            String StringValorEntradaPaga = valorEntradaPaga.toString();
            String StringUpgrade = upgrade.toString();
            String StringValorDoTitulo = valorDoTitulo.toString();
            String StringValorDaParcela = valorDaParcela.toString();
            String StringSaldoAPagar = saldoAPagar.toString();
            String StringValorDaParcelaFinal = valorDaParcelaFinal.toString();

            TextView txtViewValorEntradaPaga = (TextView) findViewById(R.id.resultadosCalculadoraValueValorEntradaPaga);
            txtViewValorEntradaPaga.setText(StringValorEntradaPaga);

            TextView txtViewUpgrade = (TextView) findViewById(R.id.resultadosCalculadoraValueUp);
            txtViewUpgrade.setText(StringUpgrade);

            TextView txtViewValorDoTitulo = (TextView) findViewById(R.id.resultadosCalculadoraValueValorDoTitulo);
            txtViewValorDoTitulo.setText(StringValorDoTitulo);

            TextView txtViewValorDaParcela = (TextView) findViewById(R.id.resultadosCalculadoraValueValorParcela);
            txtViewValorDaParcela.setText(StringValorDaParcela);

            TextView txtViewSaldoAPagar = (TextView) findViewById(R.id.resultadosCalculadoraValueSaldoPagar);
            txtViewSaldoAPagar.setText(StringSaldoAPagar);

            TextView txtViewValorDaParcelaFinal = (TextView) findViewById(R.id.resultadosCalculadoraValueParcelaFinal);
            txtViewValorDaParcelaFinal.setText(StringValorDaParcelaFinal);

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
        setContentView(R.layout.activity_calculadora);
    }


}
