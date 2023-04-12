package com.assignment.randomJoke.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Joke {
    public static void main(String[] args) throws IOException, JSONException {
        URL setURL = new URL("https://api.chucknorris.io/jokes/random");
        HttpsURLConnection connection = (HttpsURLConnection) setURL.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        StringBuilder jsonResponceData;
        String readLine;

        if(responseCode == connection.HTTP_OK) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                jsonResponceData = new StringBuilder();
                readLine = null;
                while ((readLine = in.readLine()) != null) {
                    jsonResponceData.append(readLine);
                }
            }

//            JSONObject chuckNorrisJoke = new JSONObject(jsonResponceData.toString());
//
//            JSONArray category = (JSONArray) chuckNorrisJoke.get("categories");
//            String createdAt = (String) chuckNorrisJoke.get("created_at");
//            String iconURL = (String) chuckNorrisJoke.get("icon_url");
//            String id = (String) chuckNorrisJoke.get("id");
//            String updatedAt = (String) chuckNorrisJoke.get("updated_at");
//            String url = (String) chuckNorrisJoke.get("url");
//            String value = (String) chuckNorrisJoke.get("value");
//
//            System.out.println(category.toString());
//            System.out.println(createdAt);
//            System.out.println(iconURL);
//            System.out.println(id);
//            System.out.println(updatedAt);
//            System.out.println(url);
//            System.out.println(value);
            System.out.println(jsonResponceData.toString());
        }
    }
}
