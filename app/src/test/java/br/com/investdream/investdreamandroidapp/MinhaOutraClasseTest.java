package br.com.investdream.investdreamandroidapp;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;

import static org.junit.Assert.*;

/**
 * Created by ilegra0000208 on 10/07/2015.
 */
public class MinhaOutraClasseTest {

    @Test
    public void foo() {
        // given

        // mockado para o teste ficar unitario
        RodrigoClasseIdiota mock = BDDMockito.mock(RodrigoClasseIdiota.class);
        BDDMockito.given(mock.metodoIdiota("1")).willReturn(true);
        BDDMockito.given(mock.metodoIdiota("2")).willReturn(false);

        // Teste sem nenhum mock... nao eh unitario.
        RodrigoClasseIdiota naoMock = new RodrigoClasseIdiota();



        // Pego a minha classe. (A diferença entre mock ou não, se dá na chamada do método.
        // Trocar "mock" por "naoMock".
        MinhaOutraClasse minhaOutraClasse = new MinhaOutraClasse(mock);

        // Chamo meu metodo.
        String resposta = minhaOutraClasse.outroMetodo("1lalala");

        // Vejo se tá ok.
        assertEquals(resposta, "alfa");

    }
}