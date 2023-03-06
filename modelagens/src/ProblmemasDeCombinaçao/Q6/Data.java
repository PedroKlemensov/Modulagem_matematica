package ProblmemasDeCombinaçao.Q6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Data {

    public int nBarcos;



    public int nDocas;
    public int[] Tempo;


    public Data(String input) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(input));
        nBarcos = scanner.nextInt();
        nDocas = scanner.nextInt();



        Tempo = new int[nDocas];
        for (int i = 0; i < nDocas; i++) {
            Tempo[i] = scanner.nextInt();
        }




    }
}
