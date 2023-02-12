package lista03;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class tarefa5 {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();


        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;


        MPVariable rio = solver.makeIntVar(0.0, infinity, "rio");
        MPVariable saoPaulo = solver.makeIntVar(0.0, infinity, "saoPaulo");



        System.out.println("Número de variáveis = " + solver.numVariables());


        MPConstraint finas = solver.makeConstraint(-infinity, 16, "finas");
        finas.setCoefficient(rio, 2);
        finas.setCoefficient(saoPaulo, 8);




        MPConstraint medias = solver.makeConstraint(-infinity, 6, "medias");
        medias.setCoefficient(rio, 1);
        medias.setCoefficient(saoPaulo, 1);

        MPConstraint grossas = solver.makeConstraint(-infinity, 28, "medias");
        grossas.setCoefficient(rio, 7);
        grossas.setCoefficient(saoPaulo, 2);



        System.out.println("Número de restrições = " + solver.numConstraints());


        MPObjective objective = solver.objective();


        objective.setCoefficient(rio, 1);
        objective.setCoefficient(saoPaulo, 10);

        objective.setMaximization();


        MPSolver.ResultStatus resultStatus = solver.solve();


        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo = " + objective.value());
            System.out.println("rio = " + rio.solutionValue());
            System.out.println("saoPaulo = " + saoPaulo.solutionValue());

            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }
}