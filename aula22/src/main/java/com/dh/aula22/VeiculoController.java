package com.dh.aula22;

public class VeiculoController {
    private Veiculo model;
    private VeiculoView view;

    public VeiculoController(Veiculo model, VeiculoView view) {
        this.model = model;
        this.view = view;
    }

    public void setVeiculoMarca(String marca) {
        model.setMarca(marca);
    }

    public String getVeiculoMarca() {
        return model.getMarca();
    }

    public void setVeiculoCor(String cor) {
        model.setCor(cor);
    }

    public String getVeiculoCor() {
        return model.getCor();
    }

    public void updateView() {
        view.printVeiculoDetails(model.getMarca(), model.getCor());
    }
}