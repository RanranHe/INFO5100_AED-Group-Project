/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.DeliveryCompany;

import Business.Enterprise.Enterprise;
import Business.Enterprise.Restaurant.Restaurant;
import Business.Organization.DeliveryManOrganization;
import Business.Organization.ManagerOrganization;

/**
 *
 * @author ranranhe
 */
public class DeliveryCompany extends Restaurant {

    public DeliveryCompany(String name, String address, String phone) {
        super(name, address, phone);
    }
    
    @Override
    public void createOrganizations() {
        this.getOrganizationDirectory().getOrganizationList().add(new DeliveryManOrganization());
        this.getOrganizationDirectory().getOrganizationList().add(new ManagerOrganization());
    }
    
}
