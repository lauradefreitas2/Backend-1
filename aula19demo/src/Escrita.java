import java.io.*;

public class Escrita {

    public static void main(String[] args) throws IOException {

        //Fluxo de saida com Arquivo
        FileOutputStream fos = new FileOutputStream("lorem2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");
        bw.newLine();
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");
        bw.newLine();
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");
        bw.newLine();
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");
        bw.newLine();
        bw.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor");

        bw.close();
    }
}
