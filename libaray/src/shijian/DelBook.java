package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class DelBook implements ActionListener {

    public void setView(DelBookListen view) {
        this.view = view;
    }

    DelBookListen view;


    @Override
    public void actionPerformed(ActionEvent e) {
        MyLibraryData borr = new MyLibraryData();
        try {
            borr.DelBook(view.text1.getText(), view.text2.getText());
            JOptionPane.showMessageDialog(null, "删除成功！", "恭喜你", JOptionPane.INFORMATION_MESSAGE);
            //清空文本框
            view.text1.setText("");
            view.text2.setText("");


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}


