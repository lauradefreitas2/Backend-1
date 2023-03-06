package com.DH;

import org.apache.log4j.Logger;

import java.util.Arrays;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        try {
            ListaMedia listaMaior5 = new ListaMedia(Arrays.asList(1,2,3,4,5,6));
            ListaMedia listaMaior10 = new ListaMedia(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11));
            int listamedia = new ListaMedia(Arrays.asList(1,2,3,4,5)).media();
            ListaMedia listaVazia = new ListaMedia(Arrays.asList());


    } catch (Exception e) {
            logger.info("A lista é igual a zero ", e);

        }
    }
}