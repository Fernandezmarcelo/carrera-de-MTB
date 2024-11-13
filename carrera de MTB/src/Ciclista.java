import java.util.ArrayList;
import java.util.Arrays;
class Ciclista {
    private String nombre;
    private double velocidadPromedio;
    private ArrayList<Recorrido> recorridosElegidos;
    private Nivel nivel;

    public Ciclista(String nombre, double velocidadPromedio, Nivel nivel) {
        this.nombre = nombre;
        this.velocidadPromedio = velocidadPromedio;
        this.recorridosElegidos = new ArrayList<>();
        this.nivel = nivel;
    }

    public void agregarRecorrido(Recorrido recorrido) {
        recorridosElegidos.add(recorrido);
    }

    public double calcularPuntajeTotal() {
        double puntajeTotal = 0;
        for (Recorrido recorrido : recorridosElegidos) {
            puntajeTotal += recorrido.calcularPuntaje();
        }
        return nivel.aplicarHandicap(puntajeTotal);
    }

    public double calcularTiempoTotal() {
        double tiempoTotal = 0;
        for (Recorrido recorrido : recorridosElegidos) {
            tiempoTotal += recorrido.calcularTiempo();
        }
        return tiempoTotal;
    }

    public double calcularDistanciaTotal() {
        double distanciaTotal = 0;
        for (Recorrido recorrido : recorridosElegidos) {
            distanciaTotal += recorrido.getDistancia();
        }
        return distanciaTotal;
    }

    public boolean terminaraEnMenosDe2Horas() {
        double tiempoEstimado = calcularDistanciaTotal() / velocidadPromedio;
        return tiempoEstimado < 2;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPuntajeTotal() {
        return calcularPuntajeTotal();
    }
}