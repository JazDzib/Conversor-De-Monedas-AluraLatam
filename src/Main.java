import Controlador.HttpCliente;
import Modelo.Moneda;
import Vista.MenuPrincipal;

import java.io.IOException;

import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws IOException, InterruptedException{
            HttpCliente cons= new HttpCliente();
            MenuPrincipal menu = new MenuPrincipal();
            Moneda consultaM;

            while (true) {
                System.out.println("\n============CONVERTIDOR DE MONEDAS===========");
                menu.IndiceMoneda();
                Scanner sc = new Scanner(System.in);
                System.out.println("Seleccione la moneda que desea: ");
                int opcionEntrada = sc.nextInt();
                if (opcionEntrada == 7 )
                    break;
                else if (opcionEntrada > 7  || opcionEntrada< 1) {
                    System.out.println("moneda no permitida");
                    menu.IndiceMoneda();
                }

                System.out.println("Ingrese la cantidad que desea convertir: ");
                Double cantidad = sc.nextDouble();

                consultaM = new Moneda(cons.consulta(opcionEntrada));


                menu.IndiceMoneda();
                System.out.println("Ingrese la moneda de destino: ");
                int omSalida = sc.nextInt();
                if (omSalida == 7)
                    break;

                System.out.println(menu.imprimirSalida(cantidad, opcionEntrada, omSalida, consultaM.cambio(cantidad, omSalida)));;



            }
            System.out.println("Gracias por usar el programa");


        }



}