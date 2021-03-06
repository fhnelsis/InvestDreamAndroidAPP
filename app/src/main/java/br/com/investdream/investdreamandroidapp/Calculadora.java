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

    private Spinner spinnerPercentualEntrada;
    private Spinner spinnerClasse;
    private Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        final EditText maskedValorCarro = (EditText) findViewById(R.id.fieldValorCarro);
        maskedValorCarro.addTextChangedListener(new MascaraMonetaria(maskedValorCarro));
        addListenerBtCalcular();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
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

        EditText valorCarro = (EditText) findViewById(R.id.fieldValorCarro);

        spinnerPercentualEntrada = (Spinner) findViewById(R.id.spinnerPercentualDeEntrada);
        String StringSpinnerPercentualEntrada = spinnerPercentualEntrada.getSelectedItem().toString();

        spinnerClasse = (Spinner) findViewById(R.id.spinnerClasse);
        String StringSpinnerClasse = spinnerClasse.getSelectedItem().toString();

        Bundle bundle = new Bundle();

        bundle.putString("valorCarro", valorCarro.getText().toString().replace("R$", "").replaceAll("\\.", "").replace(",", "."));
        bundle.putString("StringSpinnerPercentualEntrada", StringSpinnerPercentualEntrada);
        bundle.putString("StringSpinnerClasse", StringSpinnerClasse);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
