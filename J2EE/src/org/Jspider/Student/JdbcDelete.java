package org.Jspider.Student;
import java.sql.*;
public class JdbcDelete 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement smnt=null;
		String qry="Delete from btm.student where SID=101";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class Loaded and Registered");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Establish Sucessfull....");
			smnt=con.createStatement();
			System.out.println("Platform Created");
			smnt.executeUpdate(qry);
			System.out.println("Delete Database Sucessfully");
		} 
		catch (ClassNotFoundException|SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(smnt!=null)
			{
				try
				{
					smnt.close();
				}
				catch(SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try 
				{
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("Close all the costly resources");
	}

}
