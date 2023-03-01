/**
 * Buttons
 */
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Buttons extends StickFigure {
    JPanel AllButtons;
    JPanel colors;
    ActionListener listener;
    ActionListener listener2;
    ActionListener listener3;
    ActionListener listener4;
    ActionListener listener5;
    ActionListener listener6;

    JButton moveButton;
    JSlider slider;
    ChangeListener changelistener;
    JButton colorButtons;
    ArrayList <JButton> totalButtons = new ArrayList<>();
    JPanel leftRightStop;
    JPanel checkBoxes;
    JCheckBox checkbox;
    JCheckBox checkbox1;
    JCheckBox checkbox2;
    JCheckBox checkbox3;
    JCheckBox checkbox4;
    JCheckBox checkbox5;
    JCheckBox checkbox6;

        public Buttons(int baseX, int baseY, Color color, int size) {
        super(baseX, baseY, color, size);     
        AllButtons = new JPanel();
        AllButtons.setLayout(new BorderLayout());;
        
        listener = new Move();
        moveButton = new JButton("Left/Right");
        moveButton.addActionListener(listener);
        leftRightStop = new JPanel(new GridLayout(1,2));
        leftRightStop.add(moveButton, BorderLayout.WEST);
        
        
        listener2 = new Stop();
        moveButton = new JButton("Start-Stop");
        moveButton.addActionListener(listener2);
        leftRightStop.add(moveButton, BorderLayout.EAST);
        AllButtons.add(leftRightStop, BorderLayout.CENTER);

        changelistener = new changeSize();
        slider = new JSlider(0,height*2,height);        
        slider.addChangeListener(changelistener);
        AllButtons.add(slider, BorderLayout.SOUTH);

        colors = new JPanel(new GridLayout(2,3));
        listener3 = new changeColor();
        colorButtons = new JButton("Red");
        colorButtons.setBackground(Color.red);
        colorButtons.addActionListener(listener3);
        totalButtons.add(colorButtons);
        colors.add(colorButtons);
        
        colorButtons = new JButton("Blue");
        colorButtons.setBackground(Color.blue);
        colorButtons.addActionListener(listener3);
        totalButtons.add(colorButtons);
        colors.add(colorButtons);

        colorButtons = new JButton("Green");
        colorButtons.setBackground(Color.green);
        colorButtons.addActionListener(listener3);
        totalButtons.add(colorButtons);
        colors.add(colorButtons);

        colorButtons = new JButton("Magenta");
        colorButtons.setBackground(Color.magenta);
        colorButtons.addActionListener(listener3);
        totalButtons.add(colorButtons);
        colors.add(colorButtons);

        colorButtons = new JButton("Cyan");
        colorButtons.setBackground(Color.cyan);
        colorButtons.addActionListener(listener3);
        totalButtons.add(colorButtons);
        colors.add(colorButtons);

        colorButtons = new JButton("Yellow");
        colorButtons.setBackground(Color.yellow);
        colorButtons.addActionListener(listener3);
        totalButtons.add(colorButtons);
        colors.add(colorButtons);

        colorButtons = new JButton("White");
        colorButtons.setBackground(Color.white);
        colorButtons.addActionListener(listener3);
        totalButtons.add(colorButtons);
        colors.add(colorButtons);

        colorButtons = new JButton("Black");
        colorButtons.setForeground(Color.white);
        colorButtons.setBackground(Color.black);
        colorButtons.addActionListener(listener3);
        totalButtons.add(colorButtons);
        colors.add(colorButtons);

        leftRightStop.add(colors, BorderLayout.EAST);

        checkBoxes = new JPanel(new GridLayout(1,7)); //CONTAİNS ALL THE CHECKBOXES

        checkbox = new JCheckBox("Body");
        listener = new BodyCall();
        checkbox.addActionListener(listener);
        checkBoxes.add(checkbox);

        checkbox1 = new JCheckBox("Head");
        listener = new HeadCall();
        checkbox1.addActionListener(listener);
        checkBoxes.add(checkbox1);

        checkbox2 = new JCheckBox("Arms");
        listener = new ArmCall();
        checkbox2.addActionListener(listener);
        checkBoxes.add(checkbox2);

        checkbox4 = new JCheckBox("Legs");
        listener = new LegCall();
        checkbox4.addActionListener(listener);
        checkBoxes.add(checkbox4);

        checkbox5 = new JCheckBox("Mouth");
        listener = new MouthCall();
        checkbox5.addActionListener(listener);
        checkBoxes.add(checkbox5);

        checkbox3 = new JCheckBox("Nose");
        listener = new NoseCall();
        checkbox3.addActionListener(listener);
        checkBoxes.add(checkbox3);

        checkbox6 = new JCheckBox("Eyes");
        listener = new EyeCall();
        checkbox6.addActionListener(listener);
        checkBoxes.add(checkbox6);
        
        AllButtons.add(checkBoxes, BorderLayout.NORTH);

    }     

    public class Move implements ActionListener{
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
            velx = velx* (-1);            
        }

    }
    public class Stop implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isMoving){
                timer.stop();
            }   
            else{
                timer.start();
            }   
            isMoving = !isMoving;    
        }
    }
    public class changeSize implements ChangeListener{

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            height = (int)source.getValue();   
        }

    }
    public class BodyCall implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            bodySelect = !bodySelect;
            
        }

    }
    public class HeadCall implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            headSelect = !headSelect;
            
        }

    }
    public class ArmCall implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            armSelected = !armSelected;
            
        }

    }
    public class LegCall implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            legSelect = !legSelect;
            
        }

    }
    public class MouthCall implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            mouthSelected = !mouthSelected;
            
        }

    }
    public class NoseCall implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            noseSelect = !noseSelect;
            
        }

    }
    public class EyeCall implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            eyeSelected = !eyeSelected;
            
        }

    }
    public class changeColor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource().equals(totalButtons.get(0))){
                colorFigure = Color.red;
            }
                
            else if (e.getSource().equals(totalButtons.get(1))){
                colorFigure = Color.blue;
            }
            else if (e.getSource().equals(totalButtons.get(2))){
                colorFigure = Color.green;
            }
            else if (e.getSource().equals(totalButtons.get(3))){
                colorFigure = Color.magenta;
            }
            else if (e.getSource().equals(totalButtons.get(4))){
                colorFigure = Color.cyan;
            }
            else if (e.getSource().equals(totalButtons.get(5))){
                colorFigure = Color.yellow;
            }
            else if (e.getSource().equals(totalButtons.get(6))){
                colorFigure = Color.white;
            }
            else if (e.getSource().equals(totalButtons.get(7))){
                colorFigure = Color.black;
            }
        }

    }
    public JPanel getAllButtons(){
        return this.AllButtons;
    }
}