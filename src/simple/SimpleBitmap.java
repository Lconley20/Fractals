/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;
import java.awt.Color;

public class SimpleBitmap extends JPanel {

    private static final int BITMAP_WIDTH = 512;
    private static final int BITMAP_HEIGHT = 512;
    private BufferedImage image;

    public SimpleBitmap() {
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h , imageType);
    } // SimpleBitmap()
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int w = this.getWidth();
        int h = this.getHeight();
               
        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double)w) / BITMAP_WIDTH,
            ((double)h) / BITMAP_HEIGHT);

        WritableRaster raster = this.image.getRaster();
        
        int [][] palette = new int[64][3];
        
        Color startColor = Color.RED;
        int r0 = startColor.getRed();
        int g0 = startColor.getGreen();
        int b0 = startColor.getBlue();
        
        Color endColor = Color.BLUE;
        int r1 = endColor.getRed();
        int g1 = endColor.getGreen();
        int b1 = endColor.getBlue();
        
        for( int i = 0; i < 64; i++ ) {
//            double fraction = ((double) i) / 63;
//            int red = (int) ((1 - fraction) * r0 + fraction * r1);
//            int green = (int) ((1 - fraction) * g0 + fraction * g1);
//            int blue = (int) ((1 - fraction) * b0 + fraction * b1);
            
            palette[i][0] = (int) (256 * Math.random()); //red;
            palette[i][1] = (int) (256 * Math.random()); //green;
            palette[i][2] = (int) (256 * Math.random()); //blue;            
        } // for
        

        int[] black = {0, 0, 0};
        int[] green = {0, 255, 0};

        double xMin = 0;
        double xMax = BITMAP_WIDTH - 1;
        double yMin = 0;
        double yMax = BITMAP_HEIGHT - 1;
        
        double uMin =  0.25;
        double uMax =  0.50;
        double vMin =  0.25;
        double vMax =  0.50;
        
        for(int row = 0; row < BITMAP_HEIGHT; row++) {
            double y = row;
            for(int column = 0; column < BITMAP_WIDTH; column++) {
                double x = column;
                
                double u = uMin + (uMax - uMin) * (x - xMin)/(xMax - xMin);
                double v = vMin + (vMax - vMin) * (y - yMin)/(yMax - yMin);
                
                Complex comp1 = new Complex( 0.0, 0.0 );
                Complex comp2 = new Complex( u, v );
                
                int count = 0;
                
                while(comp1.sqrMagComplex() < 4.0 && count < 64) {
                    // comp1 = comp1^2 + c
                    comp1 = comp1.multComplex(comp1);
                    comp1 = comp1.addComplex(comp2);
                    count++;
                } // while
                
                if(count == 64) {
                    raster.setPixel(row, column, green);
                } // if
                else {
                    raster.setPixel(row, column, palette[count]);
                } // else
                          
//                if( row < column ) {
//                    raster.setPixel( row, column, yellow );
//                } // if
//                else {
//                    raster.setPixel( row, column, blue);
//                } // else
            } // for
        } // for
        
        g2d.drawImage(image, scale, this);

    } //paintComponent(Graphics)
} //SimpleBitmap