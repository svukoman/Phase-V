
import java.io.*;
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
            switch (option)
            {
                 case 0:
                    editHouseInfo();
                    break;
                 case 1: 
                    viewHousingInfo();
                    break;
                 case 2:
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    break;
            }
        }while(option != 2);
    }
    /*
    Method choose file prompts the user to choose a text file to read information from.
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
        int Xcoordinates = 0; boolean confirmation = false;
        int Ycoordinates = 0;
        do
        {
            //Get the X coordinates
            do
            {
                //TODO: Add a way to show the coordinates during input
                try
                {
                Xcoordinates = Integer.parseInt(JOptionPane.showInputDialog("Please enter the X coordinate"));
                }catch(NumberFormatException e){}
                if (coordinates < 0 || coordinates > 5)
                {
                    JOptionPane.showMessageDialog(null, "ERROR!  Please enter an integer between 1 and 5");
                }
                else
                {
                    //Pass into the array of house objects
                }
            }while (coordinates < 0 || coordinates > 5);
            //Get the Y coordinates
            do
            {
                //TODO: Add a way to show the coordinates during input
                try
                {
                Ycoordinates = Integer.parseInt(JOptionPane.showInputDialog("Please enter the Y coordinates"));
                }catch(NumberFormatException e){}
                if (coordinates < 0 || coordinates > 5)
                {
                    JOptionPane.showMessageDialog(null, "ERROR!  Please enter an integer between 1 and 5");
                }
                else
                {
                    //Pass into the array of house objects
                }
            }while (coordinates < 0 || coordinates > 5);

            //TODO: Print the grid with a bracket inbewteen the chosen one.
            confirmation = JOptionPane.showConfirmDialog(null, "You have chosen coordinates X: " + Xcoordinates + " & Y: " + Ycoordinates + "\nIs that correct?") == JOptionPane.YES_OPTION;
        }while(confirmation == false);
        
        //Start the edit menu process.
        int option = 0;
        do
        {
            option = editMenu();
            switch (option)
            {
                 case 0:
                    editPropertyType();
                    break;
                 case 1: 
                    editPrice();
                    break;
                 case 2:
                    editAgentName();
                    break;
                 case 3: 
                    editStatus();
                    break;
                 case 4:
                    JOptionPane.showMessageDialog(null, "Goodbye");
                    break;
            }
        }while(option != 4);
    }
    /*
        Buton menu for editing housing info
    */
    public static int editMenu()
    {
        Object[] options = {"Property type", "Price", "Agent name", "For sale/sold", "Done editing"};
       int choice = JOptionPane.showOptionDialog(null, "What would you like to edit?", "Edit Menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
       
       return choice;
    }
    /*
        editPropertyType changes the property type
    */
    public static void editPropertyType()
    {
       Object[] property = {"Single family home", "Townhouse", "Condo", "Apartment"};
       int propertyType = JOptionPane.showOptionDialog(null, "Which type of property is this home??", "Property edit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, property, property[0]);
       switch (propertyType)
            {
                 case 0:
                    //Pass info for SF home 
                    break;
                 case 1: 
                    //Pass info for Townhouse
                    break;
                 case 2:
                    //Pass info for condo
                    break;
                 case 3: 
                    //Pass info for Apartment
                    break;
            }
    }
    /*
        editPrice asks the agent for the property price.
    */
    public static void editPrice()
    {
        double price = 0;
        
        do
        {
            try
            {
                price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the property price"));
            }catch(NumberFormatException e){}
            if (price < 0)
            {
                JOptionPane.showMessageDialog(null, "ERROR!");
            }
            else
            {
                //Pass info to DDC
            }
                

        }while(price < 0);
    }
    /*
        editAgentName asks the agent for their name
    */
    public static void editAgentName()
    {
        String name = "";
        do
        {
            name = JOptionPane.showInputDialog(null, "Please enter the agents name");
            if (name.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "ERROR! Field cannot be empty please try again.");
            }
            //Add another form of error checking
        }while(name.isEmpty());
    }
    /*
        editStatus asks the agent for status, either property is sold or for sale.
    */
    public static void editStatus()
    {
       Object[] status = {"For sale", "Sold"};
       int propertyStatus = JOptionPane.showOptionDialog(null, "Which type of property is this home??", "Property edit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, status, status[0]);
       switch (propertyStatus)
            {
                 case 0:
                    //Pass info for sale 
                    break;
                 case 1: 
                    //Pass info for sold
                    break;
            }
    }
    /*
        Begin the view information method and process
    */
    public static void viewHousingInfo()
    {
        int coordinates = 0; boolean confirmation = false;
        do
        {
            //Get the X coordinates
            do
            {
                //TODO: Add a way to show the coordinates during input
                try
                {
                coordinates = Integer.parseInt(JOptionPane.showInputDialog("Pleas enter coordinates"));
                }catch(NumberFormatException e){}
                if (coordinates < 0 || coordinates > 5)
                {
                    JOptionPane.showMessageDialog(null, "ERROR!  Please enter an integer between 1 and 5");
                }
                else
                {
                    //Pass into the DDC
                }
            }while (coordinates < 0 || coordinates > 5);
            //Get the Y coordinates
            do
            {
                //TODO: Add a way to show the coordinates during input
                try
                {
                coordinates = Integer.parseInt(JOptionPane.showInputDialog("Pleas enter coordinates"));
                }catch(NumberFormatException e){}
                if (coordinates < 0 || coordinates > 5)
                {
                    JOptionPane.showMessageDialog(null, "ERROR!  Please enter an integer between 1 and 5");
                }
                else
                {
                    //Pass into the DDC
                }
            }while (coordinates < 0 || coordinates > 5);

            //TODO: Print the grid with a bracket inbewteen the chosen one.
            confirmation = JOptionPane.showConfirmDialog(null, "You have chosen coordinates X: " + " & Y: " + "\nIs that correct?") == JOptionPane.YES_OPTION;
        }while(confirmation == false);
        printHousingInformation();
    }
    public static void printHousingInformation()
    {
        String output = "Property at coordinates (" + "" + "," + "" + ") is handeled by agent: " + "" + ".\n" +
                "Property is worth: $" + "" + "\n" +
                "Property Type: " + "" + "\n" +
                "Status of property: " + "";
        JOptionPane.showMessageDialog(null, output);
    }
}
