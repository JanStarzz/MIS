package JDBC;
import Util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class addstudentsql {
    private Connection conn;
    private student st;
    private int i;
    public addstudentsql(student st){
        this.conn = user.CONN();
        this.st = st;
        String sql = "insert into student values(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,st.getsNo());
            stmt.setString(2,st.getsName());
            stmt.setString(3,st.getsGender());
            stmt.setString(4,st.getMajorNo());
            stmt.setInt(5,st.getsAge());
            stmt.setInt(6,st.getClassNo());
            i = stmt.executeUpdate();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public int getI() {
        return i;
    }
}
