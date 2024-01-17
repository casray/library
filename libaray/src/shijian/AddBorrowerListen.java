package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;


public class AddBorrowerListen implements ActionListener {
    public JTextField text1,text2,text3,text4,text5,text6;
    
    public  JFrame addborrower;
    MyLibraryData t =   new MyLibraryData();

    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (t.isroot(localname)){

        addborrower = new JFrame("添加借阅者");
        addborrower.setLayout(new FlowLayout());
        addborrower.setBounds(100,100,345,250);

        JLabel label1 = new JLabel("姓名");
        addborrower.add(label1);
        text1 = new JTextField(10);
        addborrower.add(text1);

        JLabel label2= new JLabel("密码");
        addborrower.add(label2);
        text2= new JTextField(10);
        addborrower.add(text2);

        JLabel label3= new JLabel("权限类型");
        addborrower.add(label3);
        text3= new JTextField(10);
        addborrower.add(text3);

        JButton botton1 = new JButton("确定");
        addborrower.add(botton1);

        AddBorrower  addBorrower =new  AddBorrower();
        botton1.addActionListener(addBorrower);
        addBorrower.setView(this);


//        JButton botton2= new JButton("取消");
//        addborrower.add(botton2);

        addborrower.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "您没有权限", "警告对话框", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
