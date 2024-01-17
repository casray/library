package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterListen implements ActionListener {
    public JTextField text1;
    public JTextField text2;
    public JFrame register;
    

    public void setView(library view) {
        this.view = view;
    }
    library view;

    @Override
    public void actionPerformed(ActionEvent e) {

        register = new JFrame("注册");
        register.setLayout(new FlowLayout());
        register.setBounds(100,100,345,250);


        JLabel label1 = new JLabel("姓名");
        register.add(label1);
        text1 = new JTextField(10);
        register.add(text1);

        JLabel label2= new JLabel("密码");
        register.add(label2);
        text2= new JTextField(10);
        register.add(text2);

        JButton botton1 = new JButton("确定");
        register.add(botton1);

        regsiter adduser =new regsiter();
        botton1.addActionListener(adduser);
        adduser.setView(this);

        register.setVisible(true);
    }
}
