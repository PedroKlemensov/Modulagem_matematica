package tarefa03;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Data {

    int nOrigens;
    int nDestinos;
    int[] producao;
    int[] demanda;
    int[][] custo;

    public Data(String filename) throws FileNotFoundException {

        File f = new File(filename);

        Scanner s = new Scanner(f);
        nOrigens = s.nextInt();
        nDestinos = s.nextInt();

        producao = new int[nOrigens];
        for (int i = 0; i < nOrigens; i++) {
            producao[i] = s.nextInt();
        }

        demanda = new int[nDestinos];
        for (int i = 0; i < nDestinos; i++) {
            demanda[i] = s.nextInt();
        }

        custo = new int[nOrigens][nDestinos];
        for (int i = 0; i < nOrigens; i++) {
            for (int j = 0; j < nDestinos; j++) {
                custo[i][j] = s.nextInt();
            }
        }
    }


}
