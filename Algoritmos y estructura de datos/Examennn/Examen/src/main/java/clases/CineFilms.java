package clases;

public class CineFilms {
    public static void main(String[] args) {
        Actor actor = new Actor("Tom Skerritt", 89, "Estadounidense", 'H');
        Pelicula pelicula = new Pelicula("Alien: the eight passenger", "Ficcion", "Ridley Scott", actor);
        SalaDeCine sala = new SalaDeCine();
        Actor actor2 = new Actor("Anne Hathaway", 20, "Estadounidense", 'M');
        Pelicula pelicula2 = new Pelicula("Devil Wears Prada", "Comedia Drama", "David Frankel", actor2);
        SalaDeCine sala2 = new SalaDeCine();
        Actor actor3 = new Actor("Michael Fassbender", 39, "Estadounidense", 'H');
        Pelicula pelicula3 = new Pelicula("Alien: Covenant", "Ficcion", "Ridley Scott", actor3);
        SalaDeCine sala3 = new SalaDeCine();

        sala.agregarPelicula(pelicula);
        sala2.agregarPelicula(pelicula2);
        sala3.agregarPelicula(pelicula3);

        sala.listarPeliculas();
        sala2.listarPeliculas();
        sala3.listarPeliculas();
    }
}
