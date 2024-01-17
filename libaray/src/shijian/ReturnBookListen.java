
package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;


    public class ReturnBookListen implements ActionListener {
        public JTextField text1, text2, text3, text4, text5, text6;
        MyLibraryData t = new MyLibraryData();

        @Override
        public void actionPerformed(ActionEvent e) {

            JFrame addbook = new JFrame("还书模块");
            addbook.setLayout(new FlowLayout());
            addbook.setBounds(100, 100, 345, 250);

            JLabel label1 = new JLabel("书名");
            addbook.add(label1);
            text1 = new JTextField(10);
            addbook.add(text1);

            JLabel label2 = new JLabel("ISBN");
            addbook.add(label2);
            text2 = new JTextField(10);
            addbook.add(text2);

            JLabel label3 = new JLabel("还书用户名");
            addbook.add(label3);
            text3 = new JTextField(10);
            text3.setText(localname);

//        只有 root 用户只能改其他人的数据
            try {
                if (!(t.isroot(localname))){
                    text3.setEditable(false);
                    text3.setBackground(Color.LIGHT_GRAY);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            addbook.add(text3);




            JButton botton1 = new JButton("还书");
            addbook.add(botton1);

            ReturnBook returnbook = new ReturnBook();
            botton1.addActionListener(returnbook);
            returnbook.setView(this);


//        JButton botton2= new JButton("取消");
//        addbook.add(botton2);

            addbook.setVisible(true);

        }
    }


