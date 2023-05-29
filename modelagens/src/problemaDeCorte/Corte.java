//package problemaDeCorte;
//<<<<<<< Updated upstream
//import com.google.ortools.linearsolver.MPSolver;
//
//=======
//>>>>>>> Stashed changes
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.*;
//
//public class Corte {
//    public int Peca;
//<<<<<<< Updated upstream
//    public int Peca_fixa;
//=======
//>>>>>>> Stashed changes
//    public int N_Cortes;
//    public int[] Padroes;
//    public int[] Padroes_Aux;
//    public int[] Qtd_Encomenda;
//    public int[] teste;
//    public int[][] Padroes_viaveis;
//    public int[][] Padroes_viaveis_teste = {{1,1,0},{0,0,3},{0,2,0},{1,0,1},{0,1,1}};
//<<<<<<< Updated upstream
//    public Vector<int[]> vector2D;
//    public int[] resto;
//    public int contad_aux;
//
//    public MPSolver solver;
//
//    public int[] cleanseMe(int[] teste,int posicao){
//        //salvar o vetor que vai ser limpado no Padroes_Viavei
//        vector2D.add(teste);
//=======
//    public int[] resto;
//
//    public int contador=0;
//    public void cleanseMe(int[] teste,int posicao){
//>>>>>>> Stashed changes
//
//        System.out.println(" ");
//        for (int j=0;j<teste.length;j++){
//            System.out.print(teste[j]+" ");
//        }
//        System.out.println(" ");
//<<<<<<< Updated upstream
//
//        contad_aux=teste[posicao];
//        for (int i=0;i< teste.length;i++){
//            teste[i]=0;
//        }
//        teste[posicao]=contad_aux;
//
//        return teste;
//    }
//
//    public int Pattern(int peca, int[] teste,int contador){
//
//=======
//        int auxnovo=posicao;
//        int valor=teste[posicao];
//        int aux=teste[posicao];
//        for (int i=0;i< teste.length;i++){
//            teste[i]=0;
//        }
//        teste[posicao]=valor;
//    }
//
//    public void cleanall (){
//        for(int i = 0; i > teste.length;i++){
//            teste[i]=0;
//        }
//    }
//    public int Pattern(int peca, int[] teste){
// //   int contador = 0;
//>>>>>>> Stashed changes
//        if (peca >= Padroes[Padroes.length-1]) {
//
//            for (int i = 0; i < N_Cortes; i++) {
//                int resto = peca - Padroes[i];
//                System.out.println("corte "+Padroes[i]+" o resto "+resto);
//                if (resto >= 0){
//<<<<<<< Updated upstream
//                    teste[i]++;
//                    int soma=0;
//                    for (int j=0;j < teste.length;j++){
//                        soma+= teste[j]*Padroes[j];
//                    }
//                    if (soma > Peca_fixa){
//                        teste[i]--;
//                    }
//
//                    Pattern(resto,teste,contador);
//=======
//                    System.out.println("entro "+ resto);
//                    teste[i]++;
//                    Pattern(resto,teste);
//
//
//
//>>>>>>> Stashed changes
//                }
//            }
//        }else{
//
//            cleanseMe(teste,contador);
//<<<<<<< Updated upstream
//
//        }
//        System.out.println(" ");
//        return 0;
//    }
//
//=======
//            if(contador >= teste.length-1){
//                contador = teste.length-1;
//            }else {contador++;}
//        }
//
//        System.out.println(" ");
//        return 0;
//    }
//
//>>>>>>> Stashed changes
//
//    public Corte(String input) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new FileReader(input));
//        Peca = scanner.nextInt();
//        Peca_fixa=Peca;
//        N_Cortes = scanner.nextInt();
//        Padroes = new int[N_Cortes];
//        teste = new int[N_Cortes];
//        Padroes_Aux = new int[N_Cortes];
//        Qtd_Encomenda = new int[N_Cortes];
//        Padroes_viaveis = new int[5][N_Cortes];
//<<<<<<< Updated upstream
//        vector2D = new Vector<>(N_Cortes*N_Cortes);
//=======
//
//>>>>>>> Stashed changes
//        //"5" vai ter que pegar o lengh da qtd dos padroes viaveis
//
//        for(int i=0 ;i<N_Cortes;i++) {
//                Padroes[i]=scanner.nextInt();
//                Padroes_Aux[i]=Padroes[i];
//        }
//        for(int i=0 ;i<N_Cortes;i++) {
//                Qtd_Encomenda[i]=scanner.nextInt();
//        }
//<<<<<<< Updated upstream
//
//        for (int i=0;i<N_Cortes;i++){
//
//            System.out.println("rodada "+(i+1));
//
//            Pattern(Peca,teste,i);
//
//            System.out.println();
//
//        }
//
//        for (int i=0;i<vector2D.size();i++){
//            System.out.println();
//                for (int j=0;j<N_Cortes;j++){
//                    System.out.print(vector2D.get(i)[j]+" ");
//                }
//        }
//=======
//
//
//        Pattern(Peca,teste);
//>>>>>>> Stashed changes
//
//        resto = new int[5];
//        //"5" vai ter que pegar o lengh da qtd dos padroes viaveis
//
//        for (int i=0;i<resto.length;i++){
//            System.out.println(resto[i]);
//        }
//
//<<<<<<< Updated upstream
//        resto = new int[5];
//        //"5" vai ter que pegar o lengh da qtd dos padroes viaveis
//
//
//=======
//>>>>>>> Stashed changes
//        for (int i=0;i<5;i++){
//            int soma_aux=0;
//            int resto_aux=0;
//            for (int j=0;j<N_Cortes;j++){
//                soma_aux += (Padroes_viaveis_teste[i][j]*Padroes[j]);
//            }
//            resto_aux= Peca-soma_aux;
//            resto[i]=resto_aux;
//        }
//<<<<<<< Updated upstream
////
////        System.out.println("");
////        for (int i=0;i<resto.length;i++){
////            System.out.print(resto[i]+" ");
////        }
////        System.out.println("");
//=======
//
//        for (int i=0;i<resto.length;i++){
//            System.out.println(resto[i]);
//        }
//>>>>>>> Stashed changes
//
//
//
//    }//fim do public corte
//}
