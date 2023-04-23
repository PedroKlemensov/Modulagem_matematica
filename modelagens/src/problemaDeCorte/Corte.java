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

    public int[] Padroes_viaveis;

    public int[][] pradroes;

    public int Pattern(int peca){
        int resto = peca;
        int contador=0;
        int[] teste_aux = new int[N_Cortes];

        for (int i = 0 ; i<N_Cortes ; i++){

            //tudo em fun��o da subtra��o da Pe�a
            resto = peca - Padroes[i];

            //menor padrao sempre vai ser o ultimo da Padroes[n] para facilitar a vida
            //aqui ele entra se o padr�o ainda for maior que o menor valor para possibilitar a repeti��o
            if (resto>=Padroes[Padroes.length-1]){
                contador++;
                System.out.println(Padroes[i]+" subtraiu e resto: "+resto+ " contou: "+contador);
                teste_aux[i]=contador;
                //aqui exemplificando o resto na primeira rodada vai ser 70 e vai rerodar com a inten��o de denovo tirar da menor pe�a
                Pattern(resto);


            // para ter uma "segunda opini�o" e rerodar para poder ver proximos valores
            }else if (resto>0){
                //talvez botar em fun��o de resto>=0 && resto <= menor padr�o
                contador++;
                System.out.println(Padroes[i]+" entrou para tirar: "+resto+ " contou: "+contador);
                teste_aux[i]=contador;
                Pattern(resto);


            //para finalizar e ver qual era o resto do final
            }

        }
        System.out.println("-------------------------------");
        return resto;
    }




    public int NovoPattern(int peca){
       int faltante = peca;
       int contator = 0;
       int[] 






        return faltante;
    }




        public Corte(String input) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(input));
        Peca = scanner.nextInt();
        N_Cortes = scanner.nextInt();
        Padroes = new int[N_Cortes];
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

        Pattern(Peca);






    }//fim do public corte




    
    public void mostrarCorte(){

    }

}
