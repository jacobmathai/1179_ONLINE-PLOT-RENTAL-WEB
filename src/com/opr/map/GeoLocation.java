/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.map;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import org.json.JSONArray;

/**
 *
 * @author SUJITH
 */
public class GeoLocation {

    public static String getLatLang(String textLocation) throws ParseException, MalformedURLException, IOException {
        String location = "";
        
            //URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=false");
            URL url = new URL("http://maps.googleapis.com/maps/api/geocode/json?address=" + textLocation + "&sensor=false");
            URLConnection conn = url.openConnection();
            conn.connect();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            StringBuffer sbLocation = new StringBuffer();

            for (int i = 0; i != -1; i = isr.read()) {
                sbLocation.append((char) i);
            }
            String getContent = sbLocation.toString().trim();
            if (getContent.contains("results")) {
                String temp = getContent.substring(getContent.indexOf("["));
                JSONArray JSONArrayForAll = new JSONArray(temp);
                String lng = JSONArrayForAll.getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lng").toString();
                String lat = JSONArrayForAll.getJSONObject(0).getJSONObject("geometry").getJSONObject("location").get("lat").toString();
                System.out.println(" Latitude : " + lat);
                System.out.println(" Longitude : " + lng);
                location = lat + "," + lng;
            }
       
        return location;
    }

    public static void main(String[] args) {
        try {
            String address = "Temple Road, Chelakkara, Kerala";
            //String address = "Panjal Manaladi Vettkkattiri Road";
            //String address = "Painkulam, Kerala, India";
            //String address = "Swaraj Round North, Thrissur, Kerala";
            String formatedText = address.trim().replaceAll(" ", "+");
            String latLang = getLatLang(formatedText);
            System.out.println("LatLang: " + latLang);
        } catch (ParseException ex) {
            ex.printStackTrace();
        } catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
