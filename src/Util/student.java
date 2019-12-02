package Util;

public class student {
    private int sNo;
    private String sName;
    private String sGender;
    private String majorNo;
    private int sAge;
    private int classNo;
    public student(int sNo,String sName,String sGender,String majorNo,int sAge,int classNo){
        this.classNo = classNo;
        this.majorNo = majorNo;
        this.sAge = sAge;
        this.sGender = sGender;
        this.sName = sName;
        this.sNo =sNo;
    }

    public int getClassNo() {
        return classNo;
    }

    public int getsAge() {
        return sAge;
    }

    public String getMajorNo() {
        return majorNo;
    }

    public String getsGender() {
        return sGender;
    }

    public String getsName() {
        return sName;
    }

    public int getsNo() {
        return sNo;
    }
}
