package problemaDeCorte;
import com.google.ortools.linearsolver.MPSolver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Corte {
    public int Peca;
    public int Peca_fixa;
    public int N_Cortes;
    public int[] Padroes;
    public int[] Padroes_Aux;
    public int[] Qtd_Encomenda;
    public int[] teste;
    public int[][] Padroes_viaveis;
    public int[][] Padroes_viaveis_teste = {{1,1,0},{0,0,3},{0,2,0},{1,0,1},{0,1,1}};
    public Vector<int[]> vector2D;
    public int[] resto;
    public int contad_aux;

    public MPSolver solver;

    public int[] cleanseMe(int[] teste,int posicao){
        //salvar o vetor que vai ser limpado no Padroes_Viavei
        vector2D.add(teste);

        System.out.println(" ");
        for (int j=0;j<teste.length;j++){
            System.out.print(teste[j]+" ");
        }
        System.out.println(" ");

        contad_aux=teste[posicao];
        for (int i=0;i< teste.length;i++){
            teste[i]=0;
        }
        teste[posicao]=contad_aux;

        return teste;
    }

    public int Pattern(int peca, int[] teste,int contador){

        if (peca >= Padroes[Padroes.length-1]) {

            for (int i = 0; i < N_Cortes; i++) {
                int resto = peca - Padroes[i];
                System.out.println("corte "+Padroes[i]+" o resto "+resto);
                if (resto >= 0){
                    teste[i]++;
                    int soma=0;
                    for (int j=0;j < teste.length;j++){
                        soma+= teste[j]*Padroes[j];
                    }
                    if (soma > Peca_fixa){
                        teste[i]--;
                    }

                    Pattern(resto,teste,contador);
                }
            }
        }else{

            cleanseMe(teste,contador);

        }
        System.out.println(" ");
        return 0;
    }
        

    public Corte(String input) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(input));
        Peca = scanner.nextInt();
        Peca_fixa=Peca;
        N_Cortes = scanner.nextInt();
        Padroes = new int[N_Cortes];
        teste = new int[N_Cortes];
        Padroes_Aux = new int[N_Cortes];
        Qtd_Encomenda = new int[N_Cortes];
        Padroes_viaveis = new int[5][N_Cortes];
        vector2D = new Vector<>(N_Cortes*N_Cortes);
        //"5" vai ter que pegar o lengh da qtd dos padroes viaveis

        for(int i=0 ;i<N_Cortes;i++) {
                Padroes[i]=scanner.nextInt();
                Padroes_Aux[i]=Padroes[i];
        }
        for(int i=0 ;i<N_Cortes;i++) {
                Qtd_Encomenda[i]=scanner.nextInt();
        }

        for (int i=0;i<N_Cortes;i++){

            System.out.println("rodada "+(i+1));

            Pattern(Peca,teste,i);

            System.out.println();

        }

        for (int i=0;i<vector2D.size();i++){
            System.out.println();
                for (int j=0;j<N_Cortes;j++){
                    System.out.print(vector2D.get(i)[j]+" ");
                }
        }



        resto = new int[5];
        //"5" vai ter que pegar o lengh da qtd dos padroes viaveis


        for (int i=0;i<5;i++){
            int soma_aux=0;
            int resto_aux=0;
            for (int j=0;j<N_Cortes;j++){
                soma_aux += (Padroes_viaveis_teste[i][j]*Padroes[j]);
            }
            resto_aux= Peca-soma_aux;
            resto[i]=resto_aux;
        }
//
//        System.out.println("");
//        for (int i=0;i<resto.length;i++){
//            System.out.print(resto[i]+" ");
//        }
//        System.out.println("");



    }//fim do public corte
}
