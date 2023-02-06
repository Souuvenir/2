
/**
 * Write a description of class Caja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Caja
{
    // Variables Contenedor de vuelto
    private int cantM10;
    private int cantM50;
    private int cantM100;
    private int cantM500;
    // Variables monedas entrantes
    private int cantCajaM10;
    private int cantCajaM50;
    private int cantCajaM100;
    private int cantCajaM500;
    
    
    public Caja(int cantM10, int cantM50, int cantM100, int cantM500) {
        if(cantM10 > 0 && cantM50 > 0 && cantM100 > 0 && cantM500 > 0) {
            this.cantM10 = cantM10;
            this.cantM50 = cantM50;
            this.cantM100 = cantM100;
            this.cantM500 = cantM500;
            cantCajaM10 = 0;
            cantCajaM50 = 0;
            cantCajaM100 = 0;
            cantCajaM500 = 0;
        }else {
            throw new IllegalArgumentException("No hay suficiente vuelto");
        }
        
    }

    
    private boolean verificarMoneda(int moneda) {
        if(moneda == 10) {
            return true;
        }
        if(moneda == 50) {
            return true;
        }
        if(moneda == 100) {
            return true;
        }
        if(moneda == 500) {
            return true;
        }
        return false;
    }
    
    public int getCantM10() {
        return cantM10;
    }
    public int getCantM50() {
        return cantM50;
    }
    public int getCantM100() {
        return cantM100;
    }
    public int getCantM500() {
        return cantM50;
    }
    public int getCantCajaM10() {
        return cantCajaM10;
    }
    public int getCantCajaM50() {
        return cantCajaM50;
    }
    public int getCantCajaM100() {
        return cantCajaM100;
    }
    public int getCantCajaM500() {
        return cantCajaM500;
    }
    
    public String ingresarMoneda(int moneda) {
    verificarMoneda(moneda);
    if(moneda == 10) {
        cantCajaM10 ++;
        return "Moneda Ingresada";
    }
    if(moneda == 50) {
        cantCajaM50 ++;
        return "Moneda Ingresada";
    }
    if(moneda == 100) {
        cantCajaM100 ++;
        return "Moneda Ingresada";
    }
    if(moneda == 500) {
        cantCajaM500 ++;
        return "Moneda Ingresada";
    }
    return "Moneda Invalida";
}
}
