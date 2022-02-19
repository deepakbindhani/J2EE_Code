package org.Jspider.Student;
import java.sql.*;
public class PreStmtUpdat
{
	public static void main(String[] args) 
	{
		Connection cn=null;
		PreparedStatement pstm=null;
		String qry="Update btm.student set SID=5 where SID=3";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class loaded & register...");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection establish sucessfully");
			pstm=cn.prepareStatement(qry);
			System.out.println("Platform Generated");
			pstm.executeUpdate();
			System.out.println("Update sucessfully!!!!!!!!!");
		} 
		catch (ClassNotFoundException|SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(pstm!=null)
			{
				try
				{
					pstm.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(cn!=null)
			{
				try {
					cn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("Close all the ostly resources: ");
	}
}
