package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerUI extends UI implements ActionListener {

    private JFrame cui;
    private JPanel buttons, menu, balance, balanceContainer, titleContainer;
    private GridLayout gridSideContainer, gridMenuContainer;
    private JButton profile, orders, cart, logout,food, beverages, reload;
    private JLabel balanceAmt, title;

    public CustomerUI(Customer c) {
        cui = new JFrame();
        buttons = new JPanel();
        menu = new JPanel();
        balance = new JPanel();
        balanceContainer = new JPanel();
        titleContainer = new JPanel();
        title = new JLabel("APU CAFETERIA SYSTEM",JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        title.setForeground(Color.decode("#3171e0"));
        title.setFont(new Font("Nunito",Font.PLAIN,20));
        titleContainer.add(title);
        titleContainer.setBackground(Color.decode("#2a2a2a"));

        cui.setLayout(new BorderLayout());

        gridSideContainer = new GridLayout();
        gridMenuContainer = new GridLayout();

        gridSideContainer.setVgap(30);
        gridSideContainer.setColumns(1);
        gridSideContainer.setRows(4);

        gridMenuContainer.setRows(2);
        gridMenuContainer.setColumns(1);
        gridMenuContainer.setVgap(30);


        profile = new JButton("Profile");
        orders = new JButton("Orders");
        cart = new JButton("Cart");
        logout = new JButton("Logout");

        profile.addActionListener(this);
        orders.addActionListener(this);
        cart.addActionListener(this);
        logout.addActionListener(this);

        food = new JButton("Food");
        beverages = new JButton("Beverages");

        reload = new JButton("Reload");
        balanceAmt = new JLabel("RM " + c.getBalance());
        balance.setLayout(new BoxLayout(balance,BoxLayout.Y_AXIS));
        balance.add(balanceAmt);
        balance.add(reload);
        balanceAmt.setAlignmentX(Component.CENTER_ALIGNMENT);
        reload.setAlignmentX(Component.CENTER_ALIGNMENT);
        balanceContainer.add(balance);

        menu.add(food);
        menu.add(beverages);
        menu.setLayout(gridMenuContainer);
        menu.setBorder(BorderFactory.createEmptyBorder(80,80,80,80));


        buttons.add(profile);
        buttons.add(orders);
        buttons.add(cart);
        buttons.add(logout);


        buttons.setLayout(gridSideContainer);
        buttons.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        buttons.setPreferredSize(new Dimension(150,768));



        cui.add(titleContainer,BorderLayout.PAGE_START);
        cui.add(buttons,BorderLayout.LINE_START);
        cui.add(menu,BorderLayout.CENTER);
        cui.add(balanceContainer,BorderLayout.LINE_END);
        cui.setSize(1024,768);
        centerWindow(cui);
        cui.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logout) {
            cui.setVisible(false);
            Login.getX().setVisible(true);
        }
    }
}
