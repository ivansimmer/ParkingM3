package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.data.enums.EnumVehiculo;
import model.data.exceptions.NotFreePlacesException;
import model.data.exceptions.TicketNotFoundException;

/**
 *
 * @author ivans
 */
public class Parking {

    // Lista de colores con codigo ANSI
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
    // Para libres, color verde
    String freeSlotColor = ANSI_GREEN_BACKGROUND;
    
    // Para ocupadas, color rojo
    String occupiedSlotColor = ANSI_RED_BACKGROUND;

    private int id;
    private String nombre;
    private String ubicacion;
    private String telefono;
    private int numPisos;
    private int numPlazasPorPiso;
    private Map<EnumVehiculo, Double> listaTarifa;
    private ArrayList<ArrayList<Plaza>> listaPlazas;
    
    // Map para gestionar los tickets en activos
    private Map<String, Ticket> ticketsActivos;

    public Parking(int id, String nombre, String ubicacion, String telefono, int numPisos, int numPlazasPorPiso, Map<EnumVehiculo, Double> listaTarifa) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.numPisos = numPisos;
        this.numPlazasPorPiso = numPlazasPorPiso;
        this.listaTarifa = listaTarifa;
        this.listaPlazas = new ArrayList<>();
        this.ticketsActivos = new HashMap<>();
        inicializarPlazas();
    }

    private void inicializarPlazas() {
        for (int i = 0; i < numPisos; i++) {
            ArrayList<Plaza> piso = new ArrayList<>();
            for (int j = 0; j < numPlazasPorPiso; j++) {
                EnumVehiculo tipo;
                if (j == 0) {
                    tipo = EnumVehiculo.CAMION; // La primera plaza es para camiones
                } else if (j == 1 || j == 2) {
                    tipo = EnumVehiculo.MOTO; // Las dos siguientes para motos
                } else {
                    tipo = EnumVehiculo.COCHE; // El resto para coches
                }
                piso.add(new Plaza(i, j, tipo));
            }
            listaPlazas.add(piso);
        }
    }

    public String asignarPlaza(Vehiculo vehiculo) throws NotFreePlacesException {
        for (int i = 0; i < listaPlazas.size(); i++) {
            for (Plaza plaza : listaPlazas.get(i)) {
                if (!plaza.isOcupada() && plaza.getTipoVehiculo() == vehiculo.getTipoVehiculo()) {
                    plaza.asignarPlaza(vehiculo);
                    Ticket ticket = new Ticket(LocalDateTime.now(), null, vehiculo, plaza);
                    String ticketId = generarTicketId(ticket);
                    ticketsActivos.put(ticketId, ticket);  // Guardo el ticket en los activos
                    return "TICKET DE ENTRADA: \n" + nombre + "\n" + ubicacion + "\n" + telefono + "\n" + ticketId + "\n" + ticket.getFechaEntradaFormateada();
                }
            }
        }
        throw new NotFreePlacesException("\nNo hay plazas disponibles para este tipo de vehiculo.");
    }

    private String generarTicketId(Ticket ticket) {
        return "PR" + id + "_" + ticket.getPlaza().getPiso() + "_" + ticket.getPlaza().getNumeroPlaza();
    }

    public String liberarPlaza(Ticket ticket) {
        ticket.getPlaza().liberarPlaza();
        double duracion = ticket.calcularDuracion();
        double tarifa = listaTarifa.get(ticket.getVehiculo().getTipoVehiculo());
        double importe = ticket.calcularImporte(duracion, tarifa);
        ticketsActivos.remove(generarTicketId(ticket));  // Elimino el ticket de activos
        return "\nEl metodo con el cual calculamos el importe es: Duracion del estacionamiento * Tarifa.\nLas tarifas son:\n   "
                + "Para camiones el precio es el tiempo que ha estado estacionado.\n   Para motos se multiplica la duracion x3.\n   "
                + "Para coches se multiplica la duracion x5.\n\nEl tiempo que ha estado en el Parking Monlau es: " + ticket.calcularDuracion() + 
                " minutos.\n\nPlaza liberada. El importe a pagar son: " + importe + " euros.";
    }

    public Ticket buscarTicket(String ticketId) throws TicketNotFoundException {
        Ticket ticket = ticketsActivos.get(ticketId);
        if (ticket == null) {
            throw new TicketNotFoundException("\nEl ticket no existe o es invalido.");
        }
        return ticket;
    }

    public void mostrarPlazas() {
        for (int i = 0; i < listaPlazas.size(); i++) {
            System.out.println("Piso " + (i + 1) + ":");
            for (Plaza plaza : listaPlazas.get(i)) {
                if (plaza.isOcupada()) {
                    if (plaza.getTipoVehiculo().equals(EnumVehiculo.COCHE)) {
                        System.out.print(occupiedSlotColor + " C ");
                    } else if (plaza.getTipoVehiculo().equals(EnumVehiculo.MOTO)) {
                        System.out.print(occupiedSlotColor + " M ");
                    } else {
                        System.out.print(occupiedSlotColor + " T ");
                    }
                } else {
                    if (plaza.getTipoVehiculo().equals(EnumVehiculo.COCHE)) {
                        System.out.print(freeSlotColor + " C ");
                    } else if (plaza.getTipoVehiculo().equals(EnumVehiculo.MOTO)) {
                        System.out.print(freeSlotColor + " M ");
                    } else {
                        System.out.print(freeSlotColor + " T ");
                    }
                }
            }
            System.out.println();
        }
    }

    public String mostrarPlazasLibres() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaPlazas.size(); i++) {
            sb.append("Piso ").append(i + 1).append(":\n");
            for (Plaza plaza : listaPlazas.get(i)) {
                if (!plaza.isOcupada()) {
                    if (plaza.getTipoVehiculo().equals(EnumVehiculo.COCHE)) {
                        sb.append(freeSlotColor + " C ");
                    } else if (plaza.getTipoVehiculo().equals(EnumVehiculo.MOTO)) {
                        sb.append(freeSlotColor + " M ");
                    } else {
                        sb.append(freeSlotColor + " T ");
                    } // Plaza libre
                } else {
                    sb.append(occupiedSlotColor + "   "); // Pinto rojo si esta ocupada
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void mostrarPlazasPorTipo(EnumVehiculo tipoVehiculo) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < listaPlazas.size(); i++) {
            sb.append("Piso ").append(i + 1).append(":\n");
            for (Plaza plaza : listaPlazas.get(i)) {
                if (plaza.getTipoVehiculo() == tipoVehiculo) {
                    if (plaza.isOcupada()) {
                        sb.append(occupiedSlotColor + " X "); // Plaza ocupada
                    } else {
                        sb.append(freeSlotColor + " O "); // Plaza libre
                    }
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getNumPisos() {
        return numPisos;
    }

    public int getNumPlazasPorPiso() {
        return numPlazasPorPiso;
    }

    public Map<EnumVehiculo, Double> getListaTarifa() {
        return listaTarifa;
    }

    public ArrayList<ArrayList<Plaza>> getListaPlazas() {
        return listaPlazas;
    }

    public Map<String, Ticket> getTicketsActivos() {
        return ticketsActivos;
    }
}
