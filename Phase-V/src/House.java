/*
    Phase V by:
                Nasser Al-Zughaibi; Gno: 00765920; nalzugha@masonlive.gmu.edu
                Michael Poulos; G no: 00905202; mpoulos@masonlive.gmu.edu
                Sava Vukomanovic; G no: 00821360; svukoman@masonliv@gmu.edu
    
*/
public class House
{
    private int xCoordinate;
    private int yCoordinate;
    private double housePrice;
    private int houseStatus;
    private String agentName;
    private Type type = new Type();
    
    public House()
    {
        
    }
    /*Method purpose: Special constructor to save all information retrieved from the file.
      Method parameters: xCoordinate, yCoordinate, agentName, housePrice, houseStatus, type
      Return: None.
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

    /*Method purpose: Sets the house price on the house.
      Method parameters: housePrice
      Return: None.
    */
    public void setHousePrice(double housePrice)
    {
        if (housePrice <= 0)
        {
         throw new IllegalArgumentException("The value for the house entered cannot be less than 0");
        }
        else 
        {
            this.housePrice = housePrice;
        }
    }

    /*Method purpose: Sets the agent name
      Method parameters: agentName
      Return:None.
    */
    public void setAgentName(String agentName)
    {
        if(agentName.isEmpty())
        {
            throw new IllegalArgumentException("The name entered is blank, please try again.");
        }
        else 
        {
            this.agentName = agentName;
        }
    }

    /*Method purpose: Sets the house status, only 1-3
      Method parameters: houseStatus
      Return:None
    */
    public void setHouseStatus(int houseStatus)
    {
        //0 if the house is for sale, 1 if the house is sold, 2 if the house is sold by another company
        if(houseStatus > 2 || houseStatus < 0)
        {
            throw new IllegalArgumentException("House status out of range. No changes were made.");
        }
        else
        {
            this.houseStatus = houseStatus;
        }	
    }
    /*Method purpose: Sets the type of house, send it to the second ddc for storage.
      Method parameters: aType
      Return:None
    */
    public void setType(int atype) throws IllegalArgumentException{
      type.setType(atype);  
    }
    /*Method purpose: returns the agent name when called.
      Method parameters: None.
      Return: agentName.
    */
    public String getAgentName(){return this.agentName;}

    /*Method purpose: returns the X coodrinate when called.
      Method parameters: None.
      Return: xCoordinate.
    */
    public int getXCoordinate(){return this.xCoordinate;}

    /*Method purpose: returns the Y coordinate when called.
      Method parameters: None.
      Return: yCoordinate.
    */
    public int getYCoordinate(){return this.yCoordinate;}

    /*Method purpose: returns the house price when called.
      Method parameters: None.
      Return: housePrice.
    */
    public double getPrice(){return this.housePrice;}

    /*Method purpose: returns the house status when called.
      Method parameters: None.
      Return: houseStatus.
    */
    public int getStatus(){return this.houseStatus;}

    /*Method purpose: returns the house type when called from the second DDC.
      Method parameters: None.
      Return: type.getTypeNo().
    */
    public int getType(){
      return this.type.getTypeNo();
    }
    /*Method purpose: to return a symbol to help print out the grid in the implementation
      Method parameters: None.
      Return: msg.
    */
    public String ToSymbol()
    {
        String msg = "";
        switch(this.houseStatus){
                case(0): msg = " O   |  "; break;
                case(1): msg = " X   |  "; break;
                case(2): msg = " *   |  "; break;
        default: throw new IllegalArgumentException("There was an error retreaving the status of this house");
        }
        return msg;	
    }
    /*Method purpose: to print out the information whenever needed. If house is sold just the name of the agent and house status.
      If it's still for sale then all the information would be presented.
      Method parameters: None.
      Return: msg.
    */
    public String toString()
    {
        String msg = "";
        if(houseStatus == 1){
                msg = "Real Estate Agent: " + agentName + "\nThis house is already sold";
        }	
        else if(houseStatus == 2){
                msg = "This house is not being sold by this real estate company";
        }
        else{
                msg = "The house located at cordinates: (" + xCoordinate + "," + yCoordinate + ") is being sold by: " + agentName + "\n This house is available for sale\nThis house is worth: " + housePrice + "\n" + this.type.toString();
        }
        return msg;
    }
}
