package br.com.investdream.investdreamandroidapp;

/**
 * Created by ilegra0000208 on 10/07/2015.
 */
public class MinhaOutraClasse {

    private RodrigoClasseIdiota rodrigoClasseIdiota;

    public MinhaOutraClasse(RodrigoClasseIdiota rodrigoClasseIdiota) {
        this.rodrigoClasseIdiota = rodrigoClasseIdiota;
    }

    public String outroMetodo(String string) {
        if (rodrigoClasseIdiota.metodoIdiota(string)) {
            return "alfa";
        }
        return "beta";
    }

    // outroMetodo(1lalaalla) --> alfa
    // outroMetodo(2lalalala) --> beta

}
