/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author SUJITH
 */
public class TextGeolocation {

    public static String getTextLocation(String latLang) throws ParseException, IOException {
        // making url request
        String textLocation = "";

        // URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&sensor=true");
        //URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=10.5276416,76.214434&sensor=true");
        //URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=10.7224853,76.302937&sensor=true");
        URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + latLang + "&sensor=true");
        // making connection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        // Reading data's from url
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String output;
        String out = "";
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            //System.out.println(output);
            out += output;
        }
        // Converting Json formatted string into JSON object
        JSONObject json = (JSONObject) new JSONParser().parse(out);
        JSONArray results = (JSONArray) json.get("results");
        JSONObject rec = (JSONObject) results.get(0);
        JSONArray address_components = (JSONArray) rec.get("address_components");

        for (int i = 0; i < address_components.size(); i++) {
            JSONObject rec1 = (JSONObject) address_components.get(i);
            JSONArray types = (JSONArray) rec1.get("types");
            String comp = (String) types.get(0);

            if (comp.equals("locality")) {
                System.out.println("city ————-" + rec1.get("long_name"));
            } else if (comp.equals("country")) {
                System.out.println("country ———-" + rec1.get("long_name"));
            }
        }
        String formattedAddress = (String) rec.get("formatted_address");
        textLocation = (String) rec.get("formatted_address");
        System.out.println("formatted_address————–" + formattedAddress);
        conn.disconnect();

        return textLocation;
    }

    public static void main(String[] args) {
        try {
          //String textLocation = getTextLocation("Ernakulam");
            String textLocation = getTextLocation("9.966498,76.295301");
            System.out.println("TextLocation: " + textLocation);
        } catch (ParseException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
