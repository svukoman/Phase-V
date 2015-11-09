public class Type
{
    private String type;
    private final String[] TYPE_LIST = {"Single Family Home", "Town-House", "Condo", "Apartment"};

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
    public void setType(int type)
    {
       if(type < 0 || type > 3)
       {
            throw new IllegalArgumentException("Type is out of range");
       }
       else 
       {
            this.type = TYPE_LIST[type];
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
