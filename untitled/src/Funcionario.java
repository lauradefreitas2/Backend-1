public class Funcionario {
    private String nome;
    private String salario;
    Funcionario(double salario){
        this.salario = salario;
    }
    public Funcionario(String nome, Double salario) {
        this.nome = nome;
        this.salario = salario;
    }
    Funcionario (){
        Double novoSalario = salario + salario *0.1;

    }
}
