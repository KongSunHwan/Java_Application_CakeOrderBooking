package application;

import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Customer {


//	public static void main(String[] args) {
//		getConnection();
//		createUsers("","","","","");
//		ArrayList<String> list = getadmins();
//		for(String item: list) {
//			System.out.println(list);
//		}
//	}
	//어드민 DB에 무엇이 있는지 확인
	public static ArrayList<String> getadmins() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select * FROM admin");
			ResultSet results = statement.executeQuery();
			ArrayList<String> list = new ArrayList<String>();
			while(results.next()) {
				list.add(" 어드민 번호 : " + results.getString("admnumber") 
				+ " 어드민 아이디 : " + results.getString("admid") 
				+ " 어드민 비밀번호 : " + results.getString("admpwd"));
			}
			System.out.println("데이터를 전부 불러왔습니다.");
			return list;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	//유저 테이블에 DB 불러오기
	public static String[][] getUsers() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select * FROM users");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("usernumber"),
						results.getString("userid"),
						results.getString("userpwd"),
						results.getString("userpn"),
						results.getString("username"),
						results.getString("usergender")
				});
			}
			System.out.println("데이터를 전부 불러왔습니다.");
			String[][] arr = new String[list.size()][6];
			return list.toArray(arr);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	//메뉴 테이블에 DB 불러오기
	public static String[][] getMenus() {
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select * FROM menu");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("menunumber"),
						results.getString("menuname"),
						results.getString("menuprice"),
						results.getString("menudate"),
						results.getString("menucount"),
						results.getString("menuimage")
				});
			}
			System.out.println("데이터를 전부 불러왔습니다.");
			String[][] arr = new String[list.size()][6];
			return list.toArray(arr);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	//유저 회원가입 (등록)
	public static void createUsers(String userid, String userpwd, String userpn, String username, String usergender) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
			+ "INSERT INTO users"
			+ "(userid,userpwd,userpn,username,usergender) "
			+ "VALUE "
			+ "('"+userid+"','"+userpwd+"','"+userpn+"','"+username+"','"+usergender+"')");
			insert.executeUpdate();
			System.out.println("회원 데이터가 저장되었습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//유저 항목 삭제
	public static void deleteUsers(int usernumber) {
		try {
			Connection con = getConnection();
			String query = "delete from users where usernumber= ?";
			PreparedStatement delete = con.prepareStatement(query);
			delete.setInt(1, usernumber);
			delete.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	//유저 정보 변경
	public static void updateUsers(String userid, String userpwd, String userpn, String username, String usernumber) {
		try {
			Connection con = getConnection();
			String query = "UPDATE users SET userid=?,userpwd=?,userpn=?,username=? WHERE usernumber= ?";
			PreparedStatement update = con.prepareStatement(query);
			update.setString(1, userid);
			update.setString(2, userpwd);
			update.setString(3, userpn);
			update.setString(4, username);
			update.setString(5, usernumber);
			update.executeUpdate();
			System.out.println("데이터가 수정되었습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	//유저번호 정렬
	public static void numberUsers() {
		try {
			Connection con = getConnection();
			String query1 = "SET @CNT = 0";
			String query2 = "UPDATE USERS SET USERS.usernumber = @CNT:=@CNT+1;";
			String query3 = "ALTER TABLE users AUTO_INCREMENT=1";
			PreparedStatement numupdate = con.prepareStatement(query1);
			PreparedStatement numupdate1 = con.prepareStatement(query2);
			PreparedStatement numupdate2 = con.prepareStatement(query3);
			numupdate.executeUpdate();
			numupdate1.executeUpdate();
			numupdate2.executeUpdate();
			System.out.println("회원번호가 정렬 되었습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	//메뉴번호 초기화
	public static void numberMemus() {
		try {
			Connection con = getConnection();
			String query1 = "SET @CNT = 0";
			String query2 = "UPDATE menu SET menu.menunumber = @CNT:=@CNT+1;";
			String query3 = "ALTER TABLE menu AUTO_INCREMENT=1";
			PreparedStatement numupdate = con.prepareStatement(query1);
			PreparedStatement numupdate1 = con.prepareStatement(query2);
			PreparedStatement numupdate2 = con.prepareStatement(query3);
			numupdate.executeUpdate();
			numupdate1.executeUpdate();
			numupdate2.executeUpdate();
			System.out.println("메뉴번호가 초기화 되었습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	//예약번호 정렬
	public static void numberreservation() {
		try {
			Connection con = getConnection();
			String query1 = "SET @CNT = 0";
			String query2 = "UPDATE reservation SET reservation.resernumber = @CNT:=@CNT+1;";
			String query3 = "ALTER TABLE resernumber AUTO_INCREMENT=1";
			PreparedStatement numupdate = con.prepareStatement(query1);
			PreparedStatement numupdate1 = con.prepareStatement(query2);
			PreparedStatement numupdate2 = con.prepareStatement(query3);
			numupdate.executeUpdate();
			numupdate1.executeUpdate();
			numupdate2.executeUpdate();
			System.out.println("예약번호가 정렬 되었습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	//메뉴항목 등록
	public static void createMenu(int menunumber, String menuname, String menuprice, String menudate, int menucount , String menuimage) {
		try {
			Connection con = getConnection();
			PreparedStatement menuinsert = con.prepareStatement(""
			+ "INSERT INTO menu"
			+ "(menunumber,menuname,menuprice,menudate,menucount,menuimage) "
			+ "VALUE "
			+ "(?,?,?,?,?,?)");
			menuinsert.setInt(1, menunumber);
			menuinsert.setString(2, menuname);
			menuinsert.setString(3, menuprice);
			menuinsert.setString(4, menudate);
			menuinsert.setInt(5, menucount);
			menuinsert.setString(6, menuimage);
			menuinsert.executeUpdate();
			System.out.println("메뉴 데이터가 저장되었습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//메뉴항목 수정
	public static void updateMenu(String menuname, String menuprice, String menudate, String menuimage, String menunumber) {
		try {
			Connection con = getConnection();
			String query = "UPDATE menu SET menuname=?,menuprice=?,menudate=?,menuimage=? WHERE menunumber= ?";
			PreparedStatement update = con.prepareStatement(query);
			update.setString(1, menuname);
			update.setString(2, menuprice);
			update.setString(3, menudate);
			update.setString(4, menuimage);
			update.setString(5, menunumber);
			update.executeUpdate();
			System.out.println("데이터가 수정되었습니다.");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	//메뉴항목 판매수 카운트
		public static void updateMenucount(int menunumber) {
			try {
				Connection con = getConnection();
				String query = "UPDATE menu SET menucount=menucount+1 WHERE menunumber= ?";
				PreparedStatement update = con.prepareStatement(query);
				update.setInt(1, menunumber);
				update.executeUpdate();
				System.out.println("판매수 카운트 +1 되었습니다.");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	    }
	//메뉴항목 삭제
	public static void deleteMenu(int menunumber) {
		try {
			Connection con = getConnection();
			String query = "delete from menu where menunumber=?";
			PreparedStatement delete = con.prepareStatement(query);
			delete.setInt(1, menunumber);
			delete.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
    }
	//DB 커넥션 연결
	public static Connection getConnection() {
		try {
			String driver = "org.mariadb.jdbc.Driver";
			String url = "jdbc:mariadb://localhost:3306/cake";
			String uid = "root";
			String pwd = "1234";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,uid,pwd);
			System.out.println("데이터베이스 연결이 되었습니다.");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	// 회원 아이디 비밀번호 검색, 회원 유무 확인
		public static ArrayList<String> getidCheck(String userid){
			ArrayList<String> list = new ArrayList<String>();
			try {
				Connection con = getConnection();
				String query = "select userid from users where userid = ?";
				PreparedStatement uselect = con.prepareStatement(query);
				uselect.setString(1, userid);
				ResultSet rs = uselect.executeQuery();
				while(rs.next()) {
					list.add(rs.getString("userid"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return list;
		}
		//마이페이지 회원 수정
		public static void mypageupdateUsers(String userpwd, String userpn, String username, String usergender, String userid) {
			try {
				Connection con = getConnection();
				String query = "UPDATE users SET userpwd=?,userpn=?,username=?,usergender=? WHERE userid=?";
				PreparedStatement update = con.prepareStatement(query);
				update.setString(1, userpwd);
				update.setString(2, userpn);
				update.setString(3, username);
				update.setString(4, usergender);
				update.setString(5, userid);
				update.executeUpdate();
				System.out.println("마이페이지 회원 데이터가 수정되었습니다.");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
	    }
		//마이페이지 회원정보 가져오기
		public static UserInfoDTO mypageselectUsers(String userid) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("Select * FROM users WHERE userid=" + "?");
				statement.setString(1, userid);
				ResultSet results = statement.executeQuery();
				
				if(results.next()){
					
					String usernumber = results.getString("usernumber");
					userid = results.getString("userid");
					String userpwd = results.getString("userpwd");
					String userpn = results.getString("userpn");
					String username = results.getString("username");
					String usergender = results.getString("usergender");
					
					System.out.println("유저번호 : " + usernumber);
					System.out.println("ID : " + userid);
					System.out.println("PW : " + userpwd);
					System.out.println("이름 : " + username);
					System.out.println("전화번호 : " + userpn);
					System.out.println("성별 : " + usergender);
					UserInfoDTO userInfo = new UserInfoDTO(usernumber,userid,userpwd,username,userpn,usergender);
					return userInfo;
				}
				System.out.println("마이페이지 회원 데이터를 출력하였습니다.");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
	    }
		//에약정보 테이블에 가져오기
		public static String[][] getReservation(String userid) {
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("Select * FROM reservation WHERE userid=" + "?");
				statement.setString(1, userid);
				ResultSet results = statement.executeQuery();
				ArrayList<String[]> list = new ArrayList<String[]>();
				while(results.next()) {
					list.add(new String[] {
							results.getString("resernumber"),
							results.getString("userid"),
							results.getString("menuname"),
							results.getString("menuprice"),
							results.getString("reserdate")
					});
				}
				System.out.println("데이터를 전부 불러왔습니다.");
				String[][] arr = new String[list.size()][5];
				return list.toArray(arr);
			}catch(Exception e) {
				System.out.println(e.getMessage());
				return null;
			}
		}
		//예약정보 등록
		public static void createReservation(String userid, String menuname, String menuprice, String reserdate) {
			try {
				Connection con = getConnection();
				PreparedStatement menuinsert = con.prepareStatement(""
				+ "INSERT INTO reservation"
				+ "(userid,menuname,menuprice,reserdate) "
				+ "VALUE "
				+ "(?,?,?,?)");
				menuinsert.setString(1, userid);
				menuinsert.setString(2, menuname);
				menuinsert.setString(3, menuprice);
				menuinsert.setString(4, reserdate);
				menuinsert.executeUpdate();
				System.out.println("예약 데이터가 저장되었습니다.");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
				//예약변경 (수정)
				public static void updateReservation(String reserdate, String resernumber) {
					try {
						Connection con = getConnection();
						String query = "UPDATE reservation SET reserdate=? WHERE resernumber=?";
						PreparedStatement update = con.prepareStatement(query);
						update.setString(1, reserdate);
						update.setString(2, resernumber);
						update.executeUpdate();
						System.out.println("마이페이지 회원 데이터가 수정되었습니다.");
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
			    }
				
				//예약취소 (삭제)
				public static void deleteReservation(String resernumber) {
					try {
						Connection con = getConnection();
						String query = "delete from reservation where resernumber=?";
						PreparedStatement delete = con.prepareStatement(query);
						delete.setString(1, resernumber);
						delete.executeUpdate();
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
			    }
}
