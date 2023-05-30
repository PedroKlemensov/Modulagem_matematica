package profesor;

public class Arco {
	
	public int origem;
	public int destino;
	public int distancia;
	
	public Arco(int origem, int destino, int distancia) {
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Arco [origem=" + origem + ", destino=" + destino + ", distancia=" + distancia + "] \n";
	}
	
}
