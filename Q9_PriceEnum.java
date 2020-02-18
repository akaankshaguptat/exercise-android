//Q9.Write a program to display values of enums using a constructor & getPrice() method (Example display house & their prices)
enum House {
    h1(9),h2(2),h3(5),h4(15),h5(12);
    private int price;
    House(int p) {
        price = p;
    }
    int getPrice() {
        return price;
    }
}
public class Q9_PriceEnum {
    public static void main(String args[]){
        System.out.println("house prices:");
        for (House h : House.values())
            System.out.println(h + " costs " + h.getPrice());
    }
}

