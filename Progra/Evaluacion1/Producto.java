
/**
 * Write a description of class Producto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Producto {
    private String id;
    private String nombre;
    private String descripcion;
    private int valor;
    
    public Producto(String codigo, String name, String descrip, int value) {
        id = codigo;
        nombre = name;
        descripcion = descrip;
        valor = value;
        if(codigo != null && name !=null && descrip != null && value > 0) {
            this.id = codigo;
            this.nombre = name;
            this.descripcion = descrip;
            this.valor = value;
        }
    }
    
    public void setName(String name) {
        nombre = name;
    }
    public String GetName() {
        return nombre;      
    }
    public void setID(String codigo) {
        id = codigo;
    }
    public String GetID() {
        return id;      
    }
    public void setDescripcion(String descrip) {
        descripcion = descrip;
    }
    public String GetDescripcion() {
        return descripcion;
    }
    public void setValue(int value) {
        valor = value;
    }
    public int GetValue() {
        return valor;
    }
}
