package main.dao.impl;

import main.config.ConfiguracaoJDBC;
import main.dao.IDao;
import main.model.Endereco;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Logger;

public class EnderecoDAO  implements IDao<Endereco> {
    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger logger = Logger.getLogger(String.valueOf(Endereco.class));

    public EnderecoDAO(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }
    @Override
    public Endereco salvar (Endereco endereco) {
        logger.debug("Salvando novo endereco");
        configuracaoJDBC.conectarComBancoDeDaDos();
        Statement statement = null;
        String query = String.format (" INSERT INTO endereco (rua,numero,cidade,bairro) VALUES " +"('%','%','%','%')"
        endereco.getRua(), endereco.getNumero(), endereco.getCidade(), endereco.getBairro());

        try {
            Connection connection = null;
            statement = connection.createStatement();
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedkeys = statement.getGeneratedKeys();
            if (generatedkeys.next())
                endereco.setId(generatedkeys.getInt(1));
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        return null;
    }

    @Override
    public List<Endereco> buscarTodos() {
        return null;
    }

    @Override
    public void excluir(int id) {

    }

    @Override
    public Endereco buscarPorId(int id) {
        return null;
    }
}
