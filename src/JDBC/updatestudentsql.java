package JDBC;

import Util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class updatestudentsql {
    private student st;
    private Connection conn;
    private int i;
    public updatestudentsql(student st){
        this.st = st;
        this.conn = user.CONN();
        String sql = "update student set sName = ?,sGender = ?,majorNo = ?,sAge = ?," +
                "classNo = ? where sNo = ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(6,st.getsNo());
            stmt.setString(1,st.getsName());
            stmt.setString(2,st.getsGender());
            stmt.setString(3,st.getMajorNo());
            stmt.setInt(4,st.getsAge());
            stmt.setInt(5,st.getClassNo());
            i = stmt.executeUpdate();

        }catch (Exception e ){
            e.printStackTrace();
        }
    }

    public int getI() {
        return i;
    }
}
