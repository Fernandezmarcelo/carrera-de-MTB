class Experto extends Nivel {
    private static final double HANDICAP_EXPERTO = 0.8;

    @Override
    public double aplicarHandicap(double puntaje) {
        return puntaje * HANDICAP_EXPERTO;
    }
}