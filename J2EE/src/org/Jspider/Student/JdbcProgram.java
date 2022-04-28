package org.Jspider.Student;
import java.sql.*;
public class JdbcProgram
{
	public static void main(String[] args) 
	{
		Connection con=null;
		Statement stmt=null;
		String qry="insert into btm.student value(8,'Aditya',89.66)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Class Loaded and Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Establish with Database Server");
			stmt=con.createStatement();
			System.out.println("platform Created");
			stmt.executeUpdate(qry);
			System.out.println("Database Inserted!!!!!!!!!");

		} 
		catch (ClassNotFoundException|SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(stmt!=null)
			{
				try {
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("Close all Costly Resources");
	}
}