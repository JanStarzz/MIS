package UI;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import JDBC.*;


public class LoginUI extends JFrame {
    private JLabel use, password;
    private JTextField k1;//用户名输入框
    private JPasswordField k2;//密码输入框
    private JButton b1, b2,b3;
    private String susername;
    private String spassword;
    private JTextArea k3;
    //登录窗口

    public LoginUI() {
        super("系统登录");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        use = new JLabel("账号:");
        use.setFont(new Font("Serif", Font.PLAIN, 20));
        password = new JLabel("密码:");
        password.setFont(new Font("Serif", Font.PLAIN, 20));
        k1 = new JTextField(12);
        k2 = new JPasswordField(12);
        k3 = new JTextArea();
        b1 = new JButton("管理员登录");
        b2 = new JButton("学生登录");
        b3 = new JButton("退出");
        //设置登录方法
        //添加控件


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
                    k3.setText("登录成功");
                    setVisible(false);
                    adminUI a = new adminUI(k1.getText());

                }
                else {k3.setText("账号或密码错误,重新输入");
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
                    k3.setText("登录成功");
                    setVisible(false);
                    selectsql s = new selectsql();
                    studentUI a = new studentUI(sNo);
                }
                else {k3.setText("账号或密码错误,重新输入");
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


    //主函数
    public static void main(String[] args) {
        LoginUI f1 = new LoginUI();
    }
}