package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class RegistroDeInteressados extends Activity {

    private EditText nomeInteressado;
    private EditText telefoneInteressado;
    private EditText emailInteressado;
    private EditText bemDeInteresseInteressado;
    //private EditText destinatarioInvestDream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_de_interessados);

        Button btRegistrarInteresse = (Button) findViewById(R.id.btRegistrarInteresse);

        btRegistrarInteresse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                envioDeEmailRegistrarInteresse();
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

    public void envioDeEmailRegistrarInteresse() {
//TODO Implementar o envio de e-mails de registro de interessados.
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_SUBJECT, R.string.assuntoContatoInvestDream);
        intent.putExtra(Intent.EXTRA_TEXT, R.string.corpoContatoInvestDream);
        intent.putExtra(Intent.EXTRA_EMAIL, R.string.emailContatoInvestDream);
        startActivity(Intent.createChooser(intent, "Escolha o aplicativo para envio do e-mail..."));

        telefoneInteressado = (EditText) findViewById(R.id.fieldTelefoneInteressado);
        emailInteressado = (EditText) findViewById(R.id.fieldEmailInteressado);
        bemDeInteresseInteressado = (EditText) findViewById(R.id.fieldBemDeInteresseInteressado);

        Bundle bundle = new Bundle();
        bundle.putString("nomeInteressado", nomeInteressado.getText().toString());
        bundle.putString("telefoneInteressado", telefoneInteressado.getText().toString());
        bundle.putString("emailInteressado", emailInteressado.getText().toString());
        bundle.putString("bemDeInteresseInteressado", bemDeInteresseInteressado.getText().toString());
        intent.putExtras(bundle);

    }
}
