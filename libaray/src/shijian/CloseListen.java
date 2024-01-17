package shijian;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CloseListen extends WindowAdapter {
    public void setView(library view) {
        this.view = view;
    }
    library view;

    public void windowClosing(WindowEvent e) {
        int n= JOptionPane.showConfirmDialog(null,"确认退出吗","确认对话框",
                JOptionPane.YES_NO_OPTION );

        if(n==JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }


}