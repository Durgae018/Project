import java.lang.String.*;
import java.lang.reflect.Field; 
import java.util.*;
import java.sql.*;
public class Product
{

    public static void main(String[] args)
    {
        Scanner in =new Scanner(System.in);
        Admin ad=new Admin();
        ad.addItem();
    }
}
class Admin
{
    Scanner in =new Scanner(System.in);
    Connection con;
    ResultSet rs;
    Statement st;
    int id,a;
    String n;
    Admin()
    {
        try{
            makeConnection();
           rs= st.executeQuery("Select * from status");


        }
		catch(Exception e)
		{
			System.out.println(e);
		}
    }
    public void addItem()
    {
    System.out.println("Eneter");
    this.id=in.nextInt();
    this.a=in.nextInt();
    this.n=in.next();
        try{
            st.executeUpdate("update status set mpay='"+n+"' where id=5");
            rs=st.executeQuery("select * from status");
            System.out.println("s");
        }
		catch(Exception e)
		{
			System.out.println(e);
		}
}
public void makeConnection()
{
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jewel?characterEncoding=utf8","root","");
        st=con.createStatement();
        
    }
    catch(Exception e)
		{
			System.out.println(e);
		}
}
}
        