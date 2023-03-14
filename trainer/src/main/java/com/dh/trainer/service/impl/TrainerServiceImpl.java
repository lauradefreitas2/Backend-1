package com.dh.trainer.service.impl;

import com.dh.trainer.model.Trainer;
import com.dh.trainer.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Override
    public List<Trainer> listTrainer() {
        return Arrays.asList(new Trainer("Marcos1"), new Trainer("Ana"));
    }
}
