package Restaurant;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;
import java.io.*;

public class DataIO {

    private Formatter x;       //For writing files
    private Scanner y;         //For reading files

    public void closeFormatter() {
        x.close();
    }

    public void closeScanner() {
        y.close();
    }


    public void openFile(String file) {
        try {
            x = new Formatter(file + ".txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void openExistingFile(String file) {
        try {
            y = new Scanner(new File(file + ".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void write(String file) {
        openFile(file);

        switch (file){

            case "manager":
                for (int i = 0; i < Manager.managers.size(); i++) {
                    Manager m = Manager.managers.get(i);
                    x.format("%s %s %s %s %n", m.getName(), m.getPassword(), m.getEmail(), m.getNumber());
                }
                closeFormatter();
                break;
            case "customer":
                for (int i = 0; i < Customer.customers.size(); i++) {
                    Customer c = Customer.customers.get(i);
                    x.format("%s %s %s %s %.2f%n", c.getName(), c.getPassword(), c.getEmail(), c.getNumber(), c.getBalance());
                }
                closeFormatter();

                for (int i = 0; i < Customer.customers.size(); i++) {
                    Customer c = Customer.customers.get(i);
                    if (!(c.getCart().size() == 0)) {
                        openFile("cart");
                        x.format("%s%n", c.getName());
                        for (int y = 0; y < c.getCart().size(); y++) {
                            String item = c.getCart().get(y).getItem();
                            double price = c.getCart().get(y).getPrice();
                            int amt =  c.getCart().get(y).getAmt();
                            x.format("%s %.2f %d%n", item, price, amt);
                        }
                        x.format("\n");
                        closeFormatter();
                    }
                }
                break;
        }
    }

    public void read(String file) {
        openExistingFile(file);
        switch (file) {
            case "customer":
                String cname, cpassword, cemail, cnumber;
                double balance;
                ArrayList<Cart> cart = new ArrayList<Cart>();
                ArrayList<Customer> customers = new ArrayList<Customer>();

                while (y.hasNext()) {
                    cname = y.next();
                    cpassword = y.next();
                    cemail = y.next();
                    cnumber = y.next();
                    balance = Double.parseDouble(y.next());

                    customers.add(new Customer(cname, cpassword, cemail, cnumber, balance, cart));
                    if (y.hasNextLine()) {y.nextLine();}
                }
                Customer.setCustomers(customers);
                break;
            case "manager":
                String mname, mpassword, memail, mnumber;
                ArrayList<Manager> managers = new ArrayList<Manager>();

                while(y.hasNext()) {
                    mname = y.next();
                    mpassword = y.next();
                    memail = y.next();
                    mnumber = y.next();

                    managers.add(new Manager(mname,mpassword,memail,mnumber));
                    if (y.hasNextLine()) {y.nextLine();}
                }
                Manager.setManagers(managers);
                break;
            case "menu":
                break;
            case "order":
                break;
            case "cart":
                String item, owner;
                double price;
                int amt;
                ArrayList<Cart> carts = new ArrayList<Cart>();

                while (y.hasNext()) {
                    owner = y.next();
                    y.nextLine();
                    item = y.next();
                    price = Double.parseDouble(y.next());
                    amt = Integer.parseInt(y.next());
                    carts.add(new Cart(item, price, amt));
                    if (y.nextLine().equals("")) {
                        for (int i = 0; i < Customer.customers.size(); i++) {
                            Customer c = Customer.customers.get(i);
                            if (c.getName().equals(owner)) {
                                c.setCart(carts);
                            }
                        }
                    }
                }

        }
    }
}









