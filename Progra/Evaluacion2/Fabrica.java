import java.util.ArrayList;
import java.util.Random;

public class Fabrica
{
    private int[] metales;
    private ArrayList<String> estados;
    private int cantidadMinima;
    Random rand = new Random();
    int cont = 0;
    int contF = 0;
    int cant2 = 0;
    int cont2 = 0;  
    public Fabrica()
    {
        metales = new int[5];
        estados = new ArrayList();
    }
    public String agregarMaterial(int cantidad, int contenedor) {
        cant2 = cantidad;
        cont2 = contenedor;
        if(cantidad > 0 && contenedor > 0 ) {
            return "Parametros Validos";
        }
        else{
             if(contenedor <= 0 && cantidad <= 0) {
                return "La cantidad de contenedores y materiales no es suficiente";
            }
            if(cantidad <= 0) {
                return"La cantidad de material no es suficiente";
            }
            if(contenedor <= 0) {
                return"La cantidad de contenedores no es suficiente";
            }
            return "";
        }
        
    }
     public String fabricar() {
        StringBuilder salida = new StringBuilder();
        salida.append("Reporte de Fabricacion");
        cantidadMinima = 2;
        int metales[] = {1,2,3,4,5};
        for(int metal : metales) { 
            if(metal > cantidadMinima) {
                salida.append("Exitoso");
                estados.add("Exitoso");
            }
            else {
                salida.append("Fallo, metal insuficiente");
                estados.add("Fallo");
            }
        }
        return salida.toString();
    }
    public int getOks() {
        if(estados.size() == 0) {
                return -1;
            }
        for(String estado : estados) {
            if(estado == "Exito") {
                cont++;
            }
        }
        return cont;
    }
    public int getFallidos() {
        if(estados.size() == 0) {
                return -1;
            }
        for(String estado : estados) {
            if(estado == "Fallo") {
                contF++;
            }
        }
        return contF;
    }
    
}


