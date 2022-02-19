package org.Jspider.Student;
import java.sql.*;
import java.util.Scanner;
public class fetchDataSID_placeHolder
{
	public static void main(String[] args)
	{
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String qry="Select * from btm.student where SID=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Id");
		int SID=sc.nextInt();
		sc.close();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			pstmt=con.prepareStatement(qry);
			//Set the value for place holder before execution//
			pstmt.setInt(1,SID);
			//Execute SQL query//
			rs=pstmt.executeQuery();
			//2nd way for creating implementation object of ResultSet//
			if(rs.next())
			{
				int id=rs.getInt("SID");
				String name=rs.getString(2);
				double per=rs.getDouble(3);
				System.out.print("SID "+id+" SName " +name+" pers="+per);
			}
			else
			{
				System.err.println("No Data found for ID"+SID);
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
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
