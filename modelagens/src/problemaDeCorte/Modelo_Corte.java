package problemaDeCorte;
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.beans.ParameterDescriptor;


public class Modelo_Corte {

    public MPSolver solver;
    public MPObjective min;

    public MPVariable[] x;
    public double custoSolucao;
    public double[][] solucao;


    public Modelo_Corte (Corte cut){
//        int[] need={70,100,120};
//        int[] resto={10,0,30,20,40};
//        int[][] padroes={{1,1,0},{0,0,3},{0,2,0},{1,0,1},{0,1,1}};

//        System.out.println(cut.Padroes_viaveis_teste[0][0]);
//        System.out.println(cut.Padroes_viaveis_teste.length);
//        System.out.println(cut.Padroes_viaveis_teste[0].length);


        Loader.loadNativeLibraries();
        solver = MPSolver.createSolver("SCIP");
        double infinity = Double.POSITIVE_INFINITY;

        //x receber o tamanho da lista de resto que conseguirimos depois de rodar todos os padr�es e pegar seus restos
        x = new MPVariable[cut.resto.length];

        for (int i=0;i < x.length ; i++){
            x[i]= solver.makeIntVar(0.0, infinity ,"x "+(i+1));
        }
        System.out.println("Numero de variaveis = " + solver.numVariables());

        min = solver.objective();
        for (int i=0; i < cut.resto.length ; i++){
            min.setCoefficient(x[i],cut.resto[i]);
        }
        min.setMinimization();


        for (int i=0;i < cut.Qtd_Encomenda.length ; i++) {
            MPConstraint ct = solver.makeConstraint(cut.Qtd_Encomenda[i],infinity, "teste "+(i+1));

            for (int j=0;j < cut.Padroes_viaveis_teste.length;j++){
                ct.setCoefficient(x[j],cut.Padroes_viaveis_teste[j][i]);
            }
        }








    }

    public void SolvePdC(Corte cut){
        MPSolver.ResultStatus result = solver.solve();

        if (result == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solucao:");
            System.out.println("Custo da funcao objetivo = " + min.value());
            for (int i =0; i < cut.Padroes_viaveis_teste.length ;i++){
                System.out.println("x = "+(i+1)+" valor "+x[i].solutionValue());

            }
            System.out.println("Tempo de resolucao = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solu��o �tima n�o encontrada!");
        }
    }

}
