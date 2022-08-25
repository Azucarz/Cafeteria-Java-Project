package Restaurant.Dash.DashMan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class MyFrame extends JFrame implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel tpeoffood;
    private JRadioButton food;
    private JRadioButton drink;
    private ButtonGroup gengp;
    private JLabel serialnumber;

    private JLabel add;
    private JTextArea tadd;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;



    // constructor, to initialize the components
    // with default values.
    public MyFrame()
    {
        setTitle("Adding Menu Form");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Adding Menu Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        c.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        c.add(tname);

        mno = new JLabel("Price");
        mno.setFont(new Font("Arial", Font.PLAIN, 20));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        c.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 150);
        c.add(tmno);

        tpeoffood = new JLabel("T.O.F");
        tpeoffood.setFont(new Font("Arial", Font.PLAIN, 20));
        tpeoffood.setSize(100, 20);
        tpeoffood.setLocation(100, 200);
        c.add(tpeoffood);

        food = new JRadioButton("Food");
        food.setFont(new Font("Arial", Font.PLAIN, 15));
        food.setSelected(true);
        food.setSize(75, 20);
        food.setLocation(200, 200);
        c.add(food);

        drink = new JRadioButton("Drink");
        drink.setFont(new Font("Arial", Font.PLAIN, 15));
        drink.setSelected(false);
        drink.setSize(80, 20);
        drink.setLocation(275, 200);
        c.add(drink);

        gengp = new ButtonGroup();
        gengp.add(food);
        gengp.add(drink);

        serialnumber = new JLabel("Serial Number");
        serialnumber.setFont(new Font("Arial", Font.PLAIN, 20));
        serialnumber.setSize(100, 20);
        serialnumber.setLocation(100, 250);
        c.add(serialnumber);

        term = new JCheckBox("I authorize to add this menu.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        c.add(resadd);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                String data1;
                String data
                        = "Name : "
                        + tname.getText() + "\n"
                        + "Price : "
                        + tmno.getText() + "\n";
                if (food.isSelected())
                    data1 = "Type Food : Food"
                            + "\n";
                else
                    data1 = "Type Food : Drink"
                            + "\n";



                tout.setText(data + data1 );
                tout.setEditable(false);
                res.setText("Added Successfully..");
            }
            else {
                tout.setText("");
                resadd.setText("");
                res.setText("Please accept the"
                        + " terms & conditions..");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            tname.setText(def);
            tadd.setText(def);
            tmno.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);
            resadd.setText(def);
        }


        try {
            String textFieldValue = tname.getText();
            String textFieldprice = tmno.getText();

            File file = new File("C:\\Users\\User\\Documents\\Degree\\OODJ\\Restaurant\\Java-Project\\menu.txt");

            // if file doesnt exists, then create it
            if (!file.exists())
                file.createNewFile();

            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(textFieldValue + " " + textFieldprice + "\r\n");
            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}

// Driver Code
class addmenu {

    public static void main(String[] args) throws Exception
    {
        MyFrame f = new MyFrame();






    }
}