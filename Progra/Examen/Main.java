

public class Main
{
    public static void main(){
        Estacionamiento e1 = new Normal("A1 ","Sector 1");
        Estacionamiento e2 = new Preferente("P1 ","Sector 1");
        e1.registrarEntrada(10, 20);
        e1.registrarSalida(11,30);
        e1.definirTarifaMinuto(50);
        e2.definirTipoDescuento(1);
        e2.definirTarifaUnica(3000);
        System.out.println(e1.mostrarPago());
        System.out.println(e2.mostrarPago());
    }
    
}
