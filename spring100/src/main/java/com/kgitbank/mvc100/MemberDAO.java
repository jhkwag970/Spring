package com.kgitbank.mvc100;

import java.sql.*;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	
	Connection con;
	public MemberDAO(){
		try {
			// Model DB ���� 
			//1. Ŀ���� ���� 
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Ŀ���� ���� �Ϸ�");
						
			//2. DB���� (db �ּ�): jdbc: mysql -> server_ip:port -> spring db ����
			String url = "jdbc:mysql://localhost:3309/spring";
			String user = "root";
			String password = "1234";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("2. db ���� �Ϸ�");		
		}catch(Exception e) {
		}
	}
	
	public void insert(MemberDTO dto) {
	
		// �ܺ�, �ܺ� ���� ó���� try catch�� ���� ó���� ���� ���Ѵ�.
		try {
			
			//3. sql�� ����
			String sql = "insert into member values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getTel());
			
			System.out.println("3. SQL�� ��üȭ");
			
			//4. sql�� ����
			ps.executeUpdate();
			System.out.println("4. sql�� ���� �Ϸ�");
		} catch (Exception e) {
		
		}
		
		
	}
	
	public void delete(MemberDTO dto) {
		
		// �ܺ�, �ܺ� ���� ó���� try catch�� ���� ó���� ���� ���Ѵ�.
		try {
			
			//3. sql�� ����
			String sql = "delete from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getId());
			
			System.out.println("3. SQL�� ��üȭ");
			
			//4. sql�� ����
			ps.executeUpdate();
			System.out.println("4. sql�� ���� �Ϸ�");
		} catch (Exception e) {
		
		}
		
	}
	
	public void update(MemberDTO dto) {
		
		// �ܺ�, �ܺ� ���� ó���� try catch�� ���� ó���� ���� ���Ѵ�.
		try {
			
			//3. sql�� ����
			String sql = "update member set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dto.getTel());
			ps.setString(2, dto.getId());
			
			System.out.println("3. SQL�� ��üȭ");
			
			//4. sql�� ����
			ps.executeUpdate();
			System.out.println("4. sql�� ���� �Ϸ�");
		} catch (Exception e) {
		
		}
		
	}
	
	public MemberDTO select(MemberDTO dto) {
		
		// �ܺ�, �ܺ� ���� ó���� try catch�� ���� ó���� ���� ���Ѵ�.
		MemberDTO dto2 = null;
		try {
			
			//3. sql�� ����
			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			
			System.out.println("3. SQL�� ��üȭ");
			
			//4. sql�� ����
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto2 = new MemberDTO();
				dto2.setId(rs.getString(1));
				dto2.setPw(rs.getString(2));
				dto2.setTel(rs.getString(3));
				dto2.setName(rs.getString(4));
			}
			System.out.println("4. sql�� ���� �Ϸ�");
			//5. �˻���� �޾ƿ;� ��: record  �ϳ�
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto2;
	}
	
	public void selectAll(MemberDTO dto) {
		
		// �ܺ�, �ܺ� ���� ó���� try catch�� ���� ó���� ���� ���Ѵ�.
		try {
			
			//3. sql�� ����
			String sql = "select * from member";
			PreparedStatement ps = con.prepareStatement(sql);
			
			System.out.println("3. SQL�� ��üȭ");
			
			//4. sql�� ����
			ps.executeUpdate();
			System.out.println("4. sql�� ���� �Ϸ�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
