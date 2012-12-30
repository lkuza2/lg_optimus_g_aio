package com.darkprograms.gaio.network;

import com.darkprograms.gaio.util.Constants;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created with IntelliJ IDEA.
 * User: theshadow
 * Date: 12/29/12
 * Time: 3:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class NetworkUtil {

    public String getJSON(String jsonFile) {
        try {
            URLConnection urlConnection = new URL(Constants.GAIO_URL_BASE + jsonFile).openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            String json = "";

            while ((line = bufferedReader.readLine()) != null) {
                json += line;
            }
            return json;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
