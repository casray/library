
package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;


public class AddBookListen implements ActionListener {
    public JTextField text1, text2, text3, text4, text5,text6,text7;
    public  JFrame addbook;
    MyLibraryData t =   new MyLibraryData();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (t.isroot(localname)){
                addbook = new JFrame("添加图书");
                addbook.setLayout(new FlowLayout());
                addbook.setBounds(100, 100, 345, 250);

                JLabel label1 = new JLabel("书名");
                addbook.add(label1);
                text1 = new JTextField(10);
                addbook.add(text1);

                JLabel label2 = new JLabel("作者");
                addbook.add(label2);
                text2 = new JTextField(10);
                addbook.add(text2);

                JLabel label3 = new JLabel("价格");
                addbook.add(label3);
                text3 = new JTextField(10);
                addbook.add(text3);

                JLabel label4 = new JLabel("ISDN");
                addbook.add(label4);
                text4 = new JTextField(10);
                addbook.add(text4);

                JButton botton1 = new JButton("确定");
                addbook.add(botton1);

                Addbook addBook = new Addbook();
                botton1.addActionListener(addBook);
                addBook.setView(this);


//        JButton botton2= new JButton("取消");
//        addbook.add(botton2);

                addbook.setVisible(true);

            }
            else {
                JOptionPane.showMessageDialog(null, "您没有权限", "警告对话框", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}

