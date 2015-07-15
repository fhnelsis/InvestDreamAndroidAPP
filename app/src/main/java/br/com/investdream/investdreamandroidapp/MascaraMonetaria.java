package br.com.investdream.investdreamandroidapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by FranciscoHenrique on 14/07/2015.
 */
public class MascaraMonetaria implements TextWatcher {
    final EditText campo;

    public MascaraMonetaria(EditText campo) {
        super();
        this.campo = campo;
    }

    private boolean isUpdating = false;
    // Pega a formatacao do sistema, se for brasil R$
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int after) {
        // Evita que o método seja executado varias vezes. Se tirar ele entre em loop.
        if (isUpdating) {
            isUpdating = false;
            return;
        }
        isUpdating = true;
        String str = s.toString();
        // Verifica se já existe a máscara no texto.
        boolean hasMask = ((str.indexOf("R$") > -1 || str.indexOf("$") > -1) && (str.indexOf(".") > -1 || str.indexOf(",") > -1));
        // Verifica se existe máscara
        if (hasMask) {
            // Retira a máscara.
            str = str.replaceAll("[R$]", "").replaceAll("[,]", "").replaceAll("[.]", "");
        }
        try {
            // Transforma o número que está escrito no EditText em monetário.
            str = nf.format(Double.parseDouble(str) / 100);
            campo.setText(str);
            campo.setSelection(campo.getText().length());
        } catch (NumberFormatException e) {
            s = "";
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}