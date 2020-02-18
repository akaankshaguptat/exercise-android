//Q11.Create 3 sub class of bank SBI,BOI,ICICI all 4 should have method called getDetails which provide there specific details like rateofinterest etc,print details of every banks
class  Bank{
    void getDetails(double rate){
        System.out.println("rate is "+rate);
    }
}
class SBI extends Bank{

    void getDetails(double rate){
        System.out.println("rate is "+rate);
    }

}
class BOI extends Bank{

    void getDetails(double rate){
        System.out.println("rate is "+rate);
    }
}
class ICICI extends Bank{

    void getDetails(double rate){
        System.out.println("rate is "+rate);
    }
}
public class Q11_Overriding {
    public static void main(String[] args) {
        SBI sb =new SBI();
        BOI b =new BOI();
        ICICI i= new ICICI();
        sb.getDetails(4.0);
        b.getDetails(3.3);
        i.getDetails(45.5);

    }

}