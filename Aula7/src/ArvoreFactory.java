import java.util.HashMap;
import java.util.Map;

public class ArvoreFactory {

    private static HashMap<String, Arvores> flyweight = new HashMap<>();

    public Arvores getArvores(int altura, int largura, String cor, String tipo) {

        String id = "id: " + altura + ": " + largura + ": " + cor + ": " + tipo;

        System.out.println(id);

        if (!flyweight.containsKey(id)) {
            Arvores arvore = new Arvores(altura, largura, cor, tipo);
            flyweight.put(id, arvore);
            System.out.println("Arvore Criada!");
            return flyweight.get(id);
        }
        System.out.println("Arvore Obtida");
        exibirMemoria();
        return flyweight.get(id);
    }

    public void exibirMemoria(){
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memória utilizada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }


}
