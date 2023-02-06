
public abstract class Estacionamiento
{
    private String sigla;
    private String ubicacion;
    
    public abstract double valorAPagar();
    public abstract String mostrarPago();
    public abstract void registrarEntrada(int hora, int minuto);
    public abstract void registrarSalida(int hora, int minuto);
    public abstract void definirTarifaMinuto(int tarifa);
    public abstract void definirTarifaUnica(int tarifa);
    public abstract void definirTipoDescuento(int tipoDescuento);
    
    public String getSigla() {
        return sigla;
    }
    
    public void setSigla(String sigla) {
        this.sigla = sigla; 
    }
    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion; 
    }
    

}