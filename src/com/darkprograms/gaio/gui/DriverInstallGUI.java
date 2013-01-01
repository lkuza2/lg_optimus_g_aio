/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.darkprograms.gaio.gui;

import com.darkprograms.gaio.lgdriver.DriverInstallTask;
import com.darkprograms.gaio.lgdriver.DriverInstallThread;
import com.darkprograms.gaio.lgdriver.DriverManager;

/**
 * @author theshadow
 */
public class DriverInstallGUI extends javax.swing.JDialog {

    /**
     * Creates new form RecoveryInstallGUI
     */
    public DriverInstallGUI(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        loadDriver();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        progress = new javax.swing.JProgressBar();
        status = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Install Driver");
        setResizable(false);

        progress.setStringPainted(true);

        status.setText("Downloading...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(status)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                                .addGap(5, 5, 5)
                                .addComponent(status))
        );

        pack();
    }// </editor-fold>

    private void loadDriver() {
        DriverManager.getInstance().setComplete(false);
        DriverManager.getInstance().setStatus("");
        new Thread(new DriverInstallThread()).start();
        new DriverInstallTask(progress, status, DriverInstallGUI.this).execute();
    }

    // Variables declaration - do not modify
    private javax.swing.JProgressBar progress;
    private javax.swing.JLabel status;
    // End of variables declaration

}