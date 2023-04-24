package problemaDeCorte;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPSolver.ResultStatus;
import com.google.ortools.linearsolver.MPVariable;


public class Modelo_Corte {
    public MPObjective objectiveAdapt;
    public MPSolver solverAdapt;
    public MPVariable[] x;
    public double custoSolucao;
    public double[][] solucao;


    public Modelo_Corte (Corte cut){
        int[] need={70,100,120};
        int[] resto={10,0,30,20,40};
        int[][] padroes={{1,1,0},{0,0,3},{0,2,0},{1,0,1},{0,1,1}};

        System.out.println(padroes[0][0]);
        System.out.println(padroes.length);
        System.out.println(padroes[0].length);


        Loader.loadNativeLibraries();
        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = Double.POSITIVE_INFINITY;

        //x receber o tamanho da lista de resto que conseguirimos depois de rodar todos os padr�es e pegar seus restos
        x = new MPVariable[resto.length];

        for (int i=0;i < x.length ; i++){
            x[i]= solver.makeIntVar(0.0, infinity ,"x "+(i+1));
        }
        System.out.println("Numero de variaveis = " + solver.numVariables());

        MPObjective min = solver.objective();
        for (int i=0; i < resto.length ; i++){
            min.setCoefficient(x[i],resto[i]);
        }
        min.setMinimization();


        for (int i=0;i < need.length ; i++) {
            MPConstraint ct = solver.makeConstraint(need[i],infinity, "teste "+(i+1));

            for (int j=0;j< padroes.length;j++){
                ct.setCoefficient(x[j],padroes[j][i]);
            }
        }

        MPSolver.ResultStatus result = solver.solve();

        if (result == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solu��o:");
            System.out.println("Tempo de resolu��o = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solu��o �tima n�o encontrada!");
        }






    }

}
