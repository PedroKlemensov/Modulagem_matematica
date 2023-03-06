package ProblmemasDeCombinaçao.Q6;


import java.io.FileWriter;
import java.io.IOException;

import ProblmemasDeCombinaçao.Q6.Data;
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPSolver.ResultStatus;
import com.google.ortools.linearsolver.MPVariable;

public class Modelo {

    public MPObjective objective;
    public MPSolver solver;
    public MPVariable[][] x;
    public double custoSolucao;
    public double[][] solucao;

    public Modelo(Data data) {

        Loader.loadNativeLibraries();
        solver = MPSolver.createSolver("SCIP");

        x = new MPVariable[data.nBarcos][data.nDocas];
        for (int i = 0; i < data.nBarcos; i++) {
            for (int j = 0; j < data.nDocas; j++) {
                x[i][j] = solver.makeBoolVar("x[" + (i+1) + "][" + (j+1) + "]");
            }
        }

        objective = solver.objective();
        for (int i = 0; i < data.nBarcos; i++) {
            for (int j = 0; j < data.nDocas; j++) {
                objective.setCoefficient(x[i][j], data.Tempo[i]);
            }
        }
        objective.setMinimization();

        for (int j = 0; j < data.nDocas; j++) {
            MPConstraint ct = solver.makeConstraint(0.0, data.Tempo[j], "Barco_" + (j+1));
            for (int i = 0; i < data.nBarcos; i++) {
                ct.setCoefficient(x[i][j], data.Tempo[i]);
            }
        }

        for (int i = 0; i < data.nBarcos; i++) {
            MPConstraint ct = solver.makeConstraint(0, 1.0, "Doca_" + (i+1));
            for (int j = 0; j < data.nDocas; j++) {
                ct.setCoefficient(x[i][j], 1);
            }
        }
    }

    public void solve(Data data) {
        ResultStatus status = solver.solve();
        if (status == ResultStatus.OPTIMAL) {
            custoSolucao = objective.value();
            solucao = new double[data.nBarcos][data.nDocas];
            for (int i = 0; i < data.nBarcos; i++) {
                for (int j = 0; j < data.nDocas; j++) {
                    if (x[i][j].solutionValue() > 0.9) {
                        solucao[i][j] = 1.0;

                        System.out.println("Tarefa "+ (i+1)+ "na maquina "+(j+1));

                    }
                }
            }
        }

    }

    public void exportModel(String output) throws IOException {
        FileWriter fw = new FileWriter(output);
        fw.write(solver.exportModelAsLpFormat());
        fw.close();
    }

}
