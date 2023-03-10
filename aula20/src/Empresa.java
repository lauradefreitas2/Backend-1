import java.io.*;

public class Empresa implements Serializable {
    private String cnpj;
    private String razaoSocial;
    private Funcionario[] funcionarios;

    public Empresa(String cnpj, String razaoSocial, Funcionario[] funcionarios) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.funcionarios = funcionarios;
    }

    public void salvarEmpresa(String arquivo) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo));
        oos.writeObject(this);
        oos.close();
    }

    public static Empresa carregarEmpresa(String arquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        Empresa empresa = (Empresa) ois.readObject();
        ois.close();
        return empresa;
    }

    public static void main(String[] args) {
        Funcionario[] funcionarios = new Funcionario[4];
        funcionarios[0] = new Funcionario("João", "Silva", "2334340232", 5000);
        funcionarios[1] = new Funcionario("Márcia", "Oliveira", "5423223443", 12000);
        funcionarios[2] = new Funcionario("Gisele", "Braga", "3421323322", 2500);
        funcionarios[3] = new Funcionario("Carlos", "Motta", "8322312324", 8000);

        Empresa empresa = new Empresa("123456789", "Empresa XYZ", funcionarios);

        try {
            empresa.salvarEmpresa("empresa.dat");
            Empresa empresaRecuperada = Empresa.carregarEmpresa("empresa.dat");
            System.out.println(empresaRecuperada.getCnpj());
            System.out.println(empresaRecuperada.getRazaoSocial());
            for (Funcionario f : empresaRecuperada.getFuncionarios()) {
                System.out.println(f.getNome() + " " + f.getSobrenome() + " " + f.getDocumento() + " " + f.getSalario());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public Funcionario[] getFuncionarios() {
        return funcionarios;
    }
}


