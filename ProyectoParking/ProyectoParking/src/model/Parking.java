package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.data.EnumVehiculo;

/**
 *
 * @author ivans
 */
public class Parking {

    private int id;
    private String nombre;
    private String ubicacion;
    private String telefono;
    private int numPisos;
    private int numPlazasPorPiso;
    private Map<EnumVehiculo, Double> listaTarifa;
    private ArrayList<ArrayList<Plaza>> listaPlazas;
    private Map<String, Ticket> ticketsActivos;  // Lo uso para almacenar los tickets que hay activos

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

    public String asignarPlaza(Vehiculo vehiculo) {
        for (int i = 0; i < listaPlazas.size(); i++) {
            for (Plaza plaza : listaPlazas.get(i)) {
                if (!plaza.isOcupada() && plaza.getTipoVehiculo() == vehiculo.getTipoVehiculo()) {
                    plaza.asignarPlaza(vehiculo);
                    Ticket ticket = new Ticket(LocalDateTime.now(), null, vehiculo, plaza);
                    String ticketId = generarTicketId(ticket);
                    ticketsActivos.put(ticketId, ticket);  // Guardo el ticket en los que estan activos
                    return "TICKET DE ENTRADA: \n" + nombre + "\n" + ubicacion + "\n" + telefono + "\n" + ticketId + "\n" + ticket.getFechaEntradaFormateada();
                }
            }
        }
        return "No hay plazas disponibles para este tipo de vehiculo.";
    }

    private String generarTicketId(Ticket ticket) {
        // Genero el ticket con el formato deseado (PR123_numPiso_numPlaza)
        return "PR" + id + "_" + ticket.getPlaza().getPiso() + "_" + ticket.getPlaza().getNumeroPlaza();
    }

    public String liberarPlaza(Ticket ticket) {
        ticket.getPlaza().liberarPlaza();
        double duracion = ticket.calcularDuracion();
        double tarifa = listaTarifa.get(ticket.getVehiculo().getTipoVehiculo());
        double importe = ticket.calcularImporte(duracion, tarifa);
        ticketsActivos.remove(generarTicketId(ticket));  // Elimino el ticket de los activos
        return "Plaza liberada. El importe a pagar son: " + importe + " euros.";
    }

    public Ticket buscarTicket(String ticketId) {
        return ticketsActivos.get(ticketId);  // Devuelve el ticket o null si no lo encuentra
    }

    public void mostrarPlazas() {
        for (int i = 0; i < listaPlazas.size(); i++) {
            System.out.println("Piso " + (i + 1) + ":");
            for (Plaza plaza : listaPlazas.get(i)) {
                if (plaza.isOcupada()) {
                    System.out.print(" X "); // Plaza ocupada
                } else {
                    System.out.print(" O "); // Plaza libre
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
                    sb.append(" O "); // Plaza libre
                }
                else {
                    sb.append("   "); // Pongo un espacio si esta ocupada
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
                        sb.append(" X "); // Plaza ocupada
                    } else {
                        sb.append(" O "); // Plaza libre
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
