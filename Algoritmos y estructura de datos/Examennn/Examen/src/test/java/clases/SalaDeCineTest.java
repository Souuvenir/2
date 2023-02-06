package clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaDeCineTest {

    @Test
    void agregarPelicula() {
        Actor actor = new Actor("Tom Skerritt", 89, "Estadounidense", 'H');
        Pelicula pelicula = new Pelicula("Alien: the eight passenger", "Ficcion", "Ridley Scott", actor);
        SalaDeCine sala1 = new SalaDeCine();
        String valorObtenido = sala1.agregarPelicula(pelicula);
        String valorEsperado = "Pelicula Agregada";
        assertEquals(valorEsperado, valorObtenido);
    }

    @Test
    void buscarPelicula() {
        SalaDeCine sala1 = new SalaDeCine();
        Actor actor = new Actor("Tom Skerritt", 89, "Estadounidense", 'H');
        Pelicula pelicula = new Pelicula("Alien", "Ficcion", "Ridley Scott", actor);
        sala1.agregarPelicula(pelicula);
        boolean valorObtenido = sala1.buscarPelicula("Alien");
        boolean valorEsperado = true;
        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    void listarPeliculas() {
        Actor actor = new Actor("Tom Skerritt", 89, "Estadounidense", 'H');
        Pelicula pelicula = new Pelicula("Alien", "Ficcion", "Ridley Scott", actor);
        SalaDeCine sala1 = new SalaDeCine();
        sala1.agregarPelicula(pelicula);
        String valorObtenido = sala1.listarPeliculas();
        String valorEsperado = "Pelicula impresa";
        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    void obtenerActricesMujeres() {
        Actor actor = new Actor("Anne Hathaway", 39, "Estadounidense", 'M');
        Pelicula pelicula = new Pelicula("Devil Wears Prada", "Comedia Drama", "David Frankel", actor);
        SalaDeCine sala1 = new SalaDeCine();
        sala1.agregarPelicula(pelicula);
        int valorObtenido = sala1.obtenerActricesMujeres();
        int valorEsperado = 1;
        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    void obtenerActoresJovenes() {
        Actor actor = new Actor("Anne Hathaway", 29, "Estadounidense", 'M');
        Pelicula pelicula = new Pelicula("Devil Wears Prada", "Comedia Drama", "David Frankel", actor);
        SalaDeCine sala1 = new SalaDeCine();
        sala1.agregarPelicula(pelicula);
        int valorObtenido = sala1.obtenerActoresJovenes();
        int valorEsperado = 1;
        assertEquals(valorObtenido, valorEsperado);

    }
}