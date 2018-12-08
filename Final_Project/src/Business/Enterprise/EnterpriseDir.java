/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author MyPC1
 */
public class EnterpriseDir {

    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDir() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void removeEnterprise(Enterprise en) {
        Enterprise result = null;
        if (!enterpriseList.isEmpty()) {
            for (Enterprise ent : enterpriseList) {
                if (ent.getId().equalsIgnoreCase(en.getId())) {
                    result = ent;
                }
            }
            enterpriseList.remove(result);
        } 
    }
}
