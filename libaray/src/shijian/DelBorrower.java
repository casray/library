package shijian;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static shijian.LoginListen.localname;

public class DelBorrower implements ActionListener {

    public void setView(DelBorrowerListen view) {
        this.view = view;
    }

    DelBorrowerListen view;


    @Override
    public void actionPerformed(ActionEvent e) {

        MyLibraryData borr = new MyLibraryData();
        try {
            if ((view.text1.getText().equals(localname))){
                JOptionPane.showMessageDialog(null, "你确定要删除此账号吗，此操作不可更改,关闭窗口以取消", "警告", JOptionPane.INFORMATION_MESSAGE);
            }

            borr.DelBorrower(view.text1.getText());
            JOptionPane.showMessageDialog(null, "删除成功！", "恭喜你", JOptionPane.INFORMATION_MESSAGE);
            //清空文本框
            view.text1.setText("");


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}



