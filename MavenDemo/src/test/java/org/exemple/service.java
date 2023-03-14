package org.exemple;
import org.example.config.ConfiguracaoJDBC;
import org.example.dao.IDao;
import org.example.dao.impl.EnderecoDao;
import org.example.dao.impl.PacienteDao;
import org.example.model.Endereco;
import org.example.model.Paciente;
import main.service.PacienteService;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class PacienteServiceTest {

    public PacienteService pacienteService = new PacienteService(new PacienteDao(new EnderecoDao()));


    @Test
    void teste() throws ParseException {


        Endereco endereco = new Endereco("Carlos Wagner","1434","Aviação","Venancio Aires");
        Paciente paciente = new Paciente("Darlei","Feix","6116", Date.valueOf(LocalDate.now()),endereco);
        pacienteService.salvar(paciente);
        System.out.println(pacienteService.buscarTodos());
    }

}