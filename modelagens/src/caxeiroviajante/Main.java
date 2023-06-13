
package caxeiroviajante;

import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;


public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Arco> listaarcos = new ArrayList<Arco>();


        Leitura leitura = new Leitura();
        leitura.Leitura();
        ArrayList<Vertice> listalida = leitura.vertices;


        for (int i = 1; i < listalida.size()+1; i++) {
            for (int j = 1; j < listalida.size()+1; j++) {
                double x1 = listalida.get(i).posx;
                double x2 = listalida.get(j).posx;
                double y1 = listalida.get(i).posy;
                double y2 = listalida.get(j).posy;
                listaarcos.add(new Arco(i, j, Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))));
            }
        }










        Modelo modelo = new Modelo(listaarcos,listalida);
        modelo.solve();
        modelo.setSolution(listaarcos);

        String output = "minhasaida.txt";
        Util util = new Util(output);
        util.escreveRelatorio(listaarcos, modelo);


    }
}
