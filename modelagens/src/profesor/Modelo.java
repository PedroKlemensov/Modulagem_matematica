package profesor;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class Modelo {
	
	public MPObjective objective;
	public MPSolver solver;
	public MPVariable[] x;
	public double custoSolucao;
	public double[] solucao;
	
	public Modelo(Data data) {
		
		Loader.loadNativeLibraries();
		solver = MPSolver.createSolver("SCIP");
		
		x = new MPVariable[data.nArcos];
		for (int i = 0; i < data.nArcos; i++) {
			Arco arco = data.arcos.get(i);
			x[i] = solver.makeBoolVar("x[" + arco.origem + "][" + arco.destino + "]");
		}
		
		objective = solver.objective();
		for (int i = 0; i < data.nArcos; i++) {
			Arco arco = data.arcos.get(i);
			objective.setCoefficient(x[i], arco.distancia);
		}
        objective.setMinimization();
        
        MPConstraint ct1 = solver.makeConstraint(1.0, 1.0, "fluxo_origem");
        for (int i = 0; i < data.nArcos; i++) {
			Arco arco = data.arcos.get(i);
			if (arco.origem == data.inicio) {
				ct1.setCoefficient(x[i], 1);
			}
        }
        
        MPConstraint ct2 = solver.makeConstraint(1.0, 1.0, "fluxo_destino");
        for (int i = 0; i < data.nArcos; i++) {
        	Arco arco = data.arcos.get(i);
			if (arco.destino == data.fim) {
				ct2.setCoefficient(x[i], 1);
			}
        }
        
        for (int v = 1; v <= data.nVertices; v++) {
			if (v != data.inicio && v != data.fim)	{
				MPConstraint ct3 = solver.makeConstraint(0.0, 0.0, "conservação_" + v);
				for (int i = 0; i < data.nArcos; i++) {
					Arco arco = data.arcos.get(i);
					if (arco.destino == v)	{
						ct3.setCoefficient(x[i], 1);
					}
					if (arco.origem == v)	{
						ct3.setCoefficient(x[i], -1);
					}
				}
			}
		}
		
	}
	
	public void solve() {
		solver.solve();
	}
	
	public void setSolution(Data data) {
		custoSolucao = objective.value();
		solucao = new double[data.nArcos];
		for (int i = 0; i < data.nArcos; i++) {
			if (x[i].solutionValue() > 0) {
				solucao[i] = 1.0;
			}
		}
	}
	
	public String exportModel() {
		return solver.exportModelAsLpFormat();
	}
	
}
