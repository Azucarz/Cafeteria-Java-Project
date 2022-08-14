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
        try{y = new Scanner(new File(file+".txt"));System.out.println("IT WORKS");}
        catch (FileNotFoundException e) {e.printStackTrace();}
    }

    public void write(Object o,String file){
        openFile(file);
        if (o instanceof Manager) {
            x.format("%s %s %s %s",((Manager) o).getName(),((Manager) o).getPassword(),((Manager) o).getEmail(),String.valueOf(((Manager) o).getNumber()));
            closeFormatter();
        } else if (o instanceof Customer) {
            x.format("%s %s %s %s",((Customer) o).getName(),((Customer) o).getPassword(),((Customer) o).getEmail(),String.valueOf(((Customer) o).getNumber()));
            closeFormatter();
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

}




