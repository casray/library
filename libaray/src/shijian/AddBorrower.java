package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddBorrower implements ActionListener {


    public void setView(AddBorrowerListen view) {
        this.view = view;
    }



    AddBorrowerListen view;


    @Override
    public void actionPerformed(ActionEvent e) {
        MyLibraryData borrower = new MyLibraryData();
        try {
            borrower.addBorrower(view.text1.getText(), view.text2.getText(), view.text3.getText());
            JOptionPane.showMessageDialog(null,"添加成功！","恭喜你",JOptionPane.INFORMATION_MESSAGE);
            //清空文本框
            view.text1.setText("");
            view.text2.setText("");
            view.text3.setText("");


            view.addborrower.dispose();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
