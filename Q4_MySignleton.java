/*
Created By
akaanksha
on 18/02/20
*/
class MySingleton {

    private static MySingleton obj;

    static{
        obj = new MySingleton();
    }

    private MySingleton(){

    }

    public static MySingleton getInstance(){
        return obj;
    }

    public void func(){
        System.out.println("hello");
    }

    public static void main(String a[]){
        MySingleton ms = getInstance();
        ms.func();
    }
}
