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

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.SpringLayout;

public class Cakereservation {

	JFrame frame;
	private JTextField textmenunumber;
	private JTextField textmenuname;
	private JTextField textmenuprice;
	private JTextField textmenudate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cakereservation window = new Cakereservation();
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
	public Cakereservation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1300, 900);
		frame.setTitle("케이크 주문 예약 프로그램");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelcakevation = new JLabel("케이크 예약");
		labelcakevation.setHorizontalAlignment(SwingConstants.CENTER);
		labelcakevation.setForeground(Color.WHITE);
		labelcakevation.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		labelcakevation.setBounds(0, 0, 1294, 166);
		frame.getContentPane().add(labelcakevation);
		
		JButton buttonback = new JButton("돌아가기");
		buttonback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Usermain umain = new Usermain();
				umain.frame.setVisible(true);
			}
		});
		
		JButton buttonlogout = new JButton("로그아웃");
		buttonlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.","로그아웃 메세지",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				Logintest lgin = new Logintest();
				lgin.frame.setVisible(true);
			}
		});
		buttonlogout.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttonlogout.setBounds(1102, 82, 129, 55);
		frame.getContentPane().add(buttonlogout);
		buttonback.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttonback.setBounds(33, 64, 129, 55);
		frame.getContentPane().add(buttonback);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\btnimg.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		label_1.setBounds(0, 0, 1294, 206);
		frame.getContentPane().add(label_1);
		
		String[][] cdata= Customer.getMenus();
		String[] cheaders = new String[] {"메뉴 번호", "메뉴 이름", "가격", "제조일","총 판매수","이미지"};
		DefaultTableModel cmodel = new DefaultTableModel(cdata, cheaders)
				{
			public boolean isCellEditable(int i, int c) {
				return false;
			}
				};
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker.setBounds(230, 520, 232, 30);


		
		JPanel panelcake = new JPanel();
		panelcake.add(datePicker);
		panelcake.setBounds(0, 170, 1294, 701);
		panelcake.setLayout(null);
		
		JTable ctable = new JTable(cmodel);
		ctable.setRowHeight(30);
		ctable.setAlignmentX(0);
		ctable.setSize(1000, 300);
		ctable.setPreferredScrollableViewportSize(new Dimension(1000,300));
		ctable.getTableHeader().setReorderingAllowed(false);
		ctable.getColumn("이미지").setWidth(0);
		ctable.getColumn("이미지").setMinWidth(0);
		ctable.getColumn("이미지").setMaxWidth(0);
		ctable.getColumn("총 판매수").setWidth(0);
		ctable.getColumn("총 판매수").setMinWidth(0);
		ctable.getColumn("총 판매수").setMaxWidth(0);

		JScrollPane scrollPane = new JScrollPane(ctable);
		scrollPane.setBounds(146, 5, 1002, 328);
		panelcake.add(scrollPane);
		frame.getContentPane().add(panelcake);
		
		JLabel lblmenulist = new JLabel("메뉴 항목");
		lblmenulist.setHorizontalAlignment(SwingConstants.CENTER);
		lblmenulist.setFont(new Font("굴림", Font.BOLD, 20));
		lblmenulist.setBounds(145, 12, 107, 33);
		panelcake.add(lblmenulist);
		
		textmenunumber = new JTextField();
		textmenunumber.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenunumber.setEditable(false);
		textmenunumber.setColumns(10);
		textmenunumber.setBackground(Color.WHITE);
		textmenunumber.setBounds(230, 358, 232, 29);
		panelcake.add(textmenunumber);
		
		JLabel labelmenunum = new JLabel("메뉴 번호");
		labelmenunum.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenunum.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenunum.setBounds(155, 358, 73, 29);
		panelcake.add(labelmenunum);
		
		textmenuname = new JTextField();
		textmenuname.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenuname.setEditable(false);
		textmenuname.setColumns(10);
		textmenuname.setBackground(Color.WHITE);
		textmenuname.setBounds(230, 398, 232, 29);
		panelcake.add(textmenuname);
		
		JLabel labelmenuname = new JLabel("메뉴 이름");
		labelmenuname.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenuname.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenuname.setBounds(155, 397, 73, 29);
		panelcake.add(labelmenuname);
		
		textmenuprice = new JTextField();
		textmenuprice.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenuprice.setColumns(10);
		textmenuprice.setBounds(230, 437, 232, 29);
		panelcake.add(textmenuprice);
		
		JLabel labelmenuprice = new JLabel("가격");
		labelmenuprice.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenuprice.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenuprice.setBounds(172, 437, 56, 29);
		panelcake.add(labelmenuprice);
		
		textmenudate = new JTextField();
		textmenudate.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenudate.setColumns(10);
		textmenudate.setBounds(230, 477, 232, 29);
		panelcake.add(textmenudate);
		
		JLabel labelmenudate = new JLabel("제조일");
		labelmenudate.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenudate.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenudate.setBounds(172, 476, 56, 29);
		panelcake.add(labelmenudate);
		
		JButton buttonreservation = new JButton("예약하기");
		buttonreservation.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		buttonreservation.setBounds(302, 554, 93, 37);
		panelcake.add(buttonreservation);
		
		JLabel labelreservationdate = new JLabel("예약일");
		labelreservationdate.setHorizontalAlignment(SwingConstants.CENTER);
		labelreservationdate.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelreservationdate.setBounds(172, 517, 56, 29);
		panelcake.add(labelreservationdate);
		
		JButton buttonbestmenu = new JButton("베스트 상품보기");
		buttonbestmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Bestmenu best = new Bestmenu();
				best.frame.setVisible(true);
			}
		});
		buttonbestmenu.setFont(new Font("함초롬돋움", Font.BOLD, 11));
		buttonbestmenu.setBounds(1022, 357, 123, 48);
		panelcake.add(buttonbestmenu);
		
		JPanel panelmenuimg = new JPanel();
		panelmenuimg.setLayout(null);
		panelmenuimg.setBounds(484, 355, 278, 233);
		panelcake.add(panelmenuimg);
		
		JLabel labelmenuimg = new JLabel("");
		labelmenuimg.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\발표자료 or 참고자료\\cakeimgjpg.jpg"));
		labelmenuimg.setBounds(0, 0, 278, 233);
		panelmenuimg.add(labelmenuimg);
		
		//테이블안에서 마우스 클릭시 일어나는 이벤트
				ctable.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						TableModel udata = ctable.getModel();
						int row = ctable.getSelectedRow();
						  int col = ctable.getSelectedColumn();
						  for (int i = 0; i < ctable.getColumnCount(); i++) {
						   System.out.println(ctable.getModel().getValueAt(row, i )+"\t"); 
						  }
						  String menunumber = (String)udata.getValueAt(row,0);
						  String menuname = (String)udata.getValueAt(row,1);
						  String menuprice = (String)udata.getValueAt(row,2);
						  String menudate = (String)udata.getValueAt(row,3);
						  String menuimage = (String)udata.getValueAt(row,5);

						  textmenunumber.setText(menunumber);
						  textmenuname.setText(menuname);
						  textmenuprice.setText(menuprice);
						  textmenudate.setText(menudate);
						  
						  labelmenuimg.setIcon(new ImageIcon(menuimage));
						  labelmenuimg.repaint();
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
				
				//예약하기 버튼 누를 시
				buttonreservation.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						String Rdate = model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay(); //현재 날짜 구하기
						int row = ctable.getSelectedRow(); // 테이블 행을 넣어줌
						int mi = Integer.parseInt(textmenunumber.getText()); // i에 String형인 textmenunumber을 int로 형변환하여 넣어줌
						String id = Logintest.textId.getText();
						String nameTxt = textmenuname.getText();
						String priceTxt = textmenuprice.getText();
						String reservationTxt = datePicker.getJFormattedTextField().getText();
						
						if(datePicker.getJFormattedTextField().getText().equals("")) {
		                    JOptionPane.showMessageDialog(null, "아래 예약일에서 날짜를 선택해주세요!");
		                } else if(datePicker.getJFormattedTextField().getText().equals(reservationTxt)) {
		                	Customer.createReservation(id, nameTxt, priceTxt, reservationTxt);
		                	Customer.updateMenucount(mi);
//		                	Customer.deleteMenu(mi); //Customer에 있는 DAO 딜리트문을 실행 매개변수엔 mi를 넣음
//		                	cmodel.removeRow(row); // 모델안에 있는 테이블 행을 하나씩 없애라
							Customer.numberreservation();
							JOptionPane.showMessageDialog(null, "케이크 예약이 되었습니다!");
							textmenunumber.setText("");
							textmenuname.setText("");
							textmenuprice.setText("");
							textmenudate.setText("");
							datePicker.getJFormattedTextField().setText("");
		                }
					}
				});
				//현재 시간 구하기
//				LocalDateTime now = LocalDateTime.now();
//				String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
//				System.out.println(formatedNow);
	}
}
