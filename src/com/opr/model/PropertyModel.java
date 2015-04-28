package com.opr.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.opr.bean.PropertyBean;
import com.opr.map.TextGeolocation;
import com.opr.utils.AppConstants;
import com.opr.utils.SupportMethods;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

public class PropertyModel {

    Connection con = null;

    @SuppressWarnings("resource")
    public String addPropertyInfo(PropertyBean bean)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        try {
            String propQuery = "INSERT INTO property_info(prop_id,prop_title, prop_type, owner_name, city, location, "
                    + "address, pub_location, dist_pub_location, bedrooms, bathrooms, area, price, "
                    + "contract_type, quality_type, post_date, proof_type, proof_id,status,type,description) VALUES(?,?,?,?,?,?,"
                    + " ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            con = new DbConnection().getConnection();
            statement = con.prepareStatement(propQuery);
            statement.setString(1, bean.getPropertyId());
            statement.setString(2, bean.getPropTitle());
            statement.setString(3, bean.getPropType());
            statement.setString(4, bean.getUsername());
            statement.setString(5, bean.getCity());
            statement.setString(6, bean.getLocation());
            statement.setString(7, bean.getAddress());
            statement.setString(8, bean.getPublicLocaton());
            statement.setString(9, bean.getDistance());
            statement.setString(10, bean.getBedrooms());
            statement.setString(11, bean.getBathrooms());
            statement.setString(12, bean.getArea());
            statement.setString(13, bean.getPrice());
            statement.setString(14, bean.getContractType());
            statement.setString(15, AppConstants.QUALITY);
            statement.setString(16, SupportMethods.getSystemDate());
            statement.setString(17, bean.getProofType());
            statement.setString(18, bean.getProofId());
            statement.setString(19, bean.getStatus());
            statement.setString(20, bean.getType());
            statement.setString(21, bean.getDescription());
            int propUpdate = statement.executeUpdate();
            if (propUpdate > 0) {
                String amenityQuery = "INSERT INTO amenities_info(prop_id, ac, coffee, heating, parking, balcony, "
                        + "  internet, pool, bedding, fridge, microwave,cable, oven) "
                        + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                con = new DbConnection().getConnection();
                statement = con.prepareStatement(amenityQuery);
                statement.setString(1, bean.getPropertyId());
                statement.setString(2, bean.getAc());
                statement.setString(3, bean.getCoffee());
                statement.setString(4, bean.getHeating());
                statement.setString(5, bean.getParking());
                statement.setString(6, bean.getBalcony());
                statement.setString(7, bean.getInternet());
                statement.setString(8, bean.getPool());
                statement.setString(9, bean.getBedding());
                statement.setString(10, bean.getFridge());
                statement.setString(11, bean.getMicrowave());
                statement.setString(12, bean.getCable());
                statement.setString(13, bean.getOven());
                int amenitiesUpadate = statement.executeUpdate();
                if (amenitiesUpadate > 0) {
                    return AppConstants.TRUE;
                }
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return AppConstants.FALSE;
    }

    @SuppressWarnings("resource")
    public String addPlotInfo(PropertyBean bean)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        try {
            String propQuery = "INSERT INTO property_info(prop_id,prop_title, prop_type, owner_name, city, location, "
                    + "address, pub_location, dist_pub_location, bedrooms, bathrooms, area, price, "
                    + "contract_type, quality_type, post_date, proof_type, proof_id,status,type,description) VALUES(?,?,?,?,?,?,"
                    + " ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            con = new DbConnection().getConnection();
            statement = con.prepareStatement(propQuery);
            statement.setString(1, bean.getPropertyId());
            statement.setString(2, bean.getPropTitle());
            statement.setString(3, bean.getPropType());
            statement.setString(4, bean.getUsername());
            statement.setString(5, bean.getCity());
            statement.setString(6, bean.getLocation());
            statement.setString(7, bean.getAddress());
            statement.setString(8, bean.getPublicLocaton());
            statement.setString(9, bean.getDistance());
            statement.setString(10, bean.getBedrooms());
            statement.setString(11, bean.getBathrooms());
            statement.setString(12, bean.getArea());
            statement.setString(13, bean.getPrice());
            statement.setString(14, bean.getContractType());
            statement.setString(15, AppConstants.QUALITY);
            statement.setString(16, SupportMethods.getSystemDate());
            statement.setString(17, bean.getProofType());
            statement.setString(18, bean.getProofId());
            statement.setString(19, bean.getStatus());
            statement.setString(20, bean.getType());
            statement.setString(21, bean.getDescription());
            int propUpdate = statement.executeUpdate();
            if (propUpdate > 0) {
                return AppConstants.TRUE;
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return AppConstants.FALSE;
    }

    public boolean removePorty(String propId) throws ClassNotFoundException,
            SQLException {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM property_info WHERE prop_id = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, propId);
            int executeUpdate = statement.executeUpdate();
            if (executeUpdate > 0) {
                return true;
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return false;
    }

    public String updateGcmKey(String username, String gcmKey)
            throws ClassNotFoundException, SQLException {
        PreparedStatement statement = null;
        try {
            String uploadStmt = "UPDATE login_info SET gcm_key = ? WHERE username = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(uploadStmt);
            statement.setString(1, gcmKey);
            statement.setString(2, username);
            int executeUpdate = statement.executeUpdate();
            if (executeUpdate > 0) {
                return AppConstants.TRUE;
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return AppConstants.FALSE;
    }

    public String doBook(String propId, String username) throws SQLException,
            ClassNotFoundException {
        PreparedStatement statement = null;
        try {
            String uploadStmt = "INSERT INTO booking_info(prop_id, username, booking_date, status) VALUES(?,?,?,?)";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(uploadStmt);
            statement.setString(1, propId);
            statement.setString(2, username);
            statement.setString(3, SupportMethods.getSystemDate());
            statement.setString(4, AppConstants.BOOKED);
            int executeUpdate = statement.executeUpdate();
            if (executeUpdate > 0) {
                return AppConstants.TRUE;
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return AppConstants.FALSE;
    }

    public boolean acceptProperty(String propId) throws ClassNotFoundException,
            SQLException {
        PreparedStatement statement = null;
        try {
            String query = "UPDATE property_info SET status = ? WHERE prop_id = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, AppConstants.APPROVED);
            statement.setString(2, propId);
            int executeUpdate = statement.executeUpdate();
            if (executeUpdate > 0) {
                return true;
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return false;
    }

    public boolean remoBooking(String bookId) throws ClassNotFoundException,
            SQLException {
        PreparedStatement statement = null;
        try {
            String query = "DELETE FROM booking_info WHERE id = ?";
            con = new DbConnection().getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, bookId);
            int executeUpdate = statement.executeUpdate();
            if (executeUpdate > 0) {
                return true;
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return false;
    }

    //This method is called by user using their android app.
    public String addPropertyInfo(JSONObject propJson) throws SQLException, ClassNotFoundException, ParseException, IOException {
        PreparedStatement statement = null;
        String propertyId;
        try {
            String propSql = "INSERT INTO property_info(prop_id, prop_title, prop_type, owner_name, city, location, "
                    + "address, pub_location, dist_pub_location, bedrooms, bathrooms, area, price, "
                    + "contract_type, quality_type, post_date, proof_type, proof_id,status,type)"
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            String plotSql = "INSERT INTO property_info(prop_id,prop_title, prop_type, owner_name, city, location, "
                    + "address, pub_location, dist_pub_location,  area, price, "
                    + "contract_type, quality_type, post_date, proof_type, proof_id,status,type,description) "
                    + " VALUES(?,?,?,?,?,?,"
                    + " ?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            String amenitySql = "INSERT INTO amenities_info(prop_id, ac, coffee, heating, parking, balcony, "
                    + "  internet, pool, bedding, fridge, microwave,cable, oven) "
                    + " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            propertyId = new PasswordGenerator().getRandomNumber();
            con = new DbConnection().getConnection();
            if (propJson.get("type").equals(AppConstants.BUILDING)) {
                statement = con.prepareStatement(propSql);
                statement.setString(1, propertyId);
                statement.setString(2, propJson.get("prop_title").toString());
                statement.setString(3, propJson.get("prop_type").toString());
                statement.setString(4, propJson.get("owner_name").toString());
                statement.setString(5, propJson.get("city").toString());
                statement.setString(6,TextGeolocation.getTextLocation(propJson.get("location").toString().trim()));
                statement.setString(7, propJson.get("address").toString());
                statement.setString(8, propJson.get("pub_location").toString());
                statement.setString(9, propJson.get("dist_pub_location").toString());
                statement.setString(10, propJson.get("bedrooms").toString());
                statement.setString(11, propJson.get("bathrooms").toString());
                statement.setString(12, propJson.get("area").toString());
                statement.setString(13, propJson.get("price").toString());
                statement.setString(14, propJson.get("contract_type").toString());
                statement.setString(15, AppConstants.QUALITY);
                statement.setString(16, SupportMethods.getSystemDate());
                statement.setString(17, propJson.get("proof_type").toString());
                statement.setString(18, propJson.get("proof_id").toString());
                statement.setString(19, AppConstants.PENDING);
                statement.setString(20, AppConstants.BUILDING);
                int propValue = statement.executeUpdate();
                if (propValue > 0) {
                    con = new DbConnection().getConnection();
                    statement = con.prepareStatement(amenitySql);
                    JSONArray ameList = (JSONArray) propJson.get("amenities");
                    if (ameList.size() > 0) {
                        statement.setString(1, propertyId);
                        if (ameList.contains("ac")) {
                            statement.setString(2, AppConstants.IS_ON);
                        } else {
                            statement.setString(2, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("coffee")) {
                            statement.setString(3, AppConstants.IS_ON);
                        } else {
                            statement.setString(3, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("heating")) {
                            statement.setString(4, AppConstants.IS_ON);
                        } else {
                            statement.setString(4, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("parking")) {
                            statement.setString(5, AppConstants.IS_ON);
                        } else {
                            statement.setString(5, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("balcony")) {
                            statement.setString(6, AppConstants.IS_ON);
                        } else {
                            statement.setString(6, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("internet")) {
                            statement.setString(7, AppConstants.IS_ON);
                        } else {
                            statement.setString(7, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("pool")) {
                            statement.setString(8, AppConstants.IS_ON);
                        } else {
                            statement.setString(8, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("bedding")) {
                            statement.setString(9, AppConstants.IS_ON);
                        } else {
                            statement.setString(9, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("fridge")) {
                            statement.setString(10, AppConstants.IS_ON);
                        } else {
                            statement.setString(10, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("microwave")) {
                            statement.setString(11, AppConstants.IS_ON);
                        } else {
                            statement.setString(11, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("cable")) {
                            statement.setString(12, AppConstants.IS_ON);
                        } else {
                            statement.setString(12, AppConstants.IS_OFF);
                        }
                        if (ameList.contains("oven")) {
                            statement.setString(13, AppConstants.IS_ON);
                        } else {
                            statement.setString(13, AppConstants.IS_OFF);
                        }
                        int propVal = statement.executeUpdate();
                        if (propVal > 0) {
                            return propertyId;
                        }
                    }

                }
            } else if (propJson.get("type").equals(AppConstants.PLOT)) {
                con = new DbConnection().getConnection();
                statement = con.prepareStatement(plotSql);
                statement.setString(1, propertyId);
                statement.setString(2, propJson.get("prop_title").toString());
                statement.setString(3, propJson.get("prop_type").toString());
                statement.setString(4, propJson.get("owner_name").toString());
                statement.setString(5, propJson.get("city").toString());
                statement.setString(6, TextGeolocation.getTextLocation(propJson.get("location").toString().trim()));
                statement.setString(7, propJson.get("address").toString());
                statement.setString(8, propJson.get("pub_location").toString());
                statement.setString(9, propJson.get("dist_pub_location").toString());
                statement.setString(10, propJson.get("area").toString());
                statement.setString(11, propJson.get("price").toString());
                statement.setString(12, propJson.get("contract_type").toString());
                statement.setString(13, AppConstants.QUALITY);
                statement.setString(14, SupportMethods.getSystemDate());
                statement.setString(15, propJson.get("proof_type").toString());
                statement.setString(16, propJson.get("proof_id").toString());
                statement.setString(17, AppConstants.PENDING);
                statement.setString(18, AppConstants.PLOT);
                statement.setString(19, propJson.get("description").toString());
                int plotVal = statement.executeUpdate();
                if (plotVal > 0) {
                    return propertyId;
                }
            }
        } finally {
            SupportMethods.CloseInstance(con, statement);
        }
        return AppConstants.FAILED;
    }

    public String addPropertyInfos(org.json.JSONObject propertyJsons) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
