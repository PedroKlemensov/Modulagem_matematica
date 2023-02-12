package lista03;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class tarefa8 {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();


        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;


        MPVariable cormecial = solver.makeIntVar(0.0, infinity, "cormecial");
        MPVariable flex = solver.makeIntVar(0.0, infinity, "flex");
        MPVariable plus = solver.makeIntVar(0.0, infinity, "plus");
        System.out.println("Número de variáveis = " + solver.numVariables());


        MPConstraint agua = solver.makeConstraint(-infinity, 100, "agua");
        agua.setCoefficient(cormecial, 2);
        agua.setCoefficient(flex, 2);
        agua.setCoefficient(plus, 3);



        MPConstraint bombom = solver.makeConstraint(-infinity, 250, "bombom");
        bombom.setCoefficient(cormecial, 6);
        bombom.setCoefficient(flex, 1);
        bombom.setCoefficient(plus, 5);


        MPConstraint biscoito = solver.makeConstraint(-infinity, 200, "biscoito");
        biscoito.setCoefficient(cormecial, 0);
        biscoito.setCoefficient(flex, 5);
        biscoito.setCoefficient(plus, 1);

        System.out.println("Número de restrições = " + solver.numConstraints());


        MPObjective objective = solver.objective();


        objective.setCoefficient(cormecial, 40);
        objective.setCoefficient(flex, 60);
        objective.setCoefficient(plus, 30);
        objective.setMaximization();


        MPSolver.ResultStatus resultStatus = solver.solve();


        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo = " + objective.value());
            System.out.println("cormecial = " + cormecial.solutionValue());
            System.out.println("flex = " + flex.solutionValue());
            System.out.println("plus = " + plus.solutionValue());


            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }
}