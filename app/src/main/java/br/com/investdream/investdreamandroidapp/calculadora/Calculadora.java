package br.com.investdream.investdreamandroidapp.calculadora;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.investdream.investdreamandroidapp.R;


public class Calculadora extends Activity {

    private EditText edtValorBem;
    private EditText edtValorEntrada;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        //inicializarElementos();
        Button btCalcular = (Button) findViewById(R.id.btCalcular);
        //carregaListeners();

        btCalcular.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                calcular();
            }
        });
    }

    private void calcular(){
        Intent intent = new Intent(Calculadora.this, ResultadosCalculadora.class);
                Double valorCarro = Double.parseDouble(edtValorBem.getText().toString());
                Double valorEntrada = Double.parseDouble(edtValorEntrada.getText().toString());

                Double valorEntradaPaga = valorEntrada;
                Double up = (valorCarro * 1.25);
                Double valorTitulo = (up * 2);
                Double valorParcela = (up / 60);
                Double saldoPagar = (valorTitulo - valorEntradaPaga);
                Double valorParcelaFinal = (saldoPagar / 90);

                //TODO Verificar como os meses para resgate entram no cálculo.

                intent.putExtra("intentValorEntradaPaga", valorEntradaPaga);
                intent.putExtra("intentUp", up);
                intent.putExtra("intentValorTitulo", valorTitulo);
                intent.putExtra("intentValorParcela", valorParcela);
                intent.putExtra("intentSaldoPagar", saldoPagar);
                intent.putExtra("intentValorParcelaFinal", valorParcelaFinal);

                startActivity(intent);
                setContentView(R.layout.activity_resultados_calculadora);
    }

//    private void inicializarElementos() {
//        Button btCalcular = (Button) findViewById(R.id.btCalcular);
//        edtValorBem = (EditText) findViewById(R.id.fieldValorDoBem);
//        edtValorEntrada = (EditText) findViewById(R.id.fieldValorDaEntrada);
//    }

//    private void carregaListeners() {
//
//        btCalcular.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Calculadora.this, ResultadosCalculadora.class);
//                Double valorCarro = Double.parseDouble(edtValorBem.getText().toString());
//                Double valorEntrada = Double.parseDouble(edtValorEntrada.getText().toString());
//
//                Double valorEntradaPaga = valorEntrada;
//                Double up = (valorCarro * 1.25);
//                Double valorTitulo = (up * 2);
//                Double valorParcela = (up / 60);
//                Double saldoPagar = (valorTitulo - valorEntradaPaga);
//                Double valorParcelaFinal = (saldoPagar / 90);
//
//                //TODO Verificar como os meses para resgate entram no cálculo.
//
//                intent.putExtra("intentValorEntradaPaga", valorEntradaPaga);
//                intent.putExtra("intentUp", up);
//                intent.putExtra("intentValorTitulo", valorTitulo);
//                intent.putExtra("intentValorParcela", valorParcela);
//                intent.putExtra("intentSaldoPagar", saldoPagar);
//                intent.putExtra("intentValorParcelaFinal", valorParcelaFinal);
//
//                startActivity(intent);
//                setContentView(R.layout.activity_resultados_calculadora);
//
//            }
//        });
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
