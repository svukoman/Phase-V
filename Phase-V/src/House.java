public class House
{
    private int xCoordinate;
    private int yCoordinate;
    private double housePrice;
    private int houseStatus;
    private String agentName;
    private Type type = new Type();
    /*Method purpose:  Constructor, when reading from a txt file, this constructor stores values and checks the validity of the 
      x and y co-ordinates
      Method parameters: integer @xCoordinate, integer @yCoordinate, String @agentName, double @housePrice, integer @houseStatus
      integer @type
      Return:This method has no return values
    */
    public House(int xCoordinate, int yCoordinate,String agentName, double housePrice, int houseStatus, int type)
    {
        if(xCoordinate > 5 || xCoordinate < 1)
        {
            throw new IllegalArgumentException("Cordinate out of range");
        }
        else
        {
            this.xCoordinate = xCoordinate;
        }
        if(yCoordinate > 5 || xCoordinate < 1)
        {
            throw new IllegalArgumentException("Cordinate out of range");
        }
        else
        {
            this.yCoordinate = yCoordinate;
        }
        this.housePrice = housePrice;
        this.houseStatus = houseStatus;
        this.agentName = agentName;
        this.type.setType(type);
    }

    /*Method purpose:The method purpose is to store the price value of the house, if it is greater then zeor
      if not the method will return an illegal argument exception message
      Method parameters: double @housePrice
      Return: The return is set to true if the @housePrice is greater than zero
    */

    public boolean setHousePrice(double housePrice)
    {
        if (housePrice < 0)
        {
         throw new IllegalArgumentException("The value for the house entered cannot be less than 0");
        }
        else 
        {
            this.housePrice = housePrice;
            return true;
        }
    }

    /*Method purpose:This method sets the agents name if the @agentName string is not empty, otherwise the method throws
      an illegal argument exception message
      Method parameters: String @agentName
      Return: The method returns true if the @agentName value is not empty
    */

    public boolean setAgentName(String agentName)
    {
        if(agentName.equals(""))
        {
            throw new IllegalArgumentException("The name entered is blank, please try again.");
        }
        else 
        {
            this.agentName = agentName;
            return true;
        }
    }

    /*Method purpose: To set the house status if the integer passed is between 1 and 3.  Option one means the house belongs
     to the agent company and that it is for sale.  Option 2 means the house belongs to the agent company but its not for sale.
     Option three means the house does not belong to the agent company
      Method parameters: integer @houseStatus
      Return:The method return is void, it throws an illegal arguemnt exception if the @houseStatus is not within the range
      of 1 and 3
    */


    public void setHouseStatus(int houseStatus)
    {
        //1 if the house is for sail, 2 if the house is sold, 3 if the house is sold by another company
        if(houseStatus > 3 || houseStatus < 1)
        {
            throw new IllegalArgumentException("The option has to be 1, 2, or 3");
        }
        else
        {
            this.houseStatus = houseStatus;
        }	
    }

    /*Method purpose:Returns the agent name that was either set by the user or read by a text file
      Method parameters: This method takes in no parameters
      Return: The method returns the agent name, which is a String @agentName
    */
    public String getAgentName(){return this.agentName;}

    /*Method purpose: Returns the x coordinate of the house that was read in from a text file
      Method parameters: This method takes in no parameters
      Return: The method returns the x coordinate of the house location which is an integer, @xCoordinate
    */
    public int getXCoordinate(){return this.xCoordinate;}

    /*Method purpose:eturns the y coordinate of the house that was read in from a text file
      Method parameters:This method takes in no parameters
      Return: The method returns the y coordinate of the house location which is an integer, @yCoordinate
    */
    public int getYCoordinate(){return this.yCoordinate;}

    /*Method purpose: This getter method returns the price of the house
      Method parameters: This method takes in no parameters
      Return: The method returns the price of the house which is a double, @housePrice
    */
    public double getPrice(){return this.housePrice;}

    /*Method purpose: The getter method returns the status of a house between 1-3
      Method parameters: This method takes in no parameters
      Return: The method returns the status of the house which is an integer, @houseStatus
    */
    public int getStatus(){return this.houseStatus;}

    /*Method purpose: This special purpose method is used to set the symbol that correlates with the house status (between 1-3).
     Each case sets the symbol to a String, which is either "O", "X" or "*". 
      Method parameters: This method takes in no parameters
      Return:The method returns a string @msg, or it throws an exception if the staus of the house did not correlate
      between 1-3
    */
    public String ToSymbol()
    {
        String msg = "";
        switch(this.houseStatus){
                case(1): msg = "O"; break;
                case(2): msg = "X"; break;
                case(3): msg = "*"; break;
        default: throw new IllegalArgumentException("There was an error retreaving the status of this house");
        }
        return msg;	
    }
    
    /*Method purpose: This special purpose method is used to create a user printout.  It uses a switch case format to set the 
     string in the possible 3 cases for the printout.  
      Method parameters: This method has no parameters
      Return: The method returns a string @msg
    */
    public String toString()
    {
        String msg = "";
        if(houseStatus == 2){
                msg = "Real Estate Agent: " + agentName + "\nThis house is already sold";
        }	
        else if(houseStatus == 3){
                msg = "This house is not being sold by this real estate company";
        }
        else{
                msg = "The house located at cordinates: (" + xCoordinate + "," + yCoordinate + ") is being sold by: " + agentName + "\n This house is available for sale\nThis house is worth: " + housePrice + "\n" + this.type.toString();
        }
        return msg;
    }
}

