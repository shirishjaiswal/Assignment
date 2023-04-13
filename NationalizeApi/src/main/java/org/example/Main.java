package org.example;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {

        URL setURL = new URL("https://api.nationalize.io/?name=nathaniel");
        HttpURLConnection httpConnection = (HttpURLConnection) setURL.openConnection();
        httpConnection.setRequestMethod("GET");

        int responseCode = httpConnection.getResponseCode();

        if(responseCode == httpConnection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()))) {
                StringBuilder jsonData = new StringBuilder();
                String readLine = null;

                while ((readLine = in.readLine()) != null) {
                    jsonData.append(readLine);
                }

                JSONObject jsonObj = new JSONObject(jsonData.toString());
                System.out.println(jsonObj.toString());

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}