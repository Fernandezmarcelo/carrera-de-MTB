class RecorridoAvanzado extends Recorrido {
    private int cantidadObstaculos;

    public RecorridoAvanzado(double distancia, int cantidadObstaculos) {
        super(distancia);
        this.cantidadObstaculos = cantidadObstaculos;
    }

    @Override
    public double calcularTiempo() {
        return (distancia / 20.0) * cantidadObstaculos;
    }

    @Override
    public double calcularPuntaje() {
        return 0.5 * distancia;
    }
}
