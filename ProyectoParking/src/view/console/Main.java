package view.console;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import model.Parking;
import model.Ticket;
import model.Vehiculo;
import model.data.enums.EnumColor;
import model.data.enums.EnumVehiculo;
import model.data.exceptions.NotFreePlacesException;
import model.data.exceptions.TicketNotFoundException;

public class Main {

    public static void main(String[] args) {

        // Lista de tarifas
        Map<EnumVehiculo, Double> tarifas = new HashMap<>();
        tarifas.put(EnumVehiculo.COCHE, 5.0);
        tarifas.put(EnumVehiculo.MOTO, 3.0);
        tarifas.put(EnumVehiculo.CAMION, 1.0);

        // Datos del parking
        Parking parking = new Parking(123, "Parking Monlau", "C/ Monlau 6, Barcelona", "+34 666 66 66", 3, 10, tarifas);

        Scanner scan = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mostrar todas las plazas");
            System.out.println("2. Mostrar plazas disponibles");
            System.out.println("3. Mostrar plazas para Coches");
            System.out.println("4. Mostrar plazas para Motos");
            System.out.println("5. Mostrar plazas para Camiones");
            System.out.println("6. Asignar plaza");
            System.out.println("7. Liberar plaza");
            System.out.println("0. Salir");
            System.out.print("Elige una opcion: ");

            // Valido que la opcion sea un numero
            while (!scan.hasNextInt()) {
                System.out.println("Opcion no valida. Por favor, ingresa un numero.");
                scan.next();
                System.out.print("Elige una opcion: ");
            }
            opcion = scan.nextInt();
            scan.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("\nEstado de todas las plazas:");
                    parking.mostrarPlazas();
                    break;

                case 2:
                    System.out.println("\nPlazas disponibles:");
                    System.out.print(parking.mostrarPlazasLibres());
                    break;

                case 3:
                    System.out.println("\nPlazas disponibles para Coches:");
                    parking.mostrarPlazasPorTipo(EnumVehiculo.COCHE);
                    break;

                case 4:
                    System.out.println("\nPlazas disponibles para Motos:");
                    parking.mostrarPlazasPorTipo(EnumVehiculo.MOTO);
                    break;

                case 5:
                    System.out.println("\nPlazas disponibles para Camiones:");
                    parking.mostrarPlazasPorTipo(EnumVehiculo.CAMION);
                    break;

                case 6:
                    System.out.print("\nIntroduce la matricula del vehiculo: ");
                    String matricula = scan.nextLine();
                    EnumColor color = null;
                    boolean colorValido = false;
                    while (!colorValido) {
                        System.out.print("Introduce el color del vehiculo (ROJO, AZUL, VERDE, NEGRO, BLANCO): ");
                        String colorStr = scan.nextLine().toUpperCase();
                        try {
                            color = EnumColor.valueOf(colorStr);
                            colorValido = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Color no valido. Intenta de nuevo.");
                        }
                    }

                    EnumVehiculo tipoVehiculo = null;
                    boolean tipoValido = false;
                    while (!tipoValido) {
                        System.out.print("Introduce el tipo de vehiculo (COCHE, MOTO, CAMION): ");
                        String tipoStr = scan.nextLine().toUpperCase();
                        try {
                            tipoVehiculo = EnumVehiculo.valueOf(tipoStr);
                            tipoValido = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Tipo de vehiculo no valido. Intenta de nuevo.");
                        }
                    }

                    Vehiculo vehiculo = new Vehiculo(tipoVehiculo, matricula, color);

                    // Excepcion en caso de que no exista plaza para el vehiculo
                    try {
                        String ticket = parking.asignarPlaza(vehiculo);
                        System.out.println("\n" + ticket);
                    } catch (NotFreePlacesException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    System.out.print("\nIntroduce el identificador del ticket (ejemplo: PR123_2_5): ");
                    String ticketId = scan.nextLine();

                    // Excepcion en caso de que no exista o sea invalido el ticket introducido
                    try {

                        Ticket ticketObj = parking.buscarTicket(ticketId);
                        String mensaje = parking.liberarPlaza(ticketObj);
                        System.out.println(mensaje);
                    } catch (TicketNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("\nSaliendo del sistema. Gracias!");
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }
        } while (opcion != 0);

        scan.close();
    }
}
