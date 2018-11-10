/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_4.entities;

/**
 *
 * @author harshalneelkamal
 */
public class Item {
    private int itemId;
    private int productId;
    private int salesPrice;
    private int quantity;

    public Item(int itemId, int productId, int salesPrice, int quantity) {
        this.itemId = itemId;
        this.productId = productId;
        this.salesPrice = salesPrice;
        this.quantity = quantity;
    }

    public int getItemId() {
        return this.itemId;
    }
    
    public void setItemId(int id) {
        this.itemId = id;
    }
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        this.salesPrice = salesPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
