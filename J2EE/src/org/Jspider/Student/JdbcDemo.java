package org.Jspider.Student;
public class JdbcDemo 
{
	public static void main(String[] args) 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class loaded & Registered");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}