package org.Jspider.Student;
import java.sql.*;
public class fetchGetxxx 
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="select * from btm.student";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			rs=pstmt.executeQuery();
			System.out.println("Data fetched");
			if(rs.next())
			{
				int ID=rs.getInt("SID");
				String name=rs.getString(2);
				double pers=rs.getDouble(3);
				System.out.println("SID="+ID+" name="+name+" pers="+pers);
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
