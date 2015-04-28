/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.converter;

import com.opr.image.ImageResizer;
import com.opr.utils.AppConstants;
import com.opr.utils.AppVariable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.bind.DatatypeConverter;
import org.json.simple.JSONArray;

/**
 *
 * @author SUJITH
 */
public class ObjectConverter {

    static File realDir = new File(AppVariable.REAL_SERVLET_CONTEXT);
    static File navDir = new File(AppVariable.NAVIGATE_SERVLET_CONTEXT);
    static File searchDir = new File(AppVariable.SEARCH_SERVLET_CONTEXT);

    public static boolean parseVideo(byte[] videoBuffer, String propId) throws FileNotFoundException, IOException {
        FileOutputStream videoStreamFile = null;
        File videoFile = null;

        // File path = new File(AppVariable.Video_ServletContext + File.separator + userName);
        File path = new File(AppVariable.VIDEO_SERVLET_CONTEXT);
        if (!path.exists()) {
            path.mkdirs();
        }
        videoFile = new File(path + File.separator + propId + ".MP4");
        videoStreamFile = new FileOutputStream(videoFile);
        videoStreamFile.write(videoBuffer);
        videoStreamFile.close();

        return true;
    }

    public static boolean parseImage(JSONArray imageArray, String propId) throws IOException {
        byte[] imgBufferOne = null;
        byte[] imgBufferTwo = null;
        byte[] imgBufferThree = null;
        FileOutputStream imageStream = null;
        if (!realDir.exists()) {
            realDir.mkdirs();
        }

        if (!navDir.exists()) {
            navDir.mkdirs();
        }

        if (!searchDir.exists()) {
            searchDir.mkdirs();
        }

        if (imageArray.size() == 2) {
            imgBufferOne = DatatypeConverter.parseBase64Binary(imageArray.get(0).toString());
            imgBufferTwo = DatatypeConverter.parseBase64Binary(imageArray.get(1).toString());
            imgBufferThree = DatatypeConverter.parseBase64Binary(imageArray.get(2).toString());
        }

        //==============Write First/Real Image=============
        File realImg = new File(realDir + File.separator + AppConstants.PHOTO_ONE + propId + ".jpg");
        imageStream = new FileOutputStream(realImg);
        imageStream.write(imgBufferOne);
        imageStream.flush();
        imageStream.close();
        saveImage(propId, realImg, AppConstants.PHOTO_ONE);

        //==============Write Second Image=============
        File secondImg = new File(realDir + File.separator + AppConstants.PHOTO_TWO + propId + ".jpg");
        imageStream = new FileOutputStream(secondImg);
        imageStream.write(imgBufferTwo);
        imageStream.flush();
        imageStream.close();
        saveAllImage(propId, secondImg, AppConstants.PHOTO_TWO);

        //==============Write Third Image=============
        File thirdImg = new File(realDir + File.separator + AppConstants.PHOTO_THREE + propId + ".jpg");
        imageStream = new FileOutputStream(thirdImg);
        imageStream.write(imgBufferThree);
        imageStream.flush();
        imageStream.close();
        saveAllImage(propId, thirdImg, AppConstants.PHOTO_THREE);
        
        //==============Write Fourth Image=============
        File fourthImg = new File(realDir + File.separator + AppConstants.PHOTO_FOUR + propId + ".jpg");
        imageStream = new FileOutputStream(fourthImg);
        imageStream.write(imgBufferThree);
        imageStream.flush();
        imageStream.close();
        saveAllImage(propId, fourthImg, AppConstants.PHOTO_FOUR);

        return true;

    }

    private static void saveImage(String propertyId, File realImg, String photoNo) throws IOException {

        if (!navDir.exists()) {
            navDir.mkdirs();
        }
        if (!searchDir.exists()) {
            searchDir.mkdirs();
        }

        File navImg = new File(navDir
                + File.separator
                + photoNo
                + propertyId + ".jpg");

        File searchImg = new File(searchDir
                + File.separator
                + photoNo
                + propertyId + ".jpg");

        // Resize image to real image size
        ImageResizer.resize(
                realImg.getAbsolutePath(),
                realImg.getAbsolutePath(),
                AppConstants.REAL_IMG_WIDTH,
                AppConstants.REAL_IMG_HEIGHT);

        // Resize image to navigate image size
        ImageResizer.resize(realImg.getAbsolutePath(),
                navImg.getAbsolutePath(),
                AppConstants.NAVIGATE_IMG_WIDTH,
                AppConstants.NAVIGATE_IMG_HEIGHT);

        // Resize image to search image size
        ImageResizer.resize(realImg.getAbsolutePath(),
                searchImg.getAbsolutePath(),
                AppConstants.SEARCH_IMG_WIDTH,
                AppConstants.SEARCH_IMG_HEIGHT);

    }

    private static void saveAllImage(String propertyId, File realImg, String photoNo) throws IOException {

        if (!navDir.exists()) {
            navDir.mkdirs();
        }

        File navImg = new File(navDir
                + File.separator
                + photoNo
                + propertyId + ".jpg");



        // Resize image to real image size
        ImageResizer.resize(
                realImg.getAbsolutePath(),
                realImg.getAbsolutePath(),
                AppConstants.REAL_IMG_WIDTH,
                AppConstants.REAL_IMG_HEIGHT);

        // Resize image to navigate image size
        ImageResizer.resize(realImg.getAbsolutePath(),
                navImg.getAbsolutePath(),
                AppConstants.NAVIGATE_IMG_WIDTH,
                AppConstants.NAVIGATE_IMG_HEIGHT);
    }
}
