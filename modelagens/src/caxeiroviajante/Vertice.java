package caxeiroviajante;

public class Vertice {

    public Double id;
    public double posx;
    public double posy;


    public Vertice(Double id, double posx, double posy) {
        this.id = id;
        this.posx = posx;
        this.posy = posy;
    }

    public double getPosx() {
        return posx;
    }

    public void setPosx(double posx) {
        this.posx = posx;
    }

    public double getPosy() {
        return posy;
    }

    public void setPosy(double posy) {
        this.posy = posy;
    }
}
