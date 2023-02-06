package clases;

public class Actor {
    String nombre;
    int edad;
    String nacionalidad;
    char sexo;


    public Actor(String nombre, int edad, String nacionalidad, char sexo) {
        this.nombre = nombre;
        if (edad < 18){
            throw new IllegalArgumentException("Debe ser mayor de 18 años");
        } else {
            this.edad = edad;
        }
        this.nacionalidad = nacionalidad;
        if(sexo != 'H' && sexo != 'M' ){
            throw new IllegalArgumentException("Sexo debe ser H o M");
        } else {
            this.sexo = sexo;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
            this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
            this.sexo = sexo;
    }
}
