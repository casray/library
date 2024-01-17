package shijian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueryBookListen implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new QueryListen("book",0);
    }
}
