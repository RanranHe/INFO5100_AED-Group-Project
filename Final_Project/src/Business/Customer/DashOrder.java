/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Enterprise.Item;
import Business.Enterprise.Restaurant.Dash;
import Business.Enterprise.Restaurant.Restaurant;
import Business.Enterprise.ShopModel;
import java.math.BigDecimal;

/**
 *
 * @author ranranhe
 */
public class DashOrder extends ItemOrder {

    public DashOrder(ShopModel shopmodel, Item item, int quantity) {
        super(shopmodel, item, quantity);
    }

    public Restaurant getRestaurant() {
        return (Restaurant) this.getShopModel();
    }
}
