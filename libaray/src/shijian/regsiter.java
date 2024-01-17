//package shijian;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.SQLException;
//
//public class regsiter implements ActionListener {
//
//
//    public void setView(RegisterListen view) {
//        this.view = view;
//    }
//
//    RegisterListen view;
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        MyLibraryData addUser = new MyLibraryData();
//        try {
//            addUser.addBorrower(view.text1.getText(), view.text2.getText(),"");
//            JOptionPane.showMessageDialog(null,"注册成功！","恭喜你",JOptionPane.INFORMATION_MESSAGE);
//            //清空文本框
//            view.text1.setText("");
//            view.text2.setText("");
//
//            view.register.dispose();
//
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        } catch (ClassNotFoundException ex) {
//            throw new RuntimeException(ex);
//        }
//    }
//}
package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class regsiter implements ActionListener {
    public static final String LETTER_PATTERN = "^.*[a-zA-Z]+.*$";//字母
    public static final String NUMBER_PATTERN = "^.*[0-9]+.*$";//数字
    public static final String SPECIAL_CHAR_PATTERN = "^.*[/^/$/.//,;:'!@#%&/*/|/?/+/(/)/[/]/{/}]+.*$";//特殊字符
    public static final String ONLY_LETTER_OR_NUMBER = "^[a-z0-9A-Z]+$";


    public void setView(RegisterListen view) {
        this.view = view;
    }

    RegisterListen view;


    @Override
    public void actionPerformed(ActionEvent e) {
        MyLibraryData addUser = new MyLibraryData();
        try {

            if (view.text1.getText().isEmpty() || view.text2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "请输入用户名或密码", "警告对话框", JOptionPane.WARNING_MESSAGE);

            } else if ((view.text1.getText().trim().matches(SPECIAL_CHAR_PATTERN)) || (view.text2.getText().trim().matches(SPECIAL_CHAR_PATTERN))) {

                JOptionPane.showMessageDialog(null, "用户名含有非法字符", "警告对话框", JOptionPane.INFORMATION_MESSAGE);
            } else {

                addUser.addBorrower(view.text1.getText(), view.text2.getText(),"");
                JOptionPane.showMessageDialog(null,"注册成功！","恭喜你",JOptionPane.INFORMATION_MESSAGE);
                //清空文本框
                view.text1.setText("");
                view.text2.setText("");

                view.register.dispose();
            }


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
