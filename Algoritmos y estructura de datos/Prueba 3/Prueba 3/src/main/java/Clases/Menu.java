package Clases;

public class Menu extends Trabajadores{
    public static void main(String[] args) {
    Trabajadores trabajadores = new Trabajadores("159655886", "SILVIO PEREZ", 'M', 46, 400000, 0);
    trabajadores.calcularIncentivo();
    trabajadores.mostrarIncentivo();

    Trabajadores trabajadores2 = new Trabajadores("186585518", "PEPE TAPIAAAA", 'M', 46, 800000, 4);
    trabajadores2.calcularIncentivo();
    trabajadores2.mostrarIncentivo();

    Trabajadores trabajadores3 = new Trabajadores("156585515", "Carla Perez", 'F', 45, 350000, 0);
    trabajadores3.calcularIncentivo();
    trabajadores3.mostrarIncentivo();


    Trabajadores trabajadores4 = new Trabajadores("196565517", "Nathalia Busnego", 'F', 45, 500000, 2);
    trabajadores4.calcularIncentivo();
    trabajadores4.mostrarIncentivo();


    Trabajadores trabajadores5 = new Trabajadores("136585513", "Carolina Castro", 'F', 45, 540000, 80);
    trabajadores5.calcularIncentivo();
    trabajadores5.mostrarIncentivo();


    Trabajadores trabajadores6 = new Trabajadores("185544218", "Carlos Tapia", 'M', 25, 310000, 10);
    trabajadores6.calcularIncentivo();
    trabajadores6.mostrarIncentivo();

    //se agregan los correspondientes casos de los requerimientos y un ultimo donde no se cumple ninguna de las condiciones y retorna 0 como incentivo

    }

}
