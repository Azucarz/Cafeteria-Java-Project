package Restaurant;

import Restaurant.Dash.DashMan.ManagerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends UI implements ActionListener {
    private static JFrame x;
    private JPanel main,username,password,buttons;
    private Label labeluser,labelpass;
    private TextField textuser;
    private JPasswordField textpass;
    private Button login,register;


    public static CustomerUI cui;
    public static ManagerUI mui;



    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            String user = textuser.getText();
            String password = String.valueOf(textpass.getPassword());

            if (textuser.getText().isEmpty()){
                message(x,"Please enter your username");
            } else if (String.valueOf(textpass.getPassword()).isEmpty()) {
                message(x,"Please enter your password");
            }else{
                Customer c = Customer.getCustomer(textuser.getText());
                Manager m = Manager.getCustomer(textuser.getText());

                if (c != null && m != null) {
                    if(c.getName().equals(m.getName())){
                        sameName();
                    }
                }

                if (c != null) {
                    checkPassword(c,user,Integer.parseInt(password));
                }
                else if (m != null) {
                    checkPassword(m,user,Integer.parseInt(password));
                }else{
                    message(x,"User Not Found");
                    textuser.setText("");
                    textpass.setText("");
                }
            }

        }else if(e.getSource() == register){

        }
    }

    public Login(){
        x = new JFrame("APU Cafeteria System");

        main = new JPanel();
        username = new JPanel();
        password = new JPanel();
        labeluser = new Label("Username");
        textuser = new TextField(20);
        labelpass = new Label("Password");
        textpass = new JPasswordField(14);
        username.add(labeluser);
        username.add(textuser);
        password.add(labelpass);
        password.add(textpass);

        login = new Button("Login");
        register = new Button("Signup");

        buttons = new JPanel();
        buttons.add(login);
        buttons.add(register);

        login.addActionListener(this);
        register.addActionListener(this);

        username.setLayout(new FlowLayout(FlowLayout.LEFT));
        password.setLayout(new FlowLayout(FlowLayout.LEFT));

        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(username);
        main.add(password);
        main.add(buttons);

        main.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));

        x.add(main);
        x.pack();
        x.setResizable(false);
        centerWindow(x);
        x.setVisible(true);
    }



    private void sameName(){
        String[] role = {"Manager","Student"};
        String s = (String)JOptionPane.showInputDialog(
                x,
                "Select User Type",
                "Select User Type",
                JOptionPane.PLAIN_MESSAGE,
                null,
                role,
                "Student");
    }

    private void checkPassword(User u,String user, int password){

        if (u.getName().equals(user)) {
            if (u.getPassword() == password) {
                if (u instanceof Customer) {
                    textuser.setText("");
                    textpass.setText("");
                    x.setVisible(false);
                    Customer u1 = (Customer) u;
                    cui = new CustomerUI(u1);

                } else if (u instanceof Manager) {
                    Manager u1 = (Manager) u;
                    mui = new ManagerUI();
                }
            } else {
                message(x,"Incorrect Password!");
                textpass.setText("");
            }
        }
    }

    public static JFrame getLogin() {
        return x;
    }
}
