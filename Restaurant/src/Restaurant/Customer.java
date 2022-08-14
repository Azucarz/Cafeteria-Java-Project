package Restaurant;

import java.util.ArrayList;

public class Customer extends User{
    private ArrayList<Cart> cart;
    private double balance;

    public Customer(String name, String password, String email, String number, double balance, ArrayList<Cart> cart) {
        super(name, password, email, number);
        this.cart = cart;
        this.balance = balance;
    }

    public Customer(String name, String password, String email, String number) {
        super(name, password, email, number);
        this.cart = new ArrayList<Cart>();
        this.balance = 0;
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

    public void setBalance(double balance) {
        this.balance = this.balance + balance;
    }
}
