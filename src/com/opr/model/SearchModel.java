package com.opr.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.opr.bean.LoginBean;
import com.opr.bean.PropertyBean;

import com.opr.map.GeoLocation;
import com.opr.utils.AppConstants;
import com.opr.utils.SupportMethods;

import java.io.File;
import java.util.logging.Level;

import org.json.simple.JSONArray;

public class SearchModel {

    Connection con = null;

    public String checkLogin(LoginBean bean) throws Exception {
        PreparedStatement statement = null;
        ResultSet set = null;
        String type = "";
        try {
            String query = "SELECT user_type From login_info WHERE username =? AND BINARY password = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, bean.getUsername());
            statement.setString(2, bean.getPassword());
            set = statement.executeQuery();
            if (set.next()) {
                type = set.getString("user_type");
            }

        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return type;
    }

    public ArrayList<String> getUsers() throws SQLException,
            ClassNotFoundException {
        ArrayList<String> userList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT username FROM login_info WHERE user_type = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, AppConstants.TYPE_USER);
            set = statement.executeQuery();
            while (set.next()) {
                userList.add(set.getString("username"));
            }
        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return userList;
    }

    public String getUserList() throws SQLException, ClassNotFoundException {
        StringBuilder sb = new StringBuilder();
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT user_id FROM user_info WHERE user_type = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, AppConstants.TYPE_USER);
            set = statement.executeQuery();
            while (set.next()) {
                sb.append(set.getString("user_id"));
                sb.append("&");
            }
        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return sb.toString();
    }

    public String getUserName(String empId) throws SQLException,
            ClassNotFoundException {
        String empName = "";
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT name FROM user_info WHERE user_id = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, empId);
            set = statement.executeQuery();
            if (set.next()) {
                empName = set.getString("name");
            }
        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return empName;
    }

    public ArrayList<String> getAllGcmKeys() throws ClassNotFoundException,
            SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<String> keyList = new ArrayList<>();
        try {
            String query = "SELECT *  FROM login_info;";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("gcm_key") != null
                        && !resultSet.getString("gcm_key").equals("")) {
                    keyList.add(resultSet.getString("gcm_key"));
                }
            }
        } finally {
            SupportMethods.CloseInstance(con, resultSet, statement);
        }
        return keyList;
    }

    public JSONArray getCity() throws SQLException, ClassNotFoundException {
        JSONArray cityJSONArray = new JSONArray();
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT DISTINCT city FROM property_info";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            set = statement.executeQuery();
            while (set.next()) {
                JSONObject obj = new JSONObject();
                obj.put("city", set.getString("city"));
                cityJSONArray.add(obj);
            }
        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return cityJSONArray;
    }

    public JSONArray getPriceRange() throws SQLException,
            ClassNotFoundException {
        JSONArray priceArray = new JSONArray();
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT DISTINCT price  FROM property_info";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            set = statement.executeQuery();
            while (set.next()) {
                JSONObject obj = new JSONObject();
                obj.put("price", set.getString("price"));
                priceArray.add(obj);
            }
        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return priceArray;
    }

    public JSONArray getAreaSqft() throws SQLException, ClassNotFoundException {
        JSONArray areaArray = new JSONArray();
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT DISTINCT area FROM property_info";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            set = statement.executeQuery();
            while (set.next()) {
                JSONObject obj = new JSONObject();
                obj.put("area", set.getString("area"));
                areaArray.add(obj);
            }
        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return areaArray;
    }

    public String isUserExist(String empId) throws ClassNotFoundException,
            SQLException {

        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT username FROM login_info WHERE username = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, empId);
            set = statement.executeQuery();
            if (set.next()) {
                return AppConstants.TRUE;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return AppConstants.FALSE;
    }

    // Read The current locations of employee
    public String getGpsLocation(String empId) throws ClassNotFoundException {
        String location = "0";
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT location FROM route_info WHERE emp_id = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, empId);
            set = statement.executeQuery();
            if (set.last()) {
                location = set.getString("location");
            }
            if (AppConstants.DEBUG) {
                // System.out.println(empId + " pressent " + location);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return location;
    }

    // Property listing method by passing username.
    public ArrayList<PropertyBean> getUsersPropertyList(String username)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        ArrayList<PropertyBean> propertyList = new ArrayList<>();
        String query = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status,"
                + " amenities_info.id, amenities_info.ac, amenities_info.coffee, amenities_info.heating, amenities_info.parking, "
                + " amenities_info.balcony, amenities_info.internet, amenities_info.pool, amenities_info.bedding, "
                + " amenities_info.fridge, amenities_info.microwave, amenities_info.cable, amenities_info.oven "
                + " FROM property_info JOIN amenities_info ON "
                + " property_info.prop_id = amenities_info.prop_id AND property_info.owner_name = ?";
        try {
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                PropertyBean bean = new PropertyBean();
                bean.setPropertyId(propertySet.getString("prop_id"));
                bean.setPropTitle(propertySet.getString("prop_title"));
                bean.setPropType(propertySet.getString("prop_type"));
                bean.setUsername(propertySet.getString("owner_name"));
                bean.setCity(propertySet.getString("city"));
                bean.setLocation(propertySet.getString("location"));
                bean.setAddress(propertySet.getString("address"));
                bean.setPublicLocaton(propertySet.getString("pub_location"));
                bean.setDistance(propertySet.getString("dist_pub_location"));
                bean.setBedrooms(propertySet.getString("bedrooms"));
                bean.setBathrooms(propertySet.getString("bathrooms"));
                bean.setArea(propertySet.getString("area"));
                bean.setPrice(propertySet.getString("price"));
                bean.setContractType(propertySet.getString("contract_type"));
                bean.setQuality(propertySet.getString("quality_type"));
                bean.setPostDate(propertySet.getString("post_date"));
                bean.setStatus(propertySet.getString("status"));
                // ----Amenities----
                bean.setAc(propertySet.getString("ac"));
                bean.setCoffee(propertySet.getString("coffee"));
                bean.setHeating(propertySet.getString("heating"));
                bean.setParking(propertySet.getString("parking"));
                bean.setBalcony(propertySet.getString("balcony"));
                bean.setInternet(propertySet.getString("internet"));
                bean.setPool(propertySet.getString("pool"));
                bean.setBedding(propertySet.getString("bedding"));
                bean.setFridge(propertySet.getString("fridge"));
                bean.setCable(propertySet.getString("cable"));
                bean.setOven(propertySet.getString("oven"));

                propertyList.add(bean);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return propertyList;
    }
    // Plot/ Land listing method by passing username.

    public ArrayList<PropertyBean> getUsersPlotList(String username)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        ArrayList<PropertyBean> propertyList = new ArrayList<>();
        String query = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city, "
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status "
                + "  FROM property_info WHERE property_info.owner_name = ? AND property_info.type = ?";
        try {
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, AppConstants.PLOT);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                PropertyBean bean = new PropertyBean();
                bean.setPropertyId(propertySet.getString("prop_id"));
                bean.setPropTitle(propertySet.getString("prop_title"));
                bean.setPropType(propertySet.getString("prop_type"));
                bean.setUsername(propertySet.getString("owner_name"));
                bean.setCity(propertySet.getString("city"));
                bean.setLocation(propertySet.getString("location"));
                bean.setAddress(propertySet.getString("address"));
                bean.setPublicLocaton(propertySet.getString("pub_location"));
                bean.setDistance(propertySet.getString("dist_pub_location"));
                bean.setBedrooms(propertySet.getString("bedrooms"));
                bean.setBathrooms(propertySet.getString("bathrooms"));
                bean.setArea(propertySet.getString("area"));
                bean.setPrice(propertySet.getString("price"));
                bean.setContractType(propertySet.getString("contract_type"));
                bean.setQuality(propertySet.getString("quality_type"));
                bean.setPostDate(propertySet.getString("post_date"));
                bean.setStatus(propertySet.getString("status"));


                propertyList.add(bean);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return propertyList;
    }

    public ArrayList<PropertyBean> getUsersPropertyList()
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        ArrayList<PropertyBean> propertyList = new ArrayList<>();
        String query = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status "
                + " FROM property_info ";
        try {
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                PropertyBean bean = new PropertyBean();
                bean.setPropertyId(propertySet.getString("prop_id"));
                bean.setPropTitle(propertySet.getString("prop_title"));
                bean.setPropType(propertySet.getString("prop_type"));
                bean.setUsername(propertySet.getString("owner_name"));
                bean.setCity(propertySet.getString("city"));
                bean.setLocation(propertySet.getString("location"));
                bean.setAddress(propertySet.getString("address"));
                bean.setPublicLocaton(propertySet.getString("pub_location"));
                bean.setDistance(propertySet.getString("dist_pub_location"));
                bean.setBedrooms(propertySet.getString("bedrooms"));
                bean.setBathrooms(propertySet.getString("bathrooms"));
                bean.setArea(propertySet.getString("area"));
                bean.setPrice(propertySet.getString("price"));
                bean.setContractType(propertySet.getString("contract_type"));
                bean.setQuality(propertySet.getString("quality_type"));
                bean.setPostDate(propertySet.getString("post_date"));
                bean.setStatus(propertySet.getString("status"));
                // ----Amenities----
//                bean.setAc(propertySet.getString("ac"));
//                bean.setCoffee(propertySet.getString("coffee"));
//                bean.setHeating(propertySet.getString("heating"));
//                bean.setParking(propertySet.getString("parking"));
//                bean.setBalcony(propertySet.getString("balcony"));
//                bean.setInternet(propertySet.getString("internet"));
//                bean.setPool(propertySet.getString("pool"));
//                bean.setBedding(propertySet.getString("bedding"));
//                bean.setFridge(propertySet.getString("fridge"));
//                bean.setCable(propertySet.getString("cable"));
//                bean.setOven(propertySet.getString("oven"));

                propertyList.add(bean);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return propertyList;
    }

    @SuppressWarnings("unchecked")
    public JSONArray getBookedList() throws ClassNotFoundException,
            SQLException {
        PreparedStatement statement = null;
        ResultSet bookedSet = null;
        JSONArray bookedArray = new JSONArray();
        try {
            String query = "SELECT DISTINCT property_info.prop_id, property_info.prop_title, property_info.owner_name, property_info.city, "
                    + "property_info.location, property_info.price, property_info.type, property_info.contract_type, property_info.address, "
                    + "booking_info.id, booking_info.booking_date, booking_info.username, booking_info.status "
                    + "FROM property_info JOIN booking_info ON booking_info.prop_id = property_info.prop_id "
                    + "WHERE booking_info.status = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, AppConstants.BOOKED);
            bookedSet = statement.executeQuery();
            while (bookedSet.next()) {
                JSONObject obj = new JSONObject();
                obj.put("prop_id", bookedSet.getString("prop_id"));
                obj.put("prop_title", bookedSet.getString("prop_title"));
                obj.put("owner", bookedSet.getString("owner_name"));
                obj.put("address", bookedSet.getString("address"));
                obj.put("city", bookedSet.getString("city"));
                obj.put("location", bookedSet.getString("location"));
                obj.put("price", bookedSet.getString("price"));
                obj.put("type", bookedSet.getString("type"));
                obj.put("bookId", bookedSet.getString("id"));
                obj.put("contract_type", bookedSet.getString("contract_type"));
                obj.put("booking_date", bookedSet.getString("booking_date"));
                obj.put("booked_one", bookedSet.getString("username"));
                obj.put("status", bookedSet.getString("status"));
                bookedArray.add(obj);
            }
        } finally {
            SupportMethods.CloseInstance(con, bookedSet, statement);
        }
        return bookedArray;
    }

    @SuppressWarnings("unchecked")
    public JSONArray getClientList() throws ClassNotFoundException,
            SQLException {
        PreparedStatement statement = null;
        ResultSet clientSet = null;
        JSONArray clientsArray = new JSONArray();
        try {
            String query = "SELECT username, name, phone, email, city FROM user_info ";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            clientSet = statement.executeQuery();
            while (clientSet.next()) {
                JSONObject obj = new JSONObject();
                obj.put("username", clientSet.getString("username"));
                obj.put("name", clientSet.getString("name"));
                obj.put("phone", clientSet.getString("phone"));
                obj.put("email", clientSet.getString("email"));
                obj.put("city", clientSet.getString("city"));
                clientsArray.add(obj);
            }
        } finally {
            SupportMethods.CloseInstance(con, clientSet, statement);
        }
        return clientsArray;
    }

    @SuppressWarnings("unchecked")
    public JSONArray getBookedList(String username) throws ClassNotFoundException,
            SQLException {
        PreparedStatement statement = null;
        ResultSet bookedSet = null;
        JSONArray bookedArray = new JSONArray();
        try {
            String query = "SELECT DISTINCT property_info.prop_id, property_info.prop_title, property_info.owner_name, property_info.city, "
                    + "property_info.location, property_info.price, property_info.type, property_info.contract_type, property_info.address, "
                    + "booking_info.id, booking_info.booking_date, booking_info.username, booking_info.status "
                    + "FROM property_info JOIN booking_info ON booking_info.prop_id = property_info.prop_id "
                    + "WHERE booking_info.status = ? AND booking_info.username = ? ";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, AppConstants.BOOKED);
            statement.setString(2, username);
            bookedSet = statement.executeQuery();
            while (bookedSet.next()) {
                JSONObject obj = new JSONObject();
                obj.put("prop_id", bookedSet.getString("prop_id"));
                obj.put("prop_title", bookedSet.getString("prop_title"));
                obj.put("owner", bookedSet.getString("owner_name"));
                obj.put("address", bookedSet.getString("address"));
                obj.put("city", bookedSet.getString("city"));
                obj.put("location", bookedSet.getString("location"));
                obj.put("price", bookedSet.getString("price"));
                obj.put("type", bookedSet.getString("type"));
                obj.put("bookId", bookedSet.getString("id"));
                obj.put("contract_type", bookedSet.getString("contract_type"));
                obj.put("booking_date", bookedSet.getString("booking_date"));
                obj.put("booked_one", bookedSet.getString("username"));
                obj.put("status", bookedSet.getString("status"));
                bookedArray.add(obj);
            }
        } finally {
            SupportMethods.CloseInstance(con, bookedSet, statement);
        }
        return bookedArray;
    }

    // Property listing method by passing property id
    public PropertyBean getPropertyListById(String propertyId)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        PropertyBean bean = new PropertyBean();
        String query = " SELECT property_info.prop_id,property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status,"
                + " amenities_info.id, amenities_info.ac, amenities_info.coffee, amenities_info.heating, amenities_info.parking, "
                + " amenities_info.balcony, amenities_info.internet, amenities_info.pool, amenities_info.bedding, "
                + " amenities_info.fridge, amenities_info.microwave, amenities_info.cable, amenities_info.oven "
                + " FROM property_info JOIN amenities_info ON "
                + " property_info.prop_id = amenities_info.prop_id AND property_info.prop_id = ? ";
        try {
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, propertyId);
            propertySet = statement.executeQuery();
            if (propertySet.next()) {
                bean.setPropertyId(propertySet.getString("prop_id"));
                bean.setPropTitle(propertySet.getString("prop_title"));
                bean.setPropType(propertySet.getString("prop_type"));
                bean.setUsername(propertySet.getString("owner_name"));
                bean.setCity(propertySet.getString("city"));
                bean.setLocation(propertySet.getString("location"));
                bean.setAddress(propertySet.getString("address"));
                bean.setPublicLocaton(propertySet.getString("pub_location"));
                bean.setDistance(propertySet.getString("dist_pub_location"));
                bean.setBedrooms(propertySet.getString("bedrooms"));
                bean.setBathrooms(propertySet.getString("bathrooms"));
                bean.setArea(propertySet.getString("area"));
                bean.setPrice(propertySet.getString("price"));
                bean.setContractType(propertySet.getString("contract_type"));
                bean.setQuality(propertySet.getString("quality_type"));
                bean.setPostDate(propertySet.getString("post_date"));
                bean.setStatus(propertySet.getString("status"));
                // ----Amenities----
                bean.setAc(propertySet.getString("ac"));
                bean.setCoffee(propertySet.getString("coffee"));
                bean.setHeating(propertySet.getString("heating"));
                bean.setParking(propertySet.getString("parking"));
                bean.setBalcony(propertySet.getString("balcony"));
                bean.setInternet(propertySet.getString("internet"));
                bean.setPool(propertySet.getString("pool"));
                bean.setBedding(propertySet.getString("bedding"));
                bean.setFridge(propertySet.getString("fridge"));
                bean.setCable(propertySet.getString("cable"));
                bean.setOven(propertySet.getString("oven"));
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return bean;
    }
    // Property listing method by passing property id

    public PropertyBean getPlotyListById(String propertyId)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        PropertyBean bean = new PropertyBean();
        String query = " SELECT property_info.prop_id,property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status, property_info.description "
                + " FROM property_info WHERE property_info.prop_id = ?";
        try {
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, propertyId);
            propertySet = statement.executeQuery();
            if (propertySet.next()) {
                bean.setPropertyId(propertySet.getString("prop_id"));
                bean.setPropTitle(propertySet.getString("prop_title"));
                bean.setPropType(propertySet.getString("prop_type"));
                bean.setUsername(propertySet.getString("owner_name"));
                bean.setCity(propertySet.getString("city"));
                bean.setLocation(propertySet.getString("location"));
                bean.setAddress(propertySet.getString("address"));
                bean.setPublicLocaton(propertySet.getString("pub_location"));
                bean.setDistance(propertySet.getString("dist_pub_location"));
                bean.setBedrooms(propertySet.getString("bedrooms"));
                bean.setBathrooms(propertySet.getString("bathrooms"));
                bean.setArea(propertySet.getString("area"));
                bean.setPrice(propertySet.getString("price"));
                bean.setContractType(propertySet.getString("contract_type"));
                bean.setQuality(propertySet.getString("quality_type"));
                bean.setPostDate(propertySet.getString("post_date"));
                bean.setDescription(propertySet.getString("description"));
                bean.setStatus(propertySet.getString("status"));
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return bean;
    }

    @SuppressWarnings("unchecked")
    public JSONObject getPropertyViaId(String propertyId)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONObject jsonObject = new JSONObject();
        String query = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status,"
                + " amenities_info.id, amenities_info.ac, amenities_info.coffee, amenities_info.heating, amenities_info.parking, "
                + " amenities_info.balcony, amenities_info.internet, amenities_info.pool, amenities_info.bedding, "
                + " amenities_info.fridge, amenities_info.microwave, amenities_info.cable, amenities_info.oven "
                + " FROM property_info JOIN amenities_info ON "
                + " property_info.prop_id = amenities_info.prop_id AND property_info.prop_id = ?";
        try {
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, propertyId);
            propertySet = statement.executeQuery();
            if (propertySet.next()) {
                jsonObject.put("prop_id", propertySet.getString("prop_id"));
                jsonObject.put("prop_title",
                        propertySet.getString("prop_title"));
                jsonObject.put("prop_type", propertySet.getString("prop_type"));
                jsonObject.put("owner_name",
                        propertySet.getString("owner_name"));
                jsonObject.put("location", propertySet.getString("location"));
                jsonObject.put("address", propertySet.getString("address"));
                jsonObject.put("pub_location",
                        propertySet.getString("pub_location"));
                jsonObject.put("dist_pub_location",
                        propertySet.getString("dist_pub_location"));
                jsonObject.put("bedrooms", propertySet.getString("bedrooms"));
                jsonObject.put("bathrooms", propertySet.getString("bathrooms"));
                jsonObject.put("area", propertySet.getString("area"));
                jsonObject.put("price", propertySet.getString("price"));
                jsonObject.put("contract_type",
                        propertySet.getString("contract_type"));
                jsonObject.put("quality_type",
                        propertySet.getString("quality_type"));
                jsonObject.put("post_date", propertySet.getString("post_date"));
                jsonObject.put("status", propertySet.getString("status"));
                jsonObject.put(
                        "image",
                        AppConstants.SEARCH_FOLDER + "/"
                        + AppConstants.PHOTO_ONE
                        + propertySet.getString("prop_id") + ".jpg");
                // ----Amenities----
                jsonObject.put("ac", propertySet.getString("ac"));
                jsonObject.put("coffee", propertySet.getString("coffee"));
                jsonObject.put("heating", propertySet.getString("heating"));
                jsonObject.put("parking", propertySet.getString("parking"));
                jsonObject.put("balcony", propertySet.getString("balcony"));
                jsonObject.put("internet", propertySet.getString("internet"));
                jsonObject.put("pool", propertySet.getString("pool"));
                jsonObject.put("bedding", propertySet.getString("bedding"));
                jsonObject.put("fridge", propertySet.getString("fridge"));
                jsonObject.put("cable", propertySet.getString("cable"));
                jsonObject.put("oven", propertySet.getString("oven"));
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return jsonObject;
    }

    @SuppressWarnings("unchecked")
    public JSONObject getPropertyViaUsername(String username)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONObject jsonObject = new JSONObject();
        String query = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status,"
                + " amenities_info.id, amenities_info.ac, amenities_info.coffee, amenities_info.heating, amenities_info.parking, "
                + " amenities_info.balcony, amenities_info.internet, amenities_info.pool, amenities_info.bedding, "
                + " amenities_info.fridge, amenities_info.microwave, amenities_info.cable, amenities_info.oven "
                + " FROM property_info JOIN amenities_info ON "
                + " property_info.prop_id = amenities_info.prop_id AND property_info.owner_name = ?";
        try {
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, username);
            propertySet = statement.executeQuery();
            if (propertySet.next()) {
                jsonObject.put("prop_id", propertySet.getString("prop_id"));
                jsonObject.put("prop_title",
                        propertySet.getString("prop_title"));
                jsonObject.put("prop_type", propertySet.getString("prop_type"));
                jsonObject.put("owner_name",
                        propertySet.getString("owner_name"));
                jsonObject.put("location", propertySet.getString("location"));
                jsonObject.put("address", propertySet.getString("address"));
                jsonObject.put("pub_location",
                        propertySet.getString("pub_location"));
                jsonObject.put("dist_pub_location",
                        propertySet.getString("dist_pub_location"));
                jsonObject.put("bedrooms", propertySet.getString("bedrooms"));
                jsonObject.put("bathrooms", propertySet.getString("bathrooms"));
                jsonObject.put("area", propertySet.getString("area"));
                jsonObject.put("price", propertySet.getString("price"));
                jsonObject.put("contract_type",
                        propertySet.getString("contract_type"));
                jsonObject.put("quality_type",
                        propertySet.getString("quality_type"));
                jsonObject.put("post_date", propertySet.getString("post_date"));
                jsonObject.put("status", propertySet.getString("status"));
                jsonObject.put(
                        "image",
                        AppConstants.SEARCH_FOLDER + "/"
                        + AppConstants.PHOTO_ONE
                        + propertySet.getString("prop_id") + ".jpg");
                // ----Amenities----
                jsonObject.put("ac", propertySet.getString("ac"));
                jsonObject.put("coffee", propertySet.getString("coffee"));
                jsonObject.put("heating", propertySet.getString("heating"));
                jsonObject.put("parking", propertySet.getString("parking"));
                jsonObject.put("balcony", propertySet.getString("balcony"));
                jsonObject.put("internet", propertySet.getString("internet"));
                jsonObject.put("pool", propertySet.getString("pool"));
                jsonObject.put("bedding", propertySet.getString("bedding"));
                jsonObject.put("fridge", propertySet.getString("fridge"));
                jsonObject.put("cable", propertySet.getString("cable"));
                jsonObject.put("oven", propertySet.getString("oven"));
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return jsonObject;
    }

    public JSONArray getForSaleInfo(PropertyBean bean) throws SQLException,
            ClassNotFoundException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONArray saleArray = new JSONArray();
        String searchQuery = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status,"
                + " amenities_info.id, amenities_info.ac, amenities_info.coffee, amenities_info.heating, amenities_info.parking, "
                + " amenities_info.balcony, amenities_info.internet, amenities_info.pool, amenities_info.bedding, "
                + " amenities_info.fridge, amenities_info.microwave, amenities_info.cable, amenities_info.oven "
                + " FROM property_info JOIN amenities_info ON "
                + " property_info.prop_id = amenities_info.prop_id AND property_info.contract_type = ?";

        StringBuilder condionsbBuilder = new StringBuilder();
        condionsbBuilder.append(" WHERE property_info.type = '").append(bean.getType()).append("'");
        if (!isAny(bean.getPropType())) {
            condionsbBuilder.append(" AND property_info.prop_type = '").append(bean.getPropType()).append("'");
        }
        if (!isAny(bean.getCity())) {
            condionsbBuilder.append(" AND property_info.city = '").append(bean.getCity()).append("'");
        }
        if (!isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price BETWEEN '").append(bean.getMinPrice()).append("' AND '").append(bean.getMaxPrice()).append("'");
        } else if (!isAny(bean.getMinPrice()) && isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMinPrice()).append("'");
        } else if (isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMaxPrice()).append("'");
        }
        if (!isAny(bean.getBedrooms())) {
            condionsbBuilder.append(" AND property_info.bedrooms = '").append(bean.getBedrooms()).append("'");
        }
        if (!isAny(bean.getBathrooms())) {
            condionsbBuilder.append(" AND property_info.bathrooms = '").append(bean.getBathrooms()).append("'");
        }
        if (!isAny(bean.getArea())) {
            condionsbBuilder.append(" AND property_info.area = '").append(bean.getArea()).append("'");
        }
        condionsbBuilder.append(" AND property_info.status = '").append(AppConstants.APPROVED).append("'");
        try {
            // System.out.println("Query: " + searchQuery +
            // condionsbBuilder.toString());
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(searchQuery
                    + condionsbBuilder.toString());
            statement.setString(1, AppConstants.FOR_SALE);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prop_id", propertySet.getString("prop_id"));
                jsonObject.put("prop_title",
                        propertySet.getString("prop_title"));
                jsonObject.put("prop_type", propertySet.getString("prop_type"));
                jsonObject.put("owner_name",
                        propertySet.getString("owner_name"));
                jsonObject.put("location", propertySet.getString("location"));
                jsonObject.put("address", propertySet.getString("address"));
                jsonObject.put("pub_location",
                        propertySet.getString("pub_location"));
                jsonObject.put("dist_pub_location",
                        propertySet.getString("dist_pub_location"));
                jsonObject.put("bedrooms", propertySet.getString("bedrooms"));
                jsonObject.put("bathrooms", propertySet.getString("bathrooms"));
                jsonObject.put("area", propertySet.getString("area"));
                jsonObject.put("price", propertySet.getString("price"));
                jsonObject.put("contract_type",
                        propertySet.getString("contract_type"));
                jsonObject.put("quality_type",
                        propertySet.getString("quality_type"));
                jsonObject.put("post_date", propertySet.getString("post_date"));
                jsonObject.put("status", propertySet.getString("status"));
                // ----Amenities----
                jsonObject.put("ac", propertySet.getString("ac"));
                jsonObject.put("coffee", propertySet.getString("coffee"));
                jsonObject.put("heating", propertySet.getString("heating"));
                jsonObject.put("parking", propertySet.getString("parking"));
                jsonObject.put("balcony", propertySet.getString("balcony"));
                jsonObject.put("internet", propertySet.getString("internet"));
                jsonObject.put("pool", propertySet.getString("pool"));
                jsonObject.put("bedding", propertySet.getString("bedding"));
                jsonObject.put("fridge", propertySet.getString("fridge"));
                jsonObject.put("cable", propertySet.getString("cable"));
                jsonObject.put("oven", propertySet.getString("oven"));
                saleArray.add(jsonObject);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return saleArray;

    }

    public JSONArray getPlotSaleInfo(PropertyBean bean) throws SQLException,
            ClassNotFoundException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONArray saleArray = new JSONArray();
        String searchQuery = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status "
                + " FROM property_info WHERE property_info.contract_type = ? ";

        StringBuilder condionsbBuilder = new StringBuilder();
        condionsbBuilder.append(" AND property_info.type = '").append(bean.getType()).append("'");
        if (!isAny(bean.getPropType())) {
            condionsbBuilder.append(" AND property_info.prop_type = '").append(bean.getPropType()).append("'");
        }
        if (!isAny(bean.getCity())) {
            condionsbBuilder.append(" AND property_info.city = '").append(bean.getCity()).append("'");
        }
        if (!isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price BETWEEN '").append(bean.getMinPrice()).append("' AND '").append(bean.getMaxPrice()).append("'");
        } else if (!isAny(bean.getMinPrice()) && isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMinPrice()).append("'");
        } else if (isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMaxPrice()).append("'");
        }
        if (!isAny(bean.getArea())) {
            condionsbBuilder.append(" AND property_info.area = '").append(bean.getArea()).append("'");
        }
        condionsbBuilder.append(" AND property_info.status = '").append(AppConstants.APPROVED).append("'");
        try {
            // System.out.println("Query: " + searchQuery +
            // condionsbBuilder.toString());
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(searchQuery
                    + condionsbBuilder.toString());
            statement.setString(1, AppConstants.FOR_SALE);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prop_id", propertySet.getString("prop_id"));
                jsonObject.put("prop_title",
                        propertySet.getString("prop_title"));
                jsonObject.put("prop_type", propertySet.getString("prop_type"));
                jsonObject.put("owner_name",
                        propertySet.getString("owner_name"));
                jsonObject.put("location", propertySet.getString("location"));
                jsonObject.put("address", propertySet.getString("address"));
                jsonObject.put("pub_location",
                        propertySet.getString("pub_location"));
                jsonObject.put("dist_pub_location",
                        propertySet.getString("dist_pub_location"));
                jsonObject.put("bedrooms", propertySet.getString("bedrooms"));
                jsonObject.put("bathrooms", propertySet.getString("bathrooms"));
                jsonObject.put("area", propertySet.getString("area"));
                jsonObject.put("price", propertySet.getString("price"));
                jsonObject.put("contract_type",
                        propertySet.getString("contract_type"));
                jsonObject.put("quality_type",
                        propertySet.getString("quality_type"));
                jsonObject.put("post_date", propertySet.getString("post_date"));
                jsonObject.put("status", propertySet.getString("status"));
                // ----Amenities----

                saleArray.add(jsonObject);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return saleArray;

    }

    public JSONArray getDefaultInfo(PropertyBean bean) throws SQLException,
            ClassNotFoundException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONArray rentArray = new JSONArray();
        String searchQuery = "";
        StringBuilder condionsbBuilder = new StringBuilder();
        if (bean.getType().equals(AppConstants.BUILDING)) {
            searchQuery = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                    + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                    + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                    + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                    + " property_info.proof_id, property_info.status,"
                    + " amenities_info.id, amenities_info.ac, amenities_info.coffee, amenities_info.heating, amenities_info.parking, "
                    + " amenities_info.balcony, amenities_info.internet, amenities_info.pool, amenities_info.bedding, "
                    + " amenities_info.fridge, amenities_info.microwave, amenities_info.cable, amenities_info.oven "
                    + " FROM property_info JOIN amenities_info ON "
                    + " property_info.prop_id = amenities_info.prop_id";

            condionsbBuilder.append(" WHERE property_info.type = '").append(bean.getType()).append("'");
            if (!isAny(bean.getPropType())) {
                condionsbBuilder.append(" AND property_info.prop_type = '").append(bean.getPropType()).append("'");
            }
            if (!isAny(bean.getCity())) {
                condionsbBuilder.append(" AND property_info.city = '").append(bean.getCity()).append("'");
            }
            if (!isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
                condionsbBuilder.append(" AND property_info.price BETWEEN '").append(bean.getMinPrice()).append("' AND '").append(bean.getMaxPrice()).append("'");
            } else if (!isAny(bean.getMinPrice()) && isAny(bean.getMaxPrice())) {
                condionsbBuilder.append(" AND property_info.price = '").append(bean.getMinPrice()).append("'");
            } else if (isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
                condionsbBuilder.append(" AND property_info.price = '").append(bean.getMaxPrice()).append("'");
            }
            if (!isAny(bean.getBedrooms())) {
                condionsbBuilder.append(" AND property_info.bedrooms = '").append(bean.getBedrooms()).append("'");
            }
            if (!isAny(bean.getBathrooms())) {
                condionsbBuilder.append(" AND property_info.bathrooms = '").append(bean.getBathrooms()).append("'");
            }
            if (!isAny(bean.getArea())) {
                condionsbBuilder.append(" AND property_info.area = '").append(bean.getArea()).append("'");
            }
            condionsbBuilder.append(" AND property_info.status = '").append(AppConstants.APPROVED).append("'");
        } else if (bean.getType().equals(AppConstants.PLOT)) {
            searchQuery = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                    + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                    + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                    + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                    + " property_info.proof_id, property_info.status "
                    + " FROM property_info ";
            condionsbBuilder.append(" WHERE property_info.type = '").append(bean.getType()).append("'");
            if (!isAny(bean.getPropType())) {
                condionsbBuilder.append(" AND property_info.prop_type = '").append(bean.getPropType()).append("'");
            }
            if (!isAny(bean.getCity())) {
                condionsbBuilder.append(" AND property_info.city = '").append(bean.getCity()).append("'");
            }
            if (!isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
                condionsbBuilder.append(" AND property_info.price BETWEEN '").append(bean.getMinPrice()).append("' AND '").append(bean.getMaxPrice()).append("'");
            } else if (!isAny(bean.getMinPrice()) && isAny(bean.getMaxPrice())) {
                condionsbBuilder.append(" AND property_info.price = '").append(bean.getMinPrice()).append("'");
            } else if (isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
                condionsbBuilder.append(" AND property_info.price = '").append(bean.getMaxPrice()).append("'");
            }
            if (!isAny(bean.getArea())) {
                condionsbBuilder.append(" AND property_info.area = '").append(bean.getArea()).append("'");
            }
            condionsbBuilder.append(" AND property_info.status = '").append(AppConstants.APPROVED).append("'");

        }

        try {
//             System.out.println("Query: " + searchQuery +
//             condionsbBuilder.toString());
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(searchQuery
                    + condionsbBuilder.toString());
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prop_id", propertySet.getString("prop_id"));
                jsonObject.put("prop_title",
                        propertySet.getString("prop_title"));
                jsonObject.put("prop_type", propertySet.getString("prop_type"));
                jsonObject.put("owner_name",
                        propertySet.getString("owner_name"));
                jsonObject.put("location", propertySet.getString("location"));
                jsonObject.put("address", propertySet.getString("address"));
                jsonObject.put("pub_location",
                        propertySet.getString("pub_location"));
                jsonObject.put("dist_pub_location",
                        propertySet.getString("dist_pub_location"));
                jsonObject.put("bedrooms", propertySet.getString("bedrooms"));
                jsonObject.put("bathrooms", propertySet.getString("bathrooms"));
                jsonObject.put("area", propertySet.getString("area"));
                jsonObject.put("price", propertySet.getString("price"));
                jsonObject.put("contract_type",
                        propertySet.getString("contract_type"));
                jsonObject.put("quality_type",
                        propertySet.getString("quality_type"));
                jsonObject.put("post_date", propertySet.getString("post_date"));
                jsonObject.put("status", propertySet.getString("status"));
                // ----Amenities----
//                jsonObject.put("ac", propertySet.getString("ac"));
//                jsonObject.put("coffee", propertySet.getString("coffee"));
//                jsonObject.put("heating", propertySet.getString("heating"));
//                jsonObject.put("parking", propertySet.getString("parking"));
//                jsonObject.put("balcony", propertySet.getString("balcony"));
//                jsonObject.put("internet", propertySet.getString("internet"));
//                jsonObject.put("pool", propertySet.getString("pool"));
//                jsonObject.put("bedding", propertySet.getString("bedding"));
//                jsonObject.put("fridge", propertySet.getString("fridge"));
//                jsonObject.put("cable", propertySet.getString("cable"));
//                jsonObject.put("oven", propertySet.getString("oven"));
                rentArray.add(jsonObject);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return rentArray;
    }

    public JSONArray getMapInfo() throws SQLException, ClassNotFoundException,
            IOException, ParseException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;

        JSONArray rentArray = new JSONArray();
        String searchQuery = " SELECT prop_id, prop_title, location, address FROM property_info WHERE status = ?";
        try {
            // System.out.println("Query: " + searchQuery +
            // condionsbBuilder.toString());
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(searchQuery);
            statement.setString(1, AppConstants.APPROVED);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONArray childArray = new JSONArray();
                childArray.add(propertySet.getString("prop_id"));
                childArray.add(propertySet.getString("prop_title"));
                childArray.add(propertySet.getString("address"));
                //    childArray.add(coder.getAddress(propertySet.getString("location")));
                String formatedText = propertySet.getString("location").trim().replaceAll(" ", "+");
                childArray.add(GeoLocation.getLatLang(formatedText));
                rentArray.add(childArray);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return rentArray;
    }

    public JSONArray getMapInfo(PropertyBean bean) throws SQLException,
            ClassNotFoundException, IOException, ParseException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;

        JSONArray completeData = new JSONArray();
        String searchQuery = " SELECT prop_id, prop_title, location, address FROM property_info WHERE status = ?";
        StringBuilder condionsbBuilder = new StringBuilder();
        if (!isAny(bean.getPropType())) {
            condionsbBuilder.append(" AND property_info.prop_type = '").append(bean.getPropType()).append("'");
        }
        if (!isAny(bean.getCity())) {
            condionsbBuilder.append(" AND property_info.city = '").append(bean.getCity()).append("'");
        }
        if (!isAny(bean.getPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMaxPrice()).append("'");
        }
        if (!isAny(bean.getBedrooms())) {
            condionsbBuilder.append(" AND property_info.bedrooms = '").append(bean.getBedrooms()).append("'");
        }
        if (!isAny(bean.getBathrooms())) {
            condionsbBuilder.append(" AND property_info.bathrooms = '").append(bean.getBathrooms()).append("'");
        }
        if (!isAny(bean.getArea())) {
            condionsbBuilder.append(" AND property_info.area = '").append(bean.getArea()).append("'");
        }
        if (!bean.getContractType().equals(AppConstants.ALL)) {
            condionsbBuilder.append(" AND property_info.contract_type = '").append(bean.getContractType()).append("'");
        }
        try {
            // System.out.println("Query: " + searchQuery +
            // condionsbBuilder.toString());
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(searchQuery
                    + condionsbBuilder.toString());
            statement.setString(1, AppConstants.APPROVED);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONArray childArray = new JSONArray();
                childArray.add(propertySet.getString("prop_id"));
                childArray.add(propertySet.getString("prop_title"));
                childArray.add(propertySet.getString("address"));
                // childArray.add(coder.getAddress(propertySet.getString("location")));
                String formatedText = propertySet.getString("location").trim().replaceAll(" ", "+");
                childArray.add(GeoLocation.getLatLang(formatedText));
                completeData.add(childArray);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return completeData;
    }

    public JSONArray getForRentInfo(PropertyBean bean) throws SQLException,
            ClassNotFoundException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONArray rentArray = new JSONArray();
        String searchQuery = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status,"
                + " amenities_info.id, amenities_info.ac, amenities_info.coffee, amenities_info.heating, amenities_info.parking, "
                + " amenities_info.balcony, amenities_info.internet, amenities_info.pool, amenities_info.bedding, "
                + " amenities_info.fridge, amenities_info.microwave, amenities_info.cable, amenities_info.oven "
                + " FROM property_info JOIN amenities_info ON "
                + " property_info.prop_id = amenities_info.prop_id AND property_info.contract_type = ?";

        StringBuilder condionsbBuilder = new StringBuilder();
        condionsbBuilder.append(" WHERE property_info.type = '").append(bean.getType()).append("'");
        if (!isAny(bean.getPropType())) {
            condionsbBuilder.append(" AND property_info.prop_type = '").append(bean.getPropType()).append("'");
        }
        if (!isAny(bean.getCity())) {
            condionsbBuilder.append(" AND property_info.city = '").append(bean.getCity()).append("'");
        }
        if (!isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price BETWEEN '").append(bean.getMinPrice()).append("' AND '").append(bean.getMaxPrice()).append("'");
        } else if (!isAny(bean.getMinPrice()) && isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMinPrice()).append("'");
        } else if (isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMaxPrice()).append("'");
        }
        if (!isAny(bean.getBedrooms())) {
            condionsbBuilder.append(" AND property_info.bedrooms = '").append(bean.getBedrooms()).append("'");
        }
        if (!isAny(bean.getBathrooms())) {
            condionsbBuilder.append(" AND property_info.bathrooms = '").append(bean.getBathrooms()).append("'");
        }
        if (!isAny(bean.getArea())) {
            condionsbBuilder.append(" AND property_info.area = '").append(bean.getArea()).append("'");
        }
        condionsbBuilder.append("AND property_info.status = '").append(AppConstants.APPROVED).append("'");
        try {
            // System.out.println("Query: " + searchQuery +
            // condionsbBuilder.toString());
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(searchQuery
                    + condionsbBuilder.toString());
            statement.setString(1, AppConstants.FOR_RENT);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prop_id", propertySet.getString("prop_id"));
                jsonObject.put("prop_title",
                        propertySet.getString("prop_title"));
                jsonObject.put("prop_type", propertySet.getString("prop_type"));
                jsonObject.put("owner_name",
                        propertySet.getString("owner_name"));
                jsonObject.put("location", propertySet.getString("location"));
                jsonObject.put("address", propertySet.getString("address"));
                jsonObject.put("pub_location",
                        propertySet.getString("pub_location"));
                jsonObject.put("dist_pub_location",
                        propertySet.getString("dist_pub_location"));
                jsonObject.put("bedrooms", propertySet.getString("bedrooms"));
                jsonObject.put("bathrooms", propertySet.getString("bathrooms"));
                jsonObject.put("area", propertySet.getString("area"));
                jsonObject.put("price", propertySet.getString("price"));
                jsonObject.put("contract_type",
                        propertySet.getString("contract_type"));
                jsonObject.put("quality_type",
                        propertySet.getString("quality_type"));
                jsonObject.put("post_date", propertySet.getString("post_date"));
                jsonObject.put("status", propertySet.getString("status"));
                // ----Amenities----
                jsonObject.put("ac", propertySet.getString("ac"));
                jsonObject.put("coffee", propertySet.getString("coffee"));
                jsonObject.put("heating", propertySet.getString("heating"));
                jsonObject.put("parking", propertySet.getString("parking"));
                jsonObject.put("balcony", propertySet.getString("balcony"));
                jsonObject.put("internet", propertySet.getString("internet"));
                jsonObject.put("pool", propertySet.getString("pool"));
                jsonObject.put("bedding", propertySet.getString("bedding"));
                jsonObject.put("fridge", propertySet.getString("fridge"));
                jsonObject.put("cable", propertySet.getString("cable"));
                jsonObject.put("oven", propertySet.getString("oven"));
                rentArray.add(jsonObject);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return rentArray;

    }

    public JSONArray getPlotRentInfo(PropertyBean bean) throws SQLException,
            ClassNotFoundException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONArray rentArray = new JSONArray();
        String searchQuery = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status "
                + " FROM property_info WHERE property_info.contract_type = ?";

        StringBuilder condionsbBuilder = new StringBuilder();
        condionsbBuilder.append(" AND property_info.type = '").append(bean.getType()).append("'");
        if (!isAny(bean.getPropType())) {
            condionsbBuilder.append(" AND property_info.prop_type = '").append(bean.getPropType()).append("'");
        }
        if (!isAny(bean.getCity())) {
            condionsbBuilder.append(" AND property_info.city = '").append(bean.getCity()).append("'");
        }
        if (!isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price BETWEEN '").append(bean.getMinPrice()).append("' AND '").append(bean.getMaxPrice()).append("'");
        } else if (!isAny(bean.getMinPrice()) && isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMinPrice()).append("'");
        } else if (isAny(bean.getMinPrice()) && !isAny(bean.getMaxPrice())) {
            condionsbBuilder.append(" AND property_info.price = '").append(bean.getMaxPrice()).append("'");
        }

        if (!isAny(bean.getArea())) {
            condionsbBuilder.append(" AND property_info.area = '").append(bean.getArea()).append("'");
        }
        condionsbBuilder.append("AND property_info.status = '").append(AppConstants.APPROVED).append("'");
        try {
            // System.out.println("Query: " + searchQuery +
            // condionsbBuilder.toString());
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(searchQuery
                    + condionsbBuilder.toString());
            statement.setString(1, AppConstants.FOR_RENT);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prop_id", propertySet.getString("prop_id"));
                jsonObject.put("prop_title",
                        propertySet.getString("prop_title"));
                jsonObject.put("prop_type", propertySet.getString("prop_type"));
                jsonObject.put("owner_name",
                        propertySet.getString("owner_name"));
                jsonObject.put("location", propertySet.getString("location"));
                jsonObject.put("address", propertySet.getString("address"));
                jsonObject.put("pub_location",
                        propertySet.getString("pub_location"));
                jsonObject.put("dist_pub_location",
                        propertySet.getString("dist_pub_location"));
                jsonObject.put("bedrooms", propertySet.getString("bedrooms"));
                jsonObject.put("bathrooms", propertySet.getString("bathrooms"));
                jsonObject.put("area", propertySet.getString("area"));
                jsonObject.put("price", propertySet.getString("price"));
                jsonObject.put("contract_type",
                        propertySet.getString("contract_type"));
                jsonObject.put("quality_type",
                        propertySet.getString("quality_type"));
                jsonObject.put("post_date", propertySet.getString("post_date"));
                jsonObject.put("status", propertySet.getString("status"));
                // ----Amenities----

                rentArray.add(jsonObject);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return rentArray;

    }

    @SuppressWarnings("unchecked")
    public JSONArray getPropertyForUser(JSONObject jsonData)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONArray rentArray = new JSONArray();
        String searchQuery = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.bedrooms, property_info.bathrooms, property_info.area, property_info.price, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status,"
                + " amenities_info.id, amenities_info.ac, amenities_info.coffee, amenities_info.heating, amenities_info.parking, "
                + " amenities_info.balcony, amenities_info.internet, amenities_info.pool, amenities_info.bedding, "
                + " amenities_info.fridge, amenities_info.microwave, amenities_info.cable, amenities_info.oven "
                + " FROM property_info JOIN amenities_info ON "
                + " property_info.prop_id = amenities_info.prop_id  WHERE ";

        StringBuilder condionsbBuilder = new StringBuilder();
        JSONArray propArray = (JSONArray) jsonData.get("property_type");
        String propType = "";
        if (propArray.size() > 1) {
            condionsbBuilder.append("(");
        }
        for (Object obj : propArray) {
            propType = obj.toString();
            if (!obj.toString().equals(AppConstants.ANY)) {
                condionsbBuilder.append(" property_info.prop_type =  '").append(obj.toString()).append("' OR ");
            }
        }
        if (condionsbBuilder.toString().trim().lastIndexOf("OR") > -1) {
            condionsbBuilder.delete(condionsbBuilder.lastIndexOf("OR"),
                    condionsbBuilder.length());
            // condionsbBuilder.append(")");
        }
        if (propArray.size() > 1) {
            condionsbBuilder.append(")");
        }
        if (!propType.equals(AppConstants.ANY)) {
            condionsbBuilder.append(" AND ");
        }
        if (!isAny(jsonData.get("city").toString())) {
            condionsbBuilder.append(" property_info.city = '").append(jsonData.get("city").toString()).append("' AND ");
        }

        if (!isAny(jsonData.get("max_amount").toString())) {
            condionsbBuilder.append(" property_info.price BETWEEN '").append(AppConstants.MIN_PRICE).append("' AND '").append(jsonData.get("max_amount").toString()).append("' AND ");
        }
        if (!isAny(jsonData.get("no_of_bedrooms").toString())) {
            condionsbBuilder.append(" property_info.bedrooms = '").append(jsonData.get("no_of_bedrooms").toString()).append("' AND ");
        }

        if (!isAny(jsonData.get("contract_type").toString())) {
            condionsbBuilder.append(" property_info.contract_type = '").append(jsonData.get("contract_type").toString()).append("' AND ");
        }
        condionsbBuilder.append(" property_info.status = '").append(AppConstants.APPROVED).append("' AND "
                + " property_info.type = '").append(jsonData.get("type").toString()).append("'");
        try {
            System.out.println("Query: " + searchQuery
                    + condionsbBuilder.toString());
            con = new DbConnection().getConnection();

            statement = con.prepareStatement(searchQuery
                    + condionsbBuilder.toString());
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("prop_id", propertySet.getString("prop_id"));
                jsonObject.put("prop_title",
                        propertySet.getString("prop_title"));
                jsonObject.put("prop_type", propertySet.getString("prop_type"));
                jsonObject.put("owner_name",
                        propertySet.getString("owner_name"));
                jsonObject.put("location", propertySet.getString("location"));
                jsonObject.put("address", propertySet.getString("address"));
                jsonObject.put("pub_location",
                        propertySet.getString("pub_location"));
                jsonObject.put("dist_pub_location",
                        propertySet.getString("dist_pub_location"));
                jsonObject.put("bedrooms", propertySet.getString("bedrooms"));
                jsonObject.put("bathrooms", propertySet.getString("bathrooms"));
                jsonObject.put("area", propertySet.getString("area"));
                jsonObject.put("price", propertySet.getString("price"));
                jsonObject.put("contract_type",
                        propertySet.getString("contract_type"));
                jsonObject.put("quality_type",
                        propertySet.getString("quality_type"));
                jsonObject.put("post_date", propertySet.getString("post_date"));
                jsonObject.put("image",
                        AppConstants.SEARCH_FOLDER + "/"
                        + AppConstants.PHOTO_ONE
                        + propertySet.getString("prop_id")
                        + ".jpg");
                jsonObject.put("status", propertySet.getString("status"));
                // ----Amenities----
                jsonObject.put("ac", propertySet.getString("ac"));
                jsonObject.put("coffee", propertySet.getString("coffee"));
                jsonObject.put("heating", propertySet.getString("heating"));
                jsonObject.put("parking", propertySet.getString("parking"));
                jsonObject.put("balcony", propertySet.getString("balcony"));
                jsonObject.put("internet", propertySet.getString("internet"));
                jsonObject.put("pool", propertySet.getString("pool"));
                jsonObject.put("bedding", propertySet.getString("bedding"));
                jsonObject.put("fridge", propertySet.getString("fridge"));
                jsonObject.put("cable", propertySet.getString("cable"));
                jsonObject.put("oven", propertySet.getString("oven"));
                rentArray.add(jsonObject);
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return rentArray;

    }

    @SuppressWarnings("unchecked")
    public JSONArray getPlotForUser(JSONObject jsonData)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONArray resultArray = new JSONArray();
        String searchQuery = " SELECT property_info.prop_id, property_info.prop_title, property_info.prop_type, property_info.owner_name, property_info.city,"
                + " property_info.location, property_info.address, property_info.pub_location, property_info.dist_pub_location, "
                + " property_info.area, property_info.price, property_info.description, "
                + " property_info.contract_type, property_info.quality_type, property_info.post_date, property_info.proof_type, "
                + " property_info.proof_id, property_info.status FROM property_info WHERE ";
        StringBuilder condionsbBuilder = new StringBuilder();
        JSONArray propArray = (JSONArray) jsonData.get("property_type");
        String propType = "";
        if (propArray.size() > 1) {
            condionsbBuilder.append("(");
        }
        for (Object obj : propArray) {
            propType = obj.toString();
            if (!obj.toString().equals(AppConstants.ANY)) {
                condionsbBuilder.append(" property_info.prop_type =  '").append(obj.toString()).append("' OR ");
            }
        }
        if (condionsbBuilder.toString().trim().lastIndexOf("OR") > -1) {
            condionsbBuilder.delete(condionsbBuilder.lastIndexOf("OR"),
                    condionsbBuilder.length());
            // condionsbBuilder.append(")");
        }
        if (propArray.size() > 1) {
            condionsbBuilder.append(")");
        }
        if (!propType.equals(AppConstants.ANY)) {
            condionsbBuilder.append(" AND ");
        }
        if (!isAny(jsonData.get("city").toString())) {
            condionsbBuilder.append(" property_info.city = '").append(jsonData.get("city").toString()).append("' AND ");
        }

        if (!isAny(jsonData.get("max_amount").toString())) {
            condionsbBuilder.append(" property_info.price BETWEEN '").append(AppConstants.MIN_PRICE).append("' AND '").append(jsonData.get("max_amount").toString()).append("' AND ");
        }

        if (!isAny(jsonData.get("contract_type").toString())) {
            condionsbBuilder.append(" property_info.contract_type = '").append(jsonData.get("contract_type").toString()).append("' AND ");
        }
        condionsbBuilder.append(" property_info.status = '").append(AppConstants.APPROVED).append("' AND "
                + " property_info.type = '").append(jsonData.get("type").toString()).append("'");
        try {
            System.out.println("Query: " + searchQuery
                    + condionsbBuilder.toString());
            con = new DbConnection().getConnection();

            statement = con.prepareStatement(searchQuery
                    + condionsbBuilder.toString());
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                boolean status = isBooked(propertySet.getString("prop_id"));
                if (!status) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("prop_id", propertySet.getString("prop_id"));
                    jsonObject.put("prop_title",
                            propertySet.getString("prop_title"));
                    jsonObject.put("prop_type",
                            propertySet.getString("prop_type"));
                    jsonObject.put("owner_name",
                            propertySet.getString("owner_name"));
                    jsonObject.put("location",
                            propertySet.getString("location"));
                    jsonObject.put("address", propertySet.getString("address"));
                    jsonObject.put("pub_location",
                            propertySet.getString("pub_location"));
                    jsonObject.put("dist_pub_location",
                            propertySet.getString("dist_pub_location"));
                    jsonObject.put("area", propertySet.getString("area"));
                    jsonObject.put("price", propertySet.getString("price"));
                    jsonObject.put("contract_type",
                            propertySet.getString("contract_type"));
                    jsonObject.put("quality_type",
                            propertySet.getString("quality_type"));
                    jsonObject.put("post_date",
                            propertySet.getString("post_date"));
                    jsonObject.put("description",
                            propertySet.getString("description"));
                    jsonObject.put("image",
                            AppConstants.SEARCH_FOLDER + "/"
                            + AppConstants.PHOTO_ONE
                            + propertySet.getString("prop_id")
                            + ".jpg");
                    jsonObject.put("status", propertySet.getString("status"));


                    resultArray.add(jsonObject);
                }
            }
        } finally {
            SupportMethods.CloseInstance(con, propertySet, statement);
        }
        return resultArray;
    }

    private boolean isAny(String value) {
        if (value.equals(AppConstants.ANY)) {
            return true;
        }
        return false;
    }

    private boolean isBooked(String propertyId) throws SQLException,
            ClassNotFoundException {
        PreparedStatement statement = null;
        ResultSet set = null;
        try {
            String sql = "SELECT status FROM booking_info WHERE prop_id = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, propertyId);
            set = statement.executeQuery();
            if (set.next()) {
                if (set.getString("status").equals(AppConstants.BOOKED)) {
                    return true;
                }
            }

        } finally {
            SupportMethods.CloseInstance(con, set, statement);
        }
        return false;
    }

    public JSONArray getJsonPropertyList() throws ClassNotFoundException, SQLException {
        String searchQuery = " SELECT prop_id, prop_title, prop_type, owner_name, city,location, address, pub_location, dist_pub_location, "
                + " bedrooms, bathrooms, area, price,contract_type, quality_type, post_date,proof_type, proof_id, description, status ,type "
                + " FROM property_info ";
        PreparedStatement statement = null;
        ResultSet propertySet = null;
        JSONArray completeArray = new JSONArray();
        try {
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(searchQuery);
            propertySet = statement.executeQuery();
            while (propertySet.next()) {
                JSONObject object = new JSONObject();
                object.put("prop_id", propertySet.getString("prop_id"));
                object.put("prop_title", propertySet.getString("prop_title"));
                object.put("prop_type", propertySet.getString("prop_type"));
                object.put("owner_name", propertySet.getString("owner_name"));
                object.put("city", propertySet.getString("city"));
                object.put("location", propertySet.getString("location"));
                object.put("address", propertySet.getString("address"));
                object.put("pub_location", propertySet.getString("pub_location"));
                object.put("dist_pub_location", propertySet.getString("dist_pub_location"));
                object.put("bedrooms", propertySet.getString("bedrooms"));
                object.put("bathrooms", propertySet.getString("bathrooms"));
                object.put("price", propertySet.getString("price"));
                object.put("area", propertySet.getString("area"));
                object.put("contract_type", propertySet.getString("contract_type"));
                object.put("quality_type", propertySet.getString("quality_type"));
                object.put("post_date", propertySet.getString("post_date"));
                object.put("proof_type", propertySet.getString("proof_type"));
                object.put("proof_id", propertySet.getString("proof_id"));
                object.put("description", propertySet.getString("description"));
                object.put("status", propertySet.getString("status"));
                object.put("type", propertySet.getString("type"));

                completeArray.add(object);
            }
        } finally {
            SupportMethods.CloseInstance(con, propertySet, statement);
        }
        return completeArray;
    }
}
