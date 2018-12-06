/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Enterprise.Item;
import Business.Enterprise.ShopModel;
import Business.Enterprise.Store.Store;

/**
 *
 * @author wuyunyi
 */
public class ProductOrder extends ItemOrder {

    private Store store;

    public ProductOrder(ShopModel shopmodel, Item item, int quantity) {
        super(shopmodel, item, quantity);
        this.store = (Store) shopmodel;
    }

    public Store getStore() {
        return this.store;
    }

    @Override
    public ShopModel getShopModel() {
        return this.store;
    }

}
