
public class DigitalPersona extends Biometrico
{
   boolean ledAzul = true;
   boolean ledRojo = false;
   boolean lector = false;
   boolean errorLectura = false;
   String data = "";
   int rand;
   
    public String onHuella(boolean dedoEnLector) {
        if(dedoEnLector == true){
            ledAzul = false;
            ledRojo = true;
            return "Huella leida correctamente";
    }
        return "No hay dedo en el lector";
    }
    public String onMuestra() {
        rand = (int)(Math.random()*100);
        if(rand >= 50) {
            errorLectura = true;
            if(errorLectura == true) {
                return "Error de lectura";
            }
        }else {
            data = "Lectura de biometrico completa";
            return data;
        }
        return "";
    }
    public String outHuella() {
        if(errorLectura == true) {
            ledAzul = true;
            ledRojo = false;
            lector = false;
            return "Error en la lectura de la huella";
        }
        return "Lectura completa";
    }
}
