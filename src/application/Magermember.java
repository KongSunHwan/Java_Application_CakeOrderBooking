package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Magermember{

	 JFrame frame;
	 JTextField usersearch;
	 private JTextField textUserNmeber;
	 private JTextField textUserId;
	 private JTextField textUserName;
	 private JTextField textUserPn;
	 private JTextField textUserGender;
	 private JTextField textpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Magermember window = new Magermember();
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
	public Magermember() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("케이크 주문 예약 프로그램");
		frame.setBounds(100, 100, 1300, 900);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelMagermember = new JLabel("회원 관리");
		labelMagermember.setHorizontalAlignment(SwingConstants.CENTER);
		labelMagermember.setForeground(Color.WHITE);
		labelMagermember.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		labelMagermember.setBounds(0, 0, 1294, 166);
		frame.getContentPane().add(labelMagermember);
		
		JButton buttonLogout = new JButton("로그아웃");
		//로그아웃 버튼 누를 시
		buttonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.","로그아웃 메세지",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false); //현재 띄우고 있는 frame을 닫음
				Logintest lgn = new Logintest(); //Logintest 클래스를 가져옴
				lgn.frame.setVisible(true); // Logintest 객체인 lgn안에 frame을 새로 띄움
			}
		});

		JButton buttonback = new JButton("돌아가기");
		//돌아가기 버튼 누를 시
		buttonback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Adminmain adm = new Adminmain();
				adm.frame.setVisible(true);
			}
		});
		buttonback.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttonback.setBounds(33, 64, 129, 55);
		frame.getContentPane().add(buttonback);
		buttonLogout.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttonLogout.setBounds(1102, 82, 129, 55);
		frame.getContentPane().add(buttonLogout);
		
		JLabel labelimg3 = new JLabel("");
		labelimg3.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\btnimg.png"));
		labelimg3.setHorizontalAlignment(SwingConstants.CENTER);
		labelimg3.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		labelimg3.setBounds(0, 0, 1294, 206);
		frame.getContentPane().add(labelimg3);
		
		JPanel panelMagermember = new JPanel();
		panelMagermember.setBounds(0, 171, 1294, 694);
		String[][] data = Customer.getUsers(); // Customer안에 DAO => getUsers()메소드를 가져와서 data 이중배열에 넣어줌
		String[] headers = new String[] {"번호", "아이디", "비밀번호", "핸드폰번호", "이름", "성별"}; //테이블 컬럼이름 설정
		panelMagermember.setLayout(null);
		DefaultTableModel model = new DefaultTableModel(data, headers) {
			//테이블에서 수정 못하게 함.
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		JTable table = new JTable(model);
		table.setRowHeight(30);
		table.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		table.setAlignmentX(0);
		table.setSize(1000, 300);
		table.setPreferredScrollableViewportSize(new Dimension(1000,300));
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(137, 5, 1019, 328);
		panelMagermember.add(scrollPane);
		frame.getContentPane().add(panelMagermember);
		
		
		usersearch = new JTextField();
		usersearch.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		usersearch.setBounds(924, 343, 232, 29);
		panelMagermember.add(usersearch);
		usersearch.setColumns(10);
		
		JLabel lblsearch = new JLabel("검색 :");
		lblsearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblsearch.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		lblsearch.setBounds(866, 342, 56, 29);
		panelMagermember.add(lblsearch);
		
		textUserNmeber = new JTextField();
		textUserNmeber.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textUserNmeber.setColumns(10);
		textUserNmeber.setBounds(205, 343, 232, 29);
		textUserNmeber.setEditable(false);
		textUserNmeber.setBackground(Color.white);
		panelMagermember.add(textUserNmeber);
		
		JLabel labelusernumber = new JLabel("회원 번호");
		labelusernumber.setHorizontalAlignment(SwingConstants.CENTER);
		labelusernumber.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelusernumber.setBounds(130, 343, 73, 29);
		panelMagermember.add(labelusernumber);
		
		textUserId = new JTextField();
		textUserId.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textUserId.setColumns(10);
		textUserId.setBounds(205, 383, 232, 29);
//		textUserId.setEditable(false);
		textUserId.setBackground(Color.white);
		panelMagermember.add(textUserId);
		
		JLabel labeluserid = new JLabel("아이디");
		labeluserid.setHorizontalAlignment(SwingConstants.CENTER);
		labeluserid.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labeluserid.setBounds(140, 381, 63, 29);
		panelMagermember.add(labeluserid);
		
		textUserName = new JTextField();
		textUserName.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textUserName.setColumns(10);
		textUserName.setBounds(205, 507, 232, 29);
		panelMagermember.add(textUserName);
		
		JLabel labelusername = new JLabel("이름");
		labelusername.setHorizontalAlignment(SwingConstants.CENTER);
		labelusername.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelusername.setBounds(147, 506, 56, 29);
		panelMagermember.add(labelusername);
		
		textUserPn = new JTextField();
		textUserPn.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textUserPn.setColumns(10);
		textUserPn.setBounds(205, 467, 232, 29);
		panelMagermember.add(textUserPn);
		
		JLabel labelusertel = new JLabel("전화번호");
		labelusertel.setHorizontalAlignment(SwingConstants.CENTER);
		labelusertel.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelusertel.setBounds(137, 467, 56, 29);
		panelMagermember.add(labelusertel);
		
		textUserGender = new JTextField();
		textUserGender.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textUserGender.setColumns(10);
		textUserGender.setEditable(false);
		textUserGender.setBackground(Color.white);
		textUserGender.setBounds(205, 547, 232, 29);
		panelMagermember.add(textUserGender);
		
		JLabel labelusergender = new JLabel("성별");
		labelusergender.setHorizontalAlignment(SwingConstants.CENTER);
		labelusergender.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelusergender.setBounds(147, 546, 56, 29);
		panelMagermember.add(labelusergender);
		
		JButton buttonuserupdate = new JButton("수정");
		buttonuserupdate.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		buttonuserupdate.setBounds(217, 599, 93, 37);
		panelMagermember.add(buttonuserupdate);
		
		JButton buttonuserdel = new JButton("삭제");
		buttonuserdel.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		buttonuserdel.setBounds(322, 599, 93, 37);
		panelMagermember.add(buttonuserdel);
		
		textpassword = new JTextField();
		textpassword.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
//		textpassword.setEditable(false);
		textpassword.setColumns(10);
		textpassword.setBackground(Color.WHITE);
		textpassword.setBounds(205, 426, 232, 29);
		panelMagermember.add(textpassword);
		
		JLabel labelpassword = new JLabel("비밀번호");
		labelpassword.setHorizontalAlignment(SwingConstants.CENTER);
		labelpassword.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelpassword.setBounds(140, 424, 63, 29);
		panelMagermember.add(labelpassword);
		
		//검색 텍스트에 값을 입력하면 실시간으로 검색해주는 이벤트
		usersearch.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = usersearch.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		
		TableColumnModel columnModels = table.getColumnModel();
		columnModels.getColumn(0).setPreferredWidth(10); //테이블 0열을 10으로 사이즈 조정
		columnModels.getColumn(1).setPreferredWidth(50); //테이블 1열을 50으로 사이즈 조정
		columnModels.getColumn(2).setPreferredWidth(30); //테이블 2열을 30으로 사이즈 조정
		columnModels.getColumn(3).setPreferredWidth(40); //테이블 3열을 40으로 사이즈 조정
		columnModels.getColumn(4).setPreferredWidth(20); //테이블 4열을 20으로 사이즈 조정
		columnModels.getColumn(5).setPreferredWidth(30); //테이블 5열을 30으로 사이즈 조정
		
		//테이블안에서 마우스 클릭시 일어나는 이벤트
		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TableModel udata = table.getModel();
				int row = table.getSelectedRow();
				  int col = table.getSelectedColumn();
				  for (int i = 0; i < table.getColumnCount(); i++) {
				   System.out.println(table.getModel().getValueAt(row, i )+"\t"); 
				  }
				  String usernumber = (String)udata.getValueAt(row,0);
				  String userid = (String)udata.getValueAt(row,1);
				  String userpassword = (String)udata.getValueAt(row,2);
				  String userpn = (String)udata.getValueAt(row,3);
				  String username = (String)udata.getValueAt(row,4);
				  String usergender = (String)udata.getValueAt(row,5);
				  
				  textUserNmeber.setText(usernumber);
				  textUserId.setText(userid);
				  textpassword.setText(userpassword);
				  textUserName.setText(username);
				  textUserPn.setText(userpn);
				  textUserGender.setText(usergender);
				  
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
		//삭제 버튼 클릭 시
		buttonuserdel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow(); // 테이블 행을 넣어줌
				int i = Integer.parseInt(textUserNmeber.getText()); // i에 String형인 textUserNmeber을 int로 형변환하여 넣어줌
				Customer.numberUsers();
				if(row == -1) {  //row == -1 일때 리턴
				return;
				}
			Customer.deleteUsers(i); //Customer에 있는 DAO 딜리트문을 실행 매개변수엔 i를 넣음
			model.removeRow(row); // 모델안에 있는 테이블 행을 하나씩 없애라
			model.fireTableDataChanged(); // 모델안에 있는 테이블을 초기화하여 보여줘라
			JOptionPane.showMessageDialog(null,"선택된 회원이 삭제되었습니다."); // 메세지 박스 띄움
			
			frame.dispose(); 
			new Magermember().main(null);
			}
		});
		//수정 버튼 클릭 시
		buttonuserupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String numberTxt = textUserNmeber.getText();
				String idTxt = textUserId.getText();
				String pwTxt = textpassword.getText();
				String phoneTxt = textUserPn.getText();
				String nameTxt = textUserName.getText();
				
				Customer.updateUsers(idTxt, pwTxt, phoneTxt, nameTxt,numberTxt);
				model.fireTableDataChanged(); // 모델안에 있는 테이블을 초기화하여 보여줘라
				
				frame.dispose(); 
				new Magermember().main(null);
			}
		});
}
}

