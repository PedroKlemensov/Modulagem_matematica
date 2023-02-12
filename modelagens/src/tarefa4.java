
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class tarefa4 {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();


        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;


        MPVariable gasolinaVerde = solver.makeIntVar(0.0, infinity, "gasolinaVerde");
        MPVariable gasolinaAzul = solver.makeIntVar(0.0, 600, "gasolinaAzul");
        MPVariable gasolinaComum =  solver.makeIntVar(0.0, infinity, "gasolinaComum");
        System.out.println("Número de variáveis = " + solver.numVariables());


        MPConstraint pura = solver.makeConstraint(-infinity, 9000000, "pura");
        pura.setCoefficient(gasolinaVerde, 220);
        pura.setCoefficient(gasolinaAzul, 500);
        pura.setCoefficient(gasolinaComum, 280);



        MPConstraint octana = solver.makeConstraint(-infinity, 4800000, "octana");
        octana.setCoefficient(gasolinaVerde, 520);
        octana.setCoefficient(gasolinaAzul, 340);
        octana.setCoefficient(gasolinaComum, 280);



        MPConstraint atitivo = solver.makeConstraint(-infinity, 2200000, "atitivo");
        atitivo.setCoefficient(gasolinaVerde, 740);
        atitivo.setCoefficient(gasolinaAzul, 200);
        atitivo.setCoefficient(gasolinaComum, 60);




        System.out.println("Número de restrições = " + solver.numConstraints());


        MPObjective objective = solver.objective();


        objective.setCoefficient(gasolinaVerde, 30);
        objective.setCoefficient(gasolinaAzul, 25);
        objective.setCoefficient(gasolinaComum, 20);
        objective.setMaximization();


        MPSolver.ResultStatus resultStatus = solver.solve();


        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo em centavos = " + objective.value());
            System.out.println("gasolinaVerde = " + gasolinaVerde.solutionValue());
            System.out.println("gasolinaAzul = " + gasolinaAzul.solutionValue());
            System.out.println("gasolinaComum = " + gasolinaComum.solutionValue());

            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }
}