/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Enterprise.Item;
import Business.Enterprise.ShopModel;
import Business.Enterprise.ShopModel.ShopType;
import java.math.BigDecimal;

/**
 *
 * @author ranranhe
 */
public abstract class ItemOrder {
    private Item item;
    private int quantity;
    private double totalPrice;
    private ShopModel shopmodel;
    
    public ItemOrder(ShopModel shopmodel, Item item, int quantity) {
        this.shopmodel = shopmodel;
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return this.item;
    }

    public void setDash(Item item) {
        this.item = item;
    }

    public ShopModel getShopModel() {
        return this.shopmodel;
    }

    public void setRestaurant(ShopModel shopmodel) {
        this.shopmodel = shopmodel;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int q) {
        this.quantity = q;
        BigDecimal bd = new BigDecimal(item.getPrice() * q);
        this.totalPrice = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public double getTotalPrice() {
        BigDecimal bd = new BigDecimal(item.getPrice() * quantity);
        this.totalPrice = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        return this.totalPrice;
    }

    @Override
    public String toString() {
        return this.item.getName();
    }
}
