package com.school.dao;

import com.school.configuration.HelperClass;
import com.school.dto.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	
	HelperClass helperClass=new HelperClass();
	Connection connection=null;
	int i=0;
	//to retrieve data
public void retrieveStudent() {
		connection=helperClass.getConnection();
		
		String sql="SELECT * FROM student";
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
	
	//to update a student data
	public boolean updateStudent(int idt) {
		connection=helperClass.getConnection();
		String sql="UPDATE student SET name ='Kshitija' WHERE idt=?";
		
		//create statement
		
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, idt);
			
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
	
	// to delete a student data
	public boolean  deleteStudent(int idt) {
		connection =helperClass.getConnection();
		String sql ="DELETE FROM student WHERE idt=?";
		
		
		//create statement
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, idt);
			
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
	
	//to save a student data
	public Student saveStudent (Student student) {
connection=helperClass.getConnection();
		String sql="INSERT INTO student VALUES (?,?,?)";
		
		try {
		//create statement
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		//passed the values to delimiters/placeholder--->?
		
		preparedStatement.setInt(1,student.getId());
		preparedStatement.setString(2,student.getName());
		preparedStatement.setString(3,student.getEmail());
		
		//execute statement
		preparedStatement.execute();
		
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
		finally {
			try {
				//close connection
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return student;

	}
}
