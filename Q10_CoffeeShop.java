/*
Created By
akaanksha
on 19/02/20
*/
abstract public class Q10_CoffeeShop extends Barista {
}
abstract class Customer{
    boolean coffeePrepared=false;
    abstract void payCash();
    abstract int getToken();
    abstract boolean isCoffeePrepared();
}
abstract class Cashier extends Customer{
   abstract void getOrder();
   abstract void createOrder();
   abstract int waitCustomer();
   void getPayment(){
       createOrder();
       waitCustomer();
   }
}
abstract class Barista extends Cashier{
    boolean coffeePrepared;
    abstract void getNextOrder();
     boolean prepareCoffee(){
         System.out.println("processing coffee");
         coffeePrepared=true;
         return coffeePrepared;
     }
     abstract int completedOrder();
     String orderCompletedNotification(){
         return "order completed";
     }



}