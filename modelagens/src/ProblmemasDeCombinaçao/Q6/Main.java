package ProblmemasDeCombinaçao.Q6;
import ProblmemasDeCombinaçao.Q6.Data;
import ProblmemasDeCombinaçao.Q6.Modelo;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String input = "entradaQ6.txt";
        Data data = new Data(input);
        //data.mostraData();

        Modelo alocacao = new Modelo(data);
        alocacao.solve(data);
        alocacao.exportModel("modelo_binarioQ6.txt");

    }

}
