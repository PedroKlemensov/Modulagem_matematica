
package caxeiroviajante;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Arco> listaarcos= new ArrayList<Arco>();


        Leitura leitura = new Leitura();
        leitura.Leitura();
        ArrayList<Vertice> listalida = leitura.vertices;


        for (int i = 0; i < listalida.size(); i++){
            for (int j = 0; j < listalida.size(); j++){
                double x1 = listalida.get(i).posx;
                double x2 = listalida.get(j).posx;
                double y1 = listalida.get(i).posy;
                double y2 = listalida.get(j).posy;
                //System.out.println(x1 +" "+x2 +" "+y1 +" "+y2 +" ");
               listaarcos.add(new Arco(i,j, Math.sqrt(  Math.pow(x1-x2,2)  + Math.pow(y1 - y2,2))));
            }
        }

//        Math.sqrt(  Math.pow(listalida.get(i).posx - listalida.get(j).posx)  + Math.pow(listalida.get(i).posy - listalida.get(j).posy)    );
        for (int i = 0; i < listaarcos.size(); i++) {
            System.out.println(listaarcos.get(i).origem + " " + listaarcos.get(i).destino + " " +listaarcos.get(i).distancia );
        }
        Modelo modelo = new Modelo(listaarcos);
        modelo.solve();


    }
}