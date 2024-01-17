package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;

public class UpRootListen implements ActionListener {
    public JTextField text1,text2,text3,text4,text5,text6;
    MyLibraryData t =   new MyLibraryData();

    public JFrame addbook ;
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (t.isroot(localname)) {
                JOptionPane.showMessageDialog(null, "您已经是管理员了", "警告对话框", JOptionPane.INFORMATION_MESSAGE);

            }
            else {
                addbook = new JFrame("升级账户");
                addbook.setLayout(new FlowLayout());
                addbook.setBounds(100, 100, 345, 250);

                JLabel label1 = new JLabel("要升级的账户名");
                addbook.add(label1);
                text1 = new JTextField(10);
                addbook.add(text1);

                JLabel label2 = new JLabel("管理员密码");
                addbook.add(label2);
                text2 = new JTextField(10);
                addbook.add(text2);


                JButton botton1 = new JButton("确定");
                addbook.add(botton1);

                UPRoot update = new UPRoot();
                botton1.addActionListener(update);
                update.setView(this);


//        JButton botton2= new JButton("取消");
//        addbook.add(botton2);

                addbook.setVisible(true);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
