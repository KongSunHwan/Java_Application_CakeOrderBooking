package application;

import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.security.auth.login.LoginException;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.FontMetrics;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.JComboBox;

class ImagePanel extends JPanel {
	private Image imga;
	
	public ImagePanel(Image imga) {
		this.imga = imga;
		setSize(new Dimension(imga.getWidth(null), imga.getHeight(null)));
		setPreferredSize(new Dimension(imga.getWidth(null), imga.getHeight(null)));
		setLayout(null);
	}
	
	public int getWidth() {
		return imga.getWidth(null);
	}
	
	public int getHeight() {
		return imga.getHeight(null);
	}
	public void paintComponent(Graphics g) {
		g.drawImage(imga, 0, 0, null);
	}
}

public class Logintest {

	JFrame frame;
	public static JTextField textId;
	public static JPasswordField textpassword;
	private JTextField textJoinId;
	private JTextField textJointel;
	private JTextField textJoinName;
	private JPasswordField textJoinpwd;
	private JPasswordField textJoinpwdcheck;
	private boolean setbackgroundcolor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logintest window = new Logintest();
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
	public Logintest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("케이크 주문 예약 프로그램");
		frame.getContentPane().setLayout(null);
				//		frame.setBounds(100, 100, 730, 500);
						ImagePanel welcomePanel1 = new ImagePanel(new ImageIcon("C:/Users/82107/eclipse-workspace/Java_Application_CakeOrderBooking/image/ck.jpeg").getImage());
						welcomePanel1.setBounds(0, 1, 714, 444);
						frame.setSize(welcomePanel1.getWidth(),welcomePanel1.getHeight());
						frame.getContentPane().add(welcomePanel1);
						welcomePanel1.setLayout(null);
						
						JLabel lableLogin = new JLabel("로그인");
						lableLogin.setBounds(273, 60, 168, 86);
						lableLogin.setFont(new Font("함초롬돋움", Font.BOLD, 40));
						lableLogin.setHorizontalAlignment(SwingConstants.CENTER);
						welcomePanel1.add(lableLogin);
						
						JLabel labelId = new JLabel("아이디 :");
						labelId.setBounds(156, 187, 107, 44);
						labelId.setHorizontalAlignment(SwingConstants.CENTER);
						labelId.setFont(new Font("함초롬돋움", Font.BOLD, 15));
						welcomePanel1.add(labelId);
						
						JLabel labelPwd = new JLabel("비밀번호 :");
						labelPwd.setBounds(146, 226, 117, 44);
						labelPwd.setHorizontalAlignment(SwingConstants.CENTER);
						labelPwd.setFont(new Font("함초롬돋움", Font.BOLD, 15));
						welcomePanel1.add(labelPwd);
						
						textId = new JTextField(30);
						textId.setBounds(250, 198, 209, 26);
						textId.setToolTipText("Enter ID");
						textId.setFont(new Font("함초롬돋움", Font.BOLD, 15));
						welcomePanel1.add(textId);
						textId.setColumns(10);
						
						JButton btnLogin = new JButton("로그인");
						btnLogin.setBounds(464, 198, 137, 60);
						btnLogin.setIcon(null);
						btnLogin.setPressedIcon(new ImageIcon("C:\\Users\\82107\\eclipse-workspace\\Java_Application_CakeOrderBooking\\image\\buttonimg.png"));
						
						btnLogin.setFont(new Font("함초롬돋움", Font.BOLD, 21));
						welcomePanel1.add(btnLogin);
						
						textpassword = new JPasswordField(30);
						textpassword.setBounds(250, 236, 209, 26);
						textpassword.setToolTipText("Enter Pwd");
						textpassword.setFont(new Font("함초롬돋움", Font.BOLD, 15));
						welcomePanel1.add(textpassword);
						
						JRadioButton rdbtnUser = new JRadioButton("회원");
						rdbtnUser.setBorder(null);
						rdbtnUser.setBackground(Color.WHITE);
						rdbtnUser.setHorizontalAlignment(SwingConstants.CENTER);
						rdbtnUser.setLocation(290, 166);
						rdbtnUser.setSize(51, 26);
						rdbtnUser.setFont(new Font("함초롬돋움", Font.BOLD, 13));
						JRadioButton rdbtnAim = new JRadioButton("관리자");
						rdbtnAim.setBorder(null);
						rdbtnAim.setBackground(Color.WHITE);
						rdbtnAim.setHorizontalAlignment(SwingConstants.CENTER);
						rdbtnAim.setLocation(361, 166);
						rdbtnAim.setSize(65, 26);
						rdbtnAim.setFont(new Font("함초롬돋움", Font.BOLD, 13));
						ButtonGroup group = new ButtonGroup();
						rdbtnUser.setActionCommand("1");
						rdbtnAim.setActionCommand("2");
						group.add(rdbtnUser);
						group.add(rdbtnAim);
						rdbtnUser.setSelected(true);
						welcomePanel1.add(rdbtnUser);
						welcomePanel1.add(rdbtnAim);
						
						//유저 라디오 버튼 클릭 시
						rdbtnUser.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println(group.getSelection().getActionCommand());
							}
						});
						//관리자 라디도 버튼 클릭 시
						rdbtnAim.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								System.out.println(group.getSelection().getActionCommand());
							}
						});
						
						JButton btnJoin = new JButton("회원가입");
						btnJoin.setBounds(464, 271, 137, 36);
						btnJoin.setFont(new Font("함초롬돋움", Font.BOLD, 18));
						welcomePanel1.add(btnJoin);
				
				
				
				JPanel joinPanel = new JPanel();
				joinPanel.setBackground(SystemColor.inactiveCaption); 
				joinPanel.setBounds(0, 0, 714, 451);
				frame.getContentPane().add(joinPanel);
				joinPanel.setLayout(null);
				
				JLabel labelJoin = new JLabel("회원가입");
				labelJoin.setBounds(279, 5, 156, 53);
				labelJoin.setHorizontalAlignment(SwingConstants.CENTER);
				labelJoin.setFont(new Font("함초롬돋움", Font.BOLD, 40));
				joinPanel.add(labelJoin);
				joinPanel.setVisible(false);
				
				JLabel labelJoinId = new JLabel("아이디 :");
				labelJoinId.setHorizontalAlignment(SwingConstants.CENTER);
				labelJoinId.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				labelJoinId.setBounds(167, 70, 107, 44);
				joinPanel.add(labelJoinId);
				
				JLabel labelJoinPwd = new JLabel("비밀번호 :");
				labelJoinPwd.setHorizontalAlignment(SwingConstants.CENTER);
				labelJoinPwd.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				labelJoinPwd.setBounds(157, 109, 117, 44);
				joinPanel.add(labelJoinPwd);
				
				textJoinId = new JTextField(30);
				textJoinId.setToolTipText("");
				textJoinId.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				textJoinId.setColumns(10);
				textJoinId.setBounds(261, 81, 209, 26);
				joinPanel.add(textJoinId);
				
				JButton buttonOk = new JButton("확인");
				buttonOk.setFont(new Font("함초롬돋움", Font.BOLD, 18));
				buttonOk.setBounds(292, 323, 83, 68);
				joinPanel.add(buttonOk);
				
				JButton buttonCall = new JButton("취소");
				buttonCall.setFont(new Font("함초롬돋움", Font.BOLD, 18));
				buttonCall.setBounds(387, 323, 83, 68);
				joinPanel.add(buttonCall);
				
				textJointel = new JTextField(30);
				textJointel.setToolTipText("");
				textJointel.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				textJointel.setColumns(10);
				textJointel.setBounds(261, 228, 209, 26);
				joinPanel.add(textJointel);
				
				JLabel labelJoinPwdCheck = new JLabel("비밀번호 확인 :");
				labelJoinPwdCheck.setHorizontalAlignment(SwingConstants.CENTER);
				labelJoinPwdCheck.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				labelJoinPwdCheck.setBounds(146, 145, 107, 44);
				joinPanel.add(labelJoinPwdCheck);
				
				JLabel labelJoinName = new JLabel("이름 :");
				labelJoinName.setHorizontalAlignment(SwingConstants.CENTER);
				labelJoinName.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				labelJoinName.setBounds(175, 183, 117, 44);
				joinPanel.add(labelJoinName);
				
				JLabel labelJointel = new JLabel("전화번호 :");
				labelJointel.setHorizontalAlignment(SwingConstants.CENTER);
				labelJointel.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				labelJointel.setBounds(157, 219, 125, 44);
				joinPanel.add(labelJointel);
				
				textJoinName = new JTextField(30);
				textJoinName.setToolTipText("");
				textJoinName.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				textJoinName.setColumns(10);
				textJoinName.setBounds(261, 192, 209, 26);
				joinPanel.add(textJoinName);
				
				JButton btnJoinIdCheck = new JButton("중복확인");
				btnJoinIdCheck.setFont(new Font("함초롬돋움", Font.BOLD, 14));
				btnJoinIdCheck.setBounds(484, 76, 90, 33);
				joinPanel.add(btnJoinIdCheck);
				
				JLabel labelJoinGender = new JLabel("성별 :");
				labelJoinGender.setHorizontalAlignment(SwingConstants.CENTER);
				labelJoinGender.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				labelJoinGender.setBounds(175, 254, 117, 44);
				joinPanel.add(labelJoinGender);
				
				JComboBox JoinGendercomboBox = new JComboBox(new String[] {"남자","여자"});
				JoinGendercomboBox.setFont(new Font("함초롬돋움", Font.BOLD, 12));
				JoinGendercomboBox.setBackground(Color.WHITE);
				JoinGendercomboBox.setBounds(262, 260, 208, 34);
				joinPanel.add(JoinGendercomboBox);
				
				textJoinpwd = new JPasswordField(20);
				textJoinpwd.setToolTipText("Enter Pwd");
				textJoinpwd.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				textJoinpwd.setBounds(261, 118, 209, 26);
				joinPanel.add(textJoinpwd);
				
				textJoinpwdcheck = new JPasswordField(20);
				textJoinpwdcheck.setToolTipText("Enter Pwd");
				textJoinpwdcheck.setFont(new Font("함초롬돋움", Font.BOLD, 15));
				textJoinpwdcheck.setBounds(261, 154, 209, 26);
				joinPanel.add(textJoinpwdcheck);
				
//				JLabel lblpwcheck = new JLabel("암호가 확인되었습니다.");
//				lblpwcheck.setVisible(false);
//				lblpwcheck.setEnabled(true);
//				lblpwcheck.setBounds(474, 161, 150, 15);
//				joinPanel.add(lblpwcheck);
				 
				//회원가입 패널에서 취소버튼 클릭 시
				buttonCall.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						joinPanel.setVisible(false);
						welcomePanel1.setVisible(true);
					}
				});
				//회원가입 패널에서 확인 버튼 클릭시
				buttonOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String regExp = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$";
						String idTxt = textJoinId.getText();
						String pwTxt = new String(textJoinpwd.getPassword());
						String phoneTxt = textJointel.getText();
						String nameTxt = textJoinName.getText();
						String genderTxt = JoinGendercomboBox.getSelectedItem().toString();
						
						String password = textJoinpwd.getText();
						String pwdCheck = textJoinpwdcheck.getText();
						
						//회원가입 유효성 검사
						if(textJoinId.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"아이디를 입력해주세요.");
						}else if(Arrays.equals(textJoinpwd.getPassword(),"".toCharArray())) {
							JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요.");
						}else if(password.length()<6 || password.length()>20) {    
							JOptionPane.showMessageDialog(null, "비밀번호는 6자리 이상, 20자리 이하만 가능 합니다.");
						}else if(Arrays.equals(textJoinpwdcheck.getPassword(),"".toCharArray())) {
							JOptionPane.showMessageDialog(null, "비교할 비밀번호를 입력해 주시기 바랍니다");
						} else if(!password.equals(pwdCheck)) {
							JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다");
						}else if(checkPWDMethod(password)==1) {
							JOptionPane.showMessageDialog(null, "비밀번호 특수문자는 (!,@,#)만 포함 가능 합니다");
						}else if(textJoinName.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"이름을 입력해주세요.");
						}else if(textJointel.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"전화번호를 입력해주세요.");
						}
//						else if(phoneTxt.matches(regExp) == true) {
//							JOptionPane.showMessageDialog(null,"형식에 맞는 전화번호입니다.");
//						}
						else if(phoneTxt.matches(regExp) == false){
							JOptionPane.showMessageDialog(null,"전화번호 형식은 [000-0000-0000], [01012345678]으로 입력해주세요.");
						}
						
						//유효성에 적합 했을 시 실행
						if(phoneTxt.matches(regExp) == true && textJoinId.getText().equals(idTxt) && 
						Arrays.equals(textJoinpwd.getPassword(),pwTxt.toCharArray()) && textJoinName.getText().equals(nameTxt)
						&& password.equals(pwdCheck) && password.length() >= 6) {
							Customer.createUsers(idTxt,pwTxt,phoneTxt,nameTxt,genderTxt);
							JOptionPane.showMessageDialog(null, textJoinName.getText() + "님 회원가입이 완료되었습니다.");
							joinPanel.setVisible(false);
							welcomePanel1.setVisible(true);
							textJoinId.setText("");
							textJoinpwd.setText("");
							textJoinpwdcheck.setText("");
							textJointel.setText("");
							textJoinName.setText("");
							btnJoinIdCheck.setEnabled(true);
							textJoinId.setEnabled(true);
							Customer.numberUsers();
						}
					}
				});
				//회원가입 패널에서 아이디 중복체크 버튼 클릭시 
				btnJoinIdCheck.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String idSearch = textJoinId.getText();
						System.out.println(idSearch.length());
						if(idSearch.equals("")) {
							JOptionPane.showMessageDialog(null, "아이디를 입력하셔야 합니다");
							//id 특수문자 포함 확인
						} else if(idSearch.length() < 6 || idSearch.length() > 15) {
							JOptionPane.showMessageDialog(null, "아이디는 6자리 이상, 15자리 이하만 가능 합니다.");
						} else if(checkIDMethod(idSearch)==1){
							JOptionPane.showMessageDialog(null, "아이디는 특수문자 포함이 불가능합니다");
						} else {
							 ArrayList<String> result = Customer.getidCheck(idSearch);
							if(result.size()==0) {
								JOptionPane.showMessageDialog(null, "사용 가능한 아이디 입니다");
								btnJoinIdCheck.setEnabled(false);
								textJoinId.setEnabled(false);
							} else {
								JOptionPane.showMessageDialog(null, "등록되어 있는 아이디 입니다");
							}
					}
					}
				});
				//회원가입 버튼 클릭시
				btnJoin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						welcomePanel1.setVisible(false);
						joinPanel.setVisible(true);
					}
				});
				//로그인 버튼 클릭 시
				btnLogin.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						//어드민 로그인 확인
						 AdminDAO adao=AdminDAO.getInstance();
						 String id = textId.getText();
						String pass = new String(textpassword.getPassword());
						 try {
					            boolean result=adao.login2(id, pass);
					            System.out.println(result);
					            if(result && group.getSelection().getActionCommand().equals("2")) {
					                JOptionPane.showMessageDialog(null, "로그인 성공");
					                frame.setVisible(false);
									Adminmain adm = new Adminmain();
									adm.frame.setVisible(true);
					            } 
					            else if (group.getSelection().getActionCommand().equals("2") && result == false){
					            	JOptionPane.showMessageDialog(null,"로그인 실패","경고 메세지",JOptionPane.INFORMATION_MESSAGE);
					            }
					        } catch (LoginFailException e) {
					            //로그인 실패 시, LoginFailException 발생에 의해 catch문 실행됨
					            JOptionPane.showMessageDialog(null, e.getMessage());
					        }
						 
						 //유저 로그인 확인
						 UsersDAO udao=UsersDAO.getInstance();
						 try {
					            boolean uresult=udao.login2(id, pass);
					            System.out.println(uresult);
					            if(uresult && group.getSelection().getActionCommand().equals("1")) {
					                JOptionPane.showMessageDialog(null, "로그인 성공");
					                frame.setVisible(false);
									Usermain umain = new Usermain();
									umain.frame.setVisible(true);
					            }
					            else if (group.getSelection().getActionCommand().equals("1") && uresult == false) {
					            	JOptionPane.showMessageDialog(null,"로그인 실패","경고 메세지",JOptionPane.INFORMATION_MESSAGE);
					            }
					        } catch (LoginUserException e) {
					            //로그인 실패 시, LoginFailException 발생에 의해 catch문 실행됨
					            JOptionPane.showMessageDialog(null, e.getMessage());
					        }
						    if(textId.getText().equals("") && Arrays.equals(textpassword.getPassword(),"".toCharArray())) {
							JOptionPane.showMessageDialog(null,"아이디와 패스워드를 입력해주세요.","경고 메세지",JOptionPane.INFORMATION_MESSAGE);
						} else if(textId.getText().equals("")) {
							JOptionPane.showMessageDialog(null,"아이디를 입력해주세요.","경고 메세지",JOptionPane.INFORMATION_MESSAGE);
						} else if(Arrays.equals(textpassword.getPassword(),"".toCharArray())) {
							JOptionPane.showMessageDialog(null,"비밀번호를 입력해주세요.","경고 메세지",JOptionPane.INFORMATION_MESSAGE);
						}
					}
				});
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public int checkIDMethod(String id) {
		int check= 0;
		char alpha;
		int code;
		for(int i=0; i<id.length(); i++) {
			alpha = id.charAt(i);
			code = (int)alpha;
			if(code>=0 && code<=47 || code>=58 && code<=63 || code>=91 && code <=96 || code>=123 && code <= 127) {
				check = 1;
			}
		}
		return check;
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

