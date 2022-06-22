package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class Information {

	JFrame frame;
	private JTextField textsearch;
	private JTextField textmenunumber;
	private JTextField textmenuname;
	private JTextField textmenuprice;
	private JTextField textuserid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Information window = new Information();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Information() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 900);
		frame.setTitle("케이크 예약 프로그램 ");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("예약 정보");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		label.setBounds(0, 0, 1294, 166);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("돌아가기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Usermain umain = new Usermain();
				umain.frame.setVisible(true);
			}
		});
		button.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		button.setBounds(33, 64, 129, 55);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("로그아웃");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.","로그아웃 메세지",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				Logintest lgin = new Logintest();
				lgin.frame.setVisible(true);
			}
		});
		button_1.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		button_1.setBounds(1102, 82, 129, 55);
		frame.getContentPane().add(button_1);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\btnimg.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		label_1.setBounds(0, 0, 1294, 206);
		frame.getContentPane().add(label_1);
		String id = Logintest.textId.getText();
		String[][] idata= Customer.getReservation(id);
		String[] iheaders = new String[] {"예약 번호", "아이디", "메뉴 이름", "가격","예약일"};
		
		JPanel panelInfor = new JPanel();
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker.setBounds(953, 237, 230, 29);
		panelInfor.add(datePicker);
		panelInfor.setBounds(0, 172, 1294, 693);
		panelInfor.setLayout(null);
		
		
		DefaultTableModel imodel = new DefaultTableModel(idata, iheaders) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		
		JTable ctable = new JTable(imodel);
		ctable.setRowHeight(30);
		ctable.setAlignmentX(0);
		ctable.setSize(1000, 300);
		ctable.setPreferredScrollableViewportSize(new Dimension(1000,300));
		ctable.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(ctable);
		scrollPane.setBounds(85, 75, 779, 328);
		panelInfor.add(scrollPane);
		frame.getContentPane().add(panelInfor);
		
		textsearch = new JTextField();
		textsearch.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textsearch.setColumns(10);
		textsearch.setBounds(144, 28, 700, 26);
		panelInfor.add(textsearch);
		
		JLabel labelsearch = new JLabel("검색");
		labelsearch.setHorizontalAlignment(SwingConstants.CENTER);
		labelsearch.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		labelsearch.setBounds(93, 17, 61, 44);
		panelInfor.add(labelsearch);
		
		textmenunumber = new JTextField();
		textmenunumber.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenunumber.setEditable(false);
		textmenunumber.setColumns(10);
		textmenunumber.setBackground(Color.WHITE);
		textmenunumber.setBounds(953, 77, 232, 29);
		panelInfor.add(textmenunumber);
		
		JLabel labelmenunumber = new JLabel("메뉴 번호");
		labelmenunumber.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenunumber.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenunumber.setBounds(878, 77, 73, 29);
		panelInfor.add(labelmenunumber);
		
		textmenuname = new JTextField();
		textmenuname.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenuname.setEditable(false);
		textmenuname.setColumns(10);
		textmenuname.setBackground(Color.WHITE);
		textmenuname.setBounds(953, 155, 232, 29);
		panelInfor.add(textmenuname);
		
		JLabel labelmenuname = new JLabel("메뉴 이름");
		labelmenuname.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenuname.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenuname.setBounds(878, 154, 73, 29);
		panelInfor.add(labelmenuname);
		
		textmenuprice = new JTextField();
		textmenuprice.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenuprice.setEditable(false);
		textmenuprice.setColumns(10);
		textmenuprice.setBackground(Color.WHITE);
		textmenuprice.setBounds(953, 194, 232, 29);
		panelInfor.add(textmenuprice);
		
		JLabel labelmenuprice = new JLabel("가격");
		labelmenuprice.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenuprice.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenuprice.setBounds(895, 194, 56, 29);
		panelInfor.add(labelmenuprice);
		
		JLabel labelreserdate = new JLabel("예약일");
		labelreserdate.setHorizontalAlignment(SwingConstants.CENTER);
		labelreserdate.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelreserdate.setBounds(895, 233, 56, 29);
		panelInfor.add(labelreserdate);
		
		textuserid = new JTextField();
		textuserid.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textuserid.setEditable(false);
		textuserid.setColumns(10);
		textuserid.setBackground(Color.WHITE);
		textuserid.setBounds(953, 114, 232, 29);
		panelInfor.add(textuserid);
		
		JLabel labeluserid = new JLabel("아이디");
		labeluserid.setHorizontalAlignment(SwingConstants.CENTER);
		labeluserid.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labeluserid.setBounds(895, 114, 56, 29);
		panelInfor.add(labeluserid);
		
		JButton buttoncall = new JButton("예약 취소");
		buttoncall.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		buttoncall.setBounds(1080, 275, 93, 37);
		panelInfor.add(buttoncall);
		
		JButton buttondatechange = new JButton("예약 변경");
		buttondatechange.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		buttondatechange.setBounds(975, 275, 93, 37);
		panelInfor.add(buttondatechange);
		
		//검색 텍스트에 값을 입력하면 실시간으로 검색해주는 이벤트
					textsearch.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent e) {
						String val = textsearch.getText();
						TableRowSorter<TableModel> trs = new TableRowSorter<>(ctable.getModel());
						ctable.setRowSorter(trs);
						trs.setRowFilter(RowFilter.regexFilter(val));
					}
				});
		
		ctable.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel rudata = ctable.getModel();
				int row = ctable.getSelectedRow();
				  int col = ctable.getSelectedColumn();
				  for (int i = 0; i < ctable.getColumnCount(); i++) {
				   System.out.println(ctable.getModel().getValueAt(row, i )+"\t"); 
				  }
				  String resernumber = (String)rudata.getValueAt(row,0);
				  String userid = (String)rudata.getValueAt(row,1);
				  String menuname = (String)rudata.getValueAt(row,2);
				  String menuprice = (String)rudata.getValueAt(row,3);
				  String reserdate = (String)rudata.getValueAt(row,4);

				  textmenunumber.setText(resernumber);
				  textuserid.setText(userid);
				  textmenuname.setText(menuname);
				  textmenuprice.setText(menuprice);
				  datePicker.getJFormattedTextField().setText(reserdate);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});	
		//예약 변경 버튼 누를 시 
		buttondatechange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numberTxt =  textmenunumber.getText();
				String dateTxt = datePicker.getJFormattedTextField().getText();
				
				if(datePicker.getJFormattedTextField().getText().equals("")) {
					JOptionPane.showMessageDialog(null,"아래 예약일에서 날짜를 선택해주세요!"); // 메세지 박스 띄움
				}else if(datePicker.getJFormattedTextField().getText().equals(dateTxt)) {
					Customer.updateReservation(dateTxt, numberTxt);
					JOptionPane.showMessageDialog(null,"예약일이 변경되었습니다."); // 메세지 박스 띄움
					frame.dispose(); 
					new Information().main(null);
				}
			}
		});
		//예약 취소 버튼 누를 시
		buttoncall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numberTxt =  textmenunumber.getText();
				
				Customer.deleteReservation(numberTxt);
				JOptionPane.showMessageDialog(null,"예약이 취소되었습니다."); // 메세지 박스 띄움
				frame.dispose(); 
				new Information().main(null);
			}
		});
	}
}
