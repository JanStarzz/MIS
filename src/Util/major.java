package Util;

public class major {
    private String majorNo;
    private String major;
    private String deptNo;
    public major(String majorNo,String major,String deptNo){
        this.deptNo = deptNo;
        this.major = major;
        this.majorNo = majorNo;
    }

    public String getMajorNo() {
        return majorNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public String getMajor() {
        return major;
    }
}
