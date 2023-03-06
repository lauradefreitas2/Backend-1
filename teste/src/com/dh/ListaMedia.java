package com.dh;

import org.apache.log4j.Logger;

import java.util.List;

public class ListaMedia {

    private static final Logger logger = Logger.getLogger(ListaMedia.class);

    private List<Integer> lista;

    public ListaMedia(List<Integer> lista) throws Exception {
        this.lista = lista;
        comprarLista(lista);
    }

    public void  comprarLista(List<Integer> inteiros) throws Exception {
        if (inteiros.size() >5 && inteiros.size() < 10) {
            logger.info("o comprimento da lista é maior que 5");
        }
        if (inteiros.size() > 10) {
            logger.info("o comprimento da lista é maior do que 10");
        }
        if (inteiros.size() == 0) {
            throw new Exception();
        }
    }

      public int media () {
        int soma = 0;
        for (Integer inteiro: lista) {
            soma = soma + inteiro;
        }
        int media = soma / lista.size();
        logger.info("a media da lista é" + media);
        return media;
    }
}
