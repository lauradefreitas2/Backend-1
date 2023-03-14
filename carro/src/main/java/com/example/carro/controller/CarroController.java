package com.example.carro.controller;

import com.example.carro.model.Carro;
import com.example.carro.service.ICarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//ANOTAÇÃO PARA INDICAAR QUE ESSA CLASSE É UM CONTROLLER
@RestController

//ANOTAÇÃO PARA MAPEAR A CLASSE "CARRO"
@RequestMapping("/Carro")
public class CarroController {

    private final ICarroService carroService;

    @Autowired
    public CarroController(ICarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public List<Carro> getCarro(){
        return carroService.listCarro();
    }
}
