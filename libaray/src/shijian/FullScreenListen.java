package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FullScreenListen implements ActionListener {
    void setView(library view ){
        this.view=view;
    }
    library view;
    @Override
    public void actionPerformed(ActionEvent e) {
        view.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        view.setLocation(0,0);
    }
}
