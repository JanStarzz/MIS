package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import JDBC.selectsql;

public class select_sc extends JFrame{
	  Vector rowData,columnNames;
	    JTable jt;
	    JScrollPane jsp;
	    JPanel jp;
	    JButton b2;
	    JTextArea jta;
	    private String value;
	    private int sNo;
	    public select_sc(int sNo){
	        super("选课");
	        jp = new JPanel();
	        jp.setLayout(new GridLayout(2,2));
	        b2 = new JButton("返回上一级");
	        this.sNo = sNo;
	        jta = new JTextArea();
	        jp.add(b2);
	        jp.add(jta);
	        columnNames = new Vector();
	        columnNames.add("课程编号");
	        columnNames.add("课程名称");
	        columnNames.add("任课老师");
	        columnNames.add("类型");
	        columnNames.add("学分");
	        columnNames.add("开始时间");
	        columnNames.add("结束时间");
	        columnNames.add("课容量");
	        rowData = new Vector();
	        rowData = new selectsql().selectsc(sNo);
	        jt = new JTable(rowData, columnNames);
	        jt.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
	        jt.getTableHeader().setForeground(Color.RED); // 设置表头名称字体颜色
	        jt.getTableHeader().setResizingAllowed(false); // 设置不允许手动改变列宽
	        jt.getTableHeader().setReorderingAllowed(false); // 设置不允许拖动重新排序各列
	        jt.setPreferredScrollableViewportSize(new Dimension(400, 300));
	        jsp = new JScrollPane(jt);
	        b2.addActionListener(e->{
	        	new studentUI(sNo);
	        	this.setVisible(false);
	        });
	        this.add(jsp,BorderLayout.NORTH);
	        this.add(jp);
	        this.setSize(800, 500);

	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	    }
	   
	    }
