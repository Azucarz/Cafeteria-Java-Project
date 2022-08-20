package Restaurant.managerlogis;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;

public class Manager {

    private JTextField foodnametb;
    private JTextField typeoffoodtb;
    private JTextField foodpricetb;
    private JTextField foodstatustb;
    private JLabel foodnamelbl;
    private JLabel typeoffoodlbl;
    private JLabel pricefoodlbl;
    private JLabel foodstatuslbl;
    private JButton addbtn;

    public Manager() {
        addbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String foodname = foodnametb.getText();
                String typeoffood = typeoffoodtb.getText();
                String price = foodpricetb.getText();
                String status = foodstatustb.getText();

                try
                {
                    FileWriter Writer = new FileWriter("menu.txt",true);
                    Writer.write(" "+foodname+" "+typeoffood+" "+price+"  "+status);
                    Writer.write(System.getProperty("line.separator"));
                    Writer.close();
                    JOptionPane.showMessageDialog(null,"Success");


                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }

            private void setVisible(boolean b) {
            }
        });
    }
}
