package UI;

import javax.swing.*;
import Util.*;
import JDBC.*;

import java.awt.*;


public class addcourse {
    JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
    JTextArea jta;
    JComboBox <String>Box;
    JButton 录入,返回上一级;
    JFrame j ;
    JPanel jp9 ;
    JPanel jp1 ;
    JPanel jp2 ;
    JPanel jp3;
    JPanel jp4 ;
    JPanel jp5 ;
    JPanel jp6 ;
    JPanel jp7 ;
    JPanel jp8 ;
    JLabel  编号,课程名称,授课老师,课程学分,开始周数,结束周数,课程类型,课程容量;
    public addcourse() {
        j = new JFrame("录入课程信息");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();
        jp9 = new JPanel();
        jta = new JTextArea();
        编号 = new JLabel("课程编号:");
        课程名称 = new JLabel("课程名称:");
        授课老师 = new JLabel("授课老师:");
        课程学分 = new JLabel("课程学分:");
        开始周数 = new JLabel("开始周数:");
        结束周数 = new JLabel("结束周数:");
        课程类型 = new JLabel("课程类型:");
        课程容量 = new JLabel("课程容量:");
        录入 = new JButton("录入");
        返回上一级 = new JButton("返回上一级");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);
        jt3 = new JTextField(20);
        jt4 = new JTextField(20);
        jt5 = new JTextField(20);
        jt6 = new JTextField(20);
        jt7 = new JTextField(20);
        Box = new JComboBox<String>();
        Box.addItem("必修");
        Box.addItem("选修");
        j.setLayout(new GridLayout(10, 1));
        jp1.add(编号);
        jp1.add(jt1);
        jp2.add(课程名称);
        jp2.add(jt2);
        jp3.add(授课老师);
        jp3.add(jt3);
        jp4.add(课程学分);
        jp4.add(jt4);
        jp5.add(开始周数);
        jp5.add(jt5);
        jp6.add(结束周数);
        jp6.add(jt6);
        jp7.add(课程类型);
        jp7.add(Box);
        jp8.add(课程容量);
        jp8.add(jt7);
        jp9.add(录入);
        jp9.add(返回上一级);
        jp9.add(jta);
        j.add(jp1);
        j.add(jp2);
        j.add(jp3);
        j.add(jp4);
        j.add(jp5);
        j.add(jp6);
        j.add(jp7);
        j.add(jp8);
        j.add(jp9);
        j.setSize(400, 500);
        j.setLocation(500, 400);
        j.setVisible(true);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            录入.addActionListener(e -> {
                String no = jt1.getText();
                String name = jt2.getText();
                String teacher = jt3.getText();
                String type = (String) Box.getSelectedItem();
                float credit = Float.parseFloat(jt4.getText());
                int begin = Integer.parseInt(jt5.getText());
                int end = Integer.parseInt(jt6.getText());
                int amount = Integer.parseInt(jt7.getText());
                course Sc = new course(no, name, teacher, type, credit, begin, end,amount);
                try {
                    addcoursesql add = new addcoursesql(Sc);
                    if(add.getI()>0)
                        jta.setText("录入成功");
                    else
                        jta.setText("录入成功");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    jta.setText("录入成功");
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

