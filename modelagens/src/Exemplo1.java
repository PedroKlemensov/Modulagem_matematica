// biblioteca fornecida pelo próprio Google
import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class Exemplo1 {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();

        // Esse solver resolve problemas além de PLI, como PL
        MPSolver solver = MPSolver.createSolver("SCIP");
        double infinity = java.lang.Double.POSITIVE_INFINITY;

        // x, y >= 0 e inteiros
        // Declaração de Variáveis (1)
        // Classe predefinida da biblioteca p/ fazer a declaração de variáveis do modelo
        MPVariable x = solver.makeIntVar(0.0, infinity, "x"); // makeIntVar é o único método que realiza a declaração de variáveis inteiras
        MPVariable y = solver.makeIntVar(0.0, infinity, "y"); // possíveis valores: 0 à infinito positivo
        System.out.println("Número de variáveis = " + solver.numVariables());

        // x + 7 * y <= 17.5.
        // "Constraint": Restrição
        // Aqui se cria uma restrição e ela será uma função que definirá as limitações da modelagem
        // Escreve-se "c0" apenas por convensão, a variável pode ter qualquer nome
        MPConstraint c0 = solver.makeConstraint(-infinity, 17.5, "c0"); // O valor de -infinity é colocado por servir de garantia para abordar valores engativos para uma variável ou outra
        // A biblioteca já subentende que será uma soma por seguir o modelo PLI (Programação Linear Inteira)
        c0.setCoefficient(x, 1);
        c0.setCoefficient(y, 7);

        // x <= 3.5.
        // A mesma interpretação é realizada aqui embaixo
        MPConstraint c1 = solver.makeConstraint(-infinity, 3.5, "c1");
        c1.setCoefficient(x, 1);
        c1.setCoefficient(y, 0); // Essa linha de código é indiferente, uma vez que é possível determinar as restrições na declaração das variáveis acima (1)

        System.out.println("Número de restrições = " + solver.numConstraints());

        // Maximize x + 10 * y.
        // Declaração da função objetiva:
        // Instancia um objeto do tipo MPObjective que irá receber a função objetivo do "solver"
        // A função objetivo já está criada, porém, vazia, ela será determinada logo após...
        MPObjective objective = solver.objective();

        // Declaração dos valores da função objetivo:
        objective.setCoefficient(x, 1);
        objective.setCoefficient(y, 10);
        objective.setMaximization(); // Determina se a função tem como objetivo maximizar ou minimizar resultados.

        // O comando solve() resolve o modelo estabelecido
        MPSolver.ResultStatus resultStatus = solver.solve();

        // Checagem para verificar se a solução é realmente a melhor possível (solução ótima)
        // Um modelo pode ter n soluções ótimas, que chegam no mesmo resultado, porém de maneira diferentes
        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Solução:");
            System.out.println("Custo da função objetivo = " + objective.value());
            System.out.println("x = " + x.solutionValue());
            System.out.println("y = " + y.solutionValue());
            System.out.println("Tempo de resolução = " + solver.wallTime() + " milissegundos");
            System.out.println(solver.exportModelAsLpFormat());
        } else {
            System.out.println("Solução ótima não encontrada!");
        }
    }
}