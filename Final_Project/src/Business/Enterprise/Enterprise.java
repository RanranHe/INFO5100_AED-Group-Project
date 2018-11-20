 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDir;

/**
 *
 * @author ranranhe
 */
public abstract class Enterprise extends Organization {
    private OrganizationDir organizations;

    public Enterprise(String name, City city) {
        super(name, city);
        this.organizations = new OrganizationDir();
    }
    
    public OrganizationDir getOrganizationDirectory() {
        return organizations;
    }
}
