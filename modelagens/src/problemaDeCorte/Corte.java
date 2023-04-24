package problemaDeCorte;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import java.io.FileWriter;
import java.io.IOException;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPSolver.ResultStatus;
import com.google.ortools.linearsolver.MPVariable;
public class Corte {
    public int Peca;

    public int N_Cortes;

    public int[] Padroes;
    public int[] Padroes_Aux;

    public int[] Qtd_Encomenda;
    public int[] teste;

    public int[] Padroes_viaveis;

    public int Pattern(int peca, int[] teste){
        int resto = peca;
        int contador=0;

        for (int i = 0 ; i<N_Cortes ; i++){

            resto = peca - Padroes[i];

            if (resto>=Padroes[Padroes.length-1]){
                contador++;
                System.out.println(Padroes[i]+" subtraiu e resto: "+resto+ " contou: "+contador);
                teste[i]=contador;
                Pattern(resto,teste);

            }else if (resto>0){
                contador++;
                System.out.println(Padroes[i]+" entrou para tirar: "+resto+ " contou: "+contador);
                teste[i]=contador;

                Pattern(resto,teste);

            }else{
                  System.out.println("N corta "+Padroes[i]+" pois resto: "+resto);
            }



        }
        System.out.println(" ");
        for (int j=0;j<teste.length;j++){
            System.out.print(teste[j]+" ");
        }
        System.out.println(" ");
        System.out.println("-------------------------------");
        System.out.println(" ");

        for (int j=0;j<teste.length;j++){
            teste[j]=0;
        }
        System.out.println(" ");

        return resto;
    }

    public int NewPattern(int peca, int[] teste){
        int resto = peca;
        int contador=0;

        for (int i = 0 ; i<N_Cortes ; i++){

            resto = peca - Padroes[i];

            if (resto>=Padroes[Padroes.length-1]){
                contador++;
                System.out.println(Padroes[i]+" subtraiu e resto: "+resto+ " contou: "+contador);
                teste[i]=contador;
                Pattern(resto,teste);

            }else if (resto>0){
                contador++;
                System.out.println(Padroes[i]+" entrou para tirar: "+resto+ " contou: "+contador);
                teste[i]=contador;

                Pattern(resto,teste);

            }else{
                System.out.println("N corta "+Padroes[i]+" pois resto: "+resto);
            }



        }


        System.out.println(" ");
        for (int j=0;j<teste.length;j++){
            System.out.print(teste[j]+" ");
        }
        System.out.println(" ");
        System.out.println("-------------------------------");
        System.out.println(" ");

        for (int j=0;j<teste.length;j++){
            teste[j]=0;
        }
        System.out.println(" ");

        return resto;
    }

    public Corte(String input) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(input));
        Peca = scanner.nextInt();
        N_Cortes = scanner.nextInt();
        Padroes = new int[N_Cortes];
        teste = new int[N_Cortes];
        Padroes_Aux = new int[N_Cortes];
        Qtd_Encomenda = new int[N_Cortes];
        Padroes_viaveis = new int[N_Cortes*N_Cortes];

        //Matriz = new int[nNavios][nBercos];

        for(int i=0 ;i<N_Cortes;i++) {
//                Matriz[i][j]= scanner.nextInt();
                Padroes[i]=scanner.nextInt();
                Padroes_Aux[i]=Padroes[i];
        }
        for(int i=0 ;i<N_Cortes;i++) {
//                Matriz[i][j]= scanner.nextInt();
                Qtd_Encomenda[i]=scanner.nextInt();
//                System.out.println(Padroes[i]);
        }
//        System.out.println(Padroes[Padroes.length-1]);

        Pattern(Peca,teste);
        System.out.println("/////////////////////////////////////////////////////////");
        NewPattern(Peca,teste);






    }//fim do public corte




    
    public void mostrarCorte(){

    }

}
