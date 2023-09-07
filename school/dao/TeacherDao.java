package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Teacher;

public class TeacherDao {
	HelperClass helperclass=new HelperClass();
	String sql= "INSERT INTO teacher VALUES(?,?,?)";
	int i=0;
	Connection connection=null;
	
	
	//to update the data
	public boolean updateTeacher(int id) {
		connection=helperclass.getConnection();
		String sql="UPDATE teacher SET name ='ABC' WHERE id=?";
		
		//create statement
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			
			//execute statement
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(i>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	
	
	//to retrieve the data
	public void retrieveTeacher() {
		connection=helperclass.getConnection();
		
		String sql="SELECT * FROM teacher";
		try {
		//create statement
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		//execute statement
		ResultSet resultSet= preparedStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getString(3));
			System.out.println("==========================");
		}
		
			//preparedStatement.setInt(1, idt);
			
			// execute statement
			//preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
				
			}
		}
	}
	
	
	//to delete the data
	public boolean  deleteTeacher(int id) {
		connection =helperclass.getConnection();
		String sql ="DELETE FROM teacher WHERE id=?";
		
		
		//create statement
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			//execute statement
			i=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		}if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	//to save the data
	public Teacher saveTeacher(Teacher teacher) {
		//establish connection and load driver
		Connection connection= helperclass.getConnection();
		//establish statement
		try {
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, teacher.getId());
		preparedStatement.setString(2, teacher.getName());
		preparedStatement.setString(3,teacher.getEmail());
		
		//execute statement
		preparedStatement.execute();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return teacher;
		
	}

}
