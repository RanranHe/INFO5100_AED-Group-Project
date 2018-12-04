/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Enterprise.Restaurant.Restaurant;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class ShoppingCart {

    private ArrayList<ItemOrder> itemList;
    private double totalPrice;

    public ShoppingCart() {
        this.itemList = new ArrayList<>();
        BigDecimal bd = new BigDecimal(getTotalPrice());
        this.totalPrice = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    public ArrayList<ItemOrder> getItemList() {
        return this.itemList;
    }

    public double getTotalPrice() {
        totalPrice = 0;
        for (ItemOrder d : itemList) {
            totalPrice = totalPrice + d.getTotalPrice();
        }
        return totalPrice;
    }
    
    public void addToCart(ItemOrder order) {
        this.itemList.add(order);
    }
    
    public boolean isCartEmpty() {
        return itemList.isEmpty();
    }
    
    public void clearCart(){
        this.itemList = new ArrayList<>();
    }
}
