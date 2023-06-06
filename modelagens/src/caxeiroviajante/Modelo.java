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
    public double custoSolucao;
    public double[] solucao;

    public Modelo (ArrayList<Arco> listaarcos) {
        ArrayList<Arco>  lista = listaarcos;
        Loader.loadNativeLibraries();
        solver = MPSolver.createSolver("SCIP");

        x = new MPVariable[lista.size()];
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            x[i] = solver.makeBoolVar("x[" + arco.origem + "][" + arco.destino + "]");
        }

        objective = solver.objective();
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            objective.setCoefficient(x[i], arco.distancia);
        }
        objective.setMinimization();

        MPConstraint ct1 = solver.makeConstraint(1.0, 1.0, "fluxo_origem");
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            if (arco.origem == lista.get(i).origem) {
                ct1.setCoefficient(x[i], 1);
            }
        }

        MPConstraint ct2 = solver.makeConstraint(1.0, 1.0, "fluxo_destino");
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            if (arco.destino == lista.get(i).destino) {
                ct2.setCoefficient(x[i], 1);
            }
        }

        MPConstraint ct3 = solver.makeConstraint(1.0,1.0,"Naociclo");
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            if (arco.origem != arco.destino){
                ct3.setCoefficient(x[i], 1);
            }
        }


    }
    public void solve() {solver.solve();}

}
