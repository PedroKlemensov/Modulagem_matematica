package caxeiroviajante;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;


import java.util.ArrayList;

public class Modelo {

    public MPObjective objective;
    public MPSolver solver;
    public MPVariable[] x;
    public MPVariable[] u;
    public double custoSolucao;
    public double[] solucao;

    public Modelo(ArrayList<Arco> listaarcos,ArrayList<Vertice> vertices) {
        ArrayList<Arco> lista = listaarcos;

        Loader.loadNativeLibraries();
        solver = MPSolver.createSolver("SCIP");
        x = new MPVariable[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            x[i] = solver.makeBoolVar("x[" + arco.origem + "][" + arco.destino + "]");
        }
        
        u = new MPVariable[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
        	if (i == 0)	{
        		u[i] = solver.makeIntVar(1, 1, "u[" + (i+1) + "]");
        	} else {
        		u[i] = solver.makeIntVar(2, vertices.size(), "u[" + (i+1) + "]");
        	}
        }

        objective = solver.objective();
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            objective.setCoefficient(x[i], arco.distancia);
        }
        objective.setMinimization();
        
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            if (arco.origem != 1 && arco.destino != 1) {
                MPConstraint ct = solver.makeConstraint(-Integer.MAX_VALUE, vertices.size()-1, "ante_clico");
                ct.setCoefficient(u[arco.origem-1], 1);
                ct.setCoefficient(u[arco.destino-1], -1);
                ct.setCoefficient(x[i], vertices.size());
            }
        }

        for (int i = 0; i < vertices.size(); i++) {
            MPConstraint ct = solver.makeConstraint(1.0, 1.0, "fluxo_origem");
            Double v = vertices.get(i).id;
            for (int j = 0; j < lista.size(); j++) {
                Arco arco = lista.get(j);
                if (arco.origem == v) {
                    ct.setCoefficient(x[j], 1);
                }
            }
        }

        for (int i = 0; i < vertices.size(); i++) {
            MPConstraint ct = solver.makeConstraint(1.0, 1.0, "fluxo-destino");
            Double v = vertices.get(i).id;
            for (int j = 0; j < lista.size(); j++) {
                Arco arco = lista.get(j);
                if (arco.destino == v) {
                    ct.setCoefficient(x[j], 1);
                }
            }
        }


    }

    public void solve() {
        solver.solve();
    }

    public void setSolution(ArrayList<Arco> listaarcos) {
        ArrayList<Arco> lista = listaarcos;
        custoSolucao = objective.value();
        solucao = new double[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            if (x[i].solutionValue() > 0) {
            	listaarcos.get(i).mostraArco();
                solucao[i] = 1.0;
            }
        }
    }

    public String exportModel() {
        return solver.exportModelAsLpFormat();
    }


}
