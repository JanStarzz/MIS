package UI;

import JDBC.*;
import JDBC.selectsql;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class deletestudent {
    private JFrame Jf;
    private JPanel Jp,Jp1,Jp2;
    private JLabel Jl,Jl2;
    private JTextArea Jta,Jta1;
    private JTextField Jtf;
    private JButton b1, b2;

    public deletestudent() {
        Jf = new JFrame("ɾ��ѧ����Ϣ");
        Jp = new JPanel();

        Jp1 = new JPanel();
        Jp2 = new JPanel();
        Jl = new JLabel("ѧ��:");
        Jl2 = new JLabel("����:");
        Jta = new JTextArea();
        Jta1 = new JTextArea();
        Jtf = new JTextField(30);
        b1 = new JButton("ɾ��");
        b2 = new JButton("������һ��");
        Jf.setLayout(new GridLayout(3,1));
        Jp.add(Jl);
        Jp.add(Jtf);
        Jp1.add(Jl2);
        Jp1.add(Jta);
        Jp2.add(b1);
        Jp2.add(b2);
        Jp2.add(Jta1);
        Jf.add(Jp);
        Jf.add(Jp1);
        Jf.add(Jp2);
        Jf.setLocation(300,400);
        Jf.setSize(400,300);
        Jf.setVisible(true);
        Jf.setResizable(false);
        Jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Jtf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar()==KeyEvent.VK_ENTER){
                    System.out.println(Jtf.getText());
                    Jta.setText(new selectsql().selectfromstudent(Integer.parseInt(Jtf.getText())).getsName());
                }
            }
        });
        b1.addActionListener(e->{
            try {
            	
               deletestudentsql de = new deletestudentsql(Integer.parseInt(Jtf.getText()));
               if(de.getI()>0)
                Jta1.setText("ɾ���ɹ���");
               else Jta1.setText("ɾ��ʧ�ܣ�");
            }catch (Exception e1){
                Jta1.setText("ɾ��ʧ�ܣ�");
            }
        });
        b2.addActionListener(e ->{ new adminUI("��ӭ������");
            Jf.setVisible(false);
        });
    }
}
