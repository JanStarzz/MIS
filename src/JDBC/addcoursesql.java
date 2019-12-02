package JDBC;
/*
这是插入课程的类
 */
import Util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addcoursesql {
    private course Sc;
    private Connection conn;
    private int i;
    public addcoursesql(course Sc){
        this.conn = user.CONN();
        this.Sc = Sc;

        String sql = "insert into course values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,Sc.getNo());
            stmt.setString(2,Sc.getName());
            stmt.setFloat(3,Sc.getCredit());
            stmt.setString(4,Sc.getType());
            stmt.setString(5,Sc.getTeacher());
            stmt.setInt(6,Sc.getBegin());
            stmt.setInt(7,Sc.getEnd());
            stmt.setInt(8,Sc.getLast());
            i = stmt.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }

    }

    public int getI() {
        return i;
    }
}
