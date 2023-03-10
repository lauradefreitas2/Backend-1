import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Cria uma lista de funcionários
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("João", "Silva", "2334340232", 5000));
        funcionarios.add(new Funcionario("Márcia", "Oliveira", "5423223443", 12000));
        funcionarios.add(new Funcionario("Gisele", "Braga", "3421323322", 2500));
        funcionarios.add(new Funcionario("Carlos", "Motta", "8322312324", 8000));

        // Salva a lista de funcionários em um arquivo
        try (FileWriter writer = new FileWriter("empregados.txt")) {
            for (Funcionario f : funcionarios) {
                writer.write(f.getNome() + ";" + f.getSobrenome() + ";" + f.getDocumento() + ";" + f.getSalario() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
