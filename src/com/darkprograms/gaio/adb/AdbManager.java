package com.darkprograms.gaio.adb;

import com.darkprograms.gaio.util.Constants;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/9/12
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class AdbManager {

    private static AdbManager instance;

    private AdbManager() {

    }

    public static AdbManager getInstance() {
        if (instance == null) {
            instance = new AdbManager();
        }
        return instance;
    }


    public String executeAdbCommand(String command) {

        Process process = executeAdb("shell " + command);


        return getAdbResponse(process);
    }

    public String getAdbResponse(Process process) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        String response = "";

        String read;

        try {

            while ((read = bufferedReader.readLine()) != null) {
                response = response + read + "\n";
            }

            bufferedReader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return response;
    }

    public void adbPush(String localFilePath, String deviceFilePath) {
        try {
            executeAdb("push " + localFilePath + " " + deviceFilePath).waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void adbReboot() {
        executeAdb("reboot");
    }

    public void adbKill() {
        executeAdb("kill-server");
    }

    public void adbStart() {
        executeAdb("start-server");
    }

    public Process executeAdb(String extension) {
        Runtime runtime = Runtime.getRuntime();

        try {
            if (isWindows()) {
                return runtime.exec(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + "adb.exe " + extension);
            } else {
                return runtime.exec(getTmpDir() + "/" + Constants.GAIO_DIR_NAME + "/" + "adb " + extension);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();

        return os.contains("windows");
    }

    public void loadAdbTools() {
        loadRescourcesFromArray();
    }

    private void loadRescourcesFromArray() {
        int length = Constants.RESOURCES_ADB_ARRAY.length;

        File gaioDir = new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME);

        if (!gaioDir.exists()) {
            gaioDir.mkdir();
        }

        for (int i = 0; i < length; i++) {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(Constants.RESOURCES_DIR_NAME + "/" + Constants.RESOURCES_ADB_ARRAY[i]);


            File outputFile = new File(getTmpDir() + "/gaio/" + Constants.RESOURCES_ADB_ARRAY[i]);
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
        adbStart();
    }

    public void deleteTempFiles() throws IOException {
        delete(new File(getTmpDir() + "/" + Constants.GAIO_DIR_NAME));
    }

    private void delete(File f) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles())
                delete(c);
        }
        if (!f.delete())
            throw new FileNotFoundException("Failed to delete file: " + f);
    }


    private String getTmpDir() {
        return System.getProperty("java.io.tmpdir");
    }

}
