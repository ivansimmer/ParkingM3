package model;

import model.data.enums.EnumVehiculo;

/**
 *
 * @author ivans
 */
public class Plaza {
    
    private Long id;
    private int piso;
    private int numeroPlaza;
    private boolean ocupada;
    private Vehiculo vehiculoAsignado;
    private EnumVehiculo tipoVehiculo;

    public Plaza(Long id, int piso, int numeroPlaza, EnumVehiculo tipoVehiculo) {
        this.id = id;
        this.piso = piso;
        this.numeroPlaza = numeroPlaza;
        this.tipoVehiculo = tipoVehiculo;
        this.ocupada = false;
    }

    public void asignarPlaza(Vehiculo vehiculo) {
        this.vehiculoAsignado = vehiculo;
        this.ocupada = true;
    }

    public void liberarPlaza() {
        this.vehiculoAsignado = null;
        this.ocupada = false;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public EnumVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public int getPiso() {
        return piso + 1;
    }

    public int getNumeroPlaza() {
        return numeroPlaza + 1;
    }
    
    public Long getId() {
        return id;
    }

    
    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    @Override
    public String toString() {
        return "Plaza [Piso=" + piso + ", Numero=" + numeroPlaza + ", Ocupada=" + ocupada + ", TipoVehiculo=" + tipoVehiculo + "]";
    }
}
