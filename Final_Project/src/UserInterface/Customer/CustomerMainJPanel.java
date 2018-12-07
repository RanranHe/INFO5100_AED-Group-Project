/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.EcoSystem;
import Business.Enterprise.ShopModel.ShopType;
import Business.Network.Network;
import Business.Role.CustomerRole;
import Business.UserAccount.CustomerAccount;
import Business.UserAccount.UserAccount;
import UserInterface.LoginJFrame;
import java.awt.CardLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author ranranhe
 */
public class CustomerMainJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private CustomerAccount customerAccount;
    private JPanel container;
    private JFrame frame;

    /**
     * Creates new form CustomerMainJPanel
     * @param system
     * @param container
     * @param userAccount
     * @param frame
     */
    public CustomerMainJPanel(EcoSystem system, JPanel container, UserAccount userAccount, JFrame frame) {
        initComponents();
        this.system = system;
        this.container = container;
        this.frame = frame;
        this.customerAccount = (CustomerAccount) userAccount;

        DefaultListCellRenderer renderer = (DefaultListCellRenderer) cityList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultListModel<String> model = new DefaultListModel<>();
        for (Network net : system.getNetworkList()) {
            model.addElement(net.getCity());
        }
        cityList.setModel(model);
        nameLabel.setText(customerAccount.getCustomer().getFirstName());
        goButton.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cityList = new javax.swing.JList<String>();
        jLabel5 = new javax.swing.JLabel();
        goButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        typeList = new javax.swing.JList<ShopType>();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        jLabel1.setText("Welcome, ");

        nameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        nameLabel.setText("<Name>");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel3.setText("Please select your location: ");

        cityList.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cityList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                cityListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(cityList);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 16)); // NOI18N
        jLabel5.setText("City");

        goButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        goButton.setText("GO!!");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        profileButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        profileButton.setText("My Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        typeList.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        typeList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                typeListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(typeList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(554, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(goButton)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(profileButton)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameLabel)
                    .addComponent(logoutButton)
                    .addComponent(profileButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel3)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(115, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(goButton)
                        .addGap(250, 250, 250))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        if (cityList.getSelectedValue() != null) {
            Network net = system.getNetworkByCity((String) cityList.getSelectedValue());
            String city = (String) cityList.getSelectedValue();
            ShopType type = (ShopType) typeList.getSelectedValue();
            
            ShopListJPanel panel = new ShopListJPanel(system, net, this.container, this.customerAccount, type, this.frame);
            container.add(panel);
            CardLayout layout = (CardLayout) this.container.getLayout();
            layout.next(container);
        }
    }//GEN-LAST:event_goButtonActionPerformed

    private void cityListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_cityListValueChanged
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) typeList.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultListModel<ShopType> model = new DefaultListModel<>();
        for (ShopType type : ShopType.values()) {
            model.addElement(type);
        }
        typeList.setModel(model);
        goButton.setEnabled(false);
    }//GEN-LAST:event_cityListValueChanged

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        CustomerProfileJPanel panel = new CustomerProfileJPanel(this.system, this.container, this.customerAccount, this.frame, new CustomerRole());
        this.container.add(panel);
        CardLayout layout = (CardLayout) this.container.getLayout();
        layout.next(this.container);
    }//GEN-LAST:event_profileButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LoginJFrame lf = new LoginJFrame();
        this.frame.dispose();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void typeListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_typeListValueChanged
        goButton.setEnabled(true);
    }//GEN-LAST:event_typeListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> cityList;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton profileButton;
    private javax.swing.JList<ShopType> typeList;
    // End of variables declaration//GEN-END:variables
}
