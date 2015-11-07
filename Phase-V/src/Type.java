public class Type
{
    private String type;
    private final String[] TYPE_LIST = {"Apartment", "Town-House", "Condo", "Mansion"};

    public Type(){}
    /*Method purpose:
     Method parameters:
     Return:
    */
    public Type(int type)
    {
        this.type = TYPE_LIST[type-1];  
    }
    /*Method purpose:
     Method parameters:
     Return:
    */
    public String getType(){return this.type;}

    /*Method purpose:
     Method parameters:
     Return:
    */
    public boolean setType(int type)
    {
       if(type < 0)
       {
            throw new IllegalArgumentException("Sorry...");
       }
       else 
       {
            this.type = TYPE_LIST[type];
            return true;
       }
    }

    /*Method purpose:
     Method parameters:
     Return:
    */
    public String toString()
    {
       return "Property Type: " + this.type;
    }
}
