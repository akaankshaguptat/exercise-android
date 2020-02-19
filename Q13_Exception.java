/*
Created By
akaanksha
on 19/02/20
*/
public class Q13_Exception  extends Exception
{

    private String message;

    public Q13_Exception(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}

class Exception1
{
    public String findName(int id)throws Q13_Exception
    {
        if(id==100)
        {
            throw new Q13_Exception("Wrong id Exception given");

        }
        return "welcome";
    }

    public static void main(String[] args) throws Q13_Exception {
        Exception1 exception=new Exception1();
        exception.findName(100);
    }

}