package shijian;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static shijian.LoginListen.localname;

public class QueryListen extends JFrame {
//    public class QueryListen extends JFrame implements ActionListener {
    private JButton queryButton;
    private JTable dataTable;
    private JScrollPane scrollPane;
//    public  String querytype;
    public QueryListen(String querytype ,int restrict) {

        setTitle("查询页面");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        queryButton = new JButton("查询");
        queryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 连接MySQL数据库
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "csl800809");
                    Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    ResultSet rs = null;
                    if (restrict==0){
                        //        restrict = 0 不限制查询
                        rs = stmt.executeQuery("SELECT * FROM " + querytype);
                    }


                    else if (restrict==1){
                        //        restrict = 1 限制查询为当前用户
                        rs = stmt.executeQuery("SELECT * FROM " + querytype + " WHERE name=('" + localname + "')");
                    }
                    else {
//                        JOptionPane.showMessageDialog(null, "系统错误", "警告对话框", JOptionPane.WARNING_MESSAGE);
                        System.out.println("系统错误");
                    };


                    // 将查询结果转换为二维数组
                    int columnCount = rs.getMetaData().getColumnCount();
                    Object[][] data = new Object[getRowCount(rs)][columnCount];
                    int row = 0;
                    while (rs.next()) {
                        for (int col = 0; col < columnCount; col++) {
                            data[row][col] = rs.getObject(col + 1);
                        }
                        row++;
                    }

                    // 创建JTable并设置数据模型
                    dataTable = new JTable(data, getColumnNames(rs));
                    scrollPane.setViewportView(dataTable);
                    setBounds(495,220,600,400);

                    // 关闭数据库连接
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(QueryListen.this, "Error occurred while querying data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dataTable = new JTable();
        scrollPane = new JScrollPane(dataTable);

        add(queryButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 获取查询结果集的行数
    private int getRowCount(ResultSet rs) throws SQLException {
        int rowCount = 0;
        if (rs.last()) {
            rowCount = rs.getRow();
            rs.beforeFirst();
        }
        return rowCount;
    }

    // 获取查询结果集的列名
    private String[] getColumnNames(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int i = 0; i < columnCount; i++) {
            columnNames[i] = rsmd.getColumnName(i + 1);
        }
        return columnNames;
    }


}
