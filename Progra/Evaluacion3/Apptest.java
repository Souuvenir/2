public class Apptest
{
    
    public static void main()
    {
        Biometrico b1 = new Microsoft();   
        Biometrico b2 = new DigitalPersona();
        
        String resultado = b1.onHuella(true);
        String resultado2 = b1.onMuestra();
        String resultado3 = b1.outHuella();
        String resultado4 = b2.onHuella(true);
        String resultado5 = b2.onMuestra();
        String resultado6 = b2.outHuella();
        
        b1.onHuella(true);
        b1.onMuestra();
        b1.outHuella();
        b2.onHuella(true);
        b2.onMuestra();
        b2.outHuella();
        
        System.out.println("Resultado onHuella: " + resultado);
        System.out.println("Resultado onMuestra: " + resultado2);
        System.out.println("Resultado outHuella: " + resultado3);
        System.out.println("Resultado onHuellaDigitalP: " + resultado4);
        System.out.println("Resultado onMuestraDigitalP: " + resultado5);
        System.out.println("Resultado outHuellaDigitalP: " + resultado6);
    }
    
}
