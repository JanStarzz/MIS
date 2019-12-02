package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class deletescsqlfor {
    private Connection conn;
    private int i;
    public deletescsqlfor(int sNo, String cNo){
        conn = user.CONN();
        String sql1 = "delete  from sc where sNo = ?";
        String sql2 = "update course set amount = amount+1 where cNo = ?";
        PreparedStatement stmt1,stmt2;
        try {
            stmt1 = conn.prepareStatement(sql1);
            stmt1 = conn.prepareStatement(sql1);
            stmt2 = conn.prepareStatement(sql2);
            stmt1.setInt(1,sNo);
            stmt2.setString(1,cNo);
            i = stmt1.executeUpdate()+stmt2.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getI() {
        return i;
    }
}
