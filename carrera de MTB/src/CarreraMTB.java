import java.util.ArrayList;
import java.util.Arrays;
public class CarreraMTB {
    private ArrayList<Sede> sedes;

    public  CarreraMTB() {
        this.sedes = new ArrayList<>();
    }
    public ArrayList<Ciclista> obtenerCiclistasConMasDe30Puntos() {
        ArrayList<Ciclista> ciclistasConMasDe30Puntos = new ArrayList<>();
        for (Sede sede : sedes) {
            for (Ciclista ciclista : sede.getCiclistas()) {
                if (ciclista.calcularPuntajeTotal() > 30) {
                    ciclistasConMasDe30Puntos.add(ciclista);
                }
            }
        }
        return ciclistasConMasDe30Puntos;
    }

    public Ciclista obtenerCiclistaConMayorTiempo() {
        Ciclista ciclistaMayorTiempo = null;
        double mayorTiempo = 0;
        for (Sede sede : sedes) {
            for (Ciclista ciclista : sede.getCiclistas()){
                double tiempo = ciclista.calcularTiempoTotal();
                if (tiempo > mayorTiempo) {
                    mayorTiempo = tiempo;
                    ciclistaMayorTiempo = ciclista;
                }
            }
        }
        return ciclistaMayorTiempo;  // Retorna el ciclista con mayor tiempo
    }

    public ArrayList<Ciclista> obtenerCiclistasQueTerminanEnMenosDe2Horas() {
        ArrayList<Ciclista> ciclistasMenosDe2Horas = new ArrayList<>();
        for (Sede sede : sedes) {
            for (Ciclista ciclista : sede.getCiclistas()) {
                if (ciclista.terminaraEnMenosDe2Horas()) {
                    ciclistasMenosDe2Horas.add(ciclista);
                }
            }

        }
        return ciclistasMenosDe2Horas;
    }

    // Procedimiento para agregar una nueva sede
    public void agregarSede(Sede sede) {
        sedes.add(sede);
    }

    // Procedimiento para agregar un ciclista a una sede específica
    public void agregarCiclistaASede(String nombreSede, Ciclista ciclista) {
        for (Sede sede : sedes) {
            if (sede.getNombre().equals(nombreSede)) {
                sede.agregarCiclista(ciclista);
                return;
            }
        }
        System.out.println("Sede no encontrada: " + nombreSede);
    }

    public Sede obtenerSedeGanadora() {
        Sede sedeGanadora = null;
        double mayorPuntajeSede = 0;

        for (Sede sede : sedes) {
            Ciclista mejorCiclista = sede.getCiclistaMayorPuntaje();
            if (mejorCiclista != null && mejorCiclista.getPuntajeTotal() > mayorPuntajeSede) {
                mayorPuntajeSede = mejorCiclista.getPuntajeTotal();
                sedeGanadora = sede;
            }
        }
        return sedeGanadora;
    }

    public Ciclista obtenerGanadorTorneo() {
        Ciclista ganadorTorneo = null;
        double mayorPuntajeTorneo = 0;

        for (Sede sede : sedes) {
            for (Ciclista ciclista : sede.getCiclistas()) {
                if (ciclista.getPuntajeTotal() > mayorPuntajeTorneo) {
                    mayorPuntajeTorneo = ciclista.getPuntajeTotal();
                    ganadorTorneo = ciclista;
                }
            }
        }
        return ganadorTorneo;
    }

}
