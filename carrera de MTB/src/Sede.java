import java.util.ArrayList;
import java.util.Arrays;
class Sede {
    private String nombre;
    private ArrayList<Ciclista> ciclistas;

    public Sede(String nombre) {
        this.nombre = nombre;
        this.ciclistas = new ArrayList<>();
    }

    public void agregarCiclista(Ciclista ciclista) {
        ciclistas.add(ciclista);
    }

    public Ciclista getCiclistaMayorPuntaje() {
        Ciclista mayorPuntajeCiclista = null;
        double mayorPuntaje = 0;
        for (Ciclista ciclista : ciclistas) {
            if (ciclista.getPuntajeTotal() > mayorPuntaje) {
                mayorPuntaje = ciclista.getPuntajeTotal();
                mayorPuntajeCiclista = ciclista;
            }
        }
        return mayorPuntajeCiclista;
    }

    public ArrayList<Ciclista> getCiclistas() {
        return ciclistas;
    }

    public String getNombre() {
        return nombre;
    }
}