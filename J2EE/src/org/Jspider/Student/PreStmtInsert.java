package org.Jspider.Student;
import java.sql.*;
public class PreStmtInsert
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student value(5,'Manas',88.25)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("classLoaded and register:");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection establish sucessfull");
			pstmt=con.prepareStatement(qry);
			System.out.println("platform Generated");
			pstmt.executeUpdate();
			System.out.println("Data Inserted!!!!!");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				} catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try
				{
					con.close();
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("close all the costly resourses:");
	}

}