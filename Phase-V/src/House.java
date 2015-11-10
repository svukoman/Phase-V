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
    /*Method purpose:
      Method parameters:
      Return:
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

    /*Method purpose:
      Method parameters:
      Return:
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

    /*Method purpose:
      Method parameters:
      Return:
    */

    public void setAgentName(String agentName)
    {
        if(agentName.equals(""))
        {
            throw new IllegalArgumentException("The name entered is blank, please try again.");
        }
        else 
        {
            this.agentName = agentName;
            
        }
    }

    /*Method purpose:
      Method parameters:
      Return:
    */


    public void setHouseStatus(int houseStatus)
    {
        //1 if the house is for sail, 2 if the house is sold, 3 if the house is sold by another company
        if(houseStatus > 3 || houseStatus < 1)
        {
            throw new IllegalArgumentException("");
        }
        else
        {
            this.houseStatus = houseStatus;
        }	
    }
    
    /*
        
    */
    public void setXCoordinates(int x)
    {
        //1 if the house is for sail, 2 if the house is sold, 3 if the house is sold by another company
        if(x > 5 || x< 1)
        {
            throw new IllegalArgumentException("");
        }
        else
        {
            this.xCoordinate = x;
        }	
    }
    /*
        
    */
    public void setYCoordinates(int y)
    {
        //1 if the house is for sail, 2 if the house is sold, 3 if the house is sold by another company
        if(y > 5 || y< 1)
        {
            throw new IllegalArgumentException("");
        }
        else
        {
            this.yCoordinate = y;
        }	
    }
    public void setType(int atype) throws IllegalArgumentException{
      type.setType(atype);  
    }
    /*Method purpose:
      Method parameters:
      Return:
    */
    public String getAgentName(){return this.agentName;}

    /*Method purpose:
      Method parameters:
      Return:
    */
    public int getXCoordinate(){return this.xCoordinate;}

    /*Method purpose:
      Method parameters:
      Return:
    */
    public int getYCoordinate(){return this.yCoordinate;}

    /*Method purpose:
      Method parameters:
      Return:
    */
    public double getPrice(){return this.housePrice;}

    /*Method purpose:
      Method parameters:
      Return:
    */
    public int getStatus(){return this.houseStatus;}

    /*Method purpose:
      Method parameters:
      Return:
    */
    public int getType(){
      return this.type.getTypeNo();
    }
    public String ToSymbol()
    {
        String msg = "";
        switch(this.houseStatus){
                case(1): msg = "O|"; break;
                case(2): msg = "X|"; break;
                case(3): msg = "*|"; break;
        default: throw new IllegalArgumentException("There was an error retreaving the status of this house");
        }
        return msg;	
    }
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
