//-------------------------------------------------------------------
// StateStats - Project 10    Author: Katie Bogan
// December 3, 2015
//-------------------------------------------------------------------
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class StateStats
{
   public static void main (String[]args) throws IOException
   {
      Scanner filescan;
      File myFile = new File("2015data.txt"); //Importing file//
      filescan = new Scanner (myFile);
      String line;
      
      //Declaring arrays//
      String[] state = new String[55];
      String[] attribute = new String[43];
      int[][] data = new int[55][42];
     
      line = filescan.nextLine();
      Scanner scanLine = new Scanner(line);
      scanLine.useDelimiter("\t");
  
      //Attribute loop//
      for(int b = 0; b<attribute.length; b++)
        {
            attribute[b] = scanLine.next();
            //System.out.println(attribute[b]);
        }
        
      //State loop//
      for(int count = 0; count < state.length; count++)
      {
         line = filescan.nextLine();
         scanLine = new Scanner(line);
         scanLine.useDelimiter("\t");
         
         state[count] = scanLine.next();
         //System.out.println(state[count]);
       
         //Data Loop//
         for(int k = 0; k < 42; k++)
         {
            data[count][k] = scanLine.nextInt();
            //System.out.println(data[count][k]);
         }
       }
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