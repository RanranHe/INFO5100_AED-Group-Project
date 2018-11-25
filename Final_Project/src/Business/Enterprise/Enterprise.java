 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.DeliveryManOrganization;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.Organization.OrganizationDir;
import Business.Restaurant.RestaurantDir;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class Enterprise extends Organization {
    private OrganizationDir organizations;
    private RestaurantDir restaurants;
    private City city;
    
    public Enterprise(String name, City city) {
        super(name);
        this.city = city;
        this.restaurants = new RestaurantDir();
        this.organizations = new OrganizationDir();
    }
    
    public OrganizationDir getOrganizationDirectory() {
        return organizations;
    }
    
    public void createOrganizations() {
        this.organizations.getOrganizationList().add(new DeliveryManOrganization());
        this.organizations.getOrganizationList().add(new ManagerOrganization());
    }
    
    public RestaurantDir getRestaurantDirectory() {
        return restaurants;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
