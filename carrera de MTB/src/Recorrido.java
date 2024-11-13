abstract class Recorrido {
    protected double distancia;

    public Recorrido(double distancia) {
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public abstract double calcularTiempo();
    public abstract double calcularPuntaje();
}
