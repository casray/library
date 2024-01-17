package shijian;

import javax.swing.*;
import java.awt.*;

public class library extends JFrame {
    JLabel label1,label2;
    JTextField text1,text2;
    JButton botton1,botton2,botton3;

    public library(){
        init();
        setVisible(true);
//        设置关闭什么也不做，交给Closelisten关闭窗口
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    void init() {
        setLayout(new FlowLayout());
        label1 = new JLabel("用户名");
        add(label1);
        text1 = new JTextField();
        text1.setPreferredSize(new Dimension (200,30));
        add(text1);
        label2= new JLabel("密码");
        add(label2);
        text2= new JTextField();
        text2.setPreferredSize(new Dimension (200,30));
        add(text2);

        botton1 = new JButton("登陆");
        add(botton1);
        botton2= new JButton("全屏");
        add(botton2);

        botton3= new JButton("注册");
        add(botton3);

        RegisterListen registerlisten = new RegisterListen();
        botton3.addActionListener(registerlisten);
        registerlisten.setView(this);


        LoginListen loginListen = new LoginListen();
        botton1.addActionListener(loginListen);
        loginListen.setView(this);

        FullScreenListen fullScreenListen = new FullScreenListen();
        botton2.addActionListener(fullScreenListen);
        fullScreenListen.setView(this);

        CloseListen police = new  CloseListen();
        addWindowListener(police);

        police.setView(this);
    }


    public static void main(String args[]) {
        library library = new library();
        library.setBounds(100,100,250,200);
        library.setTitle("登陆界面");
    }



}


