package com.dh.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC {

    private String jdbcDriver;

    private String dbUrl;

    private String nomeUsuario;

    private String senha;


    //Construtor: quando instanciamos um objeto ConfiguracaoJDBC ele virar com essas configuracoes que setamos diretamente no construtor.
    //"org.h2.Driver" refere-se ao Driver do banco de dados que estamos utilizando
    //jdbc:h2:~/medicamentos2 refere-se a url do nosso banco de dados
    //INIT=RUNSCRIPT FROM 'create.sql' ao criarmos uma conexao, o scrip que cria a tabela sera executado
    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/medicamentos2;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
        this.nomeUsuario = "sa";
        this.senha = "";
    }

    //Metodo que realiza a conexao
    public Connection conectarComBancoDeDaDos() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, nomeUsuario, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
