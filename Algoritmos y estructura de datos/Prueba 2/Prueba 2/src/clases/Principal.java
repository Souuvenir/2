package clases;

public class Principal {
    public static void main(String[] args) {

        Pedido pedido = new Pedido();
        Repuesto nuevoR = new Repuesto(4532, "Nissan", "Asientos", 450000,4 );
        Repuesto nuevoR2 = new Repuesto(4527, "Chevrolet","Retrovisor",100000,1);
        boolean existe = false;

        //agrega pedido
        pedido.agregarRepuesto(nuevoR);
        pedido.agregarRepuesto(nuevoR2);

        //listar
        pedido.listarRepuestos();

        //verificar
        for (Repuesto repuesto: pedido.listaRepuestos) {
           if(repuesto.codigo == nuevoR.codigo) {
               existe = true;
           }
        }
        if (existe){
           System.out.println("Codigo encontrado \n");
        } else {
            System.out.println("Codigo no encontrado \n");
        }

        //eliminar
        pedido.eliminarRepuestos(4532);

        //listar despues de eliminar repuesto
        pedido.listarRepuestos();

        //mostrar por marca
        System.out.println("Total: " + pedido.obtenerRepuestosMarca("Chevrolet"));

    }
}
