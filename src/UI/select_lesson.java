package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import JDBC.*;
public class select_lesson extends  JFrame{
    Vector rowData,columnNames;
    JTable jt;
    JScrollPane jsp;
    JLabel jl;
    JTextField jtf;
    JPanel jp;
    JButton b1,b2;
    JTextArea jta;
    private String value;
	public select_lesson(){
	        super("ѡ��");
            jp = new JPanel();
            jp.setLayout(new GridLayout(3,2));
            b1 = new JButton("ȷ��");
            b2 = new JButton("������һ��");
            jl = new JLabel("ѧ��");
            jtf = new JTextField();
            jta = new JTextArea();
            jp.add(jl);
            jp.add(jtf);
            jp.add(b1);
            jp.add(b2);
            jp.add(jta);
            columnNames = new Vector();
            columnNames.add("�γ̱��");
            columnNames.add("�γ�����");
            columnNames.add("ѧ��");
            columnNames.add("����");
            columnNames.add("�ο���ʦ");
            columnNames.add("��ʼʱ��");
            columnNames.add("����ʱ��");
            columnNames.add("������");
            rowData = new Vector();
            rowData = new selectsql().selectfromcourse();
            jt = new JTable(rowData, columnNames);
            jt.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
            jt.getTableHeader().setForeground(Color.RED); // ���ñ�ͷ����������ɫ
            jt.getTableHeader().setResizingAllowed(false); // ���ò������ֶ��ı��п�
            jt.getTableHeader().setReorderingAllowed(false); // ���ò������϶������������
            jt.setPreferredScrollableViewportSize(new Dimension(400, 300));
            //��ʼ�� jsp
            jsp = new JScrollPane(jt);
            jt.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = jt.getSelectedRow();
                    value = (String) jt.getValueAt(row, 0);
                }
            });
            b1.addActionListener(e -> {
                select_lessonsql se = new select_lessonsql(value,Integer.parseInt(jtf.getText()));
                if(se.getI()>0){
                    jta.setText("ѡ�γɹ�");
                }
                else jta.setText("ѡ��ʧ��");
            });
            b2.addActionListener(e -> {new adminUI("��ӭ����");this.setVisible(false);});
            //��jsp���뵽jframe
            this.add(jsp,BorderLayout.NORTH);
            this.add(jp);
            this.setSize(800, 500);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        }

    }

