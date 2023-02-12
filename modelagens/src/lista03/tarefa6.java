package lista03;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class tarefa6 {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();


        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;


        MPVariable refrigerador = solver.makeIntVar(0.0, 200, "refrigerador");
        MPVariable bebeduros = solver.makeIntVar(0.0, 400, "bebeduros");
        MPVariable fogoes = solver.makeIntVar(0.0, 120, "fogoes");


        System.out.println("Número de variáveis = " + solver.numVariables());


        MPConstraint aco = solver.makeConstraint(-infinity, 4500, "aco");
        aco.setCoefficient(refrigerador, 20);
        aco.setCoefficient(bebeduros, 3);
        aco.setCoefficient(fogoes, 15);



        MPConstraint platico = solver.makeConstraint(-infinity, 2200, "platico");
        platico.setCoefficient(refrigerador, 8);
        platico.setCoefficient(bebeduros, 3);
        platico.setCoefficient(fogoes, 2);




        
        

        System.out.println("Número de restrições = " + solver.numConstraints());


        MPObjective objective = solver.objective();


        objective.setCoefficient(refrigerador, 430);
        objective.setCoefficient(bebeduros, 160);
        objective.setCoefficient(fogoes, 270);

        objective.setMaximization();


        MPSolver.ResultStatus resultStatus = solver.solve();


        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo = " + objective.value());
            System.out.println("refrigerador = " + refrigerador.solutionValue());
            System.out.println("bebeduros = " + bebeduros.solutionValue());
            System.out.println("fogoes = " + fogoes.solutionValue());
            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }
}