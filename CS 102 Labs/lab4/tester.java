import java.awt.Color;
import java.util.Scanner;
import java.awt.*;

import javax.swing.JFrame;

/**
 * tester
 */
public class tester {

    

    public static void main(String[] args) {
        
    JFrame frame = new JFrame ("Stick Figure");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    Scanner in = new Scanner(System.in);

    System.out.print("Enter x: ");
    int xvalue = in.nextInt();
    System.out.print("Enter y: ");
    int yvalue = in.nextInt();
    System.out.print("Enter size: ");
    int size = in.nextInt();

    Buttons panel = new Buttons(xvalue,yvalue, Color.orange, size);

    frame.add(panel);
    frame.getContentPane().add(panel.getAllButtons(), BorderLayout.NORTH);    
    frame.pack();
    
    frame.setResizable(false);

    frame.setVisible(true);
    in.close();
    }
}
