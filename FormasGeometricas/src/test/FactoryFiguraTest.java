package test;

import model.Quadrado;
import model.Triangulo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.FactoryFigura;

public class FactoryFiguraTest {

    @Test
    void getTriangulo(){

        Triangulo triangulo1 = FactoryFigura.obterTriangulo("Vermelho");
        triangulo1.setTamanho(2);

        Triangulo triangulo2 = FactoryFigura.obterTriangulo("Vermelho");
        triangulo1.setTamanho(1);

        //validação para ver se a cor é realmente vermelha
        Assertions.assertEquals(triangulo1.getCor(), "Vermelho");

        //validação para ver se o tamanho o triangulo é "1"
        Assertions.assertEquals(triangulo2.getTamanho(), 1);

        //validação para ver se o tamanho da lista é de "1"
        Assertions.assertEquals(FactoryFigura.trianguloHashMap.size() == 1, true);
    }

    @Test
    void getQuadrado() {

        Quadrado quadrado1 = FactoryFigura.obterQuadrado(2);
        quadrado1.setCor("vermelho");

        Quadrado quadrado2 = FactoryFigura.obterQuadrado(2);
        quadrado2.setCor("Verde");

        //validação para ver se a cor é realmente vermelha
        Assertions.assertEquals(quadrado1.getCor(), "vermelho");

        //validação para ver se o tamanho o triangulo é "1"
        Assertions.assertEquals(quadrado2.getTamanho(), "Verde");

        //validação para ver se o tamanho da lista é de "1"
        Assertions.assertEquals(FactoryFigura.quadradoHashMap.size() == 1, true);

    }


}
