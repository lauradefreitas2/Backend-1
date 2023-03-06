package Aula12SBD;

import org.apache.log4j.Logger;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection connection = null;

        try {

            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);
            statement.execute(sqlInsert4);
            statement.execute(sqlInsert5);

            try {
                statement.executeUpdate(sqlInsert4);
            } catch (SQLException e) {
                if (e.getMessage().contains("Unique index or primary key violation")) {
                    logger.error("Erro ao inserir funcionário com ID repetido: " + e.getMessage());
                } else {
                    logger.error("Erro desconhecido ao inserir funcionário: " + e.getMessage());
                }
            }

            statement.execute(sqlUpdate);
            logger.debug("Funcionário atualizado");

            statement.executeUpdate(sqlDeleteById);
            logger.info("Funcionário de ID 1 foi excluído");

            statement.executeUpdate(sqlDeleteByIdade);
            logger.info("Funcionário de Idade 26 foi excluído");


            connection.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

/*
    private static void mostrarFuncionarios(Connection connection) throws SQLException {
        String sqlConsulta = "SELECT * FROM Funcionanrios";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlConsulta);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - "
                    + resultSet.getString(2) + " - "
                    + resultSet.getString(3));
        }
    }
*/
    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Funcionarios; CREATE TABLE Funcionarios"
            + "("
            + " Id INT PRIMARY KEY,"
            + " Nome VARCHAR(100) NOT NULL,"
            + " Sobrenome VARCHAR(100) NOT NULL,"
            + " Idade INT,"
            + " Email  VARCHAR(100) NOT NULL"
            + ")";

    private static final String sqlInsert1 = "INSERT INTO Funcionarios (Id, Nome, Sobrenome, Idade, Email) VALUES (1, 'CAtar', 'Julios', 37, 'decap@decap.com')";
    private static final String sqlInsert2 = "INSERT INTO Funcionarios (Id, Nome, Sobrenome, Idade, Email) VALUES (2, 'CAtar', 'Julia', 20, 'mushu@mushu.com.br')";
    private static final String sqlInsert3 = "INSERT INTO Funcionarios (Id, Nome, Sobrenome, Idade, Email) VALUES (3, 'CAtar', 'Joana', 20, 'teste@teste.com')";
    private static final String sqlInsert4 = "INSERT INTO Funcionarios (Id, Nome, Sobrenome, Idade, Email) VALUES (4, 'CAtar', 'Joao', 40, 'mavis@mavis.com')";
    private static final String sqlInsert5 = "INSERT INTO Funcionarios (Id, Nome, Sobrenome, Idade, Email) VALUES (5, 'CAtar', 'JotaP', 32, 'merlin@merlin.com')";
    private static final String sqlUpdate = "UPDATE Funcionarios SET Email='muquinho@muquinho.com' WHERE Id=3";
    private static final String sqlDeleteById = "DELETE FROM Funcionarios WHERE Id=1";
    private static final String sqlDeleteByIdade = "DELETE FROM Funcionarios WHERE Idade=37";

    private static final Logger logger= Logger.getLogger(Aula12SBD.Main.class);
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}


