package Restaurant;

import java.io.*;

public class DataIO {
    File folder = new File(System.getProperty("user.dir") + "\\Database");   //file path and change before use

    // create folder in which record is save
    void createFolder() {
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }


    //check file is exist or not
    void readFile(String file) {
        try {
            FileReader fr = new FileReader(folder + "\\" + file + ".txt");
            System.out.println("file exists!");
        } catch (FileNotFoundException ex) {
            try {
                FileWriter fw = new FileWriter(folder + "\\" + file + ".txt");
                System.out.println("File created");
            } catch (IOException ex1) {
                System.out.println(ex1);
            }
        }

    }


}


