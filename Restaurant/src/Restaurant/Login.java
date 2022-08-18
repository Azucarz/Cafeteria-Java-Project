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

        if (e.getSource() == login){
            Customer.getCustomer("Sample");
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




}
