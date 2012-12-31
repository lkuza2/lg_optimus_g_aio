package com.darkprograms.gaio.restore;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/30/12
 * Time: 11:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class RestoreManager {

    private static RestoreManager instance;

    public static RestoreManager getInstance() {
        if (instance == null) {
            instance = new RestoreManager();
        }
        return instance;
    }

    private RestoreManager() {

    }

    private String status;
    private boolean complete;

    public synchronized String getStatus() {
        return status;
    }

    public synchronized void setStatus(String status) {
        this.status = status;
    }

    public synchronized boolean isComplete() {
        return complete;
    }

    public synchronized void setComplete(boolean complete) {
        this.complete = complete;
    }

}
