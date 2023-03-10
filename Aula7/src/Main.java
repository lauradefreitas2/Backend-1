import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArvoreFactory arvoreFactory = new ArvoreFactory();

        ArrayList<Arvores> floresta = new ArrayList<>();

        for (int i = 0; i < 500000; i++) {

             floresta.add(arvoreFactory.getArvores(500, 300, "vermelha", "Frutiferas"));

             floresta.add(arvoreFactory.getArvores(200, 400, "verde", "Ornamental"));

        }

        System.out.println(floresta.size());

    }
}