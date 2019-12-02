package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class deletestudentsql {
    int sNo ;
    Connection conn;
    private int i;
    public deletestudentsql(int sNo){
        this.sNo = sNo;
        this.conn = user.CONN();
        String sql = "delete from student where sNo = ?";
        String sql2 = "delete from user_Table where sNo = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            PreparedStatement statement2 = conn.prepareStatement(sql2);
            statement.setInt(1,sNo);
            statement2.setInt(1,sNo);
            i =statement.executeUpdate()+statement2.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int getI() {
    	return i;
		
	}
}
