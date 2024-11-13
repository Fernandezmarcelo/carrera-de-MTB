class RecorridoFacil extends Recorrido {

    public RecorridoFacil(double distancia) {
        super(distancia);
    }

    @Override
    public double calcularTiempo() {
        return distancia / 30.0;
    }

    @Override
    public double calcularPuntaje() {
        return 2 * distancia;
    }
}