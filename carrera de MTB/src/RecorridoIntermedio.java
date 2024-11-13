class RecorridoIntermedio extends Recorrido {
    private boolean pendienteAscendente;

    public RecorridoIntermedio(double distancia, boolean pendienteAscendente) {
        super(distancia);
        this.pendienteAscendente = pendienteAscendente;
    }

    @Override
    public double calcularTiempo() {
        if (pendienteAscendente) {
            return (distancia / 25.0) * 1.5;
        } else {
            return (distancia / 25.0) * 0.5;
        }
    }

    @Override
    public double calcularPuntaje() {
        if (pendienteAscendente) {
            return 1 + 1.5;
        } else {
            return 1 + 0.5;
        }
    }
}