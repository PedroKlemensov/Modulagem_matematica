package caxeiroviajante;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Util {

    public FileWriter fw;

    public Util(String output) throws IOException {
        fw = new FileWriter(output);
    }

    public void escreveRelatorio(ArrayList<Arco> listaarcos, Modelo modelo) throws IOException {
        ArrayList<Arco> lista = listaarcos;
        escreveModelo(modelo);
        escreveDadosSaida(lista, modelo);
        fw.close();
    }


    public void escreveModelo(Modelo modelo) throws IOException {

        fw.write("/****** MODELO MATEMÁTICO ******/ \n");
        fw.write(modelo.exportModel());
        fw.write("\n\n");
    }

    public void escreveDadosSaida(ArrayList<Arco> listaarcos, Modelo modelo) throws IOException {
        ArrayList<Arco> lista = listaarcos;

        fw.write("Custo da solução ótima: " + modelo.custoSolucao + "\n");

    }
}
