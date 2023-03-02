package tarefa03;
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;
import java.io.*;
import java.util.*;

public class Tarefa03 {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "entrada.txt";
        File f = new File(filename);
        Scanner s = new Scanner(f);
        int saida = s.nextInt();
        int destino = s.nextInt();


        int[] producao = new int[saida];
        for(int i=0 ; i<saida;i++) {
            producao[i]=s.nextInt();
        }

        int[] demanda = new int[destino];
        for(int j=0 ; j<destino;j++) {
            demanda[j]=s.nextInt();
        }

        int [][] custoTotal = new int[saida][destino];
        for(int i=0 ; i<saida;i++){
            for(int j=0;j<destino;j++) {
                custoTotal[i][j]=s.nextInt();
            }
        }


        System.out.println("Valor das Saidas");

        for(int i=0 ; i<saida;i++) {
            System.out.print(producao[i] + " ");
        }
        System.out.println("");
        System.out.println("valor das demandas");
        for(int j=0 ; j<destino;j++) {
            System.out.print(demanda[j] + " ");
        }
        System.out.println();
        System.out.println("matix de custo");
        for(int i=0 ; i<saida;i++){
            for(int j=0;j<destino;j++) {
                System.out.print(custoTotal[i][j] + " ");
            }
            System.out.println("");
        }


        Loader.loadNativeLibraries();

        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;

        MPVariable[][] x = new MPVariable[saida][destino];

        for(int i=0 ; i < producao.length ; i++){
            for(int j=0 ; j < demanda.length  ;j++){
                x[i][j] = solver.makeIntVar(0.0,infinity,"saindas "+(i+1)+"_"+(j+1));
            }
        }
        System.out.println("Numero de variaveis = " + solver.numVariables());

        for(int i=0; i<producao.length;i++){
            MPConstraint limite3x2 = solver.makeConstraint(-infinity, producao[i], "limite1");
            for(int j=0;j < demanda.length ;j++){
                limite3x2.setCoefficient(x[i][j],1);
            }
        }


        for(int i=0; i < demanda.length ; i++){
            MPConstraint limite2x3 = solver.makeConstraint(demanda[i], demanda[i], "limite2");

            for(int j=0 ; j < producao.length ;j++){
               limite2x3.setCoefficient(x[j][i],1);
            }
        }
        System.out.println("Nnmero de restricaes = " + solver.numConstraints());

//        MPObjective max = solver.objective();

        MPObjective min = solver.objective();

//        for(int i=0; i<producao.length;i++){
//            for(int j=0;j < demanda.length ;j++){
//                max.setCoefficient(x[i][j],custoTotal[i][j]);
//            }
//        }

        for(int i=0; i<producao.length;i++){
            for(int j=0;j < demanda.length ;j++){
                min.setCoefficient(x[i][j],custoTotal[i][j]);
            }
        }


        min.setMinimization();
        MPSolver.ResultStatus result = solver.solve();

        if (result == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solucao:");
            System.out.println("Custo total = " + min.value());

            for(int i=0; i<producao.length;i++){   //2
                for(int j=0;j < demanda.length ;j++){   //3
                    System.out.println("x"+(i+1)+"_"+(j+1)+" =" +  x[i][j].solutionValue());
                }
            }
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solucao otima n�o encontrada!");
        }






    }
}
