package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
		private UsersDAO() {
	    };
	    // 2.인스턴스를 직접 생성
	    // 멤버변수 보호를 위해 private 접근제어자 사용
	    // 인스턴스 생성없이 접근가능하도록 static 키워드 사용
	    private static UsersDAO uinstance = new UsersDAO();
	    // 3.생성된 인스턴스를 외부로리턴하는 Getter 정의
	    public static UsersDAO getInstance() {
	        return uinstance;
	    }
	    // 로그인 기능수행을 위한 login()메서드 정의
	    // 리턴 타입 : boolean, 파라미터 : id,pass
	    public boolean login(String id, String pass) {
	        boolean b = false;
	        //System.out.println(id+", "+pass); 
	        // java5 데이터베이스의 users 테이블에 있는 id, pass와 비교하여
	        // 둘다 일치하면 true, 아니면 false 리턴
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	            Class.forName("org.mariadb.jdbc.Driver");
	            String url = "jdbc:mariadb://localhost:3306/cake";
	            String user = "root";
	            String password = "1234";
	            con = DriverManager.getConnection(url, user, password);
	 
	            String sql = "SELECT * FROM users WHERE userid=? AND userpwd=?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id);
	            pstmt.setString(2, pass);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                b = true;
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                rs.close();
	                pstmt.close();
	                con.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return b;
	    }
	    // 로그인 기능수행을 위한 login2()메서드 정의
	    // 리턴 타입 : boolean, 파라미터 : id,pass
	    public boolean login2(String id, String pass) throws LoginUserException {
	        boolean b = false;
	        // System.out.println(id+", "+pass);
	        // java5 데이터베이스의 users 테이블에 있는 id, pass와 비교하여
	        // 둘다 일치하면 true, 아니면 false 리턴
	        Connection con = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        try {
	        	Class.forName("org.mariadb.jdbc.Driver");
	            String url = "jdbc:mariadb://localhost:3306/cake";
	            String user = "root";
	            String password = "1234";
	            con = DriverManager.getConnection(url, user, password);
	 
	            String sql = "SELECT userpwd FROM users WHERE userid=?";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, id);
	            rs = pstmt.executeQuery();
	            if (rs.next()) {
	                if (pass.equals(rs.getString("userpwd"))) {
	                    b = true;
	                } else {// 패스워드가 일치하지 않을 경우 LoginUserException예외를 강제로 발생시키기
	                    throw new LoginUserException("로그인 오류 : 일치하지않는 패스워드");
	                }
	            } 
//	            else {
//	                throw new LoginUserException("로그인 오류 : 존재하지 않는 ID");
//	            }
	 
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (Exception e) {
	                }
	            }
	            if (pstmt != null) {
	                try {
	                    rs.close();
	                } catch (Exception e) {
	                }
	            }
	            if (con != null) {
	                try {
	                    rs.close();
	                } catch (Exception e) {
	                }
	            }
	        }
	        return b;
	    }
}
