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

    public void closeFormatter(){x.close();}
    public void closeScanner(){y.close();}


    public void openFile(String file){
        try{x = new Formatter(file+".txt");}
        catch (FileNotFoundException e) {e.printStackTrace();}
    }

    public void openExistingFile(String file){
        try{y = new Scanner(new File(file+".txt"));}
        catch (FileNotFoundException e) {e.printStackTrace();}
    }

    public void write(Object o,String file){
        openFile(file);
        if (o instanceof Manager) {
            x.format("%s %s %s %s%n",((Manager) o).getName(),((Manager) o).getPassword(),((Manager) o).getEmail(),((Manager) o).getNumber());
            closeFormatter();
        }
        else if (o instanceof Customer) {
            x.format("%s %s %s %s %.2f%n",((Customer) o).getName(),((Customer) o).getPassword(),((Customer) o).getEmail(),((Customer) o).getNumber(),((Customer) o).getBalance());
            if (!(((Customer) o).getCart().size() == 0)){
                closeFormatter();
                openFile("cart");
                x.format("%s%n",((Customer) o).getName());
                for (int i = 0; i < ((Customer) o).getCart().size(); i++) {
                    String item = ((Customer) o).getCart().get(i).getItem();
                    double price = ((Customer) o).getCart().get(i).getPrice();
                    int amt = ((Customer) o).getCart().get(i).getAmt();

                    x.format("%s %.2f %d%n",item,price,amt);
                }
                x.format("%n");
            }
            closeFormatter();
        }
    }

    public ArrayList<Object> read(String file){
        openExistingFile(file);
        ArrayList obj =new ArrayList<>();
        switch(file){
            case "customer":
                break;
            case "manager":
                break;
            case "menu":
                break;
            case "order":
                break;
            case "cart":



        }



        return obj;
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

}




