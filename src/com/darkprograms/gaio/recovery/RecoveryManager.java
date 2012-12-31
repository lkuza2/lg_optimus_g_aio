package com.darkprograms.gaio.recovery;

import com.darkprograms.gaio.network.NetworkUtil;
import com.darkprograms.gaio.util.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RecoveryManager {

    private static RecoveryManager instance;

    public static RecoveryManager getInstance() {
        if (instance == null) {
            instance = new RecoveryManager();
        }
        return instance;
    }

    private RecoveryManager() {

    }

    private int recoveryIndex;
    private String status;
    private boolean complete;

    public String[] getRecoveries() {
        try {
            JSONObject object = new JSONObject(NetworkUtil.getInstance().getJSON(Constants.GAIO_RECOVERY_JSON));
            JSONArray array = object.getJSONArray("recovery");
            List<String> recoveries = new ArrayList<String>();


            for (int i = 0; i < array.length(); i++) {
                JSONObject recovery = array.getJSONObject(i);
                recoveries.add(recovery.getString("name") + "-" + recovery.getString("version"));
            }

            return recoveries.toArray(new String[0]);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getRecoveryFileName(int index) {
        try {
            JSONObject object = new JSONObject(NetworkUtil.getInstance().getJSON(Constants.GAIO_RECOVERY_JSON));
            JSONArray array = object.getJSONArray("recovery");

            return array.getJSONObject(index).getString("download");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int getRecoveryIndex() {
        return recoveryIndex;
    }

    public void setRecoveryIndex(int recoveryIndex) {
        this.recoveryIndex = recoveryIndex;
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
