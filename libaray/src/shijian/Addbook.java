package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Addbook implements ActionListener {


    public void setView(AddBookListen view) {
        this.view = view;
    }

    AddBookListen view;


    @Override
    public void actionPerformed(ActionEvent e) {
        MyLibraryData borr = new MyLibraryData();
        try {
            borr.addBook(view.text1.getText(), view.text2.getText(), view.text3.getText(), view.text4.getText());
            JOptionPane.showMessageDialog(null, "添加成功！", "恭喜你", JOptionPane.INFORMATION_MESSAGE);
            //清空文本框
            view.text1.setText("");
            view.text2.setText("");
            view.text3.setText("");
            view.text4.setText("");

            view.addbook.dispose();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}

