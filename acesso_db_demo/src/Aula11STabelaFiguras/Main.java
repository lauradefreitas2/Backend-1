package Aula11STabelaFiguras;

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

            mostrarFigura(connection);

            statement.execute(sqlDelete);

            mostrarFigura(connection);


        } catch (Exception e) {
            e.printStackTrace();
        }

        connection.close();
    }


    private static void mostrarFigura(Connection connection) throws SQLException {
        String sqlConsulta = "SELECT * FROM Figura";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlConsulta);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - "
                    + resultSet.getString(2) + " - "
                    + resultSet.getString(3));
        }
    }

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Figura; CREATE TABLE Figura"
            + "("
            + " Id INT PRIMARY KEY,"
            + " Cor VARCHAR(100) NOT NULL,"
            + " TipoFigura VARCHAR(100) NOT NULL"
            + ")";

    private static final String sqlInsert1 = "INSERT INTO Figura (Id, Cor, TipoFigura) VALUES (1, 'vermelho', 'Circulo')";
    private static final String sqlInsert2 = "INSERT INTO Figura (Id, Cor, TipoFigura) VALUES (2, 'verde', 'Quadrado')";
    private static final String sqlInsert3 = "INSERT INTO Figura (Id, Cor, TipoFigura) VALUES (3, 'azul', 'Quadrado')";
    private static final String sqlInsert4 = "INSERT INTO Figura (Id, Cor, TipoFigura) VALUES (4, 'marrom', 'Circulo')";
    private static final String sqlInsert5 = "INSERT INTO Figura (Id, Cor, TipoFigura) VALUES (5, 'roxo', 'Quadrado')";
    private static final String sqlDelete = "DELETE FROM Animal WHERE Id=2";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}
