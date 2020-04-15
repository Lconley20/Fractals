/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple ;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Simple extends JFrame {
    
    private static final int SIMPLE_WIDTH = 512;
    private static final int SIMPLE_HEIGHT = 512;
    private static final String SIMPLE_TITLE = "Simple";

    public Simple() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIMPLE_WIDTH, SIMPLE_HEIGHT);
        this.setTitle(SIMPLE_TITLE);

        Container pane = this.getContentPane();

//      JPanel panel = new JPanel();
//      panel.setBackground( Color.CYAN);
//      pane.add(panel);

//      SimplePicturepanel = newSimplePicture();
//      pane.add(panel);

//      SimpleBitmappanel = newSimpleBitmap();
//      pane.add(panel);

//      SimpleImagepanel = newSimpleImage();
//      pane.add(panel);

//      SimpleAnimationpanel = newSimpleAnimation();
//      pane.add(panel);
//      Timer timer = new Timer(20, panel);
//      timer.start();

        this.setVisible(true);
    } // Simple()

    public static void main(String[] args) {
        Simple simple = new Simple();
    } // main ( S t r i n g [ ] )
} // S imple
