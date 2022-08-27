package Restaurant;

public class Main {
    public static void main(String arr[]) {
        DataIO data = new DataIO();
        Login x = new Login();
        data.read("customer");
        data.read("cart");
        data.read("manager");
        data.read("food");
        data.read("drink");



    }

}
