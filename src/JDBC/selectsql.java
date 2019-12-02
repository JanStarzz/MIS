package JDBC;
import Util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class selectsql {
    private Connection conn;
    private String sql;
    public selectsql(){
        this.conn = user.CONN();
    }
    public student selectfromstudent(int sNo){
        PreparedStatement statement;
        ResultSet re;
        student st;
        sql = "select * from student where sNo = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setInt(1,sNo);
            re = statement.executeQuery();
            re.next();
            st = new student(sNo, re.getString("sName"), re.getString("sGender"),
                        re.getString("majorNo"), re.getInt("sAge"), re.getInt("classNo"));
                return st;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public major selectfrommajor(String majorNo){
        PreparedStatement statement;
        ResultSet re;
        major ma;
        sql = "select * from major where sNo = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,majorNo);
            re = statement.executeQuery();
            re.next();
            ma = new major(majorNo, re.getString("major"), re.getString("deptNo"));

            return ma;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public dept selectfromdept(String deptNo){
        PreparedStatement statement;
        ResultSet re;
        dept de;
        sql = "select * from major where sNo = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,deptNo);
            re = statement.executeQuery();
            re.next();
            de = new dept(deptNo, re.getString("dept"));
            return de;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public String selectcNamefromcourse(String cNo){
        PreparedStatement statement;
        ResultSet re;
        String cName ;
        sql = "select cName from course where cNo = ?";
        try {
            statement = conn.prepareStatement(sql);
            statement.setString(1,cNo);
            re = statement.executeQuery();
            re.next();

            cName = re.getString("cName");
            return cName;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public Vector selectfromcourse() {
        PreparedStatement statement;
        ResultSet re;
        Vector row = new Vector();
        sql = "select * from course ";
        try {
        	statement = conn.prepareStatement(sql);
            re = statement.executeQuery();
            while (re.next()) {
                Vector co = new Vector();
                co.add(re.getString("cNo"));
                co.add(re.getString("cName"));
                co.add(re.getInt("credit"));
                co.add(re.getString("cType"));
                co.add(re.getString("tName"));
                co.add(re.getInt("begin_week"));
                co.add(re.getInt("end_week"));
                co.add(re .getInt("amount"));
                row.add(co);

            }
            return row;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Vector selectsc(int sNo) {
    	 Vector row = new Vector();
    	PreparedStatement statement;
        ResultSet re;
        sql = "select course.* from sc,course where course.cNo IN (select sc.cNo from sc where sc.sNo = ?)";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1,sNo);
            re = statement.executeQuery();
            while (re.next()) {
            	Vector co = new Vector();
                co.add(re.getString("cNo"));
                co.add(re.getString("cName"));
                co.add(re.getString("tName"));
                co.add(re.getString("cType"));
                co.add(re.getInt("credit"));
                co.add(re.getInt("begin_week"));
                co.add(re.getInt("end_week"));
                co.add(re .getInt("amount"));
                row.add(co);	
				
			}
            return row;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
