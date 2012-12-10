package com.darkprograms.gaio.unlock;

import com.darkprograms.gaio.util.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/9/12
 * Time: 8:11 PM
 * To change this template use File | Settings | File Templates.
 */
public class UnlockManager {
    private static UnlockManager instance;

    public static UnlockManager getInstance() {
        if (instance == null) {
            instance = new UnlockManager();
        }
        return instance;
    }

    private UnlockManager() {
    }


    public void unlock() {

        if (isWindows()) {
            windowsUnlock();
        } else {
            linuxUnlock();
        }
    }

    private void windowsUnlock() {
        try {
            Process process = Runtime.getRuntime().exec("cmd.exe /c start " + getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.UNLOCK_DIR_NAME +
                    "/freegee.bat", null, new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.UNLOCK_DIR_NAME));
            process.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void linuxUnlock() {
        try {
            Process process = Runtime.getRuntime().exec("xterm -e sh " + getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.UNLOCK_DIR_NAME +
                    "/freegee.sh", null, new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.UNLOCK_DIR_NAME));
            process.waitFor();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();

        return os.contains("windows");
    }

    public void loadUnlockTools() {
        loadRescourcesFromArray();
    }

    private void loadRescourcesFromArray() {
        int length = Constants.RESOURCES_UNLOCK_ARRAY.length;

        File gaioDir = new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME);
        File unlockDir = new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + Constants.UNLOCK_DIR_NAME);

        if (!gaioDir.exists()) {
            gaioDir.mkdir();
        }

        if (!unlockDir.exists()) {
            unlockDir.mkdir();
        }

        for (int i = 0; i < length; i++) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(Constants.RESOURCES_UNLOCK_NAME + "/" + Constants.RESOURCES_UNLOCK_ARRAY[i]);


            File outputFile = new File(getTmpDir() + "/gaio/" + Constants.UNLOCK_DIR_NAME + "/" + Constants.RESOURCES_UNLOCK_ARRAY[i]);
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

                if (outputFile.getName().equals("adb") || outputFile.getName().equals("adb.exe") || outputFile.getName().equals("freegee.sh")
                        || outputFile.getName().equals("freegee.bat"))
                    outputFile.setExecutable(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }

    }

    private String getTmpDir() {
        return System.getProperty("java.io.tmpdir");
    }

}
