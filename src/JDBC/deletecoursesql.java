package JDBC;
import Util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class deletecoursesql {
    String cNo ;
    Connection conn;
    public deletecoursesql(String cNo){
        this.cNo = cNo;
        this.conn = user.CONN();
        String sql = "delete from course where cNo = ?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,cNo);
            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
