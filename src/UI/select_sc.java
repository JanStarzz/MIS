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
	        super("ѡ��");
	        jp = new JPanel();
	        jp.setLayout(new GridLayout(2,2));
	        b2 = new JButton("������һ��");
	        this.sNo = sNo;
	        jta = new JTextArea();
	        jp.add(b2);
	        jp.add(jta);
	        columnNames = new Vector();
	        columnNames.add("�γ̱��");
	        columnNames.add("�γ�����");
	        columnNames.add("�ο���ʦ");
	        columnNames.add("����");
	        columnNames.add("ѧ��");
	        columnNames.add("��ʼʱ��");
	        columnNames.add("����ʱ��");
	        columnNames.add("������");
	        rowData = new Vector();
	        rowData = new selectsql().selectsc(sNo);
	        jt = new JTable(rowData, columnNames);
	        jt.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
	        jt.getTableHeader().setForeground(Color.RED); // ���ñ�ͷ����������ɫ
	        jt.getTableHeader().setResizingAllowed(false); // ���ò������ֶ��ı��п�
	        jt.getTableHeader().setReorderingAllowed(false); // ���ò������϶������������
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
