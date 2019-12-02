package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class studentUI extends JFrame{
    private int sNo;
    JLabel label;
    JMenuBar mb=new JMenuBar();//菜单栏
    JMenu m3=new JMenu("选课管理");
    JMenuItem add3=new JMenuItem("增加选课信息   ");
    JMenuItem delete3=new JMenuItem("删除选课信息   ");
    JMenuItem select3 = new JMenuItem("查询选课信息 ");
    Font t=new Font ("sanerif",Font.PLAIN,12);
    public studentUI(int sNo){
        this.sNo = sNo;
        this.setTitle("学生选课管理系统");
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch(Exception e){System.err.println("不能设置外观:   "+e);}
        addMenu3();
        addJMenuBar();
        setJMenuBar(mb);
        label=new JLabel("选课管理系统",JLabel.CENTER);
        label.setFont(new Font("宋体",Font.BOLD,36));
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(Color.red);
        add3.addActionListener(e -> {new sselect_lesson(sNo);this.setVisible(false);});
        delete3.addActionListener(e->{new delete_lessonforstudent(sNo);this.setVisible(false);});
        //
        select3.addActionListener(e->{new select_sc(sNo);this.setVisible(false);});
        this.add(label);
   
        setVisible(true);
        setBounds(400,150,400,280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter(){//关闭程序时的操作
            public void windowClosing(WindowEvent e){System.exit(0);} });
        validate();}
    private void addJMenuBar() {
        mb.add(m3);}

    private void addMenu3() {
        m3.add(add3);m3.add(delete3);m3.add(select3);m3.setFont(t);	}

    };