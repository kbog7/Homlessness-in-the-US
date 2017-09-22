import javax.swing.*;
import java.awt.*;

public class StateStatsPanel extends JPanel
{
   final int TOTALS_COLUMN = 0;    // column that contains totals
   private String[] state;
   private String[] attribute;
   private int[][] data;
   private int row, col;

   // sets up panel with given data
   public StateStatsPanel(String[] state, String[] attribute, int[][] data, int row, int col)
   {
      setPreferredSize (new Dimension(1000, 400));
      setBackground (new Color(180, 180, 200));
      this.state = state;
      this.attribute = attribute;
      this.data = data;
      this.row = row;
      this.col = col;
   }

   // paints this panel using item data
   public void paintComponent(Graphics p)
   {
      super.paintComponent(p);

      // paint background

      p.setColor(Color.white);
      p.setFont(new Font("Helvetica", Font.BOLD, 40));
      p.drawString("One night in January... ", 40, 60);

      // display totals & selected data
      VisualTwoNums visual = new VisualTwoNums(10 , 100, 800,  200,
                                               data[row][TOTALS_COLUMN],
                                               data[row][col],
                                               state[row] + ": " + attribute[col]);
      visual.draw(p);
      p.setFont(new Font("Helvetica", Font.BOLD, 16));
      p.setColor(Color.black);
      p.drawString(  data[row][TOTALS_COLUMN] +
                     " black dots representing the total homeless people" +
                     " for that night in January 2014",  40, 320);
      p.setColor(Color.yellow);
      p.drawString(  data[row][col] + " yellow dots representing " +
                     attribute[col],   40, 340);
   }
}