package caxeiroviajante;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException {

        ArrayList<Arco> listaarcos = new ArrayList<Arco>();
        Leitura leitura = new Leitura();
        leitura.Leitura();
        ArrayList<Vertice> listalida = leitura.vertices;


        for (int i = 0; i < listalida.size(); i++) {
            for (int j = 0; j < listalida.size(); j++) {
                double x1 = listalida.get(i).posx;
                double x2 = listalida.get(j).posx;
                double y1 = listalida.get(i).posy;
                double y2 = listalida.get(j).posy;
                if (i != j) {
                	listaarcos.add(new Arco(i+1, j+1, Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))));
                }
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
