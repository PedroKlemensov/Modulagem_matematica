package lista03;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class tarefa10 {


    public static void main(String[] args) {
        Loader.loadNativeLibraries();

        MPSolver solver = MPSolver.createSolver("GLOP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;

        MPVariable d = solver.makeIntVar(0.0, infinity, "D");
        MPVariable n = solver.makeIntVar(0.0, infinity, "N");

        System.out.println("Número de variáveis = " + solver.numVariables());


        MPConstraint A = solver.makeConstraint(-infinity, 270000 ,"A");
        A.setCoefficient(d, 1);


        MPConstraint B = solver.makeConstraint(-infinity, 150000 ,"B");
        B.setCoefficient(n, 2);

        MPConstraint C = solver.makeConstraint(-infinity, 180000, "C");
        C.setCoefficient(d ,0.4);
        C.setCoefficient(n,1);


        MPConstraint limite = solver.makeConstraint(-infinity,180000,"limite");
        limite.setCoefficient(d,0.6);


        System.out.println("Número de restrições = " + solver.numConstraints());

        MPObjective objective = solver.objective();
        objective.setCoefficient(d, 0.12);
        objective.setCoefficient(n, 0.2);
        objective.setMaximization();

        MPSolver.ResultStatus resultStatus = solver.solve();

        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo = " + objective.value());
            System.out.println("d = " + d.solutionValue());
            System.out.println("n = " + n.solutionValue());


            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }
}