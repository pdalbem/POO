public class Cubo implements  IFiguraTridimensional{
    private double aresta;

    public Cubo(double aresta) {
        this.aresta = aresta;
    }

    @Override
    public double calcularArea() {
        return Math.pow(aresta,2)*6;
    }

    @Override
    public double calcularVolume() {
        return Math.pow(aresta,3);
    }

    public double getAresta() {
        return aresta;
    }

    public void setAresta(double aresta) {
        this.aresta = aresta;
    }
}
