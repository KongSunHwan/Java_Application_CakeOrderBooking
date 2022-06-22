package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bestmenu {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bestmenu window = new Bestmenu();
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
	public Bestmenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1300, 900);
		frame.setTitle("케이크 예약 프로그램");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("베스트 상품");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		label.setBounds(0, 0, 1294, 166);
		frame.getContentPane().add(label);
		
		JButton button = new JButton("돌아가기");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Cakereservation serva = new Cakereservation();
				serva.frame.setVisible(true);
			}
		});
		button.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		button.setBounds(33, 64, 129, 55);
		frame.getContentPane().add(button);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\btnimg.png"));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		label_1.setBounds(0, 0, 1294, 206);
		frame.getContentPane().add(label_1);
		
		JPanel panelbest = new JPanel();
		panelbest.setBackground(Color.WHITE);
		panelbest.setBounds(0, 172, 1294, 693);
		frame.getContentPane().add(panelbest);
		panelbest.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\no.1.png"));
		lblNewLabel.setBounds(135, 35, 126, 149);
		panelbest.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\no.2.png"));
		label_2.setBounds(580, 35, 126, 149);
		panelbest.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\no.3.png"));
		label_3.setBounds(1022, 35, 126, 149);
		panelbest.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\발표자료 or 참고자료\\cakeimgjpg.jpg"));
		label_4.setBounds(62, 194, 278, 233);
		panelbest.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\발표자료 or 참고자료\\cakeimgjpg.jpg"));
		label_5.setBounds(505, 194, 278, 233);
		panelbest.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\발표자료 or 참고자료\\cakeimgjpg.jpg"));
		label_6.setBounds(947, 194, 278, 233);
		panelbest.add(label_6);
	}
}
