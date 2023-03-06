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

            MostraFiguras(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.close();
    }


    private static void MostraFiguras(Connection connection) throws SQLException {
        String sqlConsulta = "SELECT * FROM MostraFiguras";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlConsulta);

        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString(3));
        }
    }

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Figura; CREATE TABLE Figura"
            + "("
            + " Id INT PRIMARY KEY,"
            + " Tipo VARCHAR(100) NOT NULL,"
            + " Cor VARCHAR(100) NOT NULL"
            + ")";
    private static final String sqlInsert1 = "INSERT INTO Figura (Id, Tipo, Cor) VALUES (1, 'Círculo', 'Vermelho')";
    private static final String sqlInsert2 = "INSERT INTO Figura (Id, Tipo, Cor) VALUES (2, 'Círculo', 'Vermelho')";
    private static final String sqlInsert3 = "INSERT INTO Figura (Id, Tipo, Cor) VALUES (3, 'Quadrado', 'Azul')";
    private static final String sqlInsert4 = "INSERT INTO Figura (Id, Tipo, Cor) VALUES (4, 'Quadrado', 'Azul')";
    private static final String sqlInsert5 = "INSERT INTO Figura (Id, Tipo, Cor) VALUES (5, 'Quadrado', 'Azul')";

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}
