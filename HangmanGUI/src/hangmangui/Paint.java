
package hangmangui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import javax.swing.JPanel;

/**
 *
 * @author kfcomputerscience2
 */
public class Paint extends JPanel
{
    
    int drawCounter=0;
    
    public Paint()
    {
        setBackground(new Color(135,206,235));
        
    }
    

    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.fillRect(150, 650, 420, 30);//base
        g.fillRect(500, 50, 25, 600);//vertical
        g.fillRect(200, 50, 325, 25);//crossbar
        g.fillRect(200, 50, 25, 70);//rope
        if (drawCounter>0)
            g.drawOval(163, 120, 100, 100);//head
        if (drawCounter>1)
            g.drawLine(213, 220, 213, 400);//body
        if(drawCounter>2)
        {
            g.drawLine(213, 400, 185 , 500);//leftLeg
            g.drawLine(185, 500, 185, 550);//leftLeg
        }
        if(drawCounter>3)
        {
            g.drawLine(213, 400, 241 , 500);//rightLeg
            g.drawLine(241, 500, 241, 550);//rightLeg
            
        }
        if(drawCounter>4)
        {
            g.drawLine(195, 230, 160, 380);//leftArm
            g.drawLine(195, 230, 213, 230);//leftShoulder
        }
        if(drawCounter>5)
        {
            g.drawLine(231, 230, 266, 380);//rightArm
            g.drawLine(213, 230, 231, 230);//rightShoulder
            
            g.drawLine(195, 150, 185, 160);//lefteye
            g.drawLine(185, 150, 195, 160);//lefteye
            g.drawLine(225, 150, 235, 160);//righteye
            g.drawLine(235, 150, 225, 160);//righteye
            
        }
        drawCounter++;
    }
}
        
       