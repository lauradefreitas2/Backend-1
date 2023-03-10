import java.io.*;

public class CopiarArquivo {
    public static void main(String[] args) {
        // Cria os objetos File para representar o arquivo de origem e o arquivo de destino
        File arquivoOrigem = new File("lorem.txt");
        File arquivoDestino = new File("lorem2.txt");

        try {
            // Cria os objetos BufferedReader e BufferedWriter
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoOrigem));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoDestino));

            // Lê cada linha do arquivo de origem e escreve no arquivo de destino
            String linha;
            while ((linha = leitor.readLine()) != null) {
                escritor.write(linha);
                escritor.newLine();
            }

            // Fecha o BufferedReader e o BufferedWriter
            leitor.close();
            escritor.close();

            System.out.println("Arquivo copiado com sucesso.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}