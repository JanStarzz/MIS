package UI;

import JDBC.deletescsqlfor;

import javax.swing.*;
import java.awt.*;

public class delete_lessonforstudent extends JFrame{
    int sNo;
    JPanel jp;
    JLabel jl2;
    JTextField jtf2;
    JTextArea jta;
    JButton b1,b2;
    public delete_lessonforstudent(int sNo){
        super("�˿�");
        jp = new JPanel();
        jp.setLayout(new GridLayout(3,2));
        jl2 = new JLabel("�γ̺�");
        jtf2 = new JTextField();
        jta = new JTextArea();
        jta.setEditable(false);
        b1 = new JButton("ɾ��");
        b2 = new JButton("������һ��");
        jp.add(jl2);
        jp.add(jtf2);
        jp.add(b1);
        jp.add(b2);
        jp.add(jta);
        this.add(jp);
        b1.addActionListener(e -> {
            deletescsqlfor de = new deletescsqlfor(sNo,jtf2.getText());
            if(de.getI()>0){
                jta.setText("ɾ���ɹ�");
            }
            else jta.setText("ɾ��ʧ��");
        });
        b2.addActionListener(e->{
            new studentUI(sNo);
            this.setVisible(false);
        });
        this.setSize(300,200);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
