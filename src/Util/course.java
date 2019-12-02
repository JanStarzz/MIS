package Util;

/*
这是对SC表的获得并储存的类


*/
public class course {
    private String No;
    private String Name;
    private String Teacher;
    private String Type;
    private float credit;
    private int begin;
    private int end;
    private int amount;
    public course(String No, String Name, String Teacher, String Type, float credit, int begin, int end ,int amount){
        this.No = No;
        this.Name = Name;
        this.Teacher = Teacher;
        this.Type = Type;
        this.credit = credit;
        this.begin = begin;
        this.end = end;
        this.amount = amount;
    }
    public String getNo(){
        return this.No;
    }
    public String getName(){
        return this.Name;
    }
    public String getTeacher(){
        return this.Teacher;
    }

    public float getCredit() {
        return this.credit;
    }

    public String getType() {
        return Type;
    }

    public int getBegin() {
        return this.begin;
    }

    public int getEnd() {
        return this.end;
    }
    public int getLast() {
        return this.amount;
    }
}
