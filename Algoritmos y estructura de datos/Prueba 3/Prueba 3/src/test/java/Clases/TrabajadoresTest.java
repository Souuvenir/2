package Clases;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrabajadoresTest {

    @Test
    void calcularIncentivo() {
        Trabajadores trabajadores = new Trabajadores("159655886", "SILVIO PEREZ", 'M', 46, 400000, 0);
        int valorObtenido = trabajadores.calcularIncentivo();
        int valorEsperado = 40000;
        assertEquals(valorObtenido, valorEsperado);
    }
    @Test
    void calcularIncentivo2() {
        Trabajadores trabajadores = new Trabajadores("186585518", "PEPE TAPIAAAA", 'M', 46, 800000, 4);
        int valorObtenido = trabajadores.calcularIncentivo();
        int valorEsperado = 144000;
        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    void calcularIncentivo3() {
        Trabajadores trabajadores = new Trabajadores("156585515", "Carla Perez", 'F', 45, 350000, 0);
        int valorObtenido = trabajadores.calcularIncentivo();
        int valorEsperado = 35000;
        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    void calcularIncentivo4() {
        Trabajadores trabajadores = new Trabajadores("196565517", "Nathalia Busnego", 'F', 45, 500000, 2);
        int valorObtenido = trabajadores.calcularIncentivo();
        int valorEsperado = 100000;
        assertEquals(valorObtenido, valorEsperado);
    }

    @Test
    void calcularIncentivo5() {
        Trabajadores trabajadores = new Trabajadores("136585513", "Carolina Castro", 'F', 45, 540000, 80);
        int valorObtenido = trabajadores.calcularIncentivo();
        int valorEsperado = 135000;
        assertEquals(valorObtenido, valorEsperado);
    }

}