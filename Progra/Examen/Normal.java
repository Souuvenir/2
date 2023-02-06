


public class Normal extends Estacionamiento
{
    private int horaEntrada;
    private int minutoEntrada;
    private int horaSalida;
    private int minutoSalida;
    private int tarifaMin;
    double total = 0;
    
    public Normal(String sigla, String ubicacion){
        super.setSigla(sigla);  
        super.setUbicacion(ubicacion);
    }
    
    public double valorAPagar() {
        int totalMin = 0;
        int totalHora = 0;
        totalMin = minutoSalida - minutoEntrada;
        totalHora = (horaSalida - horaEntrada) * 60;        
        total = (totalMin + totalHora) * tarifaMin;
        return total;
    }
    
    public String mostrarPago() {
        total = valorAPagar();
        return "Normal: " + "A pagar " + super.getSigla() + super.getUbicacion() + " $" + total;
    }
    
    public void registrarEntrada(int hora, int minuto) {
        horaEntrada = hora;
        minutoEntrada = minuto;
    }
    
    public void registrarSalida(int hora, int minuto) {
        horaSalida = hora;
        minutoSalida = minuto;
    }
    
    public void definirTarifaMinuto(int tarifa) {
        tarifaMin = tarifa;
    }
    
    public void definirTarifaUnica(int tarifa) {

    }
    
    public void definirTipoDescuento(int tipoDescuento) {

    }
}
