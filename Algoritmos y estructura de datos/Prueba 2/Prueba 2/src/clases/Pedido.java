package clases;
import java.util.ArrayList;

public class Pedido  {
    String nombreCliente;
    public ArrayList<Repuesto> listaRepuestos;

    public Pedido() {
        listaRepuestos = new ArrayList<>();
    }

    public Pedido(String nombreCliente){

    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String agregarRepuesto(Repuesto nuevoRepuesto){

        boolean verificar = false;
        String respuesta = "";
        for (Repuesto nuevoR : listaRepuestos) {

            if(nuevoR.codigo == nuevoRepuesto.codigo ) {
                nuevoRepuesto.cantidad = nuevoRepuesto.cantidad + 1;
                respuesta = "Respuesto sumado con exito";
                verificar = true;
                System.out.println(respuesta);
                return respuesta;
            }
        }

        if (!verificar) {
            listaRepuestos.add(nuevoRepuesto);
            respuesta = "Repuesto agregado con exito";
            System.out.println(respuesta);
            return respuesta;
        }

        return respuesta;
    }

    public void listarRepuestos() {
        for (Repuesto x : listaRepuestos) {
            System.out.println("" + x.nombre + "\n");
        }
    }

    public String eliminarRepuestos(int codigo) {

        String msj = "No se ha encontrado codigo";

        for (Repuesto rep : listaRepuestos) {
            if(rep.codigo == codigo) {
                listaRepuestos.remove(rep);
                msj = "Codigo eliminado";
            }
        }
        return msj;
    }

    public int obtenerRepuestosMarca(String marca) {
        int total = 0;
        for (Repuesto rep : listaRepuestos) {
            if(rep.marca == marca) {
                total++;
            }
        }
        return total;
    }

    public int obtenerTotal() {
    double totalP = 0;
        for (Repuesto rep: listaRepuestos) {
            totalP = totalP + rep.precio;
        }
        return (int) totalP;
    }

}



