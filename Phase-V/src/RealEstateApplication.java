
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class RealEstateApplication 
{
    public static void main(String[] args)
    {
        //chooseFile();
        int option = 0;
        do
        {
            option = showMenu();
            switch (choice)
            {
                 case 0:
                    editHouseInfo();
                    break;
                 case 1: 
                    viewHouseInfo();
                    break;
                 case 2:
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    break;
            }
        }while(option != 2);
    }
    /*
    Method choose file prompts the user to choose a text file to read information from.
    @param students is the array of objects.
    */
    public static void chooseFile() throws FileNotFoundException, IOException
    {
        int i = 0; String one; String name = ""; double gpa;
        Scanner scan = null;
        //JFileChooser opens a dialog box to choose a specefic file regardelss if its in the same location as the .java file.
        JFileChooser aFile = new JFileChooser();
        int result = aFile.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            //Reads the entire file and goes through the lines one by one. Seperates the name and the gpa from one another and send it to the Student class
            BufferedReader br = new BufferedReader(new FileReader(new File(aFile.getSelectedFile().getPath())));
            while((one = br.readLine()) !=null)
            {
                          
                try
                {
                    
                }catch(IllegalArgumentException e){}

            }
        }
    }
    public static int showMenu ()
    {
       Object[] options = {"Edit housing information", "View housing informaiton", "Exit"};
       int choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Main Menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
       
       return choice;
    }
    public static void editHouseInfo()
    {
        int coordinates = 0;
        do
        {
            //TODO: Add a way to show the coordinates during input
            try
            {
            coordinates = Integer.parseInt(JOptionPane.showInputDialog("Pleas enter coordinates"));
            }catch(NumberFormatException e){}
            if (coordinates < 0)
            {
                JOptionPane.showMessageDialog(null, "ERROR!");
            }
            
        }while (coordinates < 0);
    }
}
