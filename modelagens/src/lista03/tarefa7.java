//package lista03;
//
//import com.google.ortools.Loader;
//import com.google.ortools.linearsolver.MPConstraint;
//import com.google.ortools.linearsolver.MPObjective;
//import com.google.ortools.linearsolver.MPSolver;
//import com.google.ortools.linearsolver.MPVariable;
//
//public class tarefa7 {
//
//    public static void main(String[] args) {
//        Loader.loadNativeLibraries();
//
//
//        MPSolver solver = MPSolver.createSolver("SCIP");
//        double infinity = java.lang.Double.POSITIVE_INFINITY;
//
//
//        MPVariable a = solver.makeIntVar(20000, infinity, "a");
//        MPVariable b = solver.makeIntVar(12000, infinity, "b");
//        MPVariable c = solver.makeIntVar(6000, infinity, "c");
//
//        System.out.println("Número de variáveis = " + solver.numVariables());
//
//
//        MPConstraint fabeicaçao = solver.makeConstraint(-infinity, 120000, "fabeicaçao");
//        fabeicaçao.setCoefficient(a, 0.3);
//        fabeicaçao.setCoefficient(b, 0.4);
//        fabeicaçao.setCoefficient(c, 0.5);
//
//
//
//        MPConstraint montagem = solver.makeConstraint(-infinity, 160000, "montagem");
//        montagem.setCoefficient(a, 0.4);
//        montagem.setCoefficient(b, 0.5);
//        montagem.setCoefficient(c, 0.8);
//
//
//
//        MPConstraint embalagem = solver.makeConstraint(-infinity, 48000, "embalagem");
//        embalagem.setCoefficient(a, 0.1);
//        embalagem.setCoefficient(b, 0.2);
//        embalagem.setCoefficient(c, 0.3);
//
//
//        System.out.println("Número de restrições = " + solver.numConstraints());
//
//
//        MPObjective objective = solver.objective();
//
//
//        objective.setCoefficient(a, 16);
//        objective.setCoefficient(b, 30);
//        objective.setCoefficient(c, 50);
//        objective.setMaximization();
//
//
//        MPSolver.ResultStatus resultStatus = solver.solve();
//
//
//        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
//            System.out.println("Solução:");
//            System.out.println("Custo da função objetivo = " + objective.value());
//            System.out.println("a = " + a.solutionValue());
//            System.out.println("b = " + b.solutionValue());
//            System.out.println("c = " + c.solutionValue());
//            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
//            System.out.println(solver.exportModelAsLpFormat());
//        } else {
//            System.out.println("Solução ótima não encontrada!");
//        }
//    }
//}