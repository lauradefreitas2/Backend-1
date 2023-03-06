import java.sql.*;
import org.apache.log4j.Logger;
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


        }
        catch (Exception e) {
            logger.error(e);
        }
        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlupdate1);
            logger.info("Alteração de usuário ocorrida, nova alteração: "+mostrarUsuario(connection,2));
        }
        catch(Exception e){
            logger.error(e);
        }

        try{
            connection = getConnection();

            Statement statement = connection.createStatement();
            String usuarioDeletado = mostrarUsuario(connection,1);
            Integer resultSet = statement.executeUpdate(sqlDelete1);
            if(resultSet.equals(1)){
                logger.info("Funcionario excluido: "+usuarioDeletado);
            }
            usuarioDeletado = mostrarUsuario(connection,2);
            resultSet = statement.executeUpdate(sqlDelete2);
            if(resultSet.equals(1)){
                logger.info("Funcionario excluido: "+usuarioDeletado);
            }

        }catch(Exception e){
            logger.error(e);
        }
        connection.close();
    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
    private static String mostrarUsuario(Connection connection, Integer id) throws SQLException {
        String sqlConsulta = "SELECT * FROM FUNCIONARIO WHERE ID="+id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlConsulta);
        while (resultSet.next()) {
            sqlConsulta = ("ID: " + resultSet.getInt(1) + " Nome: " + resultSet.getString(2) + " Sobrenome: " + resultSet.getString(3)+" Função: "+resultSet.getString(4)+" Salário: "+resultSet.getInt(5));
        }
        return sqlConsulta;
    }
    private static final Logger logger = Logger.getLogger(Main.class);
    private static final String sqlCreateTable = """
            DROP TABLE IF EXISTS FUNCIONARIO;
            CREATE TABLE FUNCIONARIO(
            ID INT PRIMARY KEY,
            NOME VARCHAR(50),
            SOBRENOME VARCHAR(50),
            FUNCAO VARCHAR(50),
            SALARIO INT)""";

    private static final String sqlInsert1 = "INSERT INTO FUNCIONARIO(ID,NOME,SOBRENOME,FUNCAO,SALARIO) VALUES (1,'LAURA','DE FREITAS','AUXILIAR',10000)";
    private static final String sqlInsert2 = "INSERT INTO FUNCIONARIO(ID,NOME,SOBRENOME,FUNCAO,SALARIO) VALUES (2,'MILLENA','OLIVEIRA','ESTAGIARIO',1000)";
    private static final String sqlInsert3 = "INSERT INTO FUNCIONARIO(ID,NOME,SOBRENOME,FUNCAO,SALARIO) VALUES (1,'LAURA','DE FREITAS','AUXILIAR',10000)";
    private static final String sqlupdate1 = "UPDATE FUNCIONARIO SET NOME='JULIA', SALARIO=500 WHERE ID=2";
    private static final String sqlDelete1 = "DELETE FROM FUNCIONARIO WHERE ID=1";
    private static final String sqlDelete2 = "DELETE FROM FUNCIONARIO WHERE SOBRENOME='OLIVEIRA'";
}