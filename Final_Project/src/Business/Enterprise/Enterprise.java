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
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public abstract class Enterprise extends Organization {
    private OrganizationDir organizations;
    
    public Enterprise(String name) {
        super(name);
        this.organizations = new OrganizationDir();
    }
    
    public OrganizationDir getOrganizationDirectory() {
        return organizations;
    }
    
    public abstract void createOrganizations();

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
