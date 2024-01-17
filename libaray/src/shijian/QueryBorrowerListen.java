package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;

public class QueryBorrowerListen implements ActionListener {
    MyLibraryData t =   new MyLibraryData();
    @Override

    public void actionPerformed(ActionEvent e) {
        try {
            if (t.isroot(localname)){
            new QueryListen("Borrower",0);
            }
            else {
                JOptionPane.showMessageDialog(null, "您没有权限", "警告对话框", JOptionPane.INFORMATION_MESSAGE);

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    }


