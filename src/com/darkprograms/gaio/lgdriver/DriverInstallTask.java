package com.darkprograms.gaio.lgdriver;

import com.darkprograms.gaio.network.NetworkUtil;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 1/1/13
 * Time: 12:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class DriverInstallTask extends SwingWorker<Void, Integer> {

    private JProgressBar progressBar;
    private JLabel label;
    private JDialog frame;

    public DriverInstallTask(JProgressBar progressBar, JLabel label, JDialog frame) {
        this.progressBar = progressBar;
        this.label = label;
        this.frame = frame;
    }

    @Override
    protected Void doInBackground() throws Exception {
        DriverManager driverManager = DriverManager.getInstance();

        while (!driverManager.isComplete()) {

            if (driverManager.getStatus().contains("Downloading")) {
                NetworkUtil networkUtil = NetworkUtil.getInstance();

                while (networkUtil.getLength() == -1) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //wait
                }

                double totalKb = roundTwoDecimals((double) networkUtil.getLength() / 1024);
                double downloaded = roundTwoDecimals((double) networkUtil.getDownloaded() / 1024);

                label.setText("Downloading... " + downloaded + "/" + totalKb + " Kb");
                progressBar.setIndeterminate(false);
                progressBar.setValue(networkUtil.getPercentage(networkUtil.getDownloaded(), networkUtil.getLength()));
            } else {
                label.setText(driverManager.getStatus());
                progressBar.setIndeterminate(true);
            }

        }
        JOptionPane.showMessageDialog(frame, "Driver installation started.", "Driver Install", JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();

        return null;
    }

    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

}
