package com.dh.dao.impl;

import com.dh.config.ConfiguracaoJDBC;
import com.dh.dao.IDao;
import com.dh.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Implementamos a interfacasse e tipificamos ele de acordo com a necessidade do nosso negocio (exercicio)
public class MedicamentoDao implements IDao<Medicamento> {

    //atributo para podermos fazer nossa conexao com o bando de dados
    private ConfiguracaoJDBC configuracaoJDBC;

    //para podermos usar os recursos do log4j
    private final static Logger log = Logger.getLogger(MedicamentoDao.class);

    //Construtor que obriga que quando instanciarmos um MedicamentoDAO, obrigatoriamente precisaremos ter uma conexao com o banco de dado.
    public MedicamentoDao(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    //metodo sobrescrito da nossa interface IDao
    @Override
    public Medicamento salvar(Medicamento medicamento) {
        //loga informacao sobre o medicamento recebido no parametro do metodo
        log.debug("Registrando medicamento novo: " + medicamento.toString());
        //fazendo conexao com o banco de dados
        Connection connection = configuracaoJDBC.conectarComBancoDeDaDos();
        Statement statement = null;
        //query que insere informações no banco de dados
        //atravez do recurso String.format, fazemos um replace (substituicao)
        // dos valores '%s' da query pelos parametros que recebemos no objeto(medicamento)
        String query = String.format("INSERT INTO medicamentos (nome, laboratorio, quantidade, preco) VALUES ('%s', '%s', '%s', '%s')",
                medicamento.getNome(), medicamento.getLaboratorio(), medicamento.getQuantidade(), medicamento.getPreco());
        try{
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                medicamento.setId(generatedKeys.getInt(1));
                statement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicamento;
    }
}
