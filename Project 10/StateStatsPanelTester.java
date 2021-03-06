import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class StateStatsPanelTester
{
   public static void main(String[] args)
   {
      String[] state = {"AK",  "NY", "PA", "Total"};
      String[] attribute = { "Total homeless", "Unsheltered Homeless Veterans",
                              "Homeless Unaccompanied Youth and Children"};

      int[][] data = {{1784,     2,   195},
                      {80590,   457,  3790},
                      {15333,   75,   975},
                      {578424, 17885, 45205}};

      // display info in a frame
      JFrame frame = new JFrame ("HHAW");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      do{
         // get the state
         String stateSelected = (String) JOptionPane.showInputDialog(null,
                                                        "Please enter state");
         // find state index
         int stateIndex = 0;
         boolean found = false;
         while (stateIndex < state.length && !found)
            if (state[stateIndex].equalsIgnoreCase(stateSelected))
               found = true;
            else
               stateIndex++;

         if (found)
         {
            // now get the attribute - use drop-down menu
            String selected = (String) JOptionPane.showInputDialog(null,
                     "Please select an attribute to display",
                     "Attribute selection",
                     JOptionPane.QUESTION_MESSAGE,
                     null,
                     attribute,
                     attribute[1]);
            // find the corresponding index for attribute
            int col = 1;
            for (int i = 0; i <attribute.length; i++)
               if (attribute[i] == selected)
                  col = i;

            // create panel to display info about state and attribute
            frame.getContentPane().add(new StateStatsPanel(state, attribute, data, stateIndex, col));
            frame.pack();
            frame.setVisible(true);
         }
         else
            JOptionPane.showMessageDialog(frame, "Error in input. State not found: " + stateSelected );
      } while (JOptionPane.showConfirmDialog(null, "another?") == JOptionPane.YES_OPTION);

      // hide frame and dispose JFrame object to end program
      frame.setVisible(false);
      frame.dispose();
   }
}