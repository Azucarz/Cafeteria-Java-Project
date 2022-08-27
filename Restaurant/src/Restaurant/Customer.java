package Restaurant;

import java.util.ArrayList;

public class Customer extends User{
    private ArrayList<Cart> cart;
    private double balance;
    public static ArrayList<Customer> customers = new ArrayList<Customer>();

    public Customer(String name, String password, String email, String number, double balance, ArrayList<Cart> cart) {
        super(name, password, email, number);
        this.cart = cart;
        this.balance = balance;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        Customer.customers = customers;
    }

    public ArrayList<Cart> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Cart> cart) {
        this.cart = cart;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {this.balance = balance;}

    public void increaseBalance(double balance) {
        this.balance = this.balance + balance;
    }

    public static Customer getCustomer(String name){

        for (int i = 0; i < customers.size(); i++) {
            if(customers.get(i).getName().matches(name)){
                return customers.get(i);
            }
        }
        return null;
    }


}
