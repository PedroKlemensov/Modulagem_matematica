package profesor;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		String input = "entradaprof.txt";
		Data data = new Data(input);
		
		Modelo modelo = new Modelo(data);
		modelo.solve();
		modelo.setSolution(data);
		
		String output = "saida.txt";
		Util util = new Util(output);
		util.escreveRelatorio(data, modelo);
	}

}
