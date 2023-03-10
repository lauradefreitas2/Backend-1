package com.dh.service;

import com.dh.dao.IDao;
import com.dh.model.Medicamento;

//Camada de negocio, que deve ser alheia a tudo o que é feito para se comunicar com o banco de dados
public class MedicamentoService {

    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService(IDao<Medicamento> medicamentoIDao) {
        this.medicamentoIDao = medicamentoIDao;
    }

    public Medicamento salvarMedicamento(Medicamento medicamento) {
        return medicamentoIDao.salvar(medicamento);
    }
}
