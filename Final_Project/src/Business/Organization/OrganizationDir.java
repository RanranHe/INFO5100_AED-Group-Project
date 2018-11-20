/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class OrganizationDir {
    private ArrayList<Organization> organizationList;
    
    public OrganizationDir() {
        this.organizationList = new ArrayList<>();
    }
    
    public ArrayList<Organization> getOrganizationList() {
        return this.organizationList;
    }
}
