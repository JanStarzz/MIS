package JDBC;
import Util.*;
import java.sql.*;

public class updatecoursesql {
    private course co;
    private Connection conn;
    private int i ;
    public updatecoursesql(course co){
        this.co = co;
        this.conn = user.CONN();
        String sql = "update course set cName = ?,credit = ?,cType = ?,tName = ?," +
                "begin_week = ?, end_week = ?, amount = ? where cNo = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(8,co.getNo());
            stmt.setString(1,co.getName());
            stmt.setFloat(2,co.getCredit());
            stmt.setString(3,co.getType());
            stmt.setString(4,co.getTeacher());
            stmt.setInt(5,co.getBegin());
            stmt.setInt(6,co.getEnd());
            stmt.setInt(7,co.getLast());
            i = stmt.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public int getI() {
        return i;
    }
}
