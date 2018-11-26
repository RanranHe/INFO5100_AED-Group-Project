/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Restaurant.Restaurant;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class ShoppingCart {

    private ArrayList<DashOrder> itemList;
    private double totalPrice;

    public ShoppingCart() {
        this.itemList = new ArrayList<>();
        BigDecimal bd = new BigDecimal(getTotalPrice());
        this.totalPrice = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    
    public ArrayList<DashOrder> getItemList() {
        return this.itemList;
    }

    public double getTotalPrice() {
        totalPrice = 0;
        for (DashOrder d : itemList) {
            totalPrice = totalPrice + d.getTotalPrice();
        }
        return totalPrice;
    }
    
    public void addToCart(DashOrder order) {
        this.itemList.add(order);
    }
    
    public boolean isCartEmpty() {
        return itemList.isEmpty();
    }
    
    public void clearCart(){
        this.itemList = new ArrayList<>();
    }
}
