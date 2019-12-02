package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class select_lessonsql {
    private Connection conn;
    private int i;
    public select_lessonsql(String cNo,int sNo) {
        conn = user.CONN();
        PreparedStatement stmt1;
        PreparedStatement stmt2;
        String sql1 = "insert into sc value(?,?)";
        String sql2 = "update course set amount = amount-1 where cNo=?";
        try {
            stmt1 = conn.prepareStatement(sql1);
            stmt2 = conn.prepareStatement(sql2);
            stmt1.setString(1, cNo);
            stmt1.setInt(2, sNo);
            stmt2.setString(1, cNo);
            i = stmt1.executeUpdate()+stmt2.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getI() {
        return i;
    }
}
