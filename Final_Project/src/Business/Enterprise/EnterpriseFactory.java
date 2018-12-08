/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Enterprise.DeliveryCompany.DeliveryCompany;
import Business.Enterprise.Restaurant.Restaurant;
import Business.Enterprise.Store.Store;

/**
 *
 * @author ranranhe
 */
public class EnterpriseFactory {

    public static Enterprise createEnterprise(String name, String address, String phone, String description, String type) {
        if (type.equalsIgnoreCase("Restaurant")) {
            Restaurant r = new Restaurant(name, address, phone);
            r.setDescription(description);
            r.createOrganizations();
            return r;
        }
        if (type.equalsIgnoreCase("Store")) {
            Store s = new Store(name, address, phone);
            s.setDescription(description);
            s.createOrganizations();
            return s;
        }
        if (type.equalsIgnoreCase("Delivery Company")) {
            DeliveryCompany d = new DeliveryCompany(name, address, phone);
            d.setDescription(description);
            d.createOrganizations();
            return d;
        }
        return null;
    }
    
}
