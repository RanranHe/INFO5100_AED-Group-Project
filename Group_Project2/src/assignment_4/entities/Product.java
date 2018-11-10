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
public class Product {
    private int productId;
    private int minPrice;
    private int maxPrice;
    private int targetPrice;
    
    public Product(int productId, int minPrice, int maxPrice, int targetPrice) {
        this.productId = productId;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.targetPrice = targetPrice;
    }
    
    public int getProductId() {
        return this.productId;
    }
    
    public void setProductId(int newId) {
        this.productId = newId;
    }
    
    public int getMinPrice() {
        return this.minPrice;
    }
    
    public void setMinPrice(int newPrice) {
        this.minPrice = newPrice;
    }
    
    public int getMaxPrice() {
        return this.maxPrice;
    }
    
    public void setMaxPrice(int newPrice) {
        this.maxPrice = newPrice;
    }
    
    public int getTargetPrice() {
        return this.targetPrice;
    }
   
    public void setTargetPrice(int newPrice) {
        this.targetPrice = newPrice;
    }
}
