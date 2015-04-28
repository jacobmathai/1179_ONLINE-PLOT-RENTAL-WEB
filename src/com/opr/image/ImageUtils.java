/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.image;

import com.opr.utils.AppConstants;
import com.opr.utils.AppVariable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author SUJITH
 */
public class ImageUtils {

    static File realDir = new File(AppVariable.REAL_SERVLET_CONTEXT);
    static File navDir = new File(AppVariable.NAVIGATE_SERVLET_CONTEXT);
    static File searchDir = new File(AppVariable.SEARCH_SERVLET_CONTEXT);

    public static long copy(InputStream input, OutputStream output) throws IOException {
        byte[] buffer = new byte[4096];

        long count = 0L;
        int n = 0;

        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
            count += n;
        }
        return count;
    }

    public static void saveImage(String propertyId, File realImg, String photoNo) throws IOException {

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

    public static void saveAllImage(String propertyId, File realImg, String photoNo) throws IOException {

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
