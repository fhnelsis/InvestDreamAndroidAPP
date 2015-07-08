package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.investdream.investdreamandroidapp.R;


public class RegistroDeInteressados extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_interessados);

        Button btRegistrarInteresse = (Button) findViewById(R.id.btRegistrarInteresse);
        btRegistrarInteresse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarInteresse();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registro_de_interessados, menu);
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

    public void registrarInteresse() {
        Intent intent = new Intent(this, RegistrarInteresse.class);

        EditText nome = (EditText) findViewById(R.id.fieldNome);
        EditText telefone = (EditText) findViewById(R.id.fieldTelefone);
        EditText enderecoEmail = (EditText) findViewById(R.id.fieldEmail);
        EditText bemDeInteresse = (EditText) findViewById(R.id.fieldBemDeInteresse);





        String to = "contato@investdream.com.br";
        String subject = "Temos um Novo Registro de Interesse!";
        String message = "Prezado(a) vendedor," +
                "Temos um novo registro de interesse criado via aplicativo móvel!" +
                "Favor contatar o interessado com os dados abaixo:" +
                "Nome: "+nome +
                "Telefone: " +telefone+
                "E-mail: "+enderecoEmail +
                "Bem de Interesse: "+bemDeInteresse;
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.setData(Uri.parse("mailto:"));
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("text/rfc822");
        startActivity(Intent.createChooser(email, "E-mail"));


    }
}
