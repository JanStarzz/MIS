package UI;

import javax.swing.*;
import Util.*;
import JDBC.*;

import java.awt.*;


public class addcourse {
    JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
    JTextArea jta;
    JComboBox <String>Box;
    JButton ¼��,������һ��;
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
    JLabel  ���,�γ�����,�ڿ���ʦ,�γ�ѧ��,��ʼ����,��������,�γ�����,�γ�����;
    public addcourse() {
        j = new JFrame("¼��γ���Ϣ");
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
        ��� = new JLabel("�γ̱��:");
        �γ����� = new JLabel("�γ�����:");
        �ڿ���ʦ = new JLabel("�ڿ���ʦ:");
        �γ�ѧ�� = new JLabel("�γ�ѧ��:");
        ��ʼ���� = new JLabel("��ʼ����:");
        �������� = new JLabel("��������:");
        �γ����� = new JLabel("�γ�����:");
        �γ����� = new JLabel("�γ�����:");
        ¼�� = new JButton("¼��");
        ������һ�� = new JButton("������һ��");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);
        jt3 = new JTextField(20);
        jt4 = new JTextField(20);
        jt5 = new JTextField(20);
        jt6 = new JTextField(20);
        jt7 = new JTextField(20);
        Box = new JComboBox<String>();
        Box.addItem("����");
        Box.addItem("ѡ��");
        j.setLayout(new GridLayout(10, 1));
        jp1.add(���);
        jp1.add(jt1);
        jp2.add(�γ�����);
        jp2.add(jt2);
        jp3.add(�ڿ���ʦ);
        jp3.add(jt3);
        jp4.add(�γ�ѧ��);
        jp4.add(jt4);
        jp5.add(��ʼ����);
        jp5.add(jt5);
        jp6.add(��������);
        jp6.add(jt6);
        jp7.add(�γ�����);
        jp7.add(Box);
        jp8.add(�γ�����);
        jp8.add(jt7);
        jp9.add(¼��);
        jp9.add(������һ��);
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
            ¼��.addActionListener(e -> {
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
                        jta.setText("¼��ɹ�");
                    else
                        jta.setText("¼��ɹ�");
                } catch (Exception e1) {
                    e1.printStackTrace();
                    jta.setText("¼��ɹ�");
                }
            });
            ������һ��.addActionListener(e ->
                    {
                        new adminUI("��ӭ����");
                        j.setVisible(false);
                    }
            );
        }
    }

