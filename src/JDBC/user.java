package JDBC;
import java.sql.*;

public class user {
        private int sNo;  //用户姓名
        private String userneme;
        private String password;
public static Connection CONN(){
        String driverName = "com.mysql.jdbc.Driver";   //加载JDBC驱动
        String dbURL = "jdbc:mysql://127.0.0.1:3306/Course_Mananger?serverTimezone=UTC&characterEncoding=utf-8";
        String userName = "root";   //用户名
        String userPwd = "root";   //密码
        Connection conn=null;
        try {
        Class.forName(driverName);
        conn = DriverManager.getConnection(dbURL, userName, userPwd);
        System.out.println("Connection Successful!");
//如果连接成功 控制台输出Connection Successful!
        } catch (Exception e) {
        e.printStackTrace();}
        return conn;
}
public boolean isTrue(String name,String password){
        Connection conn = CONN();
        PreparedStatement stmt ;
        ResultSet re;
        String sql ="select * from user_Table where username = ?" ;//sql语句
        try {

              stmt = conn.prepareStatement(sql);
              stmt.setString(1,name);
              re = stmt.executeQuery();
              while (re.next()){
                        this.password = re.getString("pwd");
                        this.sNo = re.getInt("sNo");}
        }catch (Exception e){
                e.printStackTrace();
                return false;
        }
        if(password.equals(this.password))return true;
        else return false;
}

        public int getsNo() {
                return sNo;
        }
}
