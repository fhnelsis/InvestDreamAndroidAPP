package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Calculadora extends Activity implements View.OnClickListener {

    private EditText edtValorCarro;
    private EditText edtValorEntrada;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        btCalcular = (Button) findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });
    }

    public void onClick(View v) {
        double valorCarro = Double.parseDouble(edtValorCarro.getText().toString());
        double valorEntrada = Double.parseDouble(edtValorEntrada.getText().toString());

        double up = (valorCarro * 1.25);
        double valorTitulo  = (up * 2);
        double valorParcela = (up / 60);
        double valorEntradaPaga = valorEntrada;
        double saldoPagar = (valorTitulo - valorEntradaPaga);
        double valorParcelaFinal = (saldoPagar / 90);
        //int mesesResgate;
        //Todo Verificar como os meses para resgate entram no cálculo.

        Intent intent = new Intent(this, ResultadosCalculadora.class);
        intent.putExtra("up", up);
        intent.putExtra("valorTitulo", valorTitulo);
        intent.putExtra("valorParcela", valorParcela);
        intent.putExtra("valorEntradaPaga", valorEntradaPaga);
        intent.putExtra("saldoPagar", saldoPagar);
        intent.putExtra("valorParcelaFinal", valorParcelaFinal);


        setContentView(R.layout.activity_resultados_calculadora);
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

}
