package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalculadora = (Button) findViewById(R.id.btCalculadora);
        Button btRegistroDeInteressados = (Button) findViewById(R.id.btRegistroDeInteressados);

        btCalculadora.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculadora();
            }
        });

        btRegistroDeInteressados.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                registroDeInteressados();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void calculadora() {
        Intent telaCalculadora = new Intent(MainActivity.this, Calculadora.class);
        startActivity(telaCalculadora);
    }

    public void registroDeInteressados() {
        Intent telaRegistroDeInteressados = new Intent(MainActivity.this, RegistroDeInteressados.class);
        startActivity(telaRegistroDeInteressados);
    }

    public void calcular(View view) {
        Intent intent = new Intent(this, ResultadosCalculadora.class);

        EditText valordoBem = (EditText) findViewById(R.id.fieldValorDoBem);
        EditText valordaEntrada = (EditText) findViewById(R.id.fieldValorDaEntrada);

        Bundle bundle = new Bundle();

        bundle.putString("valorDoBem", valordoBem.getText().toString());
        bundle.putString("valordaEntrada", valordaEntrada.getText().toString());

        intent.putExtras(bundle);

        startActivity(intent);
    }
}