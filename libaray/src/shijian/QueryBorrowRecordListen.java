package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;

public class QueryBorrowRecordListen implements ActionListener {
    MyLibraryData t =   new MyLibraryData();
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (t.isroot(localname)){
                new QueryListen("Borrowrecord",0);
            }else if(!(t.isroot(localname))){
                new QueryListen("Borrowrecord",1);
            }
            else {
//                JOptionPane.showMessageDialog(null, "系统错误", "警告对话框", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("系统错误");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}

