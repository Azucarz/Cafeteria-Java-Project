package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerDrinkMenu extends UI implements ActionListener {
    private JScrollPane scrollPanel;
    private JPanel subPanel, drinkPanel;
    private GridLayout grid;


    public JPanel getdrinkPanel() {
        return drinkPanel;
    }

    public CustomerDrinkMenu(){
        grid = new GridLayout(Drink.drink.size()/3,3);
        drinkPanel = new JPanel();

        subPanel = new JPanel();
        subPanel.setLayout(grid);

        for (int i = 0; i < Drink.drink.size(); i++) {
            String foodName = Drink.drink.get(i).getName();
            double foodPrice = Drink.drink.get(i).getPrice();

            Button btn = new Button(foodName);
            btn.setPreferredSize(new Dimension(250,250));
            btn.addActionListener(this);
            subPanel.add(btn);
        }

        scrollPanel = new JScrollPane(subPanel);
        scrollPanel.setPreferredSize(new Dimension(800,700));
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder(80,30,80,30));

        drinkPanel.add(scrollPanel);
        drinkPanel.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object event = e.getSource();
        Button btn = null;
        String btnText = "";

        if (event instanceof Button){btn = (Button) event;}
        if (btn != null){
            btnText = btn.getLabel();
            System.out.println(btnText);
            //TODO Dialog to View Item
        }


    }
}
