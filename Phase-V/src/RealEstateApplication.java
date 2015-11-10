
import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class RealEstateApplication 
{
    //Remember to remove IOException from main
    public static void main(String[] args) throws IOException
    {
        //final String path = "\path\to\file.txt";
        int MAX_HOUSES = 25;
        House[] data = new House[MAX_HOUSES];
        chooseFile(data);
        int option = 0;
        do
        {
            option = showMenu();
            switch (option)
            {
                 case 0:
                    editHouseInfo(data);
                    break;
                 case 1: 
                    viewHousingInfo(data);
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
    public static void chooseFile(House[] data) throws FileNotFoundException, IOException
    {
        int i = 0;
        String one; 
        double gpa;
        Scanner scan = null;
        //JFileChooser opens a dialog box to choose a specefic file regardelss if its in the same location as the .java file.
        JFileChooser aFile = new JFileChooser();
        int result = aFile.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            //Reads the entire file and goes through the lines one by one. Seperates the name and the gpa from one another and send it to the Student class
            scan = new Scanner(new FileReader(new File(aFile.getSelectedFile().getPath())));
            
            scan.useDelimiter(",");
            while(scan.hasNext())
            {
                try
                {
                    int  xCoordinates = scan.nextInt();
                    int  yCoordinates = scan.nextInt();
                    String name = scan.next();
                    double price = scan.nextDouble();
                    int status = scan.nextInt();
                    int type = scan.nextInt();
                    data[i] = new House(xCoordinates, yCoordinates, name, price, status, type);
                    //not sure what the next 2 items are in the list
                    
                }catch(IllegalArgumentException e){}
                //TODO: add catch method for unsupported file format or something
                i++;
            }
        }
    }
    public static int showMenu ()
    {
       Object[] options = {"Edit housing information", "View housing informaiton", "Exit"};
       int choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Main Menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
       
       return choice;
    }
    public static void editHouseInfo(House[] data)
    {
        int Xcoordinates = 0;
        int Ycoordinates = 0;
        String grid = "";
        boolean confirmation = false;
        do
        {
            //Get the X coordinates
            do
            {
                //TODO: Add a way to show the coordinates during input
                
                
                grid = printGrid(data);
                try
                {
                    Xcoordinates = Integer.parseInt(JOptionPane.showInputDialog(grid + "\n\nPlease enter the X coordinate"));
                }catch(NumberFormatException e){}
                if (Xcoordinates < 0 || Xcoordinates > 5)
                {
                    JOptionPane.showMessageDialog(null, "ERROR!  Please enter an integer between 1 and 5");
                }
            }while (Xcoordinates < 0 || Xcoordinates > 5);
            //Get the Y coordinates
            do
            {
                //TODO: Add a way to show the coordinates during input
                grid = printGrid(data);
                try
                {
                Ycoordinates = Integer.parseInt(JOptionPane.showInputDialog( grid + "\n\nPlease enter the Y coordinates"));
                }catch(NumberFormatException e){}
                if (Ycoordinates < 0 || Ycoordinates > 5)
                {
                    JOptionPane.showMessageDialog(null, "ERROR!  Please enter an integer between 1 and 5");
                }
            }while (Ycoordinates < 0 || Ycoordinates > 5);

            //TODO: Print the grid with a bracket inbewteen the chosen one.
            confirmation = JOptionPane.showConfirmDialog(null, "You have chosen coordinates X: " + Xcoordinates + " & Y: " + Ycoordinates + "\nIs that correct?") == JOptionPane.YES_OPTION;
        }while(confirmation == false);
        
        //Search through the objects for the house
        int x = 0; boolean valid = false;
        do
        {
            if (Xcoordinates == data[x].getXCoordinate() && Ycoordinates == data[x].getYCoordinate())
            {
                valid = true;
            }
            else x++;
        }while(valid == false);
        //Start the edit menu process.
        int option = 0;
        do
        {
            option = editMenu();
            switch (option)
            {
                 case 0:
                    editPropertyType(data, x);
                    break;
                 case 1: 
                    editPrice(data, x);
                    break;
                 case 2:
                    editAgentName(data, x);
                    break;
                 case 3: 
                    editStatus(data, x);
                    break;
                 case 4:
                    JOptionPane.showMessageDialog(null, "Returning to Main menu");
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
    public static void editPropertyType(House[] data, int x)
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
    public static void editPrice(House[] data, int x)
    {
        double price = 0;
        boolean valid = false;
        
        do
        {
            try
            {
                price = Double.parseDouble(JOptionPane.showInputDialog("Please enter the property price"));
                valid = true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Price must be entered in a numaric format");
                valid = false;
            }catch(IllegalArgumentException f){
                JOptionPane.showMessageDialog(null, f.getMessage());   
                valid = false;
            }

        }while(!valid);
        data[x].setHousePrice(price);
    }
    /*
        editAgentName asks the agent for their name
    */
    public static void editAgentName(House[] data, int x)
    {
        String name = "";
        Boolean valid = false;
        do
        {
            try{
            name = JOptionPane.showInputDialog(null, "Please enter the agents name");
            }catch(IllegalArgumentException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }while(!valid);
        data[x].setAgentName(name);
    }
    /*
        editStatus asks the agent for status, either property is sold or for sale or NA.
    */
    public static void editStatus(House[] data, int x)
    {
       Object[] status = {"For sale", "Sold", "N/A"};
       int propertyStatus = JOptionPane.showOptionDialog(null, "Which type of property is this home??", "Property edit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, status, status[0]);
       switch (propertyStatus)
            {
                 case 0:
                    data[x].setHouseStatus(propertyStatus);
                    break;
                 case 1: 
                    data[x].setHouseStatus(propertyStatus);
                    break;
                case 2:
                    data[x].setHouseStatus(propertyStatus);
                default:
                    JOptionPane.showMessageDialog(null, "Status was not updated");
            }
    }
    /*
        Begin the view information method and process
    */
    public static void viewHousingInfo(House[] data)
    {
        int Xcoordinates = 0;
        int Ycoordinates = 0;
        boolean confirmation = false;
        String grid = "";
        do
        {
            //Get the X coordinates
            do
            {
                //TODO: Add a way to show the coordinates during input
                
                
                grid = printGrid(data);
                try
                {
                    Xcoordinates = Integer.parseInt(JOptionPane.showInputDialog(grid + "\n\nPlease enter the X coordinate"));
                }catch(NumberFormatException e){}
                if (Xcoordinates < 0 || Xcoordinates > 5)
                {
                    JOptionPane.showMessageDialog(null, "ERROR!  Please enter an integer between 1 and 5");
                }
            }while (Xcoordinates < 0 || Xcoordinates > 5);
            //Get the Y coordinates
            do
            {
                //TODO: Add a way to show the coordinates during input
                grid = printGrid(data);
                try
                {
                Ycoordinates = Integer.parseInt(JOptionPane.showInputDialog( grid + "\n\nPlease enter the Y coordinates"));
                }catch(NumberFormatException e){}
                if (Ycoordinates < 0 || Ycoordinates > 5)
                {
                    JOptionPane.showMessageDialog(null, "ERROR!  Please enter an integer between 1 and 5");
                }
            }while (Ycoordinates < 0 || Ycoordinates > 5);

            //TODO: Print the grid with a bracket inbewteen the chosen one.
            confirmation = JOptionPane.showConfirmDialog(null, "You have chosen coordinates X: " + Xcoordinates + " & Y: " + Ycoordinates + "\nIs that correct?") == JOptionPane.YES_OPTION;
        }while(confirmation == false);
        printHousingInformation(data);
    }
    /*
    
    */
    public static String printGrid(House[] data)
    {
        String grid = "";
        for (int j = 1; j < 6; j++)
        {
            for (int k = 1; k < 6; k++)
            {
                if (data[k].getYCoordinate() == j && data[k].getXCoordinate() == k)
                {
                    if (data[k].getStatus() == 0)
                    {
                        grid += "X|     ";
                    }
                    else if (data[k].getStatus() == 1)
                    {
                        grid += "O|     ";
                    }
                    else
                    {
                        grid += "*|     ";
                    }
                    
                }
            }
            grid += "\n";

        }
        return grid;
    }
    /*
    
    */
    public static void printHousingInformation(House[] data)
    {
        //where home is equal to the object refrence we are trying to print.
        //String output = home.toString();
        //JOptionPane.showMessageDialog(null, output);
        try
        {
            //This prompts the user to enter a txt file name of the users choosing. The txt file will be placed in the .java file's directory
            PrintWriter out = new PrintWriter(new FileOutputStream(new File(JOptionPane.showInputDialog("Please enter file name."))));
            Type[] type = new Type[25];
            for (int i = 0; i < data.length;i++)
            {
                type[i] = new Type();
                
                out.println(data[i].getXCoordinate() + ", " + data[i].getYCoordinate() + ", " + data[i].getAgentName() + ", " + data[i].getPrice() + ", " + data[i].getStatus() + ", " +  type[i].getTypeNo());
            }
            out.close();
        }catch(FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(null, "could not find file","Phase V", JOptionPane.ERROR_MESSAGE);
        }
    
    }
}
