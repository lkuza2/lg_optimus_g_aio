package com.darkprograms.gaio.lgdriver;

import com.darkprograms.gaio.device.DeviceManager;
import com.darkprograms.gaio.network.NetworkUtil;
import com.darkprograms.gaio.util.Constants;
import org.json.JSONObject;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/30/12
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class DriverManager {

    private static DriverManager instance;

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private DriverManager() {

    }

    private String status;
    private boolean complete;

    public boolean isDriverInstalled() {
        if (System.getProperty("os.arch").equals("amd64")) {
            return new File(Constants.LG_DRIVER_PATH_X64).exists();
        } else {
            return new File(Constants.LG_DRIVER_PATH_X32).exists();
        }
    }

    public String getDriverName() {
        try {
            JSONObject object = new JSONObject(NetworkUtil.getInstance().getJSON(Constants.GAIO_LG_DRIVER_JSON));

            return object.getString("name");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void installDriver(String driverName) {
        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec(DeviceManager.getInstance().getTmpDir() + "/gaio/" + driverName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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
