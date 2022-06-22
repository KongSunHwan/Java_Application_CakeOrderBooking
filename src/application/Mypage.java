package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Mypage {

	JFrame frame;
	private JTextField textuserid;
	private JTextField textusertel;
	private JTextField textusername;
	private JPasswordField passworduser;
	private JPasswordField passwordcheck;
	private JLabel labelgender;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mypage window = new Mypage();
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
	public Mypage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		        
		frame = new JFrame();
		frame.setTitle("케이크 주문 예약 프로그램");
		frame.setBounds(100, 100, 730, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel labelmypage = new JLabel("마이페이지");
		labelmypage.setHorizontalAlignment(SwingConstants.CENTER);
		labelmypage.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		labelmypage.setBounds(254, 10, 222, 53);
		frame.getContentPane().add(labelmypage);
		
		JLabel labeluserid = new JLabel("아이디 :");
		labeluserid.setHorizontalAlignment(SwingConstants.CENTER);
		labeluserid.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		labeluserid.setBounds(173, 101, 107, 44);
		frame.getContentPane().add(labeluserid);
		
		JLabel labelpwd = new JLabel("비밀번호 :");
		labelpwd.setHorizontalAlignment(SwingConstants.CENTER);
		labelpwd.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		labelpwd.setBounds(163, 140, 117, 44);
		frame.getContentPane().add(labelpwd);
		
		textuserid = new JTextField();
		textuserid.setToolTipText("");
		textuserid.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		textuserid.setColumns(10);
		textuserid.setEditable(false);
		textuserid.setBackground(Color.white);
		textuserid.setBounds(267, 112, 209, 26);
		frame.getContentPane().add(textuserid);
	
		String id = Logintest.textId.getText();
		textuserid.setText(id);
		UserInfoDTO userInfo = Customer.mypageselectUsers(id);

		JButton buttonupdate = new JButton("수정");
		buttonupdate.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		buttonupdate.setBounds(299, 339, 83, 68);
		frame.getContentPane().add(buttonupdate);
		
		JButton buttonclose = new JButton("취소");
		buttonclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Usermain umain = new Usermain();
				umain.frame.setVisible(true);
			}
		});
		buttonclose.setFont(new Font("함초롬돋움", Font.BOLD, 18));
		buttonclose.setBounds(394, 339, 83, 68);
		frame.getContentPane().add(buttonclose);
		
		textusertel = new JTextField();
		textusertel.setToolTipText("");
		textusertel.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		textusertel.setColumns(10);
		textusertel.setBounds(267, 259, 209, 26);
		frame.getContentPane().add(textusertel);
		
		textusertel.setText(userInfo.getUserpn());
		
		JLabel labelpwdcheck = new JLabel("비밀번호 확인 :");
		labelpwdcheck.setHorizontalAlignment(SwingConstants.CENTER);
		labelpwdcheck.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		labelpwdcheck.setBounds(152, 176, 107, 44);
		frame.getContentPane().add(labelpwdcheck);
		
		JLabel labelname = new JLabel("이름 :");
		labelname.setHorizontalAlignment(SwingConstants.CENTER);
		labelname.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		labelname.setBounds(181, 214, 117, 44);
		frame.getContentPane().add(labelname);
		
		JLabel labeltel = new JLabel("전화번호 :");
		labeltel.setHorizontalAlignment(SwingConstants.CENTER);
		labeltel.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		labeltel.setBounds(163, 250, 125, 44);
		frame.getContentPane().add(labeltel);
		
		textusername = new JTextField();
		textusername.setToolTipText("");
		textusername.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		textusername.setColumns(10);
		textusername.setBounds(267, 223, 209, 26);
		frame.getContentPane().add(textusername);
		textusername.setText(userInfo.getUsername());
		
		labelgender = new JLabel("성별 :");
		labelgender.setHorizontalAlignment(SwingConstants.CENTER);
		labelgender.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		labelgender.setBounds(181, 285, 117, 44);
		frame.getContentPane().add(labelgender);
		
		JComboBox gendercheck = new JComboBox(new String[] {"남자","여자"});
		gendercheck.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		gendercheck.setBackground(Color.WHITE);
		gendercheck.setSelectedItem(userInfo.getUsergender());
		gendercheck.setBounds(268, 291, 208, 34);
		frame.getContentPane().add(gendercheck);
		
		passworduser = new JPasswordField();
		passworduser.setToolTipText("Enter Pwd");
		passworduser.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		passworduser.setBounds(267, 149, 209, 26);
		frame.getContentPane().add(passworduser);
		
		passwordcheck = new JPasswordField();
		passwordcheck.setToolTipText("Enter Pwd");
		passwordcheck.setFont(new Font("함초롬돋움", Font.BOLD, 15));
		passwordcheck.setBounds(267, 185, 209, 26);
		frame.getContentPane().add(passwordcheck);
		
		Customer.mypageselectUsers(id);
		
		JButton buttonlogout = new JButton("로그아웃");
		//로그아웃 버튼 클릭 시
		buttonlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.","로그아웃 메세지",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				Logintest lgin = new Logintest();
				lgin.frame.setVisible(true);
			}
		});
		buttonlogout.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		buttonlogout.setBounds(609, 10, 93, 34);
		frame.getContentPane().add(buttonlogout);
		
		JButton buttonback = new JButton("돌아가기");
		//돌아가기 버튼 누를 시
		buttonback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Usermain umain = new Usermain();
				umain.frame.setVisible(true);
			}
		});
		buttonback.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		buttonback.setBounds(12, 10, 93, 34);
		frame.getContentPane().add(buttonback);
		
		//수정 버튼 누를 시
				buttonupdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String regExp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
						String pwTxt = passworduser.getText();
						String phoneTxt = textusertel.getText();
						String nameTxt = textusername.getText();
						String genderTxt = gendercheck.getSelectedItem().toString();
						
						String password = passworduser.getText();
						String pwdCheck = passwordcheck.getText();
						
						if(Arrays.equals(passworduser.getPassword(),"".toCharArray())) {
							JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요.");
						}else if(password.length()<6 || password.length()>20) {    
							JOptionPane.showMessageDialog(null, "비밀번호는 6자리 이상, 20자리 이하만 가능 합니다.");
						}else if(Arrays.equals(passwordcheck.getPassword(),"".toCharArray())) {
							JOptionPane.showMessageDialog(null, "비교할 비밀번호를 입력해 주시기 바랍니다");
						} else if(!password.equals(pwdCheck)) {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
						}else if(checkPWDMethod(password)==1) {
							JOptionPane.showMessageDialog(null, "비밀번호 특수문자는 (!,@,#)만 포함 가능 합니다");
						}else if(textusername.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"이름을 입력해주세요.");
						}else if(textusertel.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"전화번호를 입력해주세요.");
						}
//						else if(phoneTxt.matches(regExp) == true) {
//							JOptionPane.showMessageDialog(null,"형식에 맞는 전화번호입니다.");
//						}
						else if(phoneTxt.matches(regExp) == false){
							JOptionPane.showMessageDialog(null,"전화번호 형식은 [000-0000-0000], [01012345678]으로 입력해주세요.");
						}
						
						if(phoneTxt.matches(regExp) == true && 
								Arrays.equals(passworduser.getPassword(),pwTxt.toCharArray()) && textusername.getText().equals(nameTxt)
								&& password.equals(pwdCheck) && password.length() >= 6) {
						Customer.mypageupdateUsers(pwTxt, phoneTxt, nameTxt, genderTxt, id);
						JOptionPane.showMessageDialog(null, "회원 정보가 수정 되었습니다.","안내 메세지",JOptionPane.INFORMATION_MESSAGE);
						passworduser.setText("");
						passwordcheck.setText("");
						textusertel.setText("");
						textusername.setText("");
						}
					}
				});
	}
	public int checkPWDMethod(String pwd) {
		int check= 0;
		char alpha;
		int code;
		for(int i=0; i<pwd.length(); i++) {
			alpha = pwd.charAt(i);
			code = (int)alpha;
			if(code>=0 && code<=32 || code>=36 && code<=47 || code>=58 && code<=63 || code>=91 && code <=96 || code>=123 && code <= 127) {
				check = 1;
				
			}
		}
		return check;
	}

}

