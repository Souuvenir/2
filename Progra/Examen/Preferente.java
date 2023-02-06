
public class Preferente extends Estacionamiento
{
    private int tarifaUnica;
    private int tipoDescuento;
    double total = 0;
    double porcentajeDesc = 0;
    double totalDesc = 0;
    
    public Preferente(String sigla, String ubicacion){
        super.setSigla(sigla);  
        super.setUbicacion(ubicacion);
    }
    
    public double valorAPagar()
    {
        totalDesc = ((porcentajeDesc / 100) * tarifaUnica);
        total = tarifaUnica - totalDesc;
        return total;
    }
    
    public String mostrarPago() {
        total = valorAPagar();
        return "Preferente: " + "A pagar " + super.getSigla() + super.getUbicacion() + " $" + total + " Descuento: " + totalDesc ;
    }
    
    public void definirTarifaUnica(int tarifa) {
        tarifaUnica = tarifa;
    }

    public void definirTipoDescuento(int tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
        if(tipoDescuento == 1) { 
            porcentajeDesc = 20;
        }
        if(tipoDescuento == 2) {
            porcentajeDesc = 10;
        }else if(tipoDescuento > 2) { 
            System.out.println("Refencia invalida de descuento");
        }
    }
    
    public void definirTarifaMinuto(int tarifa) {
        
    }
    
    public void registrarSalida(int hora, int minuto) {
       
    }
    
    public void registrarEntrada(int hora, int minuto) {
        
    }
}
