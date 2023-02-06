package Clases;

public class Trabajadores {

String rut;
String nombre;

char sexo;
int edad;
int sueldoBase;
int cantidadDeHijos;

    public Trabajadores() {
    }

    public Trabajadores(String rut, String nombre, char sexo, int edad, int sueldoBase, int cantidadDeHijos) {
        if (rut == "") {
            throw new IllegalArgumentException("rut no puede estar vacio");
        } else {
            this.rut = rut;
        }

        if (nombre.length() < 5){
            throw new IllegalArgumentException("nombre debe contener al menos 5 caracteres");
        } else {
            this.nombre = nombre;
        }

        if(sexo != 'M' && sexo != 'F' ){
            throw new IllegalArgumentException("Sexo debe ser M o F");
        } else {
            this.sexo = sexo;
        }

        if (edad < 18){
            throw new IllegalArgumentException("Debe ser mayor de 18 años");
        } else {
            this.edad = edad;
        }

        if(sueldoBase < 300000){
            throw new IllegalArgumentException("Sueldo base debe ser mayor que 300.000");
        } else {
            this.sueldoBase = sueldoBase;
        }

        if ( cantidadDeHijos < 0) {
            throw new IllegalArgumentException("Cantidad de hijos no puede ser negativo");
        } else {
            this.cantidadDeHijos = cantidadDeHijos;
        }

    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(int sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public int getCantidadDeHijos() {
        return cantidadDeHijos;
    }

    public void setCantidadDeHijos(int cantidadDeHijos) {
        this.cantidadDeHijos = cantidadDeHijos;
    }

    int calcularIncentivo(){
        int incentivo = 0;

        if (getSexo() == 'M' && getEdad() >= 45 && getCantidadDeHijos() == 0) {
            incentivo = (getSueldoBase()/100) * 10;
            return incentivo;
        }

        if (getSexo() == 'M' && getEdad() >= 45 && getCantidadDeHijos() > 0) {
            incentivo = (getSueldoBase()/100) * 18;
            return incentivo;
        }

        if (getSexo() == 'F' && getEdad() > 40 && getCantidadDeHijos() == 0) {
            incentivo = (getSueldoBase()/100) * 10;
            return incentivo;
        }

        if (getSexo() == 'F' && getEdad() > 40 && getCantidadDeHijos() <= 3) {
            incentivo = (getSueldoBase()/100) * 20;
            return incentivo;
        }

        if (getSexo() == 'F' && getCantidadDeHijos() > 3) {
            incentivo = (getSueldoBase()/100) * 25;
            return incentivo;
        }

        return incentivo;
    }

    public void mostrarIncentivo(){
        int incentivo = calcularIncentivo();
        System.out.println("Nombre del Trabajador: " + getNombre());
        System.out.println("Sueldo actual: " + getSueldoBase());
        System.out.println("Incentivo a recibir: " + incentivo +"\n");
    }

}


