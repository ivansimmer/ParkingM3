/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.gui;

import control.DataClass;
import static control.DataClass.JFH;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import model.Parking;
import model.Ticket;
import model.data.exceptions.TicketNotFoundException;

/**
 *
 * @author ivansimmer
 */
public class JFrameLiberarPlaza extends javax.swing.JFrame {

    /**
     * Creates new form JFrameHome
     */
    public JFrameLiberarPlaza() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buttonBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTicket = new javax.swing.JTextField();
        jButtonLibera = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MostrarPlazasLibres");
        setBackground(new java.awt.Color(0, 58, 255));

        jPanel1.setBackground(new java.awt.Color(0, 58, 255));

        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/atras (1).png"))); // NOI18N
        buttonBack.setToolTipText("");
        buttonBack.setBorderPainted(false);
        buttonBack.setContentAreaFilled(false);
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LIBERA UNA PLAZA");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Introduce tu codigo de ticket:");

        jTextFieldTicket.setBackground(new java.awt.Color(0, 204, 204));
        jTextFieldTicket.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextFieldTicket.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTicket.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jTextFieldTicket.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTicketActionPerformed(evt);
            }
        });

        jButtonLibera.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonLibera.setText("LIBERA");
        jButtonLibera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLiberaActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/praki.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(buttonBack)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1)
                        .addGap(134, 134, 134))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addComponent(jButtonLibera)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                                .addComponent(jLabel4)))))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonBack)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel1)))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLibera)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        // TODO add your handling code here:
//        DataClass.JFPL.setVisible(false);
//        DataClass.JFH.setVisible(true);
        DataClass.goToAnotherFrame(this, DataClass.JFH);
    }//GEN-LAST:event_buttonBackActionPerformed

    private void jTextFieldTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTicketActionPerformed

    private void jButtonLiberaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLiberaActionPerformed
        // TODO add your handling code here:

        if (DataClass.getParking() != null) {
            Parking parking = DataClass.getParking();

            if (parking != null) {
                String ticketId = jTextFieldTicket.getText();

                if (ticketId.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Debes introducir el codigo del ticket", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        // Buscar el ticket usando el ID ingresado
                        Ticket ticketObj = parking.buscarTicket(ticketId);

                        // Liberar la plaza correspondiente al ticket encontrado
                        String resultado = parking.liberarPlaza(ticketObj);

                        // Mostrar el mensaje con el resultado
                        JOptionPane.showMessageDialog(this, resultado, "Plaza Liberada", JOptionPane.INFORMATION_MESSAGE);
                        
                        JFH.actualizarGrid(DataClass.getParking());

                        // Volver a la pantalla principal después de liberar la plaza
                        DataClass.goToAnotherFrame(this, DataClass.JFH);
                    } catch (TicketNotFoundException e) {
                        // Manejar el caso cuando el ticket no se encuentra
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                // Si no hay un parking inicializado
                JOptionPane.showMessageDialog(this, "No hay un parking asignado. Por favor, inicializa el parking.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonLiberaActionPerformed

    /**
         * @param args the command line arguments
         */
        //    public static void main(String args[]) {
        //        /* Set the Nimbus look and feel */
        //        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        //        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        //         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        //         */
        //        try {
        //            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        //                if ("Nimbus".equals(info.getName())) {
        //                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
        //                    break;
        //                }
        //            }
        //        } catch (ClassNotFoundException ex) {
        //            java.util.logging.Logger.getLogger(JFramePlazasLibres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //        } catch (InstantiationException ex) {
        //            java.util.logging.Logger.getLogger(JFramePlazasLibres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //        } catch (IllegalAccessException ex) {
        //            java.util.logging.Logger.getLogger(JFramePlazasLibres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        //            java.util.logging.Logger.getLogger(JFramePlazasLibres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        //        }
        //        //</editor-fold>
        //        //</editor-fold>
        //
        //        /* Create and display the form */
        //        java.awt.EventQueue.invokeLater(new Runnable() {
        //            public void run() {
        //                new JFramePlazasLibres().setVisible(true);
        //            }
        //        });
        //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JButton jButtonLibera;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldTicket;
    // End of variables declaration//GEN-END:variables
}
