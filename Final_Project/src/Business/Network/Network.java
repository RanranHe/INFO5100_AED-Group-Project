/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDir;

/**
 *
 * @author ranranhe
 */
public class Network {

    private String name;
    private EnterpriseDir enterpriseDir;

    public Network() {
        enterpriseDir = new EnterpriseDir();
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
}
