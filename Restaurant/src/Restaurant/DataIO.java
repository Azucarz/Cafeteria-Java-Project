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
        if (file.equals("manager")) {
//            x.format("%s %s %s %s%n", ((Manager) o).getName(), ((Manager) o).getPassword(), ((Manager) o).getEmail(), ((Manager) o).getNumber());
            closeFormatter();
        } else if (file.equals("customer")) {
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
                    System.out.println("Pass 1");
                    for (int y = 0; y < c.getCart().size(); y++) {
                        String item = c.getCart().get(y).getItem();
                        double price = c.getCart().get(y).getPrice();
                        int amt =  c.getCart().get(y).getAmt();
                        x.format("%s %.2f %d%n", item, price, amt);
                        System.out.println("Pass 2");
                    }
                    x.format("\n");
                    System.out.println("Pass 3");
                    closeFormatter();
                    System.out.println("Pass 4");
                }
            }
        }
    }

    public void read(String file) {
        openExistingFile(file);
        switch (file) {
            case "customer":
                String name, password, email, number;
                double balance;
                ArrayList<Cart> cart = new ArrayList<Cart>();
                ArrayList<Customer> customers = new ArrayList<Customer>();

                while (y.hasNext()) {
                    name = y.next();
                    password = y.next();
                    email = y.next();
                    number = y.next();
                    balance = Double.parseDouble(y.next());

                    customers.add(new Customer(name, password, email, number, balance, cart));
                    if (y.hasNextLine()) {
                        y.nextLine();
                    }
                }
                Customer.setCustomers(customers);

            case "manager":
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






//    public ArrayList readFile(String file){
//
//        //initialization of variables
//
//        ArrayList<Guest> guestList = new ArrayList<>();
//        String guestFirstName = "";
//        String guestLastName = "";
//        String guestEmail = "";
//        String guestIC = "";
//        String guestContact = "";
//        String guestRoom = "";
//        String guestStayDays = "";
//        String guestStartDate = "";
//
//        //Explaination:
//
//        //While the line has another word beside it
//        while (y.hasNext()) {
//            guestFirstName = y.next(); //The characters will be inserted into the variables
//            guestLastName = y.next();
//            guestEmail = y.next();
//            guestIC = y.next();
//            guestContact = y.next();
//            guestRoom = y.next();
//            guestStayDays = y.next();
//            guestStartDate = y.next();
//
//            //The variables will be inseted into an array to create guest objects
//
//            guestList.add(new Guest(guestFirstName,guestLastName,guestEmail,Long.parseLong(guestIC),Integer.parseInt(guestContact),Integer.parseInt(guestRoom),Integer.parseInt(guestStayDays),LocalDate.parse(guestStartDate)));
//
//            //The system will continue to read if it has a next line
//            if (y.hasNextLine()){y.nextLine();}
//        }
//
//        //The function will then return the array
//        return guestList;
//    }






