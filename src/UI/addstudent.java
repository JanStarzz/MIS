package UI;



import javax.swing.*;
import java.awt.*;
import Util.*;
import JDBC.*;
public class addstudent extends JFrame {
    JTextField jt1,jt2,jt3,jt4,jt5,jt6;
    JButton ¼��,������һ��;
    JFrame j ;
    JTextArea jta;
    JPanel jp1 ;
    JPanel jp2 ;
    JPanel jp3;
    JPanel jp4 ;
    JPanel jp5 ;
    JPanel jp6 ;
    JPanel jp7 ;
    JLabel  ѧ��,����,�Ա�,����,ϵ��,�༶;
    public addstudent() {
        j = new JFrame("����ѧ����Ϣ");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jta = new JTextArea();
        ѧ�� = new JLabel("ѧ��:");
        ���� = new JLabel("����:");
        �Ա� = new JLabel("�Ա�");
        ����  = new JLabel("����");
        ϵ�� = new JLabel("ϵ��");
        �༶ = new JLabel("�༶");
        ¼�� = new JButton("¼��");
        ������һ�� = new JButton("������һ��");
        jt1 = new JTextField(20);
        jt2 = new JTextField(20);
        jt3 = new JTextField(20);
        jt4 = new JTextField(20);
        jt5 = new JTextField(20);
        jt6 = new JTextField(20);

        j.setLayout(new GridLayout(7,1));
        jp1.add(ѧ��);
        jp1.add(jt1);
        jp2.add(����);
        jp2.add(jt2);
        jp3.add(�Ա�);
        jp3.add(jt3);
        jp4.add(����);
        jp4.add(jt4);
        jp5.add(ϵ��);
        jp5.add(jt5);
        jp6.add(�༶);
        jp6.add(jt6);
        jp7.add(¼��);
        jp7.add(������һ��);
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
        ¼��.addActionListener (e->{
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
            jta.setText("¼��ɹ�!");
            else jta.setText("¼��ʧ��!");
        }catch (Exception e1){
            e1.printStackTrace();
            jta.setText("¼��ʧ��!");
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
