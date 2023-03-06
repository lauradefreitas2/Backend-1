import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DentistaDAO {
    private static final String URL = "jdbc:h2:~/test"; // URL do banco de dados H2
    private static final String USER = "sa"; // usuário padrão do H2
    private static final String PASSWORD = ""; // senha padrão do H2

    public static void main(String[] args) throws SQLException {
        // Cria a conexão com o banco de dados
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

        // Cria a tabela Dentista, se ela não existir
        conn.createStatement().executeUpdate(
                "CREATE TABLE IF NOT EXISTS Dentista (" +
                        "  Sobrenome VARCHAR(255) NOT NULL," +
                        "  Nome VARCHAR(255) NOT NULL," +
                        "  Matricula VARCHAR(20) NOT NULL," +
                        "  PRIMARY KEY (Matricula)" +
                        ")"
        );

        // Insere um registro na tabela Dentista
        String sobrenome = "Silva";
        String nome = "João";
        String matricula = "12345";
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO Dentista (Sobrenome, Nome, Matricula) VALUES (?, ?, ?)"
        );
        stmt.setString(1, sobrenome);
        stmt.setString(2, nome);
        stmt.setString(3, matricula);
        stmt.executeUpdate();

        // Atualiza a matrícula do registro inserido
        String novaMatricula = "54321";
        stmt = conn.prepareStatement(
                "UPDATE Dentista SET Matricula = ? WHERE Sobrenome = ? AND Nome = ?"
        );
        stmt.setString(1, novaMatricula);
        stmt.setString(2, sobrenome);
        stmt.setString(3, nome);
        stmt.executeUpdate();

        // Verifica se a inserção e modificação foram realizadas corretamente
        stmt = conn.prepareStatement("SELECT * FROM Dentista WHERE Sobrenome = ? AND Nome = ?");
        stmt.setString(1, sobrenome);
        stmt.setString(2, nome);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            System.out.println("Sobrenome: " + rs.getString("Sobrenome"));
            System.out.println("Nome: " + rs.getString("Nome"));
            System.out.println("Matrícula: " + rs.getString("Matricula"));
            if (novaMatricula.equals(rs.getString("Matricula"))) {
                System.out.println("A atualização da matrícula foi realizada corretamente.");
            } else {
                System.out.println("Erro na atualização da matrícula.");
            }
        } else {
            System.out.println("Erro na inserção do registro.");
        }

        // Fecha a conexão com o banco de dados
        conn.close();
    }
}