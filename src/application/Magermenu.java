package application;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Timer;
import java.awt.event.ActionEvent;

public class Magermenu {

	JFrame frame;
	private JTextField textmenunumber;
	private JTextField textmenuname;
	private JTextField textmenuprice;
	private JTextField textmenudate;
	private JTextField textmenuimg;
	private JTextField []fields=new JTextField[6];
	
	static String[][] mdata= Customer.getMenus();
	static String[] mheaders = new String[] {"메뉴 번호", "메뉴 이름", "가격", "제조일","총 판매수","이미지 파일명"};
	
	String path=null;
	byte[] userimage=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Magermenu window = new Magermenu();
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
	public Magermenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("케이크 예약 프로그램");
		frame.setBounds(100, 100, 1300, 900);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelMagermenu = new JLabel("메뉴 관리");
		labelMagermenu.setBounds(0, 0, 1294, 166);
		labelMagermenu.setHorizontalAlignment(SwingConstants.CENTER);
		labelMagermenu.setForeground(Color.WHITE);
		labelMagermenu.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		frame.getContentPane().add(labelMagermenu);

		UtilDateModel datemodel = new UtilDateModel();
		
		JButton btnBack = new JButton("돌아가기");
		//돌아가기 버튼 누를 시
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Adminmain adm = new Adminmain();
				adm.frame.setVisible(true);
			}
		});
		
		JButton buttonLogout = new JButton("로그아웃");
		//로그아웃 버튼 누를 시
		buttonLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.","로그아웃 메세지",JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);
				Logintest lgn = new Logintest();
				lgn.frame.setVisible(true);
			}
		});
		buttonLogout.setBounds(1102, 82, 129, 55);
		buttonLogout.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		frame.getContentPane().add(buttonLogout);
		btnBack.setBounds(33, 64, 129, 55);
		btnBack.setFont(new Font("함초롬돋움", Font.BOLD, 21));
		frame.getContentPane().add(btnBack);
		
		JLabel labelimg2 = new JLabel("");
		labelimg2.setBounds(0, 0, 1294, 206);
		labelimg2.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\이미지\\btnimg.png"));
		labelimg2.setHorizontalAlignment(SwingConstants.CENTER);
		labelimg2.setFont(new Font("함초롬돋움", Font.BOLD, 40));
		frame.getContentPane().add(labelimg2);

		JPanel menupanel = new JPanel();
		menupanel.setBounds(0, 173, 1294, 698);
		menupanel.setVisible(true);
		menupanel.setLayout(null);
		DefaultTableModel mmodel = new DefaultTableModel(mdata, mheaders)
				{ //테이블에서 수정 못하게 함.
				public boolean isCellEditable(int i, int c) {
					return false;
				}
				};
		JTable mtable = new JTable(mmodel);
		mtable.getColumn("이미지 파일명").setWidth(0);
		mtable.getColumn("이미지 파일명").setMinWidth(0);
		mtable.getColumn("이미지 파일명").setMaxWidth(0);
		mtable.setRowHeight(30);
		mtable.setAlignmentX(0);
		mtable.setSize(1000, 300);
		mtable.setPreferredScrollableViewportSize(new Dimension(1000,300));
		mtable.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(mtable);
		scrollPane.setBounds(146, 5, 1002, 328);
		menupanel.add(scrollPane);
		frame.getContentPane().add(menupanel);
		
		textmenunumber = new JTextField();
		textmenunumber.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenunumber.setColumns(10);
		textmenunumber.setBackground(Color.WHITE);
		textmenunumber.setBounds(231, 343, 232, 29);
		menupanel.add(textmenunumber);
		
		JLabel labelmenunumber = new JLabel("메뉴 번호");
		labelmenunumber.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenunumber.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenunumber.setBounds(156, 343, 73, 29);
		menupanel.add(labelmenunumber);
		
		textmenuname = new JTextField();
		textmenuname.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenuname.setColumns(10);
		textmenuname.setBackground(Color.WHITE);
		textmenuname.setBounds(231, 383, 232, 29);
		menupanel.add(textmenuname);
		
		textmenuprice = new JTextField();
		textmenuprice.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenuprice.setColumns(10);
		textmenuprice.setBounds(231, 422, 232, 29);
		menupanel.add(textmenuprice);
		
		textmenudate = new JTextField();
		textmenudate.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenudate.setColumns(10);
		textmenudate.setBounds(231, 462, 232, 29);
		menupanel.add(textmenudate);
		
		JLabel labelmenudate = new JLabel("제조일");
		labelmenudate.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenudate.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenudate.setBounds(173, 461, 56, 29);
		menupanel.add(labelmenudate);
		
		JLabel labelmenuimg = new JLabel("메뉴 이미지");
		labelmenuimg.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenuimg.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenuimg.setBounds(146, 500, 83, 29);
		menupanel.add(labelmenuimg);
		
		textmenuimg = new JTextField();
		textmenuimg.setFont(new Font("함초롬돋움", Font.PLAIN, 13));
		textmenuimg.setColumns(10);
		textmenuimg.setBounds(231, 502, 173, 29);
		menupanel.add(textmenuimg);
		JButton btnmenuupdate = new JButton("수정");
		btnmenuupdate.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		btnmenuupdate.setBounds(265, 541, 93, 37);
		menupanel.add(btnmenuupdate);
		
		JButton btnmenudel = new JButton("삭제");
		btnmenudel.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		btnmenudel.setBounds(370, 541, 93, 37);
		menupanel.add(btnmenudel);
		
		JLabel labelmenuname = new JLabel("메뉴 이름");
		labelmenuname.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenuname.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenuname.setBounds(156, 382, 73, 29);
		menupanel.add(labelmenuname);
		
		JLabel labelmenuprice = new JLabel("가격");
		labelmenuprice.setHorizontalAlignment(SwingConstants.CENTER);
		labelmenuprice.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		labelmenuprice.setBounds(173, 422, 56, 29);
		menupanel.add(labelmenuprice);
		 
		
		JButton btnmenuimgadd = new JButton("등록");
		btnmenuimgadd.setFont(new Font("함초롬돋움", Font.BOLD, 11));
		btnmenuimgadd.setBounds(407, 501, 56, 30);
		menupanel.add(btnmenuimgadd);
		
		JPanel panelmenuimg = new JPanel();
		panelmenuimg.setBounds(479, 343, 278, 233);
		menupanel.add(panelmenuimg);
		panelmenuimg.setLayout(null);
		
		JLabel lblmenuimg = new JLabel("");
		lblmenuimg.setIcon(new ImageIcon("C:\\Users\\82107\\Desktop\\3학년 1학기\\JAVA 어플리케이션 제작\\발표자료 or 참고자료\\cakeimgjpg.jpg"));
		lblmenuimg.setBounds(0, 0, 278, 233);
		panelmenuimg.add(lblmenuimg);
		JButton btnmenuadd = new JButton("등록");
		btnmenuadd.setFont(new Font("함초롬돋움", Font.BOLD, 13));
		btnmenuadd.setBounds(156, 541, 93, 37);
		menupanel.add(btnmenuadd);
		String menudate = datemodel.getYear() + "-" + (datemodel.getMonth() + 1) + "-" + datemodel.getDay(); //현재 날짜 구하기
		textmenudate.setText(menudate);
		
		//이미지 등록 버튼 누를 시
		btnmenuimgadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser picchooser = new JFileChooser();
			    picchooser.setDialogTitle("Select Image");
			    picchooser.showOpenDialog(null);
			    File pic=picchooser.getSelectedFile();
			    path= pic.getAbsolutePath();
			    textmenuimg.setText(path.replace('\\','/'));
			    System.out.println(path.replace('\\','/'));
			    try{
			        File image = new File(path);
			        FileInputStream fis = new FileInputStream(image);
			        ByteArrayOutputStream baos= new ByteArrayOutputStream();
			        byte[] buff = new byte[1024];
			        for(int readNum; (readNum=fis.read(buff)) !=-1 ; ){
			            baos.write(buff,0,readNum);
			        }
			        userimage=baos.toByteArray();
			    }
			    catch(Exception e1){
			        JOptionPane.showMessageDialog(null, e1);
			    }
			    int i = 1;
//			    Customer.createfile(i, textmenuimg.getText());
			    lblmenuimg.setIcon(new ImageIcon(path));
//			    lblmenuimg.repaint();
			}
		});
				//삭제 버튼 누를 시
				btnmenudel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int row = mtable.getSelectedRow(); // 테이블 행을 넣어줌
						int mi = Integer.parseInt(textmenunumber.getText()); // i에 String형인 textmenunumber을 int로 형변환하여 넣어줌
						if(row == -1) {  //row == -1 일때 리턴
						return;
						}
					Customer.deleteMenu(mi); //Customer에 있는 DAO 딜리트문을 실행 매개변수엔 i를 넣음
					mmodel.removeRow(row); // 모델안에 있는 테이블 행을 하나씩 없애라
					mmodel.fireTableDataChanged(); // 모델안에 있는 테이블을 초기화하여 보여줘라
					mdata= null;
					mdata= Customer.getMenus();
					textmenunumber.setText("");
					textmenuname.setText("");
					textmenuprice.setText("");
					textmenudate.setText("");
					textmenuimg.setText("");
					JOptionPane.showMessageDialog(null,"선택된 메뉴가 삭제되었습니다."); // 메세지 박스 띄움
					frame.dispose(); 
					new Magermenu().main(null);
					}
				});
				//수정 버튼 누를 시
				btnmenuupdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int row = mtable.getSelectedRow(); // 테이블 행을 넣어줌
						int col = mtable.getSelectedColumn(); // 테이블 열을 넣어줌
						
						String numberTxt = textmenunumber.getText();
						String nameTxt = textmenuname.getText();
						String priceTxt = textmenuprice.getText();
						String dateTxt = textmenudate.getText();
						String imgTxt = textmenuimg.getText();
						
						Customer.updateMenu(nameTxt, priceTxt, dateTxt, imgTxt , numberTxt);
						mmodel.fireTableDataChanged(); // 모델안에 있는 테이블을 초기화하여 보여줘라
						mtable.updateUI();
						mdata= null;
						mdata= Customer.getMenus();
						textmenunumber.setText("");
						textmenuname.setText("");
						textmenuprice.setText("");
						textmenudate.setText("");
						textmenuimg.setText("");
						JOptionPane.showMessageDialog(null,"선택된 메뉴가 수정되었습니다."); // 메세지 박스 띄움
						frame.dispose(); 
						new Magermenu().main(null);
					}
				});
				//등록 버튼 클릭 시
				btnmenuadd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						int row = mtable.getSelectedRow(); // 테이블 행을 넣어줌
						int col = mtable.getSelectedColumn(); // 테이블 열을 넣어줌
						
						int mi = Integer.parseInt(textmenunumber.getText());
						String nameTxt = textmenuname.getText();
						String priceTxt = textmenuprice.getText();
						String dateTxt = textmenudate.getText();
						int countTxt = 0;
						String imgTxt = textmenuimg.getText();
						
						if(row < 1) {  //row < 1 일때 리턴
							return;
							}
						Customer.createMenu(mi, nameTxt, priceTxt, dateTxt, countTxt, imgTxt);
						mdata= null;
						mdata= Customer.getMenus();
						String[] mders = new String[] {textmenunumber.getText(), textmenuname.getText(), textmenuprice.getText(), textmenudate.getText(), "0" , textmenuimg.getText()};
						mmodel.insertRow(row, mders); // 모델안에 있는 테이블 행을 하나씩 추가
						mmodel.fireTableDataChanged(); // 모델안에 있는 테이블을 초기화하여 보여줘라
						textmenunumber.setText("");
						textmenuname.setText("");
						textmenuprice.setText("");
						textmenudate.setText("");
						textmenuimg.setText("");
						JOptionPane.showMessageDialog(null,"선택된 회원이 등록되었습니다."); // 메세지 박스 띄움
						frame.dispose(); 
						new Magermenu().main(null);
					}
				});
				//테이블 마우스 클릭 시
				mtable.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent e) {
						TableModel mudata = mtable.getModel();
						int row = mtable.getSelectedRow();
						  int col = mtable.getSelectedColumn();
						  for (int i = 0; i < mtable.getColumnCount(); i++) {
						   System.out.println(mtable.getModel().getValueAt(row, i )+"\t"); 
						  }
						  String menunumber = (String)mudata.getValueAt(row,0);
						  String menuname = (String)mudata.getValueAt(row,1);
						  String menuprice = (String)mudata.getValueAt(row,2);
						  String menudate = (String)mudata.getValueAt(row,3);
						  String menuimage = (String)mudata.getValueAt(row,5);

						  textmenunumber.setText(menunumber);
						  textmenuname.setText(menuname);
						  textmenuprice.setText(menuprice);
						  textmenudate.setText(menudate);
						  textmenuimg.setText(menuimage);
						  
						  lblmenuimg.setIcon(new ImageIcon(menuimage));
						  lblmenuimg.repaint();
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
				//시간 1초 지연
//				try {
//					Thread.sleep(1000);
//				}catch(InterruptedException e) {
//					System.out.println(e.getMessage());
//				}
	}
}
