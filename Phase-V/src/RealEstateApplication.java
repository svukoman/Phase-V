import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class RealEstateApplication 
{
    //Remember to remove IOException from main
    public static void main(String[] args) throws IOException
    {
        
        int MAX_HOUSES = 25;
        House[] data = new House[MAX_HOUSES];

        int valid = 1;
        //valid = chooseFile(data);
        
        String path = chooseFile(data);

        int option = 0;
        do
        {
            option = showMenu();
            switch (option)
            {
                 case 0:
                    editHouseInfo(data, path);
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
    public static String chooseFile(House[] data) throws FileNotFoundException
    {
        int xCord = -1;
        int yCord = -1;
        String name = " ";
        double money = 0.0;
        int status = -1;
        int type = -1;
        Scanner in = null;
        int i = 0;
        String comma;
        //JFileChooser opens a dialog box to choose a specefic file regardelss if its in the same location as the .java file.
        JFileChooser aFile = new JFileChooser();
        int result = aFile.showOpenDialog(null);
        String path = aFile.getSelectedFile().getPath();
        if (result == JFileChooser.APPROVE_OPTION)
        {
            try{
                in = new Scanner(new FileInputStream(new File(path)));
                while(in.hasNextLine()){
                    xCord = Integer.parseInt(in.next());
                    comma = in.next();

                    yCord = Integer.parseInt(in.next());
                    comma = in.next();

                    name = in.next();
                    comma = in.next();

                    money = Double.parseDouble(in.next());
                    comma = in.next();

                    status = Integer.parseInt(in.next());
                    comma = in.next();

                    type = Integer.parseInt(in.next());            

                    data[i] = new House(xCord, yCord, name, money, status, type);
                    i++;  
                }
                in.close();         
            }catch(IllegalArgumentException f){
             JOptionPane.showMessageDialog(null, f.getMessage());
            }   
            catch(NoSuchElementException e){}
            
        }
        return path;
    }
    public static int showMenu ()
    {
       Object[] options = {"Edit housing information", "View housing informaiton", "Exit"};
       int choice = JOptionPane.showOptionDialog(null, "What would you like to do?", "Main Menu", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
       
       return choice;
    }
    public static void editHouseInfo(House[] data, String path)
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
                    saveToFile(data, path);
                    break;
                 case 1: 
                    editPrice(data, x);
                    saveToFile(data, path);
                    break;
                 case 2:
                    editAgentName(data, x);
                    saveToFile(data, path);
                    break;
                 case 3: 
                    editStatus(data, x);
                    saveToFile(data, path);
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
       boolean valid = false;
       do{
       try{
         data[x].setType(propertyType);
         valid = true;
       }catch(IllegalArgumentException e){
         JOptionPane.showMessageDialog(null, e.getMessage());
       }
       }while(!valid);
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
                data[x].setHousePrice(price);
                valid = true;
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Price must be entered in a numaric format");
                valid = false;
            }catch(IllegalArgumentException f){
                JOptionPane.showMessageDialog(null, f.getMessage());   
                valid = false;
            }

        }while(!valid);       
    }
    /*
        editAgentName asks the agent for their name
    */
    public static void editAgentName(House[] data, int x)
    {
        String name = "";
        boolean valid = false;
        do
        {
            try{
            name = JOptionPane.showInputDialog(null, "Please enter the agents name");
            valid = true;
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
        String grid = printGrid(data);
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
        House home = null;
        for(int i=0; i<data.length; i++){
         if(data[i].getXCoordinate() == Xcoordinates && data[i].getYCoordinate() == Ycoordinates){
            home = data[i];
         }
        }
        printHousingInformation(home);
    }
    /*
    
    */
    public static String printGrid(House[] data)
    {
        String grid = "";
        for (int j = 0; j < data.length; j++)
        {            
         switch(j){
            case(5):
            case(10):
            case(15):
            case(20): grid+= "\n";            
         }
         grid+=data[j].ToSymbol();        
        }
        return grid;
    }
    /*
    
    */
    public static void printHousingInformation(House home)
    {
      JOptionPane.showMessageDialog(null, home.toString());    
    }
    public static void saveToFile(House[] data, String path){
        //instantiates a new object of the PrintWriter class
        PrintWriter op = null;
        try{
           //This prompts the user to enter a txt file name of the users choosing. The txt file will be placed in the .java file's directory
              op = new PrintWriter(new FileOutputStream(new File(path)));
        }catch(FileNotFoundException e){
           JOptionPane.showMessageDialog(null, "The file was unable to be created/updated, please check the permissions on the current directory and try again","Real Estate Application", JOptionPane.ERROR_MESSAGE);
        }
        for(int i=0; i<data.length; i++){
           op.println(data[i].getXCoordinate() + " , " + data[i].getYCoordinate() + " , " + data[i].getAgentName() + " , " + String.format("%.0f", data[i].getPrice()) + " , " + data[i].getStatus() + " , " + data[i].getType());
        }
        op.close();
        JOptionPane.showMessageDialog(null, "Information has successfully been saved to file.");
    }
}
