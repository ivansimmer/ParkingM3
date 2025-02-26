/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import javax.swing.JFrame;
import model.Parking;
import view.gui.JFrameAsignarPlaza;
import view.gui.JFrameHome;
import view.gui.JFrameLiberarPlaza;

/**
 *
 * @author ivansimmer
 */
public class DataClass {
    
    public static JFrameHome JFH;
    public static JFrameLiberarPlaza JFLP = new JFrameLiberarPlaza();
    public static JFrameAsignarPlaza JFAP = new JFrameAsignarPlaza();
    private static Parking parking;
    
    public static void setVisible(){
        JFH.setVisible(true);
        JFLP.setVisible(false);
        JFAP.setVisible(false);
    }
    
    public static void goToAnotherFrame(JFrame JFO, JFrame JFD){
        JFO.setVisible(false);
        JFD.setVisible(true);
    }

    // Método para asignar el parking
    public static void setParking(Parking parking) {
        DataClass.parking = parking;
    }

    // Método para obtener el parking
    public static Parking getParking() {
        return parking;
    }
}
