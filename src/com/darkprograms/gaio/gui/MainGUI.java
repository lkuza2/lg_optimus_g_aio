/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkprograms.gaio.gui;

import com.darkprograms.gaio.adb.AdbManager;
import com.darkprograms.gaio.device.DeviceManager;
import com.darkprograms.gaio.root.RootManager;
import com.darkprograms.gaio.unlock.UnlockManager;
import com.darkprograms.gaio.util.Constants;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

/**
 * @author theshadow
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    public MainGUI() {
        initComponents();
        loadAdbInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        phoneStatus = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        phoneType = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rootStatus = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buildNumber = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        softwareVersion = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        rootButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        unlockBootloaderButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        windowsDriver = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GAIO v1.00");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                deleteTmpFiles(evt);
            }
        });

        jLabel1.setText("GAIO v 1.00");

        jLabel2.setText("Phone Information");

        jLabel3.setText("Phone Status:");

        phoneStatus.setText("Not Connected");

        jLabel4.setText("Phone Type:");

        phoneType.setText("                       ");

        jLabel5.setText("Root Status:");

        rootStatus.setText("                       ");

        jLabel6.setText("Build Number:");

        buildNumber.setText("                        ");

        jLabel8.setText("Software Version:");

        softwareVersion.setText("                        ");

        rootButton.setText("Root LG Optimus G");
        rootButton.setEnabled(false);
        rootButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rootButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Use this button to root a");

        jLabel9.setText("Sprint LG Optimus G");

        unlockBootloaderButton.setText("Unlock Bootloader");
        unlockBootloaderButton.setEnabled(false);
        unlockBootloaderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unlockBootloaderButtonActionPerformed(evt);
            }
        });

        jLabel10.setText("Use this to unlock bootloader. Must");

        jLabel11.setText("be rooted first.");

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        windowsDriver.setText("Windows LG Driver");
        windowsDriver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                windowsDriverActionPerformed(evt);
            }
        });

        jLabel12.setText("Opens browser to LG Driver page");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(275, 275, 275)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(246, 246, 246)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(phoneStatus))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel6)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(buildNumber)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(phoneType))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(2, 2, 2)
                                                                .addComponent(jLabel8)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(softwareVersion)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(rootStatus))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(53, 53, 53)
                                                                .addComponent(refreshButton)
                                                                .addGap(45, 45, 45))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel12)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(windowsDriver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(rootButton, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                                                        .addComponent(jLabel7)
                                                                        .addComponent(jLabel9))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel11)
                                                                        .addComponent(jLabel10)
                                                                        .addComponent(unlockBootloaderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(unlockBootloaderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(rootButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9)))
                                .addGap(41, 41, 41)
                                .addComponent(windowsDriver, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(phoneStatus)
                                        .addComponent(jLabel4)
                                        .addComponent(phoneType)
                                        .addComponent(jLabel5)
                                        .addComponent(rootStatus))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(buildNumber)
                                        .addComponent(jLabel8)
                                        .addComponent(softwareVersion)
                                        .addComponent(refreshButton))
                                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>

    private void rootButtonActionPerformed(java.awt.event.ActionEvent evt) {

        RootManager.getInstance().loadRootTools();

        JOptionPane.showMessageDialog(this, "<html>" +
                "Instructions:<br>" +
                "When terminal appears, type the number 1 for option \"1\" and then press enter.", "Root Instructions", JOptionPane.INFORMATION_MESSAGE);

        RootManager.getInstance().root();
        //new Thread(RootManager.getInstance()).start();
    }

    private void unlockBootloaderButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UnlockManager.getInstance().loadUnlockTools();

        JOptionPane.showMessageDialog(this, "Unlock will occure automatically. Press OK.", "Unlock Instructions", JOptionPane.INFORMATION_MESSAGE);

        UnlockManager.getInstance().unlock();
    }

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadAdbInfo();
    }

    private void loadAdbInfo() {
        DeviceManager deviceManager = DeviceManager.getInstance();

        if (deviceManager.isDeviceConnected()) {
            phoneStatus.setText("Connected");
            phoneStatus.setForeground(Color.green);
        } else {
            phoneStatus.setText("Not Connected");
            phoneStatus.setForeground(Color.red);

            phoneType.setText("");
            rootStatus.setText("");
            buildNumber.setText("");
            softwareVersion.setText("");
            rootButton.setEnabled(false);
            unlockBootloaderButton.setEnabled(false);

            return;
        }

        if (deviceManager.getDeviceType().equals(Constants.SUPPORTED_DEVICE)) {
            phoneType.setText("LG Optimus G (Sprint)");
            phoneType.setForeground(Color.green);
            rootButton.setEnabled(true);
        } else {
            phoneType.setText("Unsupported");
            phoneType.setForeground(Color.red);

            rootStatus.setText("");
            buildNumber.setText("");
            softwareVersion.setText("");
            rootButton.setEnabled(false);
            unlockBootloaderButton.setEnabled(false);
            return;
        }


        if (deviceManager.deviceHasRoot()) {
            rootStatus.setText("Rooted");
            rootStatus.setForeground(Color.green);
            unlockBootloaderButton.setEnabled(true);
        } else {
            rootStatus.setText("Not Rooted");
            rootStatus.setForeground(Color.red);
            unlockBootloaderButton.setEnabled(false);
        }

        buildNumber.setText(deviceManager.getBuildNumber());
        softwareVersion.setText(deviceManager.getSoftwareVersion());

    }

    private void windowsDriverActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Desktop.getDesktop().browse(new URI(Constants.LG_DRIVER_URL));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void deleteTmpFiles(java.awt.event.WindowEvent evt) {
        AdbManager.getInstance().adbKill();
        try {
            AdbManager.getInstance().deleteTempFiles();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // Variables declaration - do not modify
    private javax.swing.JLabel buildNumber;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel phoneStatus;
    private javax.swing.JLabel phoneType;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton rootButton;
    private javax.swing.JLabel rootStatus;
    private javax.swing.JLabel softwareVersion;
    private javax.swing.JButton unlockBootloaderButton;
    private javax.swing.JButton windowsDriver;
    // End of variables declaration
}
