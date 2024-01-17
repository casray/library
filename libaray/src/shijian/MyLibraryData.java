package shijian;
import javax.swing.*;
import java.sql.*;

public class MyLibraryData {
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
////        test tt = new test();
////        tt.getConnection();
////        tt.isuer("8888","123");
//        MyLibraryData t = new MyLibraryData();
////        t.returnBook("111","计算机组成原理","001");
////        t.addBorrowBookCord("si","计算机组成原理","001","fasle");
////        t.DelBook("123","213");
//        t.DelBorrower("lei");
//
//    }

    private String DBname ="root";
    private String DBpwd = "csl800809";
    private String URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private Connection conn = null;


    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement pstm;
    private String Driver = "com.mysql.jdbc.Driver";



    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName(Driver);
        conn = DriverManager.getConnection(URL,DBname,DBpwd);
        if(conn!=null) {
            System.out.println("连接数据库成功");
        }
        return conn;
    }

    //登录验证
    public boolean isBorrower(String name, String password) throws SQLException {
        boolean flag = true;
        conn = DriverManager.getConnection(URL,DBname,DBpwd);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Borrower WHERE name='" + name + "' AND password=('" + password + "')");
        if (resultSet.next()) {
            flag = true;
//            System.out.println("登录成功！");
        } else {
            flag = false;
//            System.out.println("用户名或密码错误！");
        }
        return flag;
    }

//已弃用
    public boolean isuer(String username, String password) throws SQLException {
        boolean flag = true;
        conn = DriverManager.getConnection(URL,DBname,DBpwd);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM user WHERE username='" + username + "' AND password=('" + password + "')");
        if (resultSet.next()) {
            flag = true;
//            System.out.println("登录成功！");
        } else {
            flag = false;
//            System.out.println("用户名或密码错误！");
        }
        return flag;
    }

//注册root  已弃用
    public boolean addUser(String username, String password) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        String sql = "insert into user VALUES (?,?)";
        pstm = this.getConnection().prepareStatement(sql);
        pstm.setObject(1, username);
        pstm.setObject(2, password);
        int r = pstm.executeUpdate();
        if (r != 0) {
            flag = true;
            System.out.println("注册成功！");
        }
        return flag;
    }

//    是否是管理员
    public boolean isroot(String loaclname) throws SQLException {
        boolean flag = false;
        conn = DriverManager.getConnection(URL,DBname,DBpwd);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT type FROM Borrower WHERE name=('" + loaclname + "')");
        while (resultSet.next()){
            String name = resultSet.getString("type");
//            System.out.println(name);
            if("root".equals(name)){
//                System.out.println("是管理员");
                flag = true;
            } else if(name==null) {
//                System.out.println("不是");
                flag = false;
            }else {
//                JOptionPane.showMessageDialog(null, "系统错误", "警告对话框", JOptionPane.INFORMATION_MESSAGE);

                System.out.println("系统错误");
            }
        }
        return flag;
    }

//    升级权限
    public boolean updateroot(String name) throws SQLException {
        boolean flag = false;
        conn = DriverManager.getConnection(URL,DBname,DBpwd);
        Statement statement = conn.createStatement();
        String sql = "UPDATE Borrower set type = 'root' where name= ('" + name + "')";
//        "SELECT * FROM user WHERE username='" + username + "' AND password=('" + password + "')"/
        int count = statement.executeUpdate(sql);
//        ResultSet resultSet = statement.executeQuery(sql);
        if (count>0){
//            System.out.println("修改成功！");
            flag = true;
        }else{
            System.out.println("修改失败！");
            flag = false;
        }

        return flag;
    }


//添加借阅者
    public boolean addBorrower(String name, String password,String type) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        String sql = "insert into Borrower VALUES (?,?,?)";
        pstm = this.getConnection().prepareStatement(sql);
        pstm.setObject(1, name);
        pstm.setObject(2, password);
        pstm.setObject(3, type);
        int r = pstm.executeUpdate();
        if (r != 0) {
            flag = true;
//            System.out.println("添加图书信息成功！");
        }
        return flag;
    }

//    添加图书
        public boolean addBook(String bookname, String author, String price, String ISDN) throws SQLException, ClassNotFoundException {
            boolean flag = false;
            String sql = "insert into Book VALUES (?,?,?,?)";
            pstm = this.getConnection().prepareStatement(sql);
            pstm.setObject(1,bookname);
            pstm.setObject(2,author);
            pstm.setObject(3,price);
            pstm.setObject(4,ISDN);

            int r = pstm.executeUpdate();
            if (r!=0){
                flag=true;
//            System.out.println("添加图书信息成功！");
            }
            return flag;
    }



//添加借阅记录
    public boolean addBorrowBookCord(String name,String bookname,String ISDN,String returnornot) throws SQLException, ClassNotFoundException {
        boolean flag = false;
        String sql = "insert into Borrowrecord VALUES (?,?,?,?)";
        pstm = this.getConnection().prepareStatement(sql);
        pstm.setObject(1,name);
        pstm.setObject(2,bookname);
        pstm.setObject(3,ISDN);
        pstm.setObject(4,returnornot);
        int r = pstm.executeUpdate();
        if (r!=0){
            flag=true;
//            System.out.println("添加图书借阅记录成功！");
        }
        return flag;
    }


//



//还书
    public boolean returnBook(String name ,String bookname , String ISDB) throws SQLException {
        boolean flag = false;
        conn = DriverManager.getConnection(URL,DBname,DBpwd);
        Statement statement = conn.createStatement();
        String sql = "UPDATE BorrowRecord set returnornot = 'true' where name= ('" + name + "')   AND bookname=('" + bookname + "')  AND ISBN = ('" + ISDB + "') ";
        int count = statement.executeUpdate(sql);
//        ResultSet resultSet = statement.executeQuery(sql);
        if (count>0){
//            System.out.println("修改成功！");
            flag = true;
        }else{
            System.out.println("修改失败！");
            flag = false;
        }

        return flag;
    }

    ////删除图书
    public boolean DelBook(String bookname,String ISDB) throws SQLException {
        boolean flag = true;
        conn = DriverManager.getConnection(URL,DBname,DBpwd);
        Statement statement = conn.createStatement();
        int count = statement.executeUpdate("DELETE from Book where bookname=('" + bookname + "')  AND ISDB = ('" + ISDB + "') ");
        if (count>0){
//            System.out.println("修改成功！");
            flag = true;
        }else{
            System.out.println("修改失败！");
            flag = false;
        }

        return flag;
    }

//删除用户
    public boolean DelBorrower(String name) throws SQLException {
        boolean flag = true;
        conn = DriverManager.getConnection(URL,DBname,DBpwd);
        Statement statement = conn.createStatement();
        int count = statement.executeUpdate("DELETE from Borrower where  name = ('" + name + "') ");
        if (count>0){
//            System.out.println("修改成功！");
            flag = true;
        }else{
            System.out.println("修改失败！");
            flag = false;
        }

        return flag;
    }


    //关闭连接
    public void Close() throws SQLException {
        if (conn!=null){
            conn.close();
        }
        if (pstm!=null){
            pstm.close();
        }
        if (resultSet!=null){
            resultSet.close();
        }
    }
}

