package com.dh.aula22;

public class MVCPatternDemo {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Chevrolet", "Preto");
        VeiculoView view = new VeiculoView();
        VeiculoController controller = new VeiculoController(veiculo, view);

        controller.updateView();

        controller.setVeiculoMarca("Ford");
        controller.setVeiculoCor("Branco");

        controller.updateView();
    }
}