package org.Jspider.Student;
import java.sql.*;
import java.util.Scanner;
public class FetchData 
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select * from btm.student";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			System.out.println("Data Fetched!!!!!");
			while(rs.next())
			{
				int id=rs.getInt("SID");
				String name=rs.getString(2);
				double per=rs.getDouble(3);
				System.out.println("SID "+id+" SName " +name+" pers="+per);
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(rs!=null)
			{
				try
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e)
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
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("Close all the costly resourses");
	}

}
