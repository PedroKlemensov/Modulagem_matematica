package profesor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	
	public int nVertices;
	public int nArcos;
	public int inicio;
	public int fim;
	public ArrayList<Arco> arcos;
	
	public Data(String input) throws FileNotFoundException {
		arcos = new ArrayList<Arco>();
		Scanner scanner = new Scanner(new FileReader(input));
		nVertices = scanner.nextInt();
		inicio = scanner.nextInt();
		fim = scanner.nextInt();
		
		while (scanner.hasNext()) {
			int origem = scanner.nextInt();
			int destino = scanner.nextInt();
			int distancia = scanner.nextInt();
			Arco arco = new Arco(origem, destino, distancia);
			arcos.add(arco);
		}
		
		nArcos = arcos.size();
	}

	@Override
	public String toString() {
		return "Data [nVertices=" + nVertices + ", nArcos=" + nArcos + ", inicio=" + inicio + ", fim=" + fim + "] \n";
	}
		
}
