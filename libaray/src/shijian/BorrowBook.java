package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;


public class BorrowBook implements ActionListener {


    public void setView(BorrowBookListen view) {
        this.view = view;
    }

    BorrowBookListen view;


    @Override
    public void actionPerformed(ActionEvent e) {
        if ((view.text1.getText().isEmpty() || view.text2.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "请输入图书或 ISBN 号", "警告对话框", JOptionPane.WARNING_MESSAGE);

        }else {
            MyLibraryData borrowbook = new MyLibraryData();


            try {
//                只有 root 可以管理借书
                if (borrowbook.isroot(localname)){
                    borrowbook.addBorrowBookCord(view.text3.getText(), view.text1.getText(), view.text2.getText(), "false");
                    JOptionPane.showMessageDialog(null, "借书成功！", "恭喜你", JOptionPane.INFORMATION_MESSAGE);
                    //清空文本框
                    view.text1.setText("");
                    view.text2.setText("");
                    view.text3.setText("");

                }

                else {
                    borrowbook.addBorrowBookCord(localname, view.text1.getText(), view.text2.getText(), "false");
                    JOptionPane.showMessageDialog(null, "借书成功！", "恭喜你", JOptionPane.INFORMATION_MESSAGE);
                    //清空文本框
                    view.text1.setText("");
                    view.text2.setText("");

                }



            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }


    }
}

