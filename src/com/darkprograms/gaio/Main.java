package com.darkprograms.gaio;

import com.darkprograms.gaio.adb.AdbManager;
import com.darkprograms.gaio.gui.MainGUI;
import com.darkprograms.gaio.lgdriver.DriverManager;
import com.darkprograms.gaio.update.UpdateManager;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/9/12
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            //Don't Do anything
        }

        UpdateManager.getInstance().checkForUpdate();

        AdbManager.getInstance().loadAdbTools();

        MainGUI gui = new MainGUI();
        gui.setVisible(true);
        gui.setLocationRelativeTo(null);

        DriverManager.getInstance().checkForDriverAndInstall(gui);

    }

}
