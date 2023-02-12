package lista03;
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;
public class tarefa9 {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();

        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;

        MPVariable sandalias = solver.makeIntVar(0.0, 300, "sandalias");
        MPVariable tenis = solver.makeIntVar(0.0, 1800, "tenis");
        MPVariable botas = solver.makeIntVar(0.0, 120, "botas");
        MPVariable sapatos = solver.makeIntVar(0.0, 350, "sapatos");
        System.out.println("Número de variáveis = " + solver.numVariables());


        MPConstraint borracha = solver.makeConstraint(-infinity, 2000 ,"borracha");
        borracha.setCoefficient(sandalias, 0.2);
        borracha.setCoefficient(tenis, 0.4);
        borracha.setCoefficient(botas, 0.3);
        borracha.setCoefficient(sapatos, 0.3);


        MPConstraint couro = solver.makeConstraint(-infinity, 200 ,"couro");
        couro.setCoefficient(sandalias, 0);
        couro.setCoefficient(tenis, 0.5);
        couro.setCoefficient(botas, 1.4);
        couro.setCoefficient(sapatos, 0.8);


        MPConstraint algodao = solver.makeConstraint(-infinity, 1000 ,"algodao");
        algodao.setCoefficient(sandalias, 0.15);
        algodao.setCoefficient(tenis, 0);
        algodao.setCoefficient(botas, 0.4);
        algodao.setCoefficient(sapatos, 0.6);






        System.out.println("Número de restrições = " + solver.numConstraints());


        MPObjective max = solver.objective();
        max.setCoefficient(sandalias, 32);
        max.setCoefficient(tenis,58);
        max.setCoefficient(botas,94);
        max.setCoefficient(sapatos,74.5);
        max.setOffset(17500);
        //teste

        max.setMaximization();

        MPSolver.ResultStatus result = solver.solve();

        if (result == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo = " + max.value());
            System.out.println("sandalias = " + sandalias.solutionValue());
            System.out.println("tenis = " + tenis.solutionValue());
            System.out.println("botas = " + botas.solutionValue());
            System.out.println("sapatos = " + sapatos.solutionValue());

            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }

}