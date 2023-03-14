package com.example.carro.service.impl;

import com.example.carro.model.Carro;
import com.example.carro.service.ICarroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;

@Service
public class CarroServiceimpl implements ICarroService {
    @Override
    public List<Carro> listCarro() {
        return Arrays.asList(new Carro("Volksvagem", "Polo"), new Carro("Ford", "Focus"));
    }
}
