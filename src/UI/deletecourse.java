package UI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import JDBC.*;
public class deletecourse {
    private JFrame Jf;
    private JPanel Jp,Jp1,Jp2;
    private JLabel Jl,Jl2;
    private JTextArea Jta,Jta1;
    private JTextField Jtf;
    private JButton b1, b2;

    public deletecourse() {
        Jf = new JFrame("删除课程");
        Jp = new JPanel();

        Jp1 = new JPanel();
        Jp2 = new JPanel();
        Jl = new JLabel("课程编号:");
        Jl2 = new JLabel("课程名称:");
        Jta = new JTextArea();
        Jta1 =new JTextArea();
        Jtf = new JTextField(30);
        b1 = new JButton("删除");
        b2 = new JButton("返回上一级");
        Jf.setLayout(new GridLayout(3,1));
        Jp.add(Jl);
        Jp.add(Jtf);
        Jp1.add(Jl2);
        Jp1.add(Jta);
        Jp2.add(b1);
        Jp2.add(b2);
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
                    Jta.setText(new selectsql().selectcNamefromcourse(Jtf.getText()));
                }
            }
        });
        b1.addActionListener(e->{
            try {
                new deletecoursesql(Jtf.getText());
                Jta1.setText("删除成功！");
            }catch (Exception e1){
                Jta1.setText("删除失败！");
            }
        });
        b2.addActionListener(e ->{ new adminUI("欢迎回来！");
        Jf.setVisible(false);
        });
    }
}