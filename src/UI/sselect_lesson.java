package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import JDBC.*;
public class sselect_lesson extends  JFrame{
    Vector rowData,columnNames;
    JTable jt;
    JScrollPane jsp;
    JPanel jp;
    JButton b1,b2;
    JTextArea jta;
    private String value;
    private int sNo;
    public sselect_lesson(int sNo){
        super("选课");
        jp = new JPanel();
        jp.setLayout(new GridLayout(2,2));
        b1 = new JButton("确定");
        b2 = new JButton("返回上一级");
        this.sNo = sNo;
        jta = new JTextArea();
        jp.add(b1);
        jp.add(b2);
        jp.add(jta);
        columnNames = new Vector();
        columnNames.add("课程编号");
        columnNames.add("课程名称");
        columnNames.add("学分");
        columnNames.add("类型");
        columnNames.add("任课老师");
        columnNames.add("开始时间");
        columnNames.add("结束时间");
        columnNames.add("课容量");
        rowData = new Vector();
        rowData = new selectsql().selectfromcourse();
        jt = new JTable(rowData, columnNames);
        jt.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
        jt.getTableHeader().setForeground(Color.RED); // 设置表头名称字体颜色
        jt.getTableHeader().setResizingAllowed(false); // 设置不允许手动改变列宽
        jt.getTableHeader().setReorderingAllowed(false); // 设置不允许拖动重新排序各列
        jt.setPreferredScrollableViewportSize(new Dimension(400, 300));
        //初始化 jsp
        jsp = new JScrollPane(jt);
        jt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = jt.getSelectedRow();
                value = (String) jt.getValueAt(row, 1);
                System.out.println("222"+value);
            }
        });
        b1.addActionListener(e -> {
            select_lessonsql se = new select_lessonsql(value,sNo);
            if(se.getI()>0){
                jta.setText("选课成功");
            }
            else jta.setText("选课失败");
        });
        b2.addActionListener(e ->{new studentUI(sNo);this.setVisible(false);});
        //把jsp放入到jframe
        this.add(jsp,BorderLayout.NORTH);
        this.add(jp);
        this.setSize(800, 500);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}

