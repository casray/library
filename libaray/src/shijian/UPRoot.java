package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UPRoot implements ActionListener {

    public void setView(UpRootListen view) {
        this.view = view;
    }

    UpRootListen view;

    @Override

    public void actionPerformed(ActionEvent e) {
        if ("root".equals(view.text2.getText())){
                MyLibraryData updateroo = new MyLibraryData();
                try {
                    updateroo.updateroot(view.text1.getText());
                    JOptionPane.showMessageDialog(null, "升级成功！", "恭喜你", JOptionPane.INFORMATION_MESSAGE);
                    view.addbook.dispose();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        }


