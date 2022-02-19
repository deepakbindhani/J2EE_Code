package org.Jspider.Student;
import java.sql.*;
public class JdbcUpdate
{
	public static void main(String[] args)
	{
		Connection con=null;
		Statement smnt=null;
		String qry="Update btm.student set SName='Lipu' where SID=1";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class loaded & Register");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Establish with Database server");
			smnt=con.createStatement();
			System.out.println("Platform Created");
			smnt.executeUpdate(qry);
			System.out.println("Database Updated!!!!!!!!!!!!");
		}
		catch (ClassNotFoundException|SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(smnt!=null)
			{
				try {
					smnt.close();
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
		System.out.println("Close all The costly resourcese");
	}
}
