import  java.lang.Object;
import  java.lang.Math;

public class Microsoft extends Biometrico
{
    boolean lector = false;
    boolean luzLector = true;
    int random;
    String datoHuella = "";
    String dato = "vacio";

    public String onHuella(boolean dedoEnLector) {  
        random = (int)(Math.random()*100);
        datoHuella = String.valueOf(dedoEnLector);
        if(dedoEnLector == true) {
            luzLector = false;
            if(random <= 50) {
                lector = true;
                return "Lectura completa";
            }else{
                return"error en lectura";
            }
        }
        return "El dedo no esta en el lector ";
    }
    public String onMuestra() {
        dato = datoHuella;
        if(datoHuella == "true") {
            return "Dato recolectado con exito";
        }else{
            return "no hay dato para recolectar";
        }
       
    }    
    public String outHuella(){
        luzLector = true;
        lector = false;
        if(dato == "false"){
            return "No hay data para mostrar ";
        }
        return "La data fue recolectada con exito";
    }
}
