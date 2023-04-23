package problemaDeCorte;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;


import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPSolver.ResultStatus;
import com.google.ortools.linearsolver.MPVariable;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        String adapt = "problema_corte.txt";
        Corte problema = new Corte(adapt);

    }
}
