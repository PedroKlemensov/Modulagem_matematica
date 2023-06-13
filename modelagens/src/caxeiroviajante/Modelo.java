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

    public Modelo(ArrayList<Arco> listaarcos,ArrayList<Vertice> vertices) {
        ArrayList<Arco> lista = listaarcos;

        Loader.loadNativeLibraries();
        solver = MPSolver.createSolver("SCIP");
        int u = 1;
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
            MPConstraint ct = solver.makeConstraint(1.0, 1.0, "fluxo_Destino");
            Double v = vertices.get(i).id;
            for (int j = 0; j < lista.size(); j++) {
                Arco arco = lista.get(j);
                if (arco.destino == v) {
                    ct.setCoefficient(x[j], 1);
                }
            }
        }



       /*
        //UM ARCO SAI DA ORIGEM
        MPConstraint ct1 = solver.makeConstraint(1.0, 1.0, "fluxo_origem");
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            if (arco.origem == lista.get(i).origem) {
                ct1.setCoefficient(x[i], 1);
            }
        }

        //UM ARCO CHEGA NO DESTINO
        MPConstraint ct2 = solver.makeConstraint(1.0, 1.0, "fluxo_destino");
        for (int i = 0; i < lista.size(); i++) {
            Arco arco = lista.get(i);
            if (arco.destino == lista.get(i).destino) {
                ct2.setCoefficient(x[i], 1);
            }
        }

        */

        //PARA CADA VÉRTICE, UM ARCO CHEGA NELE

        //PARA CADA VÉRTICE, UM ARCO SAI DELE

//        MPConstraint ct3 = solver.makeConstraint(1.0, 1.0, "Naociclo");
//        for (int i = 0; i < lista.size(); i++) {
//            Arco arco = lista.get(i);
//            if (arco.origem != arco.destino) {
//                ct3.setCoefficient(x[i], 1);
//            }
//        }

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
                solucao[i] = 1.0;
            }
        }
    }

    public String exportModel() {
        return solver.exportModelAsLpFormat();
    }


}
