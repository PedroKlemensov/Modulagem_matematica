// biblioteca fornecida pelo próprio Google
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class Exercicio2 {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();

        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = Double.POSITIVE_INFINITY;

        // x, y >= 0 e inteiros
        // Declaração de Variáveis (1)
        // Classe predefinida da biblioteca p/ fazer a declaração de variáveis do modelo
        MPVariable x1 = solver.makeIntVar(0.0, infinity, "MESA"); // makeIntVar é o único método que realiza a declaração de variáveis inteiras
        MPVariable x2 = solver.makeIntVar(0.0, infinity, "CADEIRA"); // possíveis valores: 0 à infinito positivo
        System.out.println("Número de variáveis = " + solver.numVariables());

        // METRO QUADRADO
        // "Constraint": Restrição
        // Aqui se cria uma restrição e ela será uma função que definirá as limitações da modelagem
        // Escreve-se "c0" apenas por convensão, a variável pode ter qualquer nome
        MPConstraint c0 = solver.makeConstraint(-infinity, 14, "Consumo de madeira"); // O valor de -infinity é colocado por servir de garantia para abordar valores engativos para uma variável ou outra
        // A biblioteca já subentende que será uma soma por seguir o modelo PLI (Programação Linear Inteira)
        c0.setCoefficient(x1, 2);
        c0.setCoefficient(x2, 3);

        // HORAS
        // A mesma interpretação é realizada aqui embaixo
        MPConstraint c1 = solver.makeConstraint(-infinity, 10, "Horas gastas");
        c1.setCoefficient(x1, 2);
        c1.setCoefficient(x2, 1); // Essa linha de código é indiferente, uma vez que é possível determinar as restrições na declaração das variáveis acima (1)

        System.out.println("Número de restrições = " + solver.numConstraints());

        // Maximize x + 10 * y.
        // Declaração da função objetiva:
        // Instancia um objeto do tipo MPObjective que irá receber a função objetivo do "solver"
        // A função objetivo já está criada, porém, vazia, ela será determinada logo após...
        MPObjective objective = solver.objective();

        // Declaração dos valores da função objetivo:
        objective.setCoefficient(x1, 40);
        objective.setCoefficient(x2, 10);
        objective.setMaximization(); // Determina se a função tem como objetivo maximizar ou minimizar resultados.

        // O comando solve() resolve o modelo estabelecido
        MPSolver.ResultStatus resultStatus = solver.solve();

        // Checagem para verificar se a solução é realmente a melhor possível (solução ótima)
        // Um modelo pode ter n soluções ótimas, que chegam no mesmo resultado, porém de maneira diferentes
        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo = " + objective.value());
            System.out.println("x = " + x1.solutionValue());
            System.out.println("y = " + x2.solutionValue());
            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }
}