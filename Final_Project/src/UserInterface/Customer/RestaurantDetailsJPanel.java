/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Customer;

import Business.Customer.DashOrder;
import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Restaurant.Dash;
import Business.Restaurant.Restaurant;
import Business.UserAccount.CustomerAccount;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ranranhe
 */
public class RestaurantDetailsJPanel extends javax.swing.JPanel {

    private EcoSystem system;
    private Restaurant restaurant;
    private CustomerAccount account;
    private Enterprise en;

    /**
     * Creates new form RestaurantDetailsJPanel
     */
    public RestaurantDetailsJPanel(EcoSystem system, Restaurant restaurant, CustomerAccount account, Enterprise en) {
        initComponents();
        this.system = system;
        this.restaurant = restaurant;
        this.account = account;
        this.en = en;

        showImage();
        populateTable(restaurant.getMenu());

        addressTextArea.setText(restaurant.getAddress());
        addressTextArea.setEnabled(false);
        categoryLabel.setText(restaurant.getCategory().name());
        descriptionTextArea.setText(restaurant.getDescription());
        descriptionTextArea.setEnabled(false);
        phoneLabel.setText(restaurant.getPhone());
    }

    private void populateTable(ArrayList<Dash> list) {
        DefaultTableModel dtm = (DefaultTableModel) menuTable.getModel();
        dtm.setRowCount(0);
        for (Dash dash : list) {
            Object row[] = new Object[2];
            row[0] = dash;
            row[1] = dash.getPrice();
            dtm.addRow(row);
        }
    }

    private void showImage() {
        String path = "Images/Restaurant/default.png";
        String fileName = "default.PNG";
        try {
            File f = new File("Images/Restaurant");
            if (f.isDirectory()) {
                File[] F1 = f.listFiles();
                for (File f2 : F1) {
                    if (f2.getName().equalsIgnoreCase(restaurant.getId() + ".png")) {
                        fileName = restaurant.getId() + ".png";
                        path = "Images/Restaurant/" + fileName;
                    }
                }
            }
            BufferedImage image = ImageIO.read(new File(path));

            int radio = 0;
            if (image.getWidth() / 250 < image.getHeight() / 180) {
                radio = image.getWidth() / 250;
            } else {
                radio = image.getHeight() / 180;
            }
            int x = 11, y = 20, cutW = 250 * radio, cutH = 180 * radio;

            Rectangle rect = new Rectangle(x, y, cutW, cutH);
            BufferedImage areaImage = image.getSubimage(rect.x, rect.y, rect.width, rect.height);

            BufferedImage buffImg = new BufferedImage(cutW, cutH, BufferedImage.TYPE_INT_RGB);
            buffImg.getGraphics().drawImage(areaImage.getScaledInstance(cutW, cutH, java.awt.Image.SCALE_SMOOTH), 0, 0, null);

            String newPath = "Images/RestaurantCut/" + fileName;
            ImageIO.write(buffImg, "png", new File(newPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon image = new ImageIcon("Images/RestaurantCut/" + fileName);

        image.setImage(image.getImage().getScaledInstance(250, 180, Image.SCALE_DEFAULT));
        imageLabel.setIcon(image);
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        addressTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuTable = new javax.swing.JTable();
        addButton = new javax.swing.JButton();
        quantitySpinner = new javax.swing.JSpinner();

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Phone:");

        phoneLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        phoneLabel.setText("<Phone>");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("Category: ");

        categoryLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        categoryLabel.setText("N/A");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("Description: ");

        addressTextArea.setBackground(new java.awt.Color(238, 238, 238));
        addressTextArea.setColumns(20);
        addressTextArea.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        addressTextArea.setLineWrap(true);
        addressTextArea.setBorder(null);
        addressTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(addressTextArea);

        descriptionTextArea.setBackground(new java.awt.Color(238, 238, 238));
        descriptionTextArea.setColumns(20);
        descriptionTextArea.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        descriptionTextArea.setForeground(new java.awt.Color(238, 238, 238));
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setBorder(null);
        descriptionTextArea.setCaretColor(new java.awt.Color(238, 238, 238));
        descriptionTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        descriptionTextArea.setDragEnabled(false);
        jScrollPane3.setViewportView(descriptionTextArea);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel1.setText("Address: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(categoryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel2)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryLabel))
                    .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Details", jPanel1);

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
        ));
        jScrollPane1.setViewportView(menuTable);

        addButton.setText("Add to Cart");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        quantitySpinner.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(quantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addButton)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Menu", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        int selectedRow = menuTable.getSelectedRow();

        if (selectedRow >= 0) {
            Dash dash = (Dash) menuTable.getValueAt(selectedRow, 0);
            int quantity = (int) quantitySpinner.getValue();
            DashOrder order = new DashOrder(this.restaurant, dash, quantity);

            if (!this.account.getCart().isCartEmpty()) {
                for (DashOrder or : this.account.getCart().getItemList()) {
                    if (!or.getRestaurant().equals(this.restaurant)) {
                        int choice = JOptionPane.showConfirmDialog(null, "You alreay have dashes from other restaurant in shopping cart. \n"
                                + "Adding this dash will remove all previous dashes in shopping cart.\n"+ "Do you want to continue?",
                                "Restaurant Conflicts", JOptionPane.YES_NO_OPTION);
                        if (choice == JOptionPane.YES_OPTION) {
                            this.account.getCart().clearCart();
                            break;
                        } else {
                            return;
                        }
                    }
                    if (or.getRestaurant().equals(this.restaurant) && or.getDash().equals(dash)) {
                        order.setQuantity(or.getQuantity() + quantity);
                        this.account.getCart().getItemList().remove(or);
                        break;
                    }
                }
            }
            this.account.getCart().addToCart(order);

            JOptionPane.showMessageDialog(null, "Dash has been successfully added to Shopping Cart");
            DB4OUtil.getInstance().storeSystem(system);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a dash.");
        }
    }//GEN-LAST:event_addButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextArea addressTextArea;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable menuTable;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JSpinner quantitySpinner;
    // End of variables declaration//GEN-END:variables
}
