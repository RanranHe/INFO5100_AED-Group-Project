/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Restaurant.Dash;
import java.util.ArrayList;

/**
 *
 * @author ranranhe
 */
public class OrderRequest extends WorkRequest {
    private StatusEnum status;
    private ArrayList<Dash> dashes;
    
    public ArrayList<Dash> getDashes() {
        return this.dashes;
    }
    
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
