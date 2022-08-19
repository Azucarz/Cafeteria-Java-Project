package Restaurant;

import javax.swing.*;
import java.awt.*;

public abstract class UI {
    public void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int xAxis = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int yAxis = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(xAxis, yAxis);

    }

    public void message(Window frame,String message){
        JOptionPane.showMessageDialog(frame,message);
    }
}
