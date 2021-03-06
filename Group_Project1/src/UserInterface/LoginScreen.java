/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Abstract.User;
import Business.Users.Customer;
import Business.Users.Supplier;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author harshalneelkamal
 */
public class LoginScreen extends javax.swing.JPanel {

    /**
     * Creates new form LoginScreen
     */
    List<User> list;
    JPanel panelRight;
    String role;
    
    public LoginScreen(String role, JPanel panelRight, List<User> list) {
        initComponents();
        this.role = role;
        this.list = list;
        this.panelRight = panelRight;
        initialize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPword = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        comboUser = new javax.swing.JComboBox<Object>();
        txtTitle = new javax.swing.JLabel();

        btnSubmit.setText("Login");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        txtTitle.setText("Supplier Login Screen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(txtTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboUser, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(btnSubmit)))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(txtTitle)
                .addGap(18, 18, 18)
                .addComponent(comboUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnSubmit)
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        if(txtPword.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Enter ur password");
            return;
        }
        User u = (User)comboUser.getSelectedItem();
        
        if(u != null){
            if(u.getRole().equals("Customer")){
                Customer c =(Customer)u;
                if(c.verify(txtPword.getText())){
                    grantAccessTo(u);
                }
                else
                    JOptionPane.showMessageDialog(this, "Please Enter a valid password\nEnsure u have selected correct Customer");
            }
            else{
                Supplier s =(Supplier)u;
                if(s.verify(txtPword.getText()))
                    grantAccessTo(u);
                else
                    JOptionPane.showMessageDialog(this, "Please Enter a valid password\nEnsure u have selected correct Customer");
            }
        }

        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void grantAccessTo(User u){
            SuccessScreen ss = new SuccessScreen(u);
            CardLayout layout = (CardLayout)panelRight.getLayout();
            panelRight.add(ss);
            layout.next(panelRight);
    }
    
   
    private void initialize(){
        //text should either be "Supplier Login Screen" OR "Customer Login Screen"
        //Based on the selection
        
        if(role.equalsIgnoreCase("Customer")){
            txtTitle.setText("Customer Login Screen");
        }
       
        else if(role.equalsIgnoreCase("Supplier")){
           txtTitle.setText("Supplier Login Screen");
        }
        
        comboUser.removeAllItems();
        
        for(User u:list){
            comboUser.addItem(u);
        }
        
        //only customer or suppliers should be listed based on the selection
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<Object> comboUser;
    private javax.swing.JTextField txtPword;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
