package com.kgitbank.mvc100;

import java.sql.*;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	Connection con;
	public MemberDAO(){
		try {
			// Model DB 구성 
			//1. 커넥터 설정 
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. 커넥터 설정 완료");
						
			//2. DB연결 (db 주소): jdbc: mysql -> server_ip:port -> spring db 연결
			String url = "jdbc:mysql://localhost:3309/spring";
			String user = "root";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db 연결 완료");		
		}catch(Exception e) {
		}
	}
	
	public void insert(MemberDTO dto) {
	
		// 외부, 외부 파일 처리시 try catch로 예외 처리를 실행 ㅎ한다.
		try {
			
			//3. sql문 결정
			String sql = "insert into member values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTel());
			
			System.out.println("3. SQL문 객체화");
			
			//4. sql문 전송
			ps.executeUpdate();
			System.out.println("4. sql문 전송 완료");
		} catch (Exception e) {
		
		}
		
		
	}
	
	public void delete(MemberDTO dto) {
		
		// 외부, 외부 파일 처리시 try catch로 예외 처리를 실행 ㅎ한다.
		try {
			
			//3. sql문 결정
			String sql = "delete from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			
			System.out.println("3. SQL문 객체화");
			
			//4. sql문 전송
			ps.executeUpdate();
			System.out.println("4. sql문 전송 완료");
		} catch (Exception e) {
		
		}
		
	}
	
	public void update(MemberDTO dto) {
		
		// 외부, 외부 파일 처리시 try catch로 예외 처리를 실행 ㅎ한다.
		try {
			
			//3. sql문 결정
			String sql = "update member set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTel());
			ps.setString(2, dto.getId());
			
			System.out.println("3. SQL문 객체화");
			
			//4. sql문 전송
			ps.executeUpdate();
			System.out.println("4. sql문 전송 완료");
		} catch (Exception e) {
		
		}
		
	}
	
	public MemberDTO select(MemberDTO dto) {
		
		// 외부, 외부 파일 처리시 try catch로 예외 처리를 실행 ㅎ한다.
		MemberDTO dto2 = null;
		try {
			
			//3. sql문 결정
			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			
			System.out.println("3. SQL문 객체화");
			
			//4. sql문 전송
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto2 = new MemberDTO();
				dto2.setId(rs.getString(1));
				dto2.setPw(rs.getString(2));
				dto2.setTel(rs.getString(3));
				dto2.setName(rs.getString(4));
			}
			System.out.println("4. sql문 전송 완료");
			//5. 검색결과 받아와야 함: record  하나
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto2;
	}
	
	public void selectAll(MemberDTO dto) {
		
		// 외부, 외부 파일 처리시 try catch로 예외 처리를 실행 ㅎ한다.
		try {
			
			//3. sql문 결정
			String sql = "select * from member";
			PreparedStatement ps = con.prepareStatement(sql);
			
			System.out.println("3. SQL문 객체화");
			
			//4. sql문 전송
			ps.executeUpdate();
			System.out.println("4. sql문 전송 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
