package ProblmemasDeCombinaçao.Q4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Data {
	
	public int nTarefas;
	public int nMaquinas;
	public int[] lucroTarefas;
	public int[] tempoTarefas;
	public int[] tempoMaquinas;
	
	public Data(String input) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(input));
		nTarefas = scanner.nextInt();
		nMaquinas = scanner.nextInt();
		
		tempoTarefas = new int[nTarefas];
		for (int i = 0; i < nTarefas; i++) {
			tempoTarefas[i] = scanner.nextInt();
		}
		
		lucroTarefas = new int[nTarefas];
		for (int i = 0; i < nTarefas; i++) {
			lucroTarefas[i] = scanner.nextInt();
		}
		
		tempoMaquinas = new int[nMaquinas];q
		for (int i = 0; i < nMaquinas; i++) {
			tempoMaquinas[i] = scanner.nextInt();
		}
	}

	public void mostraData() {
		System.out.println("Tarefas: " + nTarefas);
		System.out.println("M�quinas: " + nMaquinas);
		for (int i = 0; i < nTarefas; i++) {
			System.out.println("Tarefa " + (i+1) + ": Tempo = " + tempoTarefas[i] + 
					           ", Lucro = " + lucroTarefas[i]);
		}
		for (int i = 0; i < nMaquinas; i++) {
			System.out.println("Tempo da m�quina " + (i+1) + " = " + tempoMaquinas[i]);
		}
	}
		
}
