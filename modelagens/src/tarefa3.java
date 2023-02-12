
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class tarefa3 {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();


        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;


        MPVariable quadros = solver.makeIntVar(0.0, infinity, "quadros");
        MPVariable paineis = solver.makeIntVar(0.0, infinity, "paineis");
        System.out.println("Número de variáveis = " + solver.numVariables());



        MPConstraint c0 = solver.makeConstraint(0, 180, "horas");
        c0.setCoefficient(quadros, 8);
        c0.setCoefficient(paineis, 12);


        MPConstraint c1 = solver.makeConstraint(0, 2000, "c1");
        c1.setCoefficient(quadros, 80);
        c1.setCoefficient(paineis, 140);

        System.out.println("Número de restrições = " + solver.numConstraints());


        MPObjective objective = solver.objective();


        objective.setCoefficient(quadros, 150);
        objective.setCoefficient(paineis, 250);
        objective.setMaximization();


        MPSolver.ResultStatus resultStatus = solver.solve();


        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo = " + objective.value());
            System.out.println("quadros = " + quadros.solutionValue());
            System.out.println("paineis = " + paineis.solutionValue());
            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }
}