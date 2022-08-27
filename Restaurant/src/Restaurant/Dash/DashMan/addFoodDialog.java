package Restaurant.Dash.DashMan;

import Restaurant.DataIO;
import Restaurant.Drink;
import Restaurant.Food;
import Restaurant.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class addFoodDialog extends UI implements ActionListener {

    // Components of the Form
    private DataIO data = new DataIO();

    private JFrame frame;
    private JLabel title;
    private JLabel name;
    private JTextField tname;
    private JLabel mno;
    private JTextField tmno;
    private JLabel tpeoffood;
    private JRadioButton food;
    private JRadioButton drink;
    private ButtonGroup gengp;

    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JTextArea resadd;



    public addFoodDialog() {
        frame = new JFrame();
        frame.setTitle("Adding Menu Form");
        frame.setBounds(300, 90, 900, 600);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);

        title = new JLabel("Adding Menu Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        frame.add(title);


        name = new JLabel("Name");
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(100, 20);
        name.setLocation(100, 100);
        frame.add(name);

        tname = new JTextField();
        tname.setFont(new Font("Arial", Font.PLAIN, 15));
        tname.setSize(190, 20);
        tname.setLocation(200, 100);
        frame.add(tname);



        mno = new JLabel("Price");
        mno.setFont(new Font("Arial", Font.PLAIN, 15));
        mno.setSize(100, 20);
        mno.setLocation(100, 150);
        frame.add(mno);

        tmno = new JTextField();
        tmno.setFont(new Font("Arial", Font.PLAIN, 15));
        tmno.setSize(150, 20);
        tmno.setLocation(200, 150);
        frame.add(tmno);

        tpeoffood = new JLabel("Type of Item");
        tpeoffood.setFont(new Font("Arial", Font.PLAIN, 15));
        tpeoffood.setSize(100, 20);
        tpeoffood.setLocation(100, 200);
        frame.add(tpeoffood);

        food = new JRadioButton("Food");
        food.setFont(new Font("Arial", Font.PLAIN, 15));
        food.setSelected(false);
        food.setSize(75, 20);
        food.setLocation(200, 200);
        frame.add(food);

        drink = new JRadioButton("Drink");
        drink.setFont(new Font("Arial", Font.PLAIN, 15));
        drink.setSelected(false);
        drink.setSize(80, 20);
        drink.setLocation(275, 200);
        frame.add(drink);

        gengp = new ButtonGroup();
        gengp.add(food);
        gengp.add(drink);

        term = new JCheckBox("I authorize to add this menu.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        frame.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        frame.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        frame.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        frame.add(tout);


        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true);
        frame.add(resadd);
        frame.setVisible(true);
    }

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
                message(frame,"Item has been added successfully!","Item Added");
                frame.dispose(); //TODO Exception Handling Instead?
            }
            else {
                tout.setText("");
                resadd.setText("");
                message(frame,"Please accept the terms & conditions","Terms & Conditions");

            }
        }

        else if (e.getSource() == reset) {
            try {
                reset();
            }catch (NullPointerException nullPointerException){
                message(frame,"The form is already cleared.","Form is Empty");
            }
        }


        try {
            String textFieldValue = tname.getText();
            String textFieldPrice = tmno.getText();

            if (food.isSelected()) {
                Food.food.add(new Food(textFieldValue,Double.parseDouble(textFieldPrice)));
                data.write("food");
            }else{
                Drink.drink.add(new Drink(textFieldValue,Double.parseDouble(textFieldPrice)));
                data.write("drink");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private void reset(){
        String def = "";
        tname.setText(def);
        tmno.setText(def);
        tout.setText(def);
        term.setSelected(false);
        resadd.setText(def);
    }

}
