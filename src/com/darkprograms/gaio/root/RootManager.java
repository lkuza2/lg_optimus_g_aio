package com.darkprograms.gaio.root;

import com.darkprograms.gaio.util.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/9/12
 * Time: 5:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class RootManager implements Runnable {

    private static RootManager instance;

    private RootManager() {

    }

    public static RootManager getInstance() {
        if (instance == null) {
            instance = new RootManager();
        }
        return instance;
    }

    public void root() {

        if (isWindows()) {
            windowsRoot();
        } else {
            linuxRoot();
        }
    }

    private void windowsRoot() {
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c start " + getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.ROOT_DIR_NAME +
                    "/RunMe.bat", null, new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.ROOT_DIR_NAME));
            process.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void linuxRoot() {
        try {
            Process process = Runtime.getRuntime().exec("xterm -e sh " + getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.ROOT_DIR_NAME +
                    "/RunMe.sh", null, new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.ROOT_DIR_NAME));
            process.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();

        return os.contains("windows");
    }

    public void loadRootTools() {
        loadRescourcesFromArray();
        loadBatchResourcesFromArray();
    }

    private void loadRescourcesFromArray() {
        int length = Constants.RESOURCES_ROOT_ARRAY.length;

        File gaioDir = new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME);
        File rootDir = new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.ROOT_DIR_NAME);
        File stuffDir = new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.ROOT_DIR_NAME + "/" + Constants.RESOURCES_ROOT_STUFF);

        if (!gaioDir.exists()) {
            gaioDir.mkdir();
        }

        if (!rootDir.exists()) {
            rootDir.mkdir();
        }

        if (!stuffDir.exists()) {
            stuffDir.mkdir();
        }

        for (int i = 0; i < length; i++) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(Constants.RESOURCES_ROOT_NAME + "/" + Constants.RESOURCES_ROOT_STUFF + "/" + Constants.RESOURCES_ROOT_ARRAY[i]);


            File outputFile = new File(getTmpDir() + "/gaio/" + Constants.ROOT_DIR_NAME + "/" + Constants.RESOURCES_ROOT_STUFF + "/" + Constants.RESOURCES_ROOT_ARRAY[i]);
            OutputStream outputStream;
            byte[] buffer = new byte[256];
            int read;

            try {
                outputStream = new FileOutputStream(outputFile);

                while ((read = inputStream.read(buffer, 0, 256)) != -1) {
                    outputStream.write(buffer, 0, read);
                }

                inputStream.close();
                outputStream.close();

                if (outputFile.getName().equals("adb") || outputFile.getName().equals("adb.exe"))
                    outputFile.setExecutable(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

    }

    private void loadBatchResourcesFromArray() {
        int length = Constants.RESOURCES_ROOT_RUN_ME.length;

        for (int i = 0; i < length; i++) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(Constants.RESOURCES_ROOT_NAME + "/" + Constants.RESOURCES_ROOT_RUN_ME[i]);


            File outputFile = new File(getTmpDir() + "/gaio/" + Constants.ROOT_DIR_NAME + "/" + Constants.RESOURCES_ROOT_RUN_ME[i]);
            OutputStream outputStream;
            byte[] buffer = new byte[256];
            int read;

            try {
                outputStream = new FileOutputStream(outputFile);

                while ((read = inputStream.read(buffer, 0, 256)) != -1) {
                    outputStream.write(buffer, 0, read);
                }

                inputStream.close();
                outputStream.close();


                outputFile.setExecutable(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

    }

    private String getTmpDir() {
        return System.getProperty("java.io.tmpdir");
    }

    @Override
    public void run() {
        root();
    }
}
