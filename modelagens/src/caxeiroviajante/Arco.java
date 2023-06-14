package caxeiroviajante;

public class Arco {
    public int origem;
    public int destino;
    public double distancia;

    public Arco(int origem, int destino, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    public void mostraArco() {
    	System.out.println(origem + " " + destino + " " + distancia);
    }
    public String dadosarco() {
        return (origem + " " + destino + " " + distancia);
    }
}
