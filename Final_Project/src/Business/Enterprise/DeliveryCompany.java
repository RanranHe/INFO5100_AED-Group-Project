/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.DeliveryManOrganization;
import Business.Organization.ManagerOrganization;

/**
 *
 * @author ranranhe
 */
public class DeliveryCompany extends Enterprise {

    public DeliveryCompany(String name) {
        super(name);
    }
    
    @Override
    public void createOrganizations() {
        this.getOrganizationDirectory().getOrganizationList().add(new DeliveryManOrganization());
        this.getOrganizationDirectory().getOrganizationList().add(new ManagerOrganization());
    }
    
}
