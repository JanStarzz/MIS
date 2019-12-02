package UI;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import JDBC.*;


public class LoginUI extends JFrame {
    private JLabel use, password;
    private JTextField k1;//�û��������
    private JPasswordField k2;//���������
    private JButton b1, b2,b3;
    private String susername;
    private String spassword;
    private JTextArea k3;
    //��¼����

    public LoginUI() {
        super("ϵͳ��¼");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        use = new JLabel("�˺�:");
        use.setFont(new Font("Serif", Font.PLAIN, 20));
        password = new JLabel("����:");
        password.setFont(new Font("Serif", Font.PLAIN, 20));
        k1 = new JTextField(12);
        k2 = new JPasswordField(12);
        k3 = new JTextArea();
        b1 = new JButton("����Ա��¼");
        b2 = new JButton("ѧ����¼");
        b3 = new JButton("�˳�");
        //���õ�¼����
        //��ӿؼ�


        c.add(use);
        c.add(k1);
        c.add(password);
        c.add(k2);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(k3);

        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                user u1 = new user();
                susername = k1.getText();
                System.out.println(susername);
                spassword = k2.getText();
                System.out.println(spassword);

                if(u1.isTrue(susername,spassword)){
                    k3.setText("��¼�ɹ�");
                    setVisible(false);
                    adminUI a = new adminUI(k1.getText());

                }
                else {k3.setText("�˺Ż��������,��������");
                }
            }
        });
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                user u1 = new user();
                susername = k1.getText();
                spassword = k2.getText();
                
            
                if(u1.isTrue(susername,spassword)){
                	int sNo = u1.getsNo();
                    k3.setText("��¼�ɹ�");
                    setVisible(false);
                    selectsql s = new selectsql();
                    studentUI a = new studentUI(sNo);
                }
                else {k3.setText("�˺Ż��������,��������");
                }
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               System.exit(0);
            }
        });
        setBounds(600, 300, 400, 150);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    //������
    public static void main(String[] args) {
        LoginUI f1 = new LoginUI();
    }
}