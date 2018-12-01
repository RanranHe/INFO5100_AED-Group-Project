/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.SystemManager;

import UserInterface.Manager.CreateEmployeeJPanel;
import UserInterface.Manager.EditEmployeeJPanel;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.CustomerAccount;
import Business.UserAccount.EmployeeAccount;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DeliveryRequest;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.WorkRequest.StatusEnum;
import UserInterface.LoginJFrame;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranranhe
 */
public class ManagerMainJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private JPanel container;
    private Network net;
    private Enterprise en;
    private EmployeeAccount account;
    private JFrame frame;

    private Employee employee;
    private boolean createMode = false;
    private WorkRequest selected;

    /**
     * Creates new form ManagerMainJPanel
     */
    public ManagerMainJPanel(EcoSystem system, JPanel container, Network net, Enterprise en, UserAccount userAccount, JFrame frame) {
        initComponents();
        this.system = system;
        this.container = container;
        this.net = net;
        this.en = en;
        this.account = (EmployeeAccount) userAccount;
        this.frame = frame;
        this.employee = this.account.getEmployee();
        
        // Profile Tab
        setInfo();
        editButton.setEnabled(true);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        setProfileFieldsEditable(false);

        
        setAllTableInfo();

        // Manage Order Tab
        orderStatusTextField.setEnabled(false);
        orderCancelOrderButton.setEnabled(false);
        orderTrackDeliveryButton.setEnabled(false);
        viewCusButton.setEnabled(false);
        viewDelButton.setEnabled(false);
        viewOrderButton.setEnabled(false);
        viewResButton.setEnabled(false);
    }
    
    public void setAllTableInfo() {
        // Manage Employee Tab
        populateEmployeeTable(en.getOrganizationDirectory().getOrganizationList());
        populateOrderTable(en);
    }

    private void setInfo() {
        roleTextField.setText(this.account.getRole().getRoleType().getValue());
        nameLabel.setText(employee.getFirstName());
        emailTextField.setText(employee.getEmail());
        firstNameTextField.setText(employee.getFirstName());
        lastNameTextField.setText(employee.getLastName());
        phoneTextField.setText(employee.getPhone());
        usernameTextField.setText(account.getUsername());
    }

    private void setProfileFieldsEditable(boolean b) {
        emailTextField.setEnabled(b);
        firstNameTextField.setEnabled(b);
        lastNameTextField.setEnabled(b);
        phoneTextField.setEnabled(b);
    }

    public void populateEmployeeTable(ArrayList<Organization> list) {
        ArrayList<EmployeeAccount> result = new ArrayList<>();
        for (Organization org : list) {
            result.addAll(org.getUserAccountDirectory().toEmployeeAccounts());
        }
        DefaultTableModel dtm = (DefaultTableModel) employeeTable.getModel();
        dtm.setRowCount(0);
        for (EmployeeAccount e : result) {
            Object row[] = new Object[4];
            row[0] = e;
            row[1] = e.getRole();
            row[2] = e.getEmployee().getFullName();
            row[3] = e.getEmployee().getEmail();
            dtm.addRow(row);
        }
    }

    public void populateOrderTable(Enterprise enter) {
        ArrayList<WorkRequest> list = enter.getWorkQueue().getWorkRequestList();
        ArrayList<OrderRequest> result1 = new ArrayList<>();
        ArrayList<DeliveryRequest> result2 = new ArrayList<>();
        for (WorkRequest wr : list) {
            if (wr instanceof OrderRequest) {
                OrderRequest dr = (OrderRequest) wr;
                if (dr.getStatus().equals(StatusEnum.Processing) || dr.getStatus().equals(StatusEnum.Cancelled)) {
                    result1.add(dr);
                }
            }
            if (wr instanceof DeliveryRequest) {
                DeliveryRequest dr = (DeliveryRequest) wr;
                result2.add(dr);
            }
        }
        DefaultTableModel dtm = (DefaultTableModel) deliveryTable.getModel();
        dtm.setRowCount(0);
        for (OrderRequest dr : result1) {
            Object row[] = new Object[6];
            row[0] = dr.getId();
            row[1] = dr;
            row[2] = (CustomerAccount) dr.getSender();
            row[3] = (RestaurantAccount) dr.getReceiver();
            row[4] = null;
            row[5] = dr.getStatus();
            dtm.addRow(row);
        }
        for (DeliveryRequest dr : result2) {
            Object row[] = new Object[6];
            row[0] = dr.getOrderId();
            row[1] = dr;
            row[2] = (CustomerAccount) dr.getCustomerAccount();
            row[3] = (RestaurantAccount) dr.getSender();
            row[4] = (EmployeeAccount) dr.getReceiver();
            row[5] = dr.getStatus();
            dtm.addRow(row);
        }
    }

    private void resetPasswordField() {
        passwordField.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        firstNameTextField = new javax.swing.JTextField();
        editButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        roleTextField = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        workPanel = new javax.swing.JPanel();
        createButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        deliveryTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        orderCancelOrderButton = new javax.swing.JButton();
        orderTrackDeliveryButton = new javax.swing.JButton();
        orderStatusTextField = new javax.swing.JTextField();
        orderDetailPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        viewOrderButton = new javax.swing.JButton();
        orderNumTextField = new javax.swing.JTextField();
        orderDateTextField = new javax.swing.JTextField();
        orderTotalTextField = new javax.swing.JTextField();
        orderResTextField = new javax.swing.JTextField();
        orderCusTextField = new javax.swing.JTextField();
        viewResButton = new javax.swing.JButton();
        viewCusButton = new javax.swing.JButton();
        orderDelTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        viewDelButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        restaurantTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();
        cancelButton1 = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();

        nameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        nameLabel.setText("<Name>");

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel5.setText("Welcome, ");

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel9.setText("Last Name: ");

        usernameTextField.setEnabled(false);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel12.setText("First Name: ");

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Email:");

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Phone:");

        saveButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel8.setText("Username: ");

        cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("Role:");

        roleTextField.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(299, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(phoneTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                    .addComponent(lastNameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roleTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameTextField, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(354, 354, 354))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(285, 285, 285))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(roleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profile", jPanel2);

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Role", "Name", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeeTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(employeeTable);

        workPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        workPanel.setLayout(new java.awt.CardLayout());

        createButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        createButton1.setText("Create Employee");
        createButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(workPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(createButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(workPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Employee", jPanel4);

        deliveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order #", "Date", "Customer", "Restaurant", "Delivery Man", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        deliveryTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        deliveryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deliveryTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(deliveryTable);

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        orderCancelOrderButton.setText("Cancel Order");
        orderCancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderCancelOrderButtonActionPerformed(evt);
            }
        });

        orderTrackDeliveryButton.setText("Track Delivery");

        orderStatusTextField.setEditable(false);
        orderStatusTextField.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        orderStatusTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderCancelOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderTrackDeliveryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(orderStatusTextField)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(orderStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(orderCancelOrderButton)
                .addGap(18, 18, 18)
                .addComponent(orderTrackDeliveryButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        orderDetailPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel17.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel17.setText("Order #:");

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel18.setText("Order Date:");

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel20.setText("Customer:");

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel21.setText("Restaurant:");

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel22.setText("Total:");

        viewOrderButton.setText("View Order Details");
        viewOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderButtonActionPerformed(evt);
            }
        });

        orderNumTextField.setEnabled(false);
        orderNumTextField.setEditable(false);

        orderDateTextField.setEnabled(false);
        orderDateTextField.setEditable(false);

        orderTotalTextField.setEnabled(false);

        orderResTextField.setEnabled(false);
        orderResTextField.setEditable(false);

        orderCusTextField.setEnabled(false);
        orderCusTextField.setEditable(false);

        viewResButton.setText("View Restaurant Details");
        viewResButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResButtonActionPerformed(evt);
            }
        });

        viewCusButton.setText("View Customer Details");
        viewCusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCusButtonActionPerformed(evt);
            }
        });

        orderDelTextField.setEnabled(false);
        orderDelTextField.setEditable(false);

        jLabel23.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel23.setText("Delivery Man:");

        viewDelButton.setText("View Delivery Man Details");
        viewDelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout orderDetailPanel1Layout = new javax.swing.GroupLayout(orderDetailPanel1);
        orderDetailPanel1.setLayout(orderDetailPanel1Layout);
        orderDetailPanel1Layout.setHorizontalGroup(
            orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, orderDetailPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(orderDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(viewResButton, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, orderDetailPanel1Layout.createSequentialGroup()
                            .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabel17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(orderNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(orderTotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(viewOrderButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                                    .addGap(48, 48, 48)
                                    .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                                            .addGap(17, 17, 17)
                                            .addComponent(jLabel21)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(orderResTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                                            .addGap(23, 23, 23)
                                            .addComponent(jLabel20)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(orderCusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel23)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(orderDelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(viewCusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(viewDelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        orderDetailPanel1Layout.setVerticalGroup(
            orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(orderDetailPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderNumTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel21)
                        .addComponent(orderResTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(orderDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewResButton))
                .addGap(11, 11, 11)
                .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(orderTotalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(orderCusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrderButton)
                    .addComponent(viewCusButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(orderDetailPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(orderDelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewDelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel19))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderDetailPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(orderDetailPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Manage Delivery Tasks", jPanel5);

        restaurantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Category", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        restaurantTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restaurantTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(restaurantTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 917, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Restaurant", jPanel3);

        cancelButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton1.setText("Cancel");
        cancelButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButton1ActionPerformed(evt);
            }
        });

        submitButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel15.setText("Confirm Password:");

        jLabel14.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel14.setText("New Password:");

        jLabel13.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel13.setText("Old Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(294, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(passwordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(passwordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton1))
                .addContainerGap(253, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Change Password", jPanel1);

        logoutButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addGap(23, 23, 23)
                .addComponent(logoutButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LoginJFrame lf = new LoginJFrame();
        this.frame.dispose();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        int index = jTabbedPane1.getSelectedIndex();
        if (index != 0 && index != -1) {
            setInfo();
        }
        setProfileFieldsEditable(false);
        resetPasswordField();

        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        char[] passwordCharArray = passwordField2.getPassword();
        String password = String.valueOf(passwordCharArray);
        char[] passwordCharArray1 = passwordField.getPassword();
        String new1 = String.valueOf(passwordCharArray1);
        char[] passwordCharArray2 = passwordField1.getPassword();
        String new2 = String.valueOf(passwordCharArray2);

        if (password.equals(account.getPassword())) {
            if (!new1.equals("")) {
                if (new1.equals(new2)) {
                    account.setPassword(new1);
                    JOptionPane.showMessageDialog(null, "Password updated successfully!");
                    DB4OUtil.getInstance().storeSystem(system);
                    resetPasswordField();
                } else {
                    JOptionPane.showMessageDialog(null, "Passwords don't match!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Password can't be empty!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Password is not correct!");
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        resetPasswordField();
    }//GEN-LAST:event_cancelButton1ActionPerformed

    private void deliveryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deliveryTableMouseClicked
        orderStatusTextField.setEnabled(true);
        orderCancelOrderButton.setEnabled(true);
        orderTrackDeliveryButton.setEnabled(true);
        viewCusButton.setEnabled(true);
        viewDelButton.setEnabled(true);
        viewOrderButton.setEnabled(true);
        viewResButton.setEnabled(true);

        int index = deliveryTable.getSelectedRow();

        if (index >= 0) {
            WorkRequest wr = (WorkRequest) deliveryTable.getValueAt(index, 1);
            if (wr instanceof OrderRequest) {
                OrderRequest or = (OrderRequest) wr;
                selected = or;
                orderStatusTextField.setText(or.getStatus().getValue());
                orderNumTextField.setText(or.getId() + "");
                orderDateTextField.setText(or.getRequestDate());
                orderTotalTextField.setText(or.getAmount() + "");
                RestaurantAccount restaurantAccount = (RestaurantAccount) or.getReceiver();
                CustomerAccount customerAccount = (CustomerAccount) or.getSender();
                orderResTextField.setText(restaurantAccount.getRestaurant().getName());
                orderCusTextField.setText(customerAccount.getCustomer().getFullName());
                orderDelTextField.setText("");
                
                viewDelButton.setEnabled(false);
            }
            if (wr instanceof DeliveryRequest) {
                DeliveryRequest or = (DeliveryRequest) wr;
                selected = or;
                orderStatusTextField.setText(or.getStatus().getValue());
                orderNumTextField.setText(or.getOrderId() + "");
                orderDateTextField.setText(or.getOrder().getRequestDate());
                orderTotalTextField.setText(or.getOrder().getAmount() + "");
                RestaurantAccount restaurantAccount = (RestaurantAccount) or.getSender();
                CustomerAccount customerAccount = or.getCustomerAccount();
                orderResTextField.setText(restaurantAccount.getRestaurant().getName());
                orderCusTextField.setText(customerAccount.getCustomer().getFullName());
                if (or.getReceiver() != null) {
                    EmployeeAccount ea = (EmployeeAccount) or.getReceiver();
                    orderDelTextField.setText(ea.getEmployee().getFullName());
                } else {
                    viewDelButton.setEnabled(false);
                    orderDelTextField.setText("");
                }
            }
        }
    }//GEN-LAST:event_deliveryTableMouseClicked

    private void createButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButton1ActionPerformed
        CreateEmployeeJPanel ep = new CreateEmployeeJPanel(this.system, this, this.workPanel, this.en);
        this.workPanel.add(ep);
        CardLayout layout = (CardLayout) this.workPanel.getLayout();
        layout.next(this.workPanel);
    }//GEN-LAST:event_createButton1ActionPerformed

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        int index = employeeTable.getSelectedRow();

        if (index >= 0) {
            EmployeeAccount selectedAccount = (EmployeeAccount) employeeTable.getValueAt(index, 0);

            EditEmployeeJPanel ep = new EditEmployeeJPanel(this.system, this, this.en, selectedAccount);
            this.workPanel.add(ep);
            CardLayout layout = (CardLayout) this.workPanel.getLayout();
            layout.next(this.workPanel);
        }
    }//GEN-LAST:event_employeeTableMouseClicked

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setProfileFieldsEditable(false);
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
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        setProfileFieldsEditable(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);

        DB4OUtil.getInstance().storeSystem(system);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        saveButton.setEnabled(true);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);

        setProfileFieldsEditable(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void orderCancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderCancelOrderButtonActionPerformed
        if (this.selected instanceof DeliveryRequest) {
            DeliveryRequest s1 = (DeliveryRequest) this.selected;
            s1.setStatus(StatusEnum.Cancelled);
        }
        if (this.selected instanceof OrderRequest) {
            OrderRequest s2 = (OrderRequest) this.selected;
            s2.setStatus(StatusEnum.Cancelled);
        }
        DB4OUtil.getInstance().storeSystem(system);
        populateOrderTable(this.en);
    }//GEN-LAST:event_orderCancelOrderButtonActionPerformed

    private void viewOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderButtonActionPerformed
        DetailsJFrame f = null;
        if (this.selected instanceof DeliveryRequest) {
            DeliveryRequest s1 = (DeliveryRequest) this.selected;
            RestaurantAccount ra = (RestaurantAccount) s1.getSender();
            f = new DetailsJFrame(this.system, null, this.en, this.account, this.frame, s1.getOrder(), ra.getRestaurant(), "order");
        }
        if (this.selected instanceof OrderRequest) {
            OrderRequest s2 = (OrderRequest) this.selected;
            RestaurantAccount ra = (RestaurantAccount) s2.getReceiver();
            f = new DetailsJFrame(this.system, null, this.en, this.account, this.frame, s2, ra.getRestaurant(), "order");
        }
    }//GEN-LAST:event_viewOrderButtonActionPerformed

    private void viewResButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResButtonActionPerformed
        DetailsJFrame f = null;
        if (this.selected instanceof DeliveryRequest) {
            DeliveryRequest s1 = (DeliveryRequest) this.selected;
            RestaurantAccount ra = (RestaurantAccount) s1.getSender();
            f = new DetailsJFrame(this.system, this, this.en, ra, this.frame, s1.getOrder(), ra.getRestaurant(), "restaurant");
        }
        if (this.selected instanceof OrderRequest) {
            OrderRequest s2 = (OrderRequest) this.selected;
            RestaurantAccount ra = (RestaurantAccount) s2.getReceiver();
            f = new DetailsJFrame(this.system, this, this.en, ra, this.frame, s2, ra.getRestaurant(), "restaurant");
        }
    }//GEN-LAST:event_viewResButtonActionPerformed

    private void restaurantTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurantTableMouseClicked
        int index = restaurantTable.getSelectedRow();
        
        if (index >= 0) {
//            RestaurantAccount ra = (RestaurantAccount) restaurantTable.getValueAt(index, 0);
//            RestaurantMainJPanel rp = new RestaurantMainJPanel(this.system, this.container, this.en, ra, this.frame, new ManagerRole());
//            this.container.add(rp);
//            CardLayout layout = (CardLayout) this.container.getLayout();
//            layout.next(this.container);
        }
    }//GEN-LAST:event_restaurantTableMouseClicked

    private void viewCusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCusButtonActionPerformed
        DetailsJFrame f = null;
        if (this.selected instanceof DeliveryRequest) {
            DeliveryRequest s1 = (DeliveryRequest) this.selected;
            RestaurantAccount ra = (RestaurantAccount) s1.getSender();
            CustomerAccount ca = s1.getCustomerAccount();
            f = new DetailsJFrame(this.system, this, this.en, ca, this.frame, s1.getOrder(), ra.getRestaurant(), "Customer");
        }
        if (this.selected instanceof OrderRequest) {
            OrderRequest s2 = (OrderRequest) this.selected;
            RestaurantAccount ra = (RestaurantAccount) s2.getReceiver();
            CustomerAccount ca = (CustomerAccount) s2.getSender();
            f = new DetailsJFrame(this.system, this, this.en, ca, this.frame, s2, ra.getRestaurant(), "Customer");
        }
    }//GEN-LAST:event_viewCusButtonActionPerformed

    private void viewDelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDelButtonActionPerformed
        DetailsJFrame f = null;
        if (this.selected instanceof DeliveryRequest) {
            DeliveryRequest s1 = (DeliveryRequest) this.selected;
            RestaurantAccount ra = (RestaurantAccount) s1.getSender();
            EmployeeAccount ea = (EmployeeAccount) s1.getReceiver();
            f = new DetailsJFrame(this.system, this, this.en, ea, this.frame, s1.getOrder(), ra.getRestaurant(), "DeliveryMan");
        }
    }//GEN-LAST:event_viewDelButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton createButton1;
    private javax.swing.JTable deliveryTable;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTable employeeTable;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton orderCancelOrderButton;
    private javax.swing.JTextField orderCusTextField;
    private javax.swing.JTextField orderDateTextField;
    private javax.swing.JTextField orderDelTextField;
    private javax.swing.JPanel orderDetailPanel1;
    private javax.swing.JTextField orderNumTextField;
    private javax.swing.JTextField orderResTextField;
    private javax.swing.JTextField orderStatusTextField;
    private javax.swing.JTextField orderTotalTextField;
    private javax.swing.JButton orderTrackDeliveryButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JTable restaurantTable;
    private javax.swing.JTextField roleTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField usernameTextField;
    private javax.swing.JButton viewCusButton;
    private javax.swing.JButton viewDelButton;
    private javax.swing.JButton viewOrderButton;
    private javax.swing.JButton viewResButton;
    private javax.swing.JPanel workPanel;
    // End of variables declaration//GEN-END:variables
}
