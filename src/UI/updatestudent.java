package UI;

import JDBC.*;
import Util.student;

import javax.swing.*;
import java.awt.*;

public class updatestudent {
    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JTextArea jta;
    JButton �޸�,������һ��;
    JFrame j ;
    JPanel jp1 ;
    JPanel jp2 ;
    JPanel jp3;
    JPanel jp4 ;
    JPanel jp5 ;
    JPanel jp6 ;
    JPanel jp7 ;
    JPanel jp8 ;
    JLabel  ѧ��,����,�Ա�,ϵ,����,�༶;
    public updatestudent() {
        j = new JFrame("�޸�ѧ����Ϣ");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();
        jta = new JTextArea();
        ѧ�� = new JLabel("ѧ��:");
        ���� = new JLabel("����:");
        �Ա� = new JLabel("�Ա�");
        ϵ = new JLabel("ϵ");
        ���� = new JLabel("����");
        �༶ = new JLabel("�༶");
        �޸� = new JButton("�޸�");
        ������һ�� = new JButton("������һ��");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);
        jt3 = new JTextField(20);
        jt4 = new JTextField(20);
        jt5 = new JTextField(20);
        jt6 = new JTextField(20);

        j.setLayout(new GridLayout(8, 1));
        jp1.add(ѧ��);
        jp1.add(jt1);
        jp2.add(����);
        jp2.add(jt2);
        jp3.add(�Ա�);
        jp3.add(jt3);
        jp4.add(ϵ);
        jp4.add(jt4);
        jp5.add(����);
        jp5.add(jt5);
        jp6.add(�༶);
        jp6.add(jt6);
        jp8.add(�޸�);
        jp8.add(������һ��);
        jp8.add(jta);
        j.add(jp1);
        j.add(jp2);
        j.add(jp3);
        j.add(jp4);
        j.add(jp5);
        j.add(jp6);
        j.add(jp7);
        j.add(jp8);
        j.setSize(400, 500);
        j.setLocation(500, 400);
        j.setVisible(true);
        j.setResizable(false);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        �޸�.addActionListener(e -> {
            int sNo = Integer.parseInt(jt1.getText()) ;
            String sName = jt2.getText();
            String sGender = jt3.getText();
            String majorNo = jt4.getText();
            int sAge = Integer.parseInt( jt5.getText() );
            int classNo = Integer.parseInt(jt6.getText());
            student st = new student(sNo,sName,sGender,majorNo,sAge,classNo);
            try {
                updatestudentsql up = new updatestudentsql(st);
                if(up.getI()>0) {
                    jta.setText("�޸ĳɹ���");
                }
                else jta.setText("�޸�ʧ�ܣ�");
            }catch (Exception e1){
                e1.printStackTrace();

            }

        });

        ������һ��.addActionListener(e->
        {new adminUI("��ӭ������");j.setVisible(false);})
        ;
    }

}
