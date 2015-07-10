package br.com.investdream.investdreamandroidapp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by ilegra0000208 on 10/07/2015.
 */
public class RodrigoClasseIdiotaTest {

    private RodrigoClasseIdiota rodrigoClasseIdiota;

    @Before
    public void setUp() {
        rodrigoClasseIdiota = new RodrigoClasseIdiota();
    }

    @Test
    public void shouldReturnTrueForStringStartingWith1() {
        // given

        // when
        boolean resposta = rodrigoClasseIdiota.metodoIdiota("1lalala");

        // then
        assertEquals(resposta, true);
    }


    @Test
    public void shouldReturnFalseForStringStartingWith2() {
        // given

        // when
        boolean resposta = rodrigoClasseIdiota.metodoIdiota("2lalala");

        // then
        assertEquals(resposta, false);
    }

    public void shouldThrowException() {
        // given

        // when
        boolean resposta = rodrigoClasseIdiota.metodoIdiota("lalala");

        // then
        assertEquals(resposta, false);
    }

}