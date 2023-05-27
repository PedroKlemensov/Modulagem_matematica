
package caxeiroviajante;


import java.util.ArrayList;

public class Testes {
    public static void main(String[] args) {



        ArrayList<Vertice> ListaTeste = new ArrayList<Vertice>();
        Vertice vertice = new Vertice(2, 3);
        ListaTeste.add(vertice);


        vertice = new Vertice(4, 3);
        ListaTeste.add(vertice);

        System.out.println(ListaTeste);
        System.out.println(ListaTeste.get(0).getPosx());
        System.out.println(ListaTeste.get(1).getPosx());

    }
}
