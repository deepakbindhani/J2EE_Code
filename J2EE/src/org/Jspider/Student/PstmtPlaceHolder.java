package org.Jspider.Student;
import java.sql.*;
public class PstmtPlaceHolder 
{
	public static void main(String[] args) 
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into btm.student value(?,?,?)";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Class Loaded and Registered:");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Establish sucessfully");
			pstmt=con.prepareStatement(qry);
			System.out.println("Platform Generated");
			pstmt.setInt(1,6);
			pstmt.setString(2,"Deep");
			pstmt.setDouble(3, 66.93);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,7);
			pstmt.setString(2,"Lipu");
			pstmt.setDouble(3, 76.93);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,9);
			pstmt.setString(2,"Depender");
			pstmt.setDouble(3, 88.93);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,10);
			pstmt.setString(2,"Delip");
			pstmt.setDouble(3, 87.93);
			pstmt.executeUpdate();
			
			pstmt.setInt(1,11);
			pstmt.setString(2,"Abhi");
			pstmt.setDouble(3,88.9);
			System.out.println("Data Inserted");
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
		System.out.println("Close all the CostlyResourses");
	}

}
