package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main extends JFrame implements ActionListener {

    JLabel l1, l2, l3;   //label for email and password

    JTextField tf1; // email field

    JButton btn1; // login button

    JPasswordField p1; // password field

    public static void main(String arr[]) {
        DataIO data = new DataIO();
        Customer c = new Customer("Zach","123","sample@mail.com","0166645771");
        data.write(c,"new");
        new Main(); // need to change

    }
    public void actionPerformed(ActionEvent e) {

//        showData();

    }

    // login logic
//    void logic(String usr, String pswd) {
//        try {
//            RandomAccessFile raf = new RandomAccessFile(f + "\\logins.txt", "rw");
//            for (int i = 0; i < ln; i += 7) {
//                System.out.println("count " + i);
//
//                String forUser = raf.readLine().substring(6);
//                String forPswd = raf.readLine().substring(9);
//                System.out.println(forUser + forPswd);
//                if (usr.equals(forUser) & pswd.equals(forPswd)) {
//                    JOptionPane.showMessageDialog(null, "Login Successfully!!");
//                    break;
//                } else if (i == (ln - 6)) {
//                    JOptionPane.showMessageDialog(null, "incorrect username/password");
//                    break;
//                }
//                for (int k = 1; k <= 5; k++) {
//                    raf.readLine();
//                }
//            }
//        } catch (FileNotFoundException ex) {
//        } catch (IOException ex) {
//        }
//
//    }
//    //count the number of lines from file
//    void countLines() {
//        try {
//            ln = 0;
//            RandomAccessFile raf = new RandomAccessFile(f + "\\logins.txt", "rw");
//            for (int i = 0; raf.readLine() != null; i++) {
//                ln++;
//            }
//            System.out.println("number of lines:" + ln);
//        } catch (FileNotFoundException ex) {
//        } catch (IOException ex) {
//        }
//
//    }
//
//    Main() {
//
//        setTitle("Login Form in Windows Form");
//
//        setVisible(true);
//
//        setSize(800, 800);
//
//        setLayout(null);
//
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        l1 = new JLabel("Login Form in Windows Form:");
//
//        l1.setForeground(Color.blue);
//
//        l1.setFont(new Font("Serif", Font.BOLD, 20));
//
//        l2 = new JLabel("Enter Email:");
//
//        l3 = new JLabel("Enter Password:");
//
//        tf1 = new JTextField();
//
//        p1 = new JPasswordField();
//
//        btn1 = new JButton("Submit");
//
//        l1.setBounds(100, 30, 400, 30);
//
//        l2.setBounds(80, 70, 200, 30);
//
//        l3.setBounds(80, 110, 200, 30);
//
//        tf1.setBounds(300, 70, 200, 30);
//
//        p1.setBounds(300, 110, 200, 30);
//
//        btn1.setBounds(150, 160, 100, 30);
//
//        add(l1);
//
//        add(l2);
//
//        add(tf1);
//
//        add(l3);
//
//        add(p1);
//
//        add(btn1);
//
//        btn1.addActionListener(this);
//
//    }
//

//
//    public void showData() {
//
//        JFrame f1 = new JFrame();
//
//        JLabel l, l0;
//
//        String str1 = tf1.getText();
//
//        char[] p = p1.getPassword();
//
//        String str2 = new String(p);
//
//        try {
//
//            createFolder();
//            readFile();
//            countLines();
//            logic(str1, str2);
//
//        } catch (Exception ex) {
//
//            System.out.println(ex);
//
//        }
//    }


}
