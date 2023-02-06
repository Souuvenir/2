package clases;

public class Pelicula {
    String titulo;
    String genero;
    String director;
    Actor protagonista;


    public Pelicula(String titulo, String genero, String director, Actor protagonista) {
        if (titulo.length() < 6) {
            throw new IllegalArgumentException("Titulo debe contener al menos 6 caracteres");
        } else {
            this.titulo = titulo;
        }
        this.genero = genero;
        this.director = director;
        this.protagonista = protagonista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Actor getProtagonista() {
        return protagonista;
    }

    public void setProtagonista(Actor protagonista) {
        this.protagonista = protagonista;
    }

    public void imprimir() {
        System.out.println("Titulo pelicula: " + getTitulo());
        System.out.println("Genero: " + getGenero());
        System.out.println("Nombre Director: " + getDirector());
        System.out.println("Nombre Protagonista: " + getProtagonista());
    }

}
