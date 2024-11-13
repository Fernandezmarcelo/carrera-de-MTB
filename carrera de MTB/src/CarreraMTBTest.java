import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class CarreraMTBTest {

    @Test
    public void testObtenerCiclistasConMasDe30Puntos() {
        // Crear las sedes y los ciclistas
        Sede sede1 = new Sede("Buenos Aires");
        Sede sede2 = new Sede("Pilar");

        Ciclista ciclista1 = new Ciclista("Carlos", 15, new Principiante());
        ciclista1.agregarRecorrido(new RecorridoFacil(20));  // Puntaje total > 30
        Ciclista ciclista2 = new Ciclista("Ana", 12, new Experto());
        ciclista2.agregarRecorrido(new RecorridoAvanzado(18, 2));  // Puntaje total < 30
        Ciclista ciclista3 = new Ciclista("Luis", 10, new Principiante());
        ciclista3.agregarRecorrido(new RecorridoFacil(10));  // Puntaje total < 30

        // Agregar ciclistas a las sedes
        sede1.agregarCiclista(ciclista1);
        sede2.agregarCiclista(ciclista2);
        sede2.agregarCiclista(ciclista3);

        // Crear la carrera y agregar las sedes
        CarreraMTB carrera = new CarreraMTB();
        carrera.agregarSede(sede1);
        carrera.agregarSede(sede2);

        // Obtener ciclistas con más de 30 puntos
        ArrayList<Ciclista> ciclistasConMasDe30 = carrera.obtenerCiclistasConMasDe30Puntos();

        // Verificar que solo ciclista1 está en la lista
        assertEquals(1, ciclistasConMasDe30.size());
        assertEquals("Carlos", ciclistasConMasDe30.get(0).getNombre());
    }
    @Test
    public void testObtenerCiclistaConMayorTiempo() {
        // Crear las sedes y los ciclistas
        Sede sede1 = new Sede("Buenos Aires");
        Sede sede2 = new Sede("Pilar");

        Ciclista ciclista1 = new Ciclista("Carlos", 15, new Principiante());
        ciclista1.agregarRecorrido(new RecorridoFacil(30));  // Tiempo estimado bajo
        Ciclista ciclista2 = new Ciclista("Ana", 12, new Experto());
        ciclista2.agregarRecorrido(new RecorridoAvanzado(20, 2));  // Tiempo estimado más alto
        Ciclista ciclista3 = new Ciclista("Luis", 10, new Principiante());
        ciclista3.agregarRecorrido(new RecorridoFacil(10));  // Tiempo estimado bajo

        // Agregar ciclistas a las sedes
        sede1.agregarCiclista(ciclista1);
        sede2.agregarCiclista(ciclista2);
        sede2.agregarCiclista(ciclista3);

        // Crear la carrera y agregar las sedes
        CarreraMTB carrera = new CarreraMTB();
        carrera.agregarSede(sede1);
        carrera.agregarSede(sede2);

        // Obtener el ciclista con mayor tiempo estimado
        Ciclista ciclistaMayorTiempo = carrera.obtenerCiclistaConMayorTiempo();

        // Verificar que ciclista2 (Ana) tiene el mayor tiempo estimado
        assertNotNull(ciclistaMayorTiempo);
        assertEquals("Ana", ciclistaMayorTiempo.getNombre());
    }
    


    @Test
    void testSedeGanadora() {
        CarreraMTB carrera = new CarreraMTB();

        // Crear sedes y ciclistas
        Sede sede1 = new Sede("Buenos Aires");
        Sede sede2 = new Sede("Pilar");
        Ciclista ciclista1 = new Ciclista("Carlos", 15, new Principiante());
        Ciclista ciclista2 = new Ciclista("Ana", 12, new Experto());

        // Agregar recorridos a ciclistas
        ciclista1.agregarRecorrido(new RecorridoFacil(10));
        ciclista2.agregarRecorrido(new RecorridoAvanzado(18, 2));

        // Agregar sedes y ciclistas al tour
        carrera.agregarSede(sede1);
        carrera.agregarSede(sede2);
        carrera.agregarCiclistaASede("Buenos Aires", ciclista1);
        carrera.agregarCiclistaASede("Pilar", ciclista2);

        // Verificar la sede ganadora
        Sede sedeGanadora = carrera.obtenerSedeGanadora();
        assertNotNull(sedeGanadora);
        assertEquals("Buenos Aires", sedeGanadora.getNombre());
    }

    @Test
    void testGanadorTorneo() {
        CarreraMTB carrera = new CarreraMTB();

        // Crear sedes y ciclistas
        Sede sede = new Sede("Pilar");
        Ciclista ciclista = new Ciclista("Ana", 12, new Experto());

        // Agregar recorrido y sede al tour
        ciclista.agregarRecorrido(new RecorridoAvanzado(18, 2));
        carrera.agregarSede(sede);
        carrera.agregarCiclistaASede("Pilar", ciclista);

        // Verificar el ciclista ganador del torneo
        Ciclista ganador = carrera.obtenerGanadorTorneo();
        assertNotNull(ganador);
        assertEquals("Ana", ganador.getNombre());
    }
}