public class Cubo implements IFiguraPlana, IFiguraTridimensional{
    private double aresta;

    public Cubo(double aresta) {
        this.aresta = aresta;
    }

    @Override
    public void calcularArea() {
        double area = Math.pow(aresta,2)*6;
        System.out.println("Área: " + area);
    }

    @Override
    public void calcularVolume() {
        double volume  = Math.pow(aresta,3);
        System.out.println("Volume: "+ volume);
    }

    public double getAresta() {
        return aresta;
    }

    public void setAresta(double aresta) {
        this.aresta = aresta;
    }
}
