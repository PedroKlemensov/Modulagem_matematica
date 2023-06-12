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
        ArrayList<Arco>  lista = listaarcos;
        escreveModelo(modelo);
        fw.close();
    }



    public void escreveModelo(Modelo modelo) throws IOException {

        fw.write("/****** MODELO MATEMÁTICO ******/ \n");
        fw.write(modelo.exportModel());
        fw.write("\n\n");
    }

    public void escreveDadosSaida(ArrayList<Arco> listaarcos, Modelo modelo) throws IOException	{
        ArrayList<Arco>  lista = listaarcos;

        fw.write("/****** SAÍDA ******/ \n");
        fw.write("Custo da solução ótima: " + modelo.custoSolucao + "\n");
        for (int i = 0; i < lista.size(); i++)	{
            if (modelo.solucao[i] > 0) {
                Arco arco = lista.get(i);
                fw.write(arco.toString());
            }
        }
    }
}
