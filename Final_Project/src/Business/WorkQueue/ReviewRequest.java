/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;

/**
 *
 * @author ranranhe
 */
public class ReviewRequest extends WorkRequest {
    private int rate;

    public ReviewRequest(Enterprise enterprise, UserAccount account) {
        super(enterprise, account);
        this.rate = -1;
    }
    
    public int getRate() {
        return this.rate;
    }
    
    public void setRate(int rate) {
        this.rate = rate;
    }
}
