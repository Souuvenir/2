
/**
 * Write a description of class Constructora here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Constructora
{
    private String rut;
    private String nombre;
    private String direccion;
    private int edad;
    private int telefono;

    public Constructora()
    {   //constructor
        this.rut = "";
        this.nombre = "";
        this.direccion = "";
        this.edad = 0;
        this.telefono = 0;   
    }
    // getters y setters
    public void setRut(String id) {
        this.rut = id;
    }
    
    public String getRut() {
        return this.rut;
    }
    
    public void setNombre(String name) {
        this.nombre = name;
    }
    
    public String getName() {
        return this.nombre;
    }
    
    public void setDireccion(String adress) {
        this.direccion = adress;
    }
    
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setEdad(int age) {
        this.edad = age;
    }
    
    public int getEdad() {
        return this.edad;
    }
    
    public void setTelefono(int phone) {
        this.telefono = phone;
    }
    
    public int getTelefono() {
        return telefono;
    }
    
    
}



