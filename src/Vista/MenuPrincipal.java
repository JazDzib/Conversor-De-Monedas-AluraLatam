package Vista;

import Controlador.HttpCliente;

import java.util.Scanner;

public class MenuPrincipal {

    public void IndiceMoneda(){

        System.out.println("Monedas aceptadas: ");
        System.out.println("1. ARS - Peso argentino\n" +
                "2. BOB - Boliviano boliviano\n" +
                "3. BRL - Real brasileño\n" +
                "4. CLP - Peso chileno\n" +
                "5. COP - Peso colombiano\n" +
                "6. USD - Dólar estadounidense\n"+
                "7. Salir");

    }

    public String imprimirSalida(Double cantidad, int monedaEntrada, int monedaSalida, double cambio){

        HttpCliente consult = new HttpCliente();

        return ("La cantidad de $" +cantidad+ " "+ consult.generadorMoneda(monedaEntrada) + " es equivalente a $" + cambio + consult.generadorMoneda(monedaSalida));
    }


}
