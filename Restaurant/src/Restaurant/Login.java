package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {
    private JFrame x;
    private JPanel main,username,password,buttons;
    private Label labeluser,labelpass;
    private TextField textuser;
    private JPasswordField textpass;
    private Button login,register;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login) {

            String user = textuser.getText();
            String password = String.valueOf(textpass.getPassword());

            if (textuser.getText().isEmpty()){
                message("Please enter your username");
            } else if (String.valueOf(textpass.getPassword()).isEmpty()) {
                message("Please enter your password");
            }else{
                Customer c = Customer.getCustomer(textuser.getText());
                Manager m = Manager.getCustomer(textuser.getText());

                if (c != null && m != null) {
                    if(c.getName().equals(m.getName())){
                        sameName();
                    }
                }

                if (c != null) {
                    checkPassword(c,user,password);
                }
                else if (m != null) {
                    checkPassword(m,user,password);
                }else{
                    message("User Not Found");
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
        centreWindow(x);
        x.setVisible(true);
    }

    private void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int xAxis = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int yAxis = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(xAxis, yAxis);

    }

    private void message(String message){
        JOptionPane.showMessageDialog(x,message);
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

    private void checkPassword(User u,String user, String password){

        if (u.getName().equals(user)) {
            if (u.getPassword().equals(password)) {
                if (u instanceof Customer) {
                    //TODO Make Customer GUI
                    System.out.println("Customer Interface");
                } else if (u instanceof Manager) {
                    //TODO Make Manager GUI
                    System.out.println("Manager Interface");
                }
            } else {
                message("Incorrect Password!");
                textpass.setText("");
            }
        }
    }

}
