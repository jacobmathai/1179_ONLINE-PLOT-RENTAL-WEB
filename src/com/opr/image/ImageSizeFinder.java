/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author SUJITH
 */
public class ImageSizeFinder {

    public static void getImageSize(String fileName) throws IOException {
        BufferedImage bimg = ImageIO.read(new File(fileName));
        int width = bimg.getWidth();
        int height = bimg.getHeight();
        System.out.println("Height: " + height);
        System.out.println("Width: " + width);
    }
    public static void main(String[] args) {
        try {
            //String filePath = "C:\\Users\\SUJITH\\Desktop\\OPR Image\\OPR\\banner3.jpg"; // 670 - 1600 [Real Image]
            //String filePath = "C:\\Users\\SUJITH\\Desktop\\OPR Image\\OPR\\blog-thumb1.jpg"; // 112 - 113 [Navigate]
            String filePath = "C:\\Users\\SUJITH\\Desktop\\OPR Image\\OPR\\home1.jpg"; // 507 - 768  [Related Prop]
            getImageSize(filePath);
        } catch (IOException ex) {
            Logger.getLogger(ImageSizeFinder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
