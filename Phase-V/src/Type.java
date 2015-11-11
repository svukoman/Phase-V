/*
    Phase V by:
                Nasser Al-Zughaibi; Gno: 00765920; nalzugha@masonlive.gmu.edu
                Michael Poulos; G no: 00905202; mpoulos@masonlive.gmu.edu
                Sava Vukomanovic; G no: 00821360; svukoman@masonliv@gmu.edu
    
*/
public class Type
{
    private String type;
    private int typeNo;
    private final String[] TYPE_LIST = {"Single Family Home", "Town-House", "Condo", "Apartment"};

    public Type(){}
    /*Method purpose: Special constructor that saves the house type on initial file read.
     Method parameters: type
     Return: None.
    */
    public Type(int type)
    {
        this.type = TYPE_LIST[type-1];  
        this.typeNo = type;
    }

    /*Method purpose: Return the house type when called.
     Method parameters: None.
     Return: TypeNo.
    */
    public int getTypeNo(){return this.typeNo;}

    /*Method purpose: Sets the type number when edited.
     Method parameters: type.
     Return: None.
    */
    public void setType(int type)
    {
       if(type < 0 || type > 3)
       {
            throw new IllegalArgumentException("Type is out of range");
       }
       else 
       {
            this.type = TYPE_LIST[type];
            this.typeNo = type;
       }
    }

    /*Method purpose: Prints out the relevant information from this class.
     Method parameters: None.
     Return: a String.
    */
    public String toString()
    {
       return "Property Type: " + this.type;
    }
}
