/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

/**
 *
 * @author ranranhe
 */
public class ReviewRequest extends WorkRequest {
    private int rate;
    private OrderRequest order;
    
    public int getRate() {
        return this.rate;
    }
    
    public void setRate(int rate) {
        this.rate = rate;
    }
    
    public OrderRequest getOrder() {
        return this.order;
    }
}
