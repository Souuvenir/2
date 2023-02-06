package clases;

public class Repuesto {
    int codigo;
    String marca;

    String nombre;
    double precio;
    int cantidad;

    public Repuesto() {
    }

    public Repuesto(int codigo, String marca, String nombre, double precio, int cantidad) {

        if (codigo < 1) {
            throw new IllegalArgumentException("Codigo debe ser mayor que 0");
        } else {
            this.codigo = codigo;
        }

        if (marca == "") {
            throw new IllegalArgumentException("Nombre de marca no puede estar vacio");
        } else {
            this.marca = marca;
        }

        if (cantidad < 1) {
            throw new IllegalArgumentException("Cantidad tiene que ser mayor que 0");
        } else {
            this.cantidad = cantidad;
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
