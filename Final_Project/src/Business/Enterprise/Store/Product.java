/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.Store;

import Business.Enterprise.Item;

/**
 *
 * @author ranranhe
 */
public class Product extends Item{
    private Store store;
//    private String name;
//    private double price;

    public Product(Store store, String name, double price) {
        super(name, price);
        this.store = store;
    }

    public Store getStore() {
        return this.store;
    }

}
