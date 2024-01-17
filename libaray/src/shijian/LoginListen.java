package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.sql.SQLException;

public class LoginListen implements ActionListener {

    public  static String localname;

    public static final String LETTER_PATTERN = "^.*[a-zA-Z]+.*$";//字母
    public static final String NUMBER_PATTERN = "^.*[0-9]+.*$";//数字
    public static final String SPECIAL_CHAR_PATTERN = "^.*[/^/$/.//,;:'!@#%&/*/|/?/+/(/)/[/]/{/}]+.*$";//特殊字符
    public static final String ONLY_LETTER_OR_NUMBER = "^[a-z0-9A-Z]+$";

    public void setView(library view) {
        this.view = view;
    }

    library view;

    MyLibraryData t = new MyLibraryData();

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean useristrue;

        MyLibraryData tt = new MyLibraryData();
        try {
            useristrue = tt.isBorrower(view.text1.getText(), view.text2.getText());
//            System.out.println(useristrue);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
//        存取用户名作为全局变量
        localname = view.text1.getText();
//        if ((view.text1.getText().trim()).equals("230")&&(view.text2.getText().trim()).equals("123")) {
        if (useristrue) {

            try {
//                管理员界面
                if (t.isroot(localname)){
                    JOptionPane.showMessageDialog(null, "登陆成功！", "恭喜你", JOptionPane.INFORMATION_MESSAGE);
                    view.text1.setText("");
                    view.text2.setText("");

                    JFrame newFrame = new JFrame("图书管理系统");
                    newFrame.setBounds(100, 100, 500, 260);
                    newFrame.setLayout(new FlowLayout());
                    JMenuBar menubar = new JMenuBar();
                    JMenu addmenu = new JMenu("添加菜单");
                    JMenu querymenu = new JMenu("查询菜单");
                    JMenu delmenu = new JMenu("删除菜单");
                    JMenu borrowmenu = new JMenu("借书菜单");
                    JMenu information = new JMenu("欢迎你管理员："+localname);

                    JMenuItem item1 = new JMenuItem("添加图书");
                    item1.setAccelerator(KeyStroke.getKeyStroke('A'));
                    AddBookListen addBook = new AddBookListen();
                    item1.addActionListener(addBook);

                    JMenuItem item2 = new JMenuItem("添加借阅者");
                    item2.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
                    AddBorrowerListen addBorrowerListen = new AddBorrowerListen();
                    item2.addActionListener(addBorrowerListen);

                    JMenuItem item3 = new JMenuItem("查询图书");
                    QueryBookListen querybook = new QueryBookListen();
                    item3.addActionListener(querybook);

                    JMenuItem item4 = new JMenuItem("查询借阅者");
                    QueryBorrowerListen queryborrower = new QueryBorrowerListen();
                    item4.addActionListener(queryborrower);

                    JMenuItem item6 = new JMenuItem("管理借书");
                    BorrowBookListen borrowbook = new BorrowBookListen();
                    item6.addActionListener(borrowbook);

                    JMenuItem item7 = new JMenuItem("查询借书记录");
                    QueryBorrowRecordListen Queryborrowrecord = new QueryBorrowRecordListen();
                    item7.addActionListener(Queryborrowrecord);

                    JMenuItem item8 = new JMenuItem("管理还书");
                    ReturnBookListen returnbook = new ReturnBookListen();
                    item8.addActionListener(returnbook);

                    JMenuItem item9 = new JMenuItem("删除图书");
                    DelBookListen delbook = new DelBookListen();
                    item9.addActionListener(delbook);

                    JMenuItem item10 = new JMenuItem("删除借阅者");
                    DelBorrowerListen delborrower = new DelBorrowerListen();
                    item10.addActionListener(delborrower);






                    addmenu.add(item1);
                    addmenu.add(item9);
                    addmenu.addSeparator();
                    addmenu.add(item2);
                    addmenu.add(item10);


                    querymenu.add(item3);
                    querymenu.add(item4);
                    querymenu.add(item7);

                    borrowmenu.add(item6);
                    borrowmenu.add(item8);



                    menubar.add(addmenu);
                    menubar.add(querymenu);
                    menubar.add(borrowmenu);
                    menubar.add(information);

//        添加到容器
                    newFrame.setJMenuBar(menubar);
                    newFrame.setVisible(true);
                }
                else{

//                    普通用户界面
                    JOptionPane.showMessageDialog(null, "登陆成功！", "恭喜你", JOptionPane.INFORMATION_MESSAGE);
                    view.text1.setText("");
                    view.text2.setText("");

                    JFrame newFrame = new JFrame("图书管理系统");
                    newFrame.setBounds(100, 100, 500, 260);
                    newFrame.setLayout(new FlowLayout());

                    JMenuBar menubar = new JMenuBar();
//                    JMenu addmenu = new JMenu("添加菜单");
                    JMenu querymenu = new JMenu("查询菜单");
                    JMenu borrowmenu = new JMenu("借书菜单");
                    JMenu mymenu = new JMenu("我的");
                    JMenu information = new JMenu("欢迎："+localname);



                    JMenuItem item3 = new JMenuItem("查询图书");

//            QueryListen querybook = new QueryListen("book");
//            item3.addActionListener(querybook);

                    QueryBookListen querybook = new QueryBookListen();
                    item3.addActionListener(querybook);


                    JMenuItem item7 = new JMenuItem("查询借书记录");

                    QueryBorrowRecordListen Queryborrowrecord = new QueryBorrowRecordListen();
                    item7.addActionListener(Queryborrowrecord);

                    JMenuItem item5 = new JMenuItem("升级 root 管理员");
                    UpRootListen uproot = new UpRootListen();
                    item5.addActionListener(uproot);

                    JMenuItem item6 = new JMenuItem("我要借书");

                    BorrowBookListen borrowbook = new BorrowBookListen();
                    item6.addActionListener(borrowbook);


                    JMenuItem item8 = new JMenuItem("我要还书");
                    ReturnBookListen returnbook = new ReturnBookListen();
                    item8.addActionListener(returnbook);


                    querymenu.add(item3);
                    querymenu.add(item7);
//            addmenu.add(menu3);
                    mymenu.add(item5);
                    borrowmenu.add(item6);
                    borrowmenu.add(item8);



//            menu3.add(new JMenuItem("子菜单里的菜单项", new ImageIcon("c.gif")));
                    menubar.add(querymenu);
                    menubar.add(borrowmenu);
                    menubar.add(mymenu);
                    menubar.add(information);

//        添加到容器
                    newFrame.setJMenuBar(menubar);
//           System.out.printf(String.valueOf(!(view.text1.getText().trim().matches(ONLY_LETTER_OR_NUMBER))));

                    newFrame.setVisible(true);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


        } else if (view.text1.getText().isEmpty() || view.text2.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "请输入用户名或密码", "警告对话框", JOptionPane.WARNING_MESSAGE);
//       } else if ((view.text1.getText().trim()).equals("230")&&(view.text2.getText().trim()).equals("123")) {
//
//       } else if (!(view.text1.getText().trim().matches(LETTER_PATTERN)) ) {
//           System.out.printf("用户名只能为英文字母和数字");

        } else if ((view.text1.getText().trim().matches(SPECIAL_CHAR_PATTERN)) || (view.text2.getText().trim().matches(SPECIAL_CHAR_PATTERN))) {

            JOptionPane.showMessageDialog(null, "用户名含有非法字符", "警告对话框", JOptionPane.INFORMATION_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(null, "用户名或密码错误", "警告对话框", JOptionPane.ERROR_MESSAGE);

        }

    }
}
