/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opr.image;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 *
 * @author SUJITH
 */
public class ImageResizer {

    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);

        // writes to output file
        File outputDir = new File(outputImagePath);
        if(!outputDir.getParentFile().exists()){
            outputDir.mkdirs();
        }
      //  ImageIO.write(outputImage, formatName, new File(outputImagePath));
        ImageIO.write(outputImage, formatName, outputDir);
    }

    /**
     * Resizes an image by a percentage of original size (proportional).
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param percent a double number specifies percentage of the output image
     * over the input image.
     * @throws IOException
     */
    public static void resize(String inputImagePath,
            String outputImagePath, double percent) throws IOException {
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
        int scaledWidth = (int) (inputImage.getWidth() * percent);
        int scaledHeight = (int) (inputImage.getHeight() * percent);
        resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
    }

    /**
     * Test resizing images
     */
    public static void main(String[] args) {
        //String inputImagePath = "D:/Photo/Puppy.jpg";
        String inputImagePath = "C:\\Users\\SUJITH\\Desktop\\OPR Image\\new\\apartment.jpg";
        String outputImagePath1 = "D:/Photo/apartment1.jpg";
        String outputImagePath2 = "D:/Photo/apartment2.jpg";
        String outputImagePath3 = "D:/Photo/apartment3.jpg";

        try {
            // resize to a fixed width (not proportional)
            int scaledWidth = 1600;
            int scaledHeight = 670;
            ImageResizer.resize(inputImagePath, outputImagePath1, scaledWidth, scaledHeight);

            // resize smaller by 50%
            double percent = 0.5;
            ImageResizer.resize(inputImagePath, outputImagePath2, percent);

            // resize bigger by 50%
            percent = 1.5;
            ImageResizer.resize(inputImagePath, outputImagePath3, percent);

        } catch (IOException ex) {
            System.out.println("Error resizing the image.");
            ex.printStackTrace();
        }
    }
}
