package UI;

import javax.swing.*;
import java.awt.*;
import JDBC.*;
public class delete_lessonforadmin extends JFrame{
    String sNo;
    JPanel jp;
    JLabel jl1,jl2;
    JTextField jtf1,jtf2;
    JTextArea jta;
    JButton b1,b2;
    public delete_lessonforadmin(){
        super("ÕÀøŒ");
        jp = new JPanel();
        jp.setLayout(new GridLayout(4,2));
        jl1 = new JLabel("—ß∫≈");
        jl2 = new JLabel("øŒ≥Ã∫≈");
        jtf1 = new JTextField();
        jtf2 = new JTextField();
        jta = new JTextArea();
        jta.setEditable(false);
        b1 = new JButton("…æ≥˝");
        b2 = new JButton("∑µªÿ…œ“ªº∂");
        jp.add(jl1);
        jp.add(jtf1);
        jp.add(jl2);
        jp.add(jtf2);
        jp.add(b1);
        jp.add(b2);
        jp.add(jta);
        this.add(jp);
        b1.addActionListener(e -> {
            deletescsqlfor de = new deletescsqlfor(Integer.parseInt(jtf1.getText()),jtf2.getText());
            if(de.getI()>0){
                jta.setText("…æ≥˝≥…π¶");
            }
            else jta.setText("…æ≥˝ ß∞‹");
        });
        b2.addActionListener(e->{new adminUI("ª∂”≠ªÿ¿¥");this.setVisible(false);});
        this.setSize(300,200);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
