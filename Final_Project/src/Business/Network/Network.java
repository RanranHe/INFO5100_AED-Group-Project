/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDir;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author ranranhe
 */
public class Network {

    private String name;
    private EnterpriseDir enterpriseDir;
    private String state;
    
    public Network(String state) {
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
     
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return this.state;
    }
    
    public Enterprise createEnterprise(String name, String city) {
        Enterprise enter = new Enterprise(name, city);
        enter.createOrganizations();
        this.enterpriseDir.getEnterpriseList().add(enter);
        return enter;
    }
    
    public Enterprise getEnterpriseByCity(String city) {
        for (Enterprise en:this.enterpriseDir.getEnterpriseList()) {
            if (en.getCity().equals(city)) {
                return en;
            }
        }
        return null;
    }
}
