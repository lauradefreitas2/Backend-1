package model;

public class Quadrado {

    //ATRIBUTOS
    private String cor;

    private int tamanho;

    private static int contador;


    //CONSTRUTOR
    public Quadrado(int tamanho) {
        this.tamanho = tamanho;
        this.contador++;
        System.out.println( "Criando uma nova instancia: " + contador);
    }


    //GETTERS AND SETTERS
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
