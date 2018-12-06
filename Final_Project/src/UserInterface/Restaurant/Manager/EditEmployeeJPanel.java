/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Restaurant.Manager;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.DeliveryCompany.DeliveryCompany;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Restaurant.Restaurant;
import Business.Enterprise.Store.Store;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.Role.RoleFactory;
import Business.UserAccount.EmployeeAccount;
import UserInterface.DeliveryCompany.Manager.DeliveryCompanyManagerMainJPanel;
import UserInterface.StoreManagerMainJPanel.StoreManagerMainJPanel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ranranhe
 */
public class EditEmployeeJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private EmployeeAccount selectedAccount;
    private EmployeeAccount account;
    private JPanel panel;
    private Enterprise en;
    private Role accessRole;

    private Employee employee;

    /**
     * Creates new form EditEmployeeJPanel
     */
    public EditEmployeeJPanel(EcoSystem system, JPanel panel, Enterprise en,
            EmployeeAccount selectedAccount, EmployeeAccount account, Role accessRole) {
        initComponents();
        this.system = system;
        this.panel = panel;
        this.selectedAccount = selectedAccount;
        this.account = account;
        this.en = en;
        this.accessRole = accessRole;

        this.employee = selectedAccount.getEmployee();
        if (en instanceof Restaurant || en instanceof Store) {
            roleComboBox.addItem(RoleType.Manager);
            if (selectedAccount.getRole().getRoleType().equals(RoleType.Boss)) {
                editButton.setEnabled(false);
                resetButton.setVisible(false);
                fireButton.setVisible(false);
            }
            if (accessRole.getRoleType().equals(RoleType.Manager)) {
                if (selectedAccount.getRole().getRoleType().equals(RoleType.Manager)
                        || selectedAccount.getRole().getRoleType().equals(RoleType.Boss)) {
                    editButton.setEnabled(false);
                    resetButton.setVisible(false);
                    fireButton.setVisible(false);
                }
            }
        }

        if (en instanceof DeliveryCompany) {
            roleComboBox.addItem(RoleType.Manager);
            roleComboBox.addItem(RoleType.DeliveryMan);
            if (selectedAccount.getRole().getRoleType().equals(RoleType.Boss)) {
                editButton.setEnabled(false);
                resetButton.setVisible(false);
                fireButton.setVisible(false);
            }
            if (accessRole.getRoleType().equals(RoleType.Manager)) {
                if (selectedAccount.getRole().getRoleType().equals(RoleType.Manager)
                        || selectedAccount.getRole().getRoleType().equals(RoleType.Boss)) {
                    editButton.setEnabled(false);
                    resetButton.setVisible(false);
                    fireButton.setVisible(false);
                }
            }
        }

        setInfo();
        setFieldsEditable(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
    }
    
    private void refreshPreviousList() {
        if (en instanceof Restaurant) {
            RestaurantManagerMainJPanel p = (RestaurantManagerMainJPanel) panel;
            p.populateEmployeeTable(this.en.getOrganizationDirectory().getOrganizationList());
        }
        if (en instanceof DeliveryCompany) {
            DeliveryCompanyManagerMainJPanel p = (DeliveryCompanyManagerMainJPanel) panel;
            p.populateEmployeeTable(this.en.getOrganizationDirectory().getOrganizationList());
        }
        if(en instanceof Store) {
            StoreManagerMainJPanel p = (StoreManagerMainJPanel) panel;
            p.populateEmployeeTable(this.en.getOrganizationDirectory().getOrganizationList());
        }
    }

    private void setFieldsEditable(boolean b) {
        roleComboBox.setEnabled(b);
        emailTextField.setEnabled(b);
        firstNameTextField.setEnabled(b);
        lastNameTextField.setEnabled(b);
        phoneTextField.setEnabled(b);
    }

    private void setInfo() {
        roleComboBox.setSelectedItem(selectedAccount.getRole().getRoleType());
        emailTextField.setText(employee.getEmail());
        firstNameTextField.setText(employee.getFirstName());
        lastNameTextField.setText(employee.getLastName());
        phoneTextField.setText(employee.getPhone());
        usernameTextField.setText(selectedAccount.getUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        phoneTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lastNameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        roleComboBox = new javax.swing.JComboBox<RoleType>();
        fireButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        usernameTextField.setEnabled(false);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Last Name: ");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Role:");

        cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Username: ");

        saveButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Phone:");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Email:");

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel12.setText("First Name: ");

        resetButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        resetButton.setText("Reset Password");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Employee Details");

        fireButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        fireButton.setForeground(new java.awt.Color(255, 0, 51));
        fireButton.setText("Fire!");
        fireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fireButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(resetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(fireButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(emailTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lastNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(firstNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(roleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton)
                    .addComponent(editButton))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resetButton)
                    .addComponent(fireButton))
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setFieldsEditable(false);
        setInfo();

        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (!emailTextField.getText().equals("") && !firstNameTextField.getText().equals("")
                && !lastNameTextField.getText().equals("") && !phoneTextField.getText().equals("")) {
            this.employee.setEmail(emailTextField.getText());
            this.employee.setFirstName(firstNameTextField.getText());
            this.employee.setLastName(lastNameTextField.getText());
            this.employee.setPhone(phoneTextField.getText());
            RoleType selectedType = (RoleType) roleComboBox.getSelectedItem();
            RoleType originType = this.selectedAccount.getRole().getRoleType();
            if (!selectedType.equals(originType)) {
                this.selectedAccount.setRole(RoleFactory.createRole(selectedType));
                Organization to = en.getOrganizationDirectory().getTypicalOrganization(selectedType.
                        getOrganizationType());
                to.getEmployeeDirectory().getEmployeeList().add(employee);
                to.getUserAccountDirectory().getUserAccountList().add(this.selectedAccount);
                Organization from = en.getOrganizationDirectory().getTypicalOrganization(originType.getOrganizationType());
                from.getUserAccountDirectory().getUserAccountList().remove(this.selectedAccount);
                from.getEmployeeDirectory().getEmployeeList().remove(this.employee);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        setFieldsEditable(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
        DB4OUtil.getInstance().storeSystem(system);

        refreshPreviousList();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        ResetPasswordJFrame f = new ResetPasswordJFrame(this.system, this.selectedAccount);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }//GEN-LAST:event_resetButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        saveButton.setEnabled(true);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);
        roleComboBox.setEnabled(true);

        setFieldsEditable(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void fireButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fireButtonActionPerformed
        int choice = JOptionPane.showConfirmDialog(null, "Are you sure to remove this employee from the system?");
        if (choice == 0) {
            this.en.removeEmployee(selectedAccount.getEmployee());
            this.en.removeEmployeeAccount(selectedAccount);
            DB4OUtil.getInstance().storeSystem(system);
        }

        refreshPreviousList();
    }//GEN-LAST:event_fireButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JButton fireButton;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton resetButton;
    private javax.swing.JComboBox<RoleType> roleComboBox;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
