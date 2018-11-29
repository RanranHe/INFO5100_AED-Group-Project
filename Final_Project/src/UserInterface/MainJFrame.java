/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import UserInterface.Customer.CustomerMainJPanel;
import UserInterface.DeliveryMan.DeliveryManInfoJPanel;
import UserInterface.DeliveryMan.DeliveryManMainJPanel;
import UserInterface.Manager.ManagerInfoJPanel;
import UserInterface.Restaurant.RestaurantMainJPanel;
import UserInterface.SystemManager.SystemManagerInfoJPanel;
import java.awt.CardLayout;

/**
 *
 * @author ranranhe
 */
public class MainJFrame extends javax.swing.JFrame {
 
    /**
     * Creates new form MainJFrame
     */
    public MainJFrame(EcoSystem system, UserAccount userAccount, Network net, Enterprise en) {
        initComponents();
        if (userAccount.getRole().getRoleType().getValue().equalsIgnoreCase("Customer")) {
            this.setSize(950, 600);
            CustomerMainJPanel cp = new CustomerMainJPanel(system, this.container, userAccount, this);
            container.add(cp);
            CardLayout layout = (CardLayout)this.container.getLayout();
            layout.next(container);
        }
        if (userAccount.getRole().getRoleType().getValue().equalsIgnoreCase("Manager")) {
            ManagerInfoJPanel cp = new ManagerInfoJPanel(system, userAccount);
            container.add(cp);
            CardLayout layout = (CardLayout)this.container.getLayout();
            layout.next(container);
        }
        if (userAccount.getRole().getRoleType().getValue().equalsIgnoreCase("Delivery Man")) {
            this.setSize(950, 600);
            DeliveryManMainJPanel cp = new DeliveryManMainJPanel(system, this.container, en, userAccount, this);
            container.add(cp);
            CardLayout layout = (CardLayout)this.container.getLayout();
            layout.next(container);
        }
        if (userAccount.getRole().getRoleType().getValue().equalsIgnoreCase("System Manager")) {
            SystemManagerInfoJPanel cp = new SystemManagerInfoJPanel(system, userAccount);
            container.add(cp);
            CardLayout layout = (CardLayout)this.container.getLayout();
            layout.next(container);
        }
        if (userAccount.getRole().getRoleType().getValue().equalsIgnoreCase("Restaurant")) {
            this.setSize(950, 600);
            RestaurantMainJPanel cp = new RestaurantMainJPanel(system, container, en, userAccount, this);
            container.add(cp);
            CardLayout layout = (CardLayout)this.container.getLayout();
            layout.next(container);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MainJFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    // End of variables declaration//GEN-END:variables
}
