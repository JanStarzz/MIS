package UI;



import javax.swing.*;
import java.awt.*;
import Util.*;
import JDBC.*;
public class addstudent extends JFrame {
    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JButton 录入,返回上一级;
    JFrame j ;
    JTextArea jta;
    JPanel jp1 ;
    JPanel jp2 ;
    JPanel jp3;
    JPanel jp4 ;
    JPanel jp5 ;
    JPanel jp6 ;
    JPanel jp7 ;
    JLabel  学号,姓名,性别,年龄,系别,班级;
    public addstudent() {
        j = new JFrame("插入学生信息");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jta = new JTextArea();
        学号 = new JLabel("学号:");
        姓名 = new JLabel("姓名:");
        性别 = new JLabel("性别");
        年龄  = new JLabel("年龄");
        系别 = new JLabel("系别");
        班级 = new JLabel("班级");
        录入 = new JButton("录入");
        返回上一级 = new JButton("返回上一级");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);
        jt3 = new JTextField(20);
        jt4 = new JTextField(20);
        jt5 = new JTextField(20);
        jt6 = new JTextField(20);

        j.setLayout(new GridLayout(7,1));
        jp1.add(学号);
        jp1.add(jt1);
        jp2.add(姓名);
        jp2.add(jt2);
        jp3.add(性别);
        jp3.add(jt3);
        jp4.add(年龄);
        jp4.add(jt4);
        jp5.add(系别);
        jp5.add(jt5);
        jp6.add(班级);
        jp6.add(jt6);
        jp7.add(录入);
        jp7.add(返回上一级);
        jp7.add(jta);
        j.add(jp1);
        j.add(jp2);
        j.add(jp3);
        j.add(jp4);
        j.add(jp5);
        j.add(jp6);
        j.add(jp7);
        j.setSize(400,500);
        j.setLocation(500,400);
        j.setVisible(true);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        录入.addActionListener (e->{
        int sNo = Integer.parseInt(jt1.getText());
        String sName = jt2.getText();
        String sGender = jt3.getText();
        String majorNo = jt5.getText();
        int sAge = Integer.parseInt( jt4.getText() );
        int classNo = Integer.parseInt(jt6.getText());
        student st = new student(sNo,sName,sGender,majorNo,sAge,classNo);
        try {
            addstudentsql add = new addstudentsql(st);
            if(add.getI()>0)
            jta.setText("录入成功!");
            else jta.setText("录入失败!");
        }catch (Exception e1){
            e1.printStackTrace();
            jta.setText("录入失败!");
        }
        });
        返回上一级.addActionListener(e ->
                {
                    new adminUI("欢迎回来");
                    j.setVisible(false);
                }
        );
    }


}
