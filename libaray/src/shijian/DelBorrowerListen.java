
package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;


public class DelBorrowerListen implements ActionListener {
    public JTextField text1, text2, text3, text4, text5,text6,text7;
    MyLibraryData t =   new MyLibraryData();

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (t.isroot(localname)){
                JFrame addbook = new JFrame("删除用户");
                addbook.setLayout(new FlowLayout());
                addbook.setBounds(100, 100, 345, 250);

                JLabel label1 = new JLabel("用户名");
                addbook.add(label1);
                text1 = new JTextField(10);
                addbook.add(text1);


                JButton botton1 = new JButton("删除");
                addbook.add(botton1);

                DelBorrower delborrower = new DelBorrower();
                botton1.addActionListener(delborrower);
                delborrower.setView(this);


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


