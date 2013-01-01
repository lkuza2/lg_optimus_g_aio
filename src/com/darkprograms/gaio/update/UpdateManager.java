package com.darkprograms.gaio.update;

import com.darkprograms.gaio.network.NetworkUtil;
import com.darkprograms.gaio.util.Constants;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/31/12
 * Time: 6:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class UpdateManager {

    private static UpdateManager instance;

    public static UpdateManager getInstance() {
        if (instance == null) {
            instance = new UpdateManager();
        }
        return instance;
    }

    private UpdateManager() {

    }

    public String getCurrentVersion() {
        try {
            JSONObject object = new JSONObject(NetworkUtil.getInstance().getJSON(Constants.GAIO_JSON));

            return object.getString("version");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean isUpToDate() {
        return Constants.GAIO_VERSION.equals(getCurrentVersion());
    }

    public boolean update() {
        try {
            Desktop.getDesktop().browse(new URI(Constants.GAIO_URL));
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void checkForUpdate() {
        String currentVersion = UpdateManager.getInstance().getCurrentVersion();

        if (currentVersion != null) {
            if (!UpdateManager.getInstance().isUpToDate()) {
                int response = JOptionPane.showConfirmDialog(null, "<html>Your GAIO version, " + Constants.GAIO_VERSION + ", is out of date." +
                        "<br>The current version is " + currentVersion + "<br>Would you like to open a browser to update?</html>", "Update", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    boolean complete = UpdateManager.getInstance().update();
                    if (complete) {
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "<html>Could not open your browser to download GAIO.<br>" +
                                "You may download it manually at " + Constants.GAIO_URL + "</html>", "Update Error", JOptionPane.ERROR_MESSAGE);
                        System.exit(0);
                    }
                }
            }
        }
    }

}
