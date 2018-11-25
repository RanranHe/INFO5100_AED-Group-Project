/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDir;
import Business.Organization.Organization.City;

/**
 *
 * @author ranranhe
 */
public class Network {

    private String name;
    private EnterpriseDir enterpriseDir;
    private State state;

    public enum State {
        MA
    }
    
    public Network(State state) {
        enterpriseDir = new EnterpriseDir();
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDir getEnterpriseDirectory() {
        return enterpriseDir;
    }
    
    public Enterprise createEnterprise(String name, City city) {
        Enterprise enter = new Enterprise(name, city);
        enter.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(enter);
        return enter;
    }
}
