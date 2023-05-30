//package ProblmemasDeCombinaçao.Q4;
//
//
//import java.io.FileWriter;
//import java.io.IOException;
//
//import com.google.ortools.Loader;
//import com.google.ortools.linearsolver.MPConstraint;
//import com.google.ortools.linearsolver.MPObjective;
//import com.google.ortools.linearsolver.MPSolver;
//import com.google.ortools.linearsolver.MPSolver.ResultStatus;
//import com.google.ortools.linearsolver.MPVariable;
//
//public class Modelo {
//
//	public MPObjective objective;
//	public MPSolver solver;
//	public MPVariable[][] x;
//	public double custoSolucao;
//	public double[][] solucao;
//
//	public Modelo(Data data) {
//
//		Loader.loadNativeLibraries();
//		solver = MPSolver.createSolver("SCIP");
//
//		x = new MPVariable[data.nTarefas][data.nMaquinas];
//		for (int i = 0; i < data.nTarefas; i++) {
//			for (int j = 0; j < data.nMaquinas; j++) {
//				x[i][j] = solver.makeBoolVar("x[" + (i+1) + "][" + (j+1) + "]");
//			}
//		}
//
//		objective = solver.objective();
//		for (int i = 0; i < data.nTarefas; i++) {
//			for (int j = 0; j < data.nMaquinas; j++) {
//				objective.setCoefficient(x[i][j], data.tempoTarefas[i]);
//			}
//		}
//        objective.setMinimization();
//
//        for (int j = 0; j < data.nMaquinas; j++) {
//        	MPConstraint ct = solver.makeConstraint(0.0, data.tempoMaquinas[j], "maquina_" + (j+1));
//        	for (int i = 0; i < data.nTarefas; i++) {
//    			ct.setCoefficient(x[i][j], data.tempoTarefas[i]);
//            }
//        }
//
//        for (int i = 0; i < data.nTarefas; i++) {
//        	MPConstraint ct = solver.makeConstraint(0, 1.0, "tarefa_" + (i+1));
//        	for (int j = 0; j < data.nMaquinas; j++) {
//        		ct.setCoefficient(x[i][j], 1);
//        	}
//        }
//	}
//
//	public void solve(Data data) {
//		ResultStatus status = solver.solve();
//		if (status == MPSolver.ResultStatus.OPTIMAL) {
//			custoSolucao = objective.value();
//			solucao = new double[data.nTarefas][data.nMaquinas];
//			for (int i = 0; i < data.nTarefas; i++) {
//				for (int j = 0; j < data.nMaquinas; j++) {
//					if (x[i][j].solutionValue() > 0.9) {
//						solucao[i][j] = 1.0;
//
//						System.out.println("Tarefa "+ (i+1)+ "na maquina "+(j+1));
//					}
//				}
//			}
//		}
//
//	}
//
//	public void exportModel(String output) throws IOException {
//		FileWriter fw = new FileWriter(output);
//		fw.write(solver.exportModelAsLpFormat());
//		fw.close();
//	}
//
//}
