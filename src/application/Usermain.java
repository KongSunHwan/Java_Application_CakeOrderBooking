package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usermain {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usermain window = new Usermain();
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
	public Usermain() {
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
		
		JPanel panelusermain = new JPanel();
		panelusermain.setLayout(null);
		panelusermain.setBounds(0, 168, 1094, 597);
		frame.getContentPane().add(panelusermain);
		
		JButton buttoncakeRvtion = new JButton("케이크 예약");
		buttoncakeRvtion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Cakereservation cvation = new Cakereservation();
				cvation.frame.setVisible(true);
			}
		});
		buttoncakeRvtion.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttoncakeRvtion.setBounds(449, 70, 204, 116);
		panelusermain.add(buttoncakeRvtion);
		
		JButton buttonmypage = new JButton("마이페이지");
		buttonmypage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Mypage mpage = new Mypage();
				mpage.frame.setVisible(true);
			}
		});
		buttonmypage.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttonmypage.setBounds(449, 215, 204, 116);
		panelusermain.add(buttonmypage);
		
		JButton buttoninfromation = new JButton("예약 정보");
		buttoninfromation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Information Intion = new Information();
				Intion.frame.setVisible(true);
			}
		});
		buttoninfromation.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttoninfromation.setBounds(449, 360, 204, 116);
		panelusermain.add(buttoninfromation);
		
		JButton buttonlogout = new JButton("로그아웃");
		buttonlogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.","로그아웃 메세지",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				Logintest lgn = new Logintest();
				lgn.frame.setVisible(true);
			}
		});
		buttonlogout.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		buttonlogout.setBounds(939, 90, 129, 55);
		frame.getContentPane().add(buttonlogout);
		
		JLabel label = new JLabel("메인페이지");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		label.setBounds(0, 0, 1094, 166);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\btnimg.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		label_1.setBounds(0, 0, 1094, 206);
		frame.getContentPane().add(label_1);
	}

}
