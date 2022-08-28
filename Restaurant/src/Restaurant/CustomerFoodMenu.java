package Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerFoodMenu extends UI implements ActionListener {
    private JScrollPane scrollPanel;
    private JPanel subPanel, foodPanel;
    private GridLayout grid;


    public JPanel getFoodPanel() {
        return foodPanel;
    }

    public CustomerFoodMenu(){
        grid = new GridLayout(Food.food.size()/3,3);
        grid.setVgap(10);
        grid.setHgap(10);

        foodPanel = new JPanel();

        subPanel = new JPanel();
        subPanel.setLayout(grid);

        for (int i = 0; i < Food.food.size(); i++) {
            String foodName = Food.food.get(i).getName();
            double foodPrice = Food.food.get(i).getPrice();

            Button btn = new Button(foodName);
            btn.setPreferredSize(new Dimension(200,200));
            btn.addActionListener(this);
            subPanel.add(btn);
        }

        scrollPanel = new JScrollPane(subPanel);
        scrollPanel.setOpaque(false);
        scrollPanel.setPreferredSize(new Dimension(800,700));
        scrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setBorder(BorderFactory.createEmptyBorder(80,30,80,30));

        foodPanel.add(scrollPanel);
        foodPanel.setVisible(true);
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
