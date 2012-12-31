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

    public String[] getRecoveries() {
        try {
            JSONObject object = new JSONObject(new NetworkUtil().getJSON(Constants.GAIO_RECOVERY_JSON));
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

    public int getRecoveryIndex() {
        return recoveryIndex;
    }

    public void setRecoveryIndex(int recoveryIndex) {
        this.recoveryIndex = recoveryIndex;
    }

}
