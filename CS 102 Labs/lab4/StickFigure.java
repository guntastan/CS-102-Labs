import javax.swing.*;

import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;

public class StickFigure extends JPanel implements ActionListener{

   
    private  int BASEX;
    private int BASEY; // base point for head   
    protected Timer timer;     
    protected int velx = 3;
    protected Color colorFigure = Color.black;
    protected int height;
    protected final int HEIGHT = 900;
    protected final int WIDTH = 900;
    protected boolean isMoving = false;
    protected boolean headSelect = true;
    protected boolean eyeSelected = true;
    protected boolean mouthSelected = true;
    protected boolean noseSelect = true;
    protected boolean bodySelect = true;
    protected boolean legSelect = true;
    protected boolean armSelected = true;
    
  
 
    public StickFigure(int baseX, int baseY, Color color, int size)
    {
    this.BASEX = baseX;
    this.BASEY = baseY;
    this.colorFigure = color;
    this.height = size;

    setBackground (Color.white);
    setPreferredSize (new Dimension(HEIGHT,WIDTH));   
    timer = new Timer(5,this);   
    timer.start();
   }

   public void paint (Graphics page)
   {
      super.paintComponent (page);
      paintHead(page);
      paintEye(page);
      paintMouth(page);
      paintNose(page);
      paintBody(page);
      paintArms(page);
      paintLegs(page);  
      
  
 }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (BASEX<-150){
            BASEX = HEIGHT;
        }
        else if (BASEX > 1060){
            BASEX = 0;
        }        
        BASEX = BASEX-velx;
        repaint();
    }
    public void paintHead(Graphics page){
        if (headSelect){
            page.setColor (colorFigure);
            page.fillOval (BASEX, BASEY, 80, 80);  // head
            page.fillOval (BASEX-5, BASEY+20, 90, 40);  // ears
        }
    }
    public void paintEye(Graphics page){
        if (eyeSelected){
            page.setColor (Color.black);
            page.fillOval (BASEX+25, BASEY+31, 5, 5);   // pupils
            page.fillOval (BASEX+50, BASEY+31, 5, 5);
        }
       
    }
    public void paintMouth(Graphics page){
        if (mouthSelected){
            page.setColor (Color.black);
            page.drawArc (BASEX+20, BASEY+50, 40, 15, 180, 180);
        }
    }
    public void paintNose(Graphics page){
        if (noseSelect){
            page.drawArc (BASEX+35, BASEY+40, 15, 10, 180, 180);
        }
    }
    public void paintBody(Graphics page){
        if (bodySelect){
            page.setColor (colorFigure);
            page.drawLine(BASEX+40, BASEY+80,BASEX+40,BASEY+80+height);
        }
    }
    public void paintArms(Graphics page){
        if (armSelected){
            page.setColor (colorFigure);
            page.drawLine(BASEX+40,  BASEY+8+height/2, BASEX+40 +(height)/2,  BASEY+80+height/2); // into my arms   YAMUK KOL
      
            page.drawLine(BASEX+40,  BASEY+8+height/2, BASEX+40-(height)/2,  BASEY+80+height/2); // into my arms 
        }
    }
    public void paintLegs(Graphics page){
        if (legSelect){
            page.setColor (colorFigure);
            page.drawLine(BASEX-height*1/5,BASEY +150+height*6/4 , BASEX+40, BASEY+80+height);// left leg

            page.drawLine(BASEX+80+height*1/5, BASEY +150+height*6/4,  BASEX+40, BASEY+80+height);//right leg
        }
    }

   
}

