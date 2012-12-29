package com.darkprograms.gaio.recovery;

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

    public String[] getRecoveries() {
        return null;
    }

}
