package Restaurant;

import java.awt.geom.Arc2D;
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
            openFile(file);
        }
    }

    public void write(String file) {
        openFile(file);

        switch (file){


//      Write Manager
//----------------------------------------------------------------------------------------------------------------------
            case "manager":
                for (int i = 0; i < Manager.managers.size(); i++) {
                    Manager m = Manager.managers.get(i);
                    x.format("%s %s %s %s %n", m.getName(), m.getPassword(), m.getEmail(), m.getNumber());
                }

                closeFormatter();
                break;


//      Write Customer
//----------------------------------------------------------------------------------------------------------------------
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


//      Write Food
//----------------------------------------------------------------------------------------------------------------------
            case "food":

                for (int i = 0; i < Food.food.size(); i++) {
                    Food f = Food.food.get(i);
                    x.format("%s %.2f%n",f.getName(),f.getPrice());
                }
                closeFormatter();
                break;


//      Write Drinks
//----------------------------------------------------------------------------------------------------------------------
            case "drink":
                for (int i = 0; i < Drink.drink.size(); i++) {
                    Drink d = Drink.drink.get(i);
                    x.format("%s %.2f%n",d.getName(),d.getPrice());
                }
                closeFormatter();
                break;

        }
//----------------------------------------------------------------------------------------------------------------------
    }




    public void read(String file) {
        openExistingFile(file);
        switch (file) {
//      Read Customer Data
//----------------------------------------------------------------------------------------------------------------------
            case "customer":
                String cName = "";
                String cEmail = "";
                String cNumber = "";
                String cTmp = "";
                int cPassword = 0;
                double balance = 0;

                ArrayList<Cart> cart = new ArrayList<Cart>();
                ArrayList<Customer> customers = new ArrayList<Customer>();

                while (y.hasNext()) {
                    cTmp = y.next();
                    try{
                        cPassword = Integer.parseInt(cTmp);

                        cEmail = y.next();
                        cNumber = y.next();
                        balance = Double.parseDouble(y.next());
                        customers.add(new Customer(cName.trim(), cPassword, cEmail, cNumber, balance, cart));

                        cName = "";

                    }catch (NumberFormatException e){
                        cName += cTmp + " ";
                    }

                }

                Customer.setCustomers(customers);

                closeScanner();
                break;

//      Read Manager Data
//----------------------------------------------------------------------------------------------------------------------
            case "manager":
                String mName = "";
                String mEmail = "";
                String mNumber = "";
                String mTmp = "";
                int mPassword;
                ArrayList<Manager> managers = new ArrayList<Manager>();

                while(y.hasNext()) {

                    mTmp = y.next();
                    try{
                        mPassword = Integer.parseInt(mTmp);

                        mEmail = y.next();
                        mNumber = y.next();

                        managers.add(new Manager(mName.trim(),mPassword,mEmail,mNumber));

                    }catch (NumberFormatException e){
                        mName += mTmp + " ";
                    }

                }
                Manager.setManagers(managers);

                closeScanner();
                break;


//      Read Customer Cart Data
//----------------------------------------------------------------------------------------------------------------------
            case "cart":
                ArrayList<Cart> carts = new ArrayList<>();
                ArrayList names = new ArrayList<>();
                String cartName;
                Scanner itemScanner;


                for (int i = 0; i < Customer.customers.size(); i++) {
                    names.add(Customer.customers.get(i).getName());
                }

                while(y.hasNextLine()){
                    cartName = y.nextLine();

                    if (names.contains(cartName.trim())){
                        for (int i = 0; i < Customer.customers.size(); i++) {

                            Customer current = Customer.customers.get(i);

                            if (current.getName().equals(cartName.trim())) {
                                current.setCart(carts);
                                carts = new ArrayList<>();
                            }
                        }
                    }

                    else {
                        itemScanner = new Scanner(cartName);
                        String cartItem = "";
                        String cartTmp = "";
                        double cartPrice = 0;
                        int cartAmt = 0;

                        while (itemScanner.hasNext()){
                            cartTmp = itemScanner.next();
                            try{
                                cartPrice = Double.parseDouble(cartTmp);
                                cartAmt = Integer.parseInt(itemScanner.next());
                                carts.add(new Cart(cartItem.trim(),cartPrice,cartAmt));
                                cartItem = "";
                            }catch (NumberFormatException e){
                                cartItem += cartTmp + " ";
                            }
                        }
                    }

                }

                closeScanner();
                break;

//      Read Food Data
//----------------------------------------------------------------------------------------------------------------------
            case "food":
                String foodName = "";
                double foodPrice = 0;
                String tmpFood = "";

                while(y.hasNext()){
                    tmpFood = y.next();
                    try{
                        foodPrice = Double.parseDouble(tmpFood);
                        Food.food.add(new Food(foodName.trim(),foodPrice));
                        foodName = "";
                    }catch (NumberFormatException e){
                        foodName += tmpFood + " ";
                    }

                }




//      Read Drink Data
//----------------------------------------------------------------------------------------------------------------------
            case "drink":
                String drinkName = "";
                double drinkPrice = 0;
                String tmpDrink = "";

                while(y.hasNext()){
                    tmpDrink = y.next();
                    try{
                        drinkPrice = Double.parseDouble(tmpDrink);
                        Drink.drink.add(new Drink(drinkName.trim(),drinkPrice));
                        drinkName = "";
                    }catch (NumberFormatException e){
                        drinkName += tmpDrink + " ";
                    }

                }
        }
//----------------------------------------------------------------------------------------------------------------------
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









