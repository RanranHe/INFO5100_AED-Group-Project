/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class WorkRequest {

    private String message;
    private Enterprise enterprise;
    private UserAccount account;
    private Date requestDate;
    private Date resolveDate;

    public enum StatusEnum {

        Processing("Processing"),
        Ready("Ready for pickup"),
        WaitForPickup("Waiting for pickup"),
        OnTheWay("On the way"),
        Cancelled("Cancelled"),
        Completed("Completed");

        private String value;

        private StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public WorkRequest(Enterprise enterprise, UserAccount account) {
        this.account = account;
        this.enterprise = enterprise;
        this.requestDate = new Date();
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String mess) {
        this.message = mess;
    }

    public Enterprise getEnterprise() {
        return this.enterprise;
    }

    public void setEnterprise(Enterprise en) {
        this.enterprise = en;
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }

    public String getRequestDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(this.requestDate);
        return dateString;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return this.getRequestDate();
    }
}
