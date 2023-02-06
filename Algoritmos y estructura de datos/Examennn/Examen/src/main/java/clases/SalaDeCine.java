package clases;

import java.util.ArrayList;

public class SalaDeCine {
    ArrayList<Pelicula> peliculas = new ArrayList();

    public SalaDeCine() {
        ArrayList<Pelicula> peliculas = new ArrayList<>();
    }


    public String agregarPelicula(Pelicula pelicula) {
        if (peliculas.size() == 0) {
            peliculas.add(pelicula);
            System.out.println("Pelicula Agregada \n");
            return "Pelicula Agregada";
        } else {
            for (Pelicula pelis : peliculas) {
                if (pelicula.getTitulo() == pelis.getTitulo()) {
                    System.out.println("Esta pelicula ya ha sido agregada anteriormente");
                    return "Esta pelicula ya ha sido agregada anteriormente";
                }
            }
        }
        return "";
    }

    public boolean buscarPelicula(String titulo) {
        for (Pelicula pelis : peliculas) {
            if (titulo == pelis.getTitulo()) {
                return true;
            }
        }
        return false;
    }


    public String listarPeliculas() {
        if (peliculas.size() > 0) {
            for (Pelicula pelis : peliculas) {
                System.out.println("Titulo: " + pelis.getTitulo());
                System.out.println("Genero: " + pelis.getGenero());
                System.out.println("Protagonista: " + pelis.getProtagonista().getNombre());
                System.out.println("Nacionalidad: " + pelis.getProtagonista().getNacionalidad() + "\n");
                return "Pelicula impresa";
            }
        } else {
            return "No hay nada para mostrar";
        }
        return "";
    }

    public int obtenerActricesMujeres() {
        int cantidad = 0;
        for (Pelicula pelis : peliculas) {
            if (pelis.getProtagonista().getSexo() == 'M') {
                cantidad = +1;
            }
        }
        return cantidad;
    }

    public int obtenerActoresJovenes() {
        int cantidad = 0;
        for (Pelicula pelis : peliculas) {
            if (pelis.getProtagonista().getEdad() >= 18 && pelis.getProtagonista().getEdad() <= 30 && pelis.getProtagonista().getNacionalidad() == "Estadounidense") {
                cantidad = +1;
            }
        }
        return cantidad;
    }

}

