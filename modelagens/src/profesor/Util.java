package profesor;

import java.io.FileWriter;
import java.io.IOException;

public class Util {
	
	public FileWriter fw;
	
	public Util(String output) throws IOException {
		fw = new FileWriter(output);
	}
	
	public void escreveRelatorio(Data data, Modelo modelo) throws IOException {
		escreveDadosEntrada(data);
		escreveModelo(modelo);
		escreveDadosSaida(data, modelo);
		fw.close();
	}
	
	public void escreveDadosEntrada(Data data) throws IOException {
		fw.write("/****** ENTRADA ******/ \n");
		fw.write(data.toString());
		for (int i = 0; i < data.nArcos; i++) {
			Arco arco = data.arcos.get(i);
			fw.write(arco.toString());
		}
		fw.write("\n\n");
	}
	
	public void escreveModelo(Modelo modelo) throws IOException {
		fw.write("/****** MODELO MATEMÁTICO ******/ \n");
		fw.write(modelo.exportModel());
		fw.write("\n\n");
	}
	
	public void escreveDadosSaida(Data data, Modelo modelo) throws IOException	{
		fw.write("/****** SAÍDA ******/ \n");
		fw.write("Custo da solução ótima: " + modelo.custoSolucao + "\n");
		for (int i = 0; i < data.nArcos; i++)	{
			if (modelo.solucao[i] > 0) {
				Arco arco = data.arcos.get(i);
				fw.write(arco.toString());
			}
		}
	}
}
