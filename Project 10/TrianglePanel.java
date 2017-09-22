//********************************************************************
//  TrianglePanel.java       Author: M A Papalaskari
//
//  Demonstrates the use of polygons and polylines to draw triangles.
//********************************************************************

import javax.swing.*;
import java.awt.*;

public class TrianglePanel extends JPanel
{
   // Constructor: Sets up the basic characteristics of this panel.
   public TrianglePanel()
   {
      setPreferredSize(new Dimension(200, 200));
   }
   
   public void addThree(int[] a)
      {
         for(int i = 0; i < a.length; i++)
            a[i] += 3;
      }

   // Draws a triangle and a V-shape using polygons and polylines.
   public void paintComponent(Graphics page)
   {
      super.paintComponent(page);

      int[] xPoints = {100, 120, 150};
      int[] yPoints = {150, 40, 110};
      
      page.setColor(Color.cyan);
      page.fillPolygon(xPoints, yPoints, xPoints.length);
      addThree(xPoints);
      
      page.setColor(Color.red);
      page.drawPolyline(xPoints, yPoints, xPoints.length);  
   }
   
   //  Tests TrianglePanel: creates a panel and displays it. 
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("Triangle Demo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      TrianglePanel panel = new TrianglePanel();

      frame.getContentPane().add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}