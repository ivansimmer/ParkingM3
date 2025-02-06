package model;

import model.data.enums.EnumColor;
import model.data.enums.EnumVehiculo;

/**
 *
 * @author ivans
 */
public class Vehiculo {
    
    private EnumVehiculo tipoVehiculo;
    private String matricula;
    private EnumColor color;

    public Vehiculo(EnumVehiculo tipoVehiculo, String matricula, EnumColor color) {
        this.tipoVehiculo = tipoVehiculo;
        this.matricula = matricula;
        this.color = color;
    }

    public EnumVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }
}