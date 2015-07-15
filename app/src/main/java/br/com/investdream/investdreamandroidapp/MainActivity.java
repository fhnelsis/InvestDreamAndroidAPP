package br.com.investdream.investdreamandroidapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btCalculadora = (Button) findViewById(R.id.btCalculadora);
        Button btRegistroDeInteressados = (Button) findViewById(R.id.btRegistroDeInteressados);
        ImageView img = (ImageView) findViewById(R.id.imageView);

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

        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.investdream.com.br/"));
                startActivity(intent);
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
        if (id == R.id.action_about) {
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


}