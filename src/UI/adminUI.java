package UI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class adminUI extends JFrame {
    String useaname;
    JPanel pCenter;
    JLabel label,label1;
    JMenuBar mb=new JMenuBar();//�˵���
    JMenu m1=new JMenu("ѧ������");
    JMenuItem add1=new JMenuItem("����ѧ����Ϣ   ");
    JMenuItem updata1=new JMenuItem("�޸�ѧ����Ϣ   ");
    JMenuItem delete1=new JMenuItem("ɾ��ѧ����Ϣ   ");
    JMenu m2=new JMenu("�γ̹���");
    JMenuItem add2=new JMenuItem("���ӿγ���Ϣ   ");
    JMenuItem updata2=new JMenuItem("�޸Ŀγ���Ϣ   ");
    JMenuItem delete2=new JMenuItem("ɾ���γ���Ϣ   ");
    JMenu m3=new JMenu("ѡ�ι���");
    JMenuItem add3=new JMenuItem("ѡ��");
    JMenuItem delete3=new JMenuItem("�˿�");
    JMenuItem m5=new JMenuItem("ϵͳ�˳�");
    Font t=new Font ("sanerif",Font.PLAIN,12);



    public adminUI(String username){
        this.useaname = username;
        this.setTitle("ѧ��ѡ�ι���ϵͳ");
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch(Exception e){System.err.println("�����������:   "+e);}
        //��ϲ˵�
        mb.add(m1);
        mb.add(m2);
        mb.add(m3);
        m3.add(add3);
        m3.add(delete3);
        m2.add(add2);
        m2.add(delete2);
        m2.add(updata2);
        m1.add(add1);
        m1.add(updata1);
        m1.add(delete1);
        setJMenuBar(mb);
        label=new JLabel("ѡ�ι���ϵͳ��ӭ�㣡",JLabel.CENTER);
        label1=new JLabel(username,JLabel.CENTER);
        label.setFont(new Font("����",Font.BOLD,36));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(Color.red);
        label1.setFont(new Font("����",Font.BOLD,36));
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label1.setForeground(Color.black);
        add1.addActionListener(e ->{new addstudent();this.setVisible(false);} );
        updata1.addActionListener(e->{new updatestudent();this.setVisible(false);});
        delete1.addActionListener(e->{new deletestudent();this.setVisible(false);});
        delete2.addActionListener(e->{new deletecourse();this.setVisible(false);});
        add2.addActionListener(e -> {new addcourse();this.setVisible(false);});
        delete3.addActionListener(e->{new delete_lessonforadmin();setVisible(false);});
        updata2.addActionListener(e -> {new updatecourse();this.setVisible(false);});
        add3.addActionListener(e -> {new select_lesson();this.setVisible(false);});
        pCenter=new JPanel();
        pCenter.add(label);
        pCenter.add(label1);
        this.add(pCenter);
        validate();
        setVisible(true);
        setBounds(400,150,400,280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter(){//�رճ���ʱ�Ĳ���
            public void windowClosing(WindowEvent e){System.exit(0);} });
        validate();}

}
