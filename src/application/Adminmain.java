package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Adminmain{

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminmain window = new Adminmain();
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
	public Adminmain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1100, 800);
		frame.setTitle("케이크 주문 에약 프로그램");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 168, 1094, 597);
		frame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JButton magerMenu = new JButton("메뉴 관리");
		magerMenu.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		magerMenu.setBounds(449, 79, 204, 116);
		mainPanel.add(magerMenu);
		
		JButton magerMember = new JButton("회원 관리");
		magerMember.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		magerMember.setBounds(449, 263, 204, 116);
		mainPanel.add(magerMember);
		
		JButton buttonLogout = new JButton("로그아웃");
		buttonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.","로그아웃 메세지",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				Logintest lgn = new Logintest();
				lgn.frame.setVisible(true);
			}
		});
		buttonLogout.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttonLogout.setBounds(939, 90, 129, 55);
		frame.getContentPane().add(buttonLogout);
		
		JLabel labelMainpage = new JLabel("메인페이지");
		labelMainpage.setForeground(Color.WHITE);
		labelMainpage.setBounds(0, 0, 1094, 166);
		labelMainpage.setHorizontalAlignment(SwingConstants.CENTER);
		labelMainpage.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		frame.getContentPane().add(labelMainpage);
		
		JLabel labelimg1 = new JLabel("");
		labelimg1.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\btnimg.png"));
		labelimg1.setHorizontalAlignment(SwingConstants.CENTER);
		labelimg1.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		labelimg1.setBounds(0, 0, 1094, 206);
		frame.getContentPane().add(labelimg1);
		
		//메뉴 관리 버튼을 눌렀을 때
		magerMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Magermenu mmenu = new Magermenu();
				mmenu.frame.setVisible(true);
			}
		});
		//회원관리 버튼을 눌렀을 때
		magerMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Magermember mbm = new Magermember();
				mbm.frame.setVisible(true);
			}
		});
	}
}
