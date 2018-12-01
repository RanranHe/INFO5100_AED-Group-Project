/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Restaurant;

import Business.Customer.DashOrder;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Restaurant.Dash;
import Business.Restaurant.Restaurant;
import Business.Restaurant.Restaurant.Category;
import Business.Role.ManagerRole;
import Business.Role.Role;
import Business.Role.Role.RoleType;
import Business.UserAccount.RestaurantAccount;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DeliveryRequest;
import Business.WorkQueue.OrderRequest;
import Business.WorkQueue.WorkRequest;
import Business.WorkQueue.WorkRequest.StatusEnum;
import UserInterface.LoginJFrame;
import UserInterface.Manager.ManagerMainJPanel;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranranhe
 */
public class RestaurantMainJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private JPanel container;
    private Enterprise en;
    private RestaurantAccount account;
    private Restaurant restaurant;
    private JFrame frame;
    private Role role;
    private String path;
    private String originPath;
    private OrderRequest selectedOrder = null;

    /**
     * Creates new form RestaurantMainJPanel
     */
    public RestaurantMainJPanel(EcoSystem system, JPanel container, Enterprise en, UserAccount userAccount, JFrame frame, Role role) {
        initComponents();
        this.system = system;
        this.container = container;
        this.en = en;
        this.account = (RestaurantAccount) userAccount;
        this.frame = frame;
        this.role = role;
        this.restaurant = this.account.getRestaurant();
        this.originPath = this.restaurant.getPath();
        this.path = this.restaurant.getPath();

        if (role.getRoleType().equals(RoleType.Manager)) {
            logoutButton.setVisible(false);
            jLabel5.setText("");
        }
        
        List<Category> list = Arrays.asList(Restaurant.Category.values());
        for (Category c : list) {
            categoryComboBox.addItem(c);
        }

        editButton.setEnabled(true);
        saveButton.setEnabled(false);
        uploadButton.setEnabled(false);
        cancelButton.setEnabled(false);
        setFieldsEditable(false);

        setInfo();
        populateMenuTable(restaurant.getMenu());

        populateOrderTable(account.getWorkQueue().getWorkRequestList());

        totalTextField.setEnabled(false);
        commentTextArea.setEnabled(false);
        deliveryButton.setEnabled(false);
        cancelOrderButton.setEnabled(false);
    }

    public void populateMenuTable(ArrayList<Dash> list) {
        DefaultTableModel dtm = (DefaultTableModel) menuTable.getModel();
        dtm.setRowCount(0);
        for (Dash dash : list) {
            Object row[] = new Object[2];
            row[0] = dash;
            row[1] = dash.getPrice();
            dtm.addRow(row);
        }
    }

    private void populateOrderTable(ArrayList<WorkRequest> list) {
        ArrayList<OrderRequest> orderList = new ArrayList<>();
        for (WorkRequest wr : list) {
            if (wr instanceof OrderRequest) {
                OrderRequest order = (OrderRequest) wr;
                orderList.add(order);
            }
        }
        DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
        dtm.setRowCount(0);
        for (OrderRequest or : orderList) {
            Object row[] = new Object[5];
            row[0] = or;
            row[1] = or.getDeliveryName();
            row[2] = or.getDeliveryPhone();
            row[3] = or.getAmount();
            row[4] = or.getStatus();
            dtm.addRow(row);
        }
    }

    private void populateDetailTable(OrderRequest order) {
        DefaultTableModel dtm = (DefaultTableModel) orderDetailTable.getModel();
        dtm.setRowCount(0);
        ArrayList<DashOrder> list = order.getDashes();
        for (DashOrder d : list) {
            Object row[] = new Object[5];
            row[0] = d;
            row[1] = d.getQuantity();
            dtm.addRow(row);
        }
        commentTextArea.setText(order.getMessage());
        totalTextField.setText(order.getAmount() + "");
        if (order.getStatus().equals(StatusEnum.Processing)) {
            deliveryButton.setEnabled(true);
            cancelOrderButton.setEnabled(true);
        } else {
            deliveryButton.setEnabled(false);
            cancelOrderButton.setEnabled(false);
        }
    }

    private void setFieldsEditable(boolean b) {
        nameTextField.setEnabled(b);
        phoneTextField.setEnabled(b);
        addressTextArea.setEnabled(b);
        descriptionTextArea.setEnabled(b);
        categoryComboBox.setEnabled(b);
    }

    private void setInfo() {
        nameLabel.setText(restaurant.getName());
        nameTextField.setText(restaurant.getName());
        phoneTextField.setText(restaurant.getPhone());
        addressTextArea.setText(restaurant.getAddress());
        descriptionTextArea.setText(restaurant.getDescription());
        categoryComboBox.setSelectedItem(restaurant.getCategory());
        ImageIcon image = new ImageIcon(originPath);
        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
    }

    private void resetPasswordField() {
        passwordField.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }
    
    private void managerUpdate() {
        if (this.role.getRoleType().equals(RoleType.Manager)) {
            ManagerMainJPanel p = (ManagerMainJPanel) this.container;
            p.setAllTableInfo();
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        uploadButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        phoneTextField = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        categoryComboBox = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        detailPanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderDetailTable = new javax.swing.JTable();
        totalTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        deliveryButton = new javax.swing.JButton();
        cancelOrderButton = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        passwordField1 = new javax.swing.JPasswordField();
        passwordField2 = new javax.swing.JPasswordField();
        cancelButton1 = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        submitButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Phone:");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Category: ");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Description: ");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Address: ");

        uploadButton.setText("Upload Photo");
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        saveButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        phoneTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        addressTextArea.setColumns(20);
        jScrollPane4.setViewportView(addressTextArea);

        descriptionTextArea.setColumns(20);
        jScrollPane5.setViewportView(descriptionTextArea);

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel7.setText("Name:");

        nameTextField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(uploadButton)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uploadButton))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Overview", jPanel2);

        menuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dash", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        menuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menuTable);

        detailPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(detailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(detailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Menu", jPanel3);

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Order Date", "Name", "Phone", "Amount", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(orderTable);

        orderDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Dash", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(orderDetailTable);

        totalTextField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        totalTextField.setText("0.00");
        totalTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel6.setText("Total: ");

        deliveryButton.setText("Confirm Order");
        deliveryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryButtonActionPerformed(evt);
            }
        });

        cancelOrderButton.setText("Cancel Order");
        cancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelOrderButtonActionPerformed(evt);
            }
        });

        commentTextArea.setColumns(20);
        jScrollPane6.setViewportView(commentTextArea);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(deliveryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cancelOrderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cancelOrderButton)
                                .addComponent(deliveryButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(totalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Orders", jPanel4);

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
                .addContainerGap(225, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Change Password", jPanel1);

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        jLabel5.setText("Welcome, ");

        nameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 16)); // NOI18N
        nameLabel.setText("<Name>");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        LoginJFrame lf = new LoginJFrame();
        this.frame.dispose();
        lf.setLocationRelativeTo(null);
        lf.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setFieldsEditable(false);
        setInfo();

        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
        uploadButton.setEnabled(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        saveButton.setEnabled(true);
        cancelButton.setEnabled(true);
        editButton.setEnabled(false);
        uploadButton.setEnabled(true);

        setFieldsEditable(true);
    }//GEN-LAST:event_editButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (!phoneTextField.getText().equals("") && !addressTextArea.getText().equals("")
                && !descriptionTextArea.getText().equals("") && !nameTextField.getText().equals("")) {
            restaurant.setName(nameTextField.getText());
            restaurant.setAddress(addressTextArea.getText());
            restaurant.setDescription(descriptionTextArea.getText());
            restaurant.setCategory((Category) categoryComboBox.getSelectedItem());
            restaurant.setPhone(phoneTextField.getText());
            if (!path.equalsIgnoreCase(originPath)) {
                restaurant.setPath(path);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Information can't be empty");
            return;
        }
        setFieldsEditable(false);
        setInfo();
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
        uploadButton.setEnabled(false);

        DB4OUtil.getInstance().storeSystem(system);
        
        managerUpdate();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = chooser.showOpenDialog(null);
        if (i == chooser.APPROVE_OPTION) {
            path = chooser.getSelectedFile().getAbsolutePath();
            restaurant.setPath(path);
        } else {
            JOptionPane.showMessageDialog(null, "No file was selected");
        }
        ImageIcon image = new ImageIcon(path);
        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
    }//GEN-LAST:event_uploadButtonActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        int index = jTabbedPane1.getSelectedIndex();
        if (index != 0 && index != -1) {
            setInfo();
        }
        setFieldsEditable(false);
        resetPasswordField();

        uploadButton.setEnabled(false);
        saveButton.setEnabled(false);
        cancelButton.setEnabled(false);
        editButton.setEnabled(true);
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void cancelButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButton1ActionPerformed
        resetPasswordField();
    }//GEN-LAST:event_cancelButton1ActionPerformed

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
                    managerUpdate();
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

    private void menuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTableMouseClicked
        int index = menuTable.getSelectedRow();

        if (index >= 0) {
            Dash dash = (Dash) menuTable.getValueAt(index, 0);
            DashEditJPanel panel = new DashEditJPanel(this.system, this, this.detailPanel, this.restaurant, dash);
            this.detailPanel.add(panel);
            CardLayout layout = (CardLayout) this.detailPanel.getLayout();
            layout.next(this.detailPanel);
        }
    }//GEN-LAST:event_menuTableMouseClicked

    private void totalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalTextFieldActionPerformed

    }//GEN-LAST:event_totalTextFieldActionPerformed

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        int index = orderTable.getSelectedRow();

        if (index >= 0) {
            selectedOrder = (OrderRequest) orderTable.getValueAt(index, 0);
            populateDetailTable(selectedOrder);
        }
    }//GEN-LAST:event_orderTableMouseClicked

    private void cancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelOrderButtonActionPerformed
        selectedOrder.setStatus(StatusEnum.Cancelled);
        DB4OUtil.getInstance().storeSystem(system);
        managerUpdate();
        populateOrderTable(this.account.getWorkQueue().getWorkRequestList());
        populateDetailTable(selectedOrder);
    }//GEN-LAST:event_cancelOrderButtonActionPerformed

    private void deliveryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryButtonActionPerformed
        selectedOrder.setStatus(StatusEnum.FoodsReady);
        DeliveryRequest dr = new DeliveryRequest(this.account, null, selectedOrder);
        dr.setStatus(StatusEnum.FoodsReady);
        this.account.getWorkQueue().getWorkRequestList().add(dr);
        this.en.getWorkQueue().getWorkRequestList().add(dr);
        DB4OUtil.getInstance().storeSystem(system);
        managerUpdate();
        populateOrderTable(this.account.getWorkQueue().getWorkRequestList());
        populateDetailTable(selectedOrder);
    }//GEN-LAST:event_deliveryButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton cancelButton1;
    private javax.swing.JButton cancelOrderButton;
    private javax.swing.JComboBox categoryComboBox;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JButton deliveryButton;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JPanel detailPanel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTable menuTable;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTable orderDetailTable;
    private javax.swing.JTable orderTable;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPasswordField passwordField1;
    private javax.swing.JPasswordField passwordField2;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextField totalTextField;
    private javax.swing.JButton uploadButton;
    // End of variables declaration//GEN-END:variables
}
