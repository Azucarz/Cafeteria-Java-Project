package Restaurant;

import java.io.*;
import java.lang.reflect.Array;
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

                openFile("cart");
                for (int i = 0; i < Customer.customers.size(); i++) {
                    Customer c = Customer.customers.get(i);

                    if (!(c.getCart().size() == 0)) {


                        for (int j = 0; j < c.getCart().size(); j++) {
                            Cart current = c.getCart().get(j);

                            String item = current.getItem();
                            double price = current.getPrice();
                            int amt =  current.getAmt();

                            x.format("%s %.2f %d %n", item, price, amt);
                        }
                        x.format("%s %n", c.getName());
                    }
                }

                closeFormatter();
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
                String name, item, tmp;
                double price;
                int amt;
                ArrayList<Cart> carts = new ArrayList<>();
                ArrayList names = new ArrayList<>();

                for (int i = 0; i < Customer.customers.size(); i++) {
                    names.add(Customer.customers.get(i).getName());
                }

                while(y.hasNext()){
                    tmp = y.next();
                    if (names.contains(tmp)){
                        name = tmp;
                        for (int i = 0; i < Customer.customers.size(); i++) {
                            Customer current = Customer.customers.get(i);
                            if (current.getName().equals(name)) {
                                current.setCart(carts);
                                carts = new ArrayList<>();
                            }
                        }

                    } else {
                        item = tmp;
                        price = y.nextDouble();
                        amt = y.nextInt();

                        carts.add(new Cart(item, price, amt));
                    }

                }
        }
    }



    public void update(User u){
        if(u instanceof Customer){
            Customer c = (Customer) u;

            for (int i = 0; i < Customer.customers.size(); i++) {
                Customer current = Customer.customers.get(i);
                if (c.getName().equals(current.getName())) {
                    current.setName(c.getName());
                    current.setEmail(c.getEmail());
                    current.setBalance(c.getBalance());
                    current.setCart(c.getCart());
                }
                //TODO Exception Handling
            }
            write("customer");

        }
        else if (u instanceof Manager) {
            //TODO Add Manager Update Logic
        }
    }
}









