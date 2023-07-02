import javax.swing.*;
import javax.swing.BorderFactory.*;
import javax.swing.border.Border;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;
public class Merriment 
{
	JFrame f=new JFrame();
	JLabel head,n,pwd,label,label2,l3;
	JButton login,b1,ad,fp;
	JTextField name;
	JPasswordField p1;
	JPanel p,s;
	Connection con;
	Statement st;
	ResultSet rs;

	
    Merriment()
	{
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
		f.setIconImage(icon);
		f.setVisible(true);
		f.setTitle("LOGIN PAGE");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		construct();
		design();
		handleEvent();
		try{
		makeConnection();
		rs=st.executeQuery("select * from user1");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void construct()
	{
		 p=new JPanel(new GridLayout(9,1));
		 s=new JPanel();
		 head=new JLabel("USER LOGIN");
		 ad=new JButton("ADMIN LOGIN");
		 n=new JLabel("ENTER YOUR NAME");
		 name=new JTextField();
		 pwd=new JLabel("ENTER YOUR PASSWORD");
		 p1=new JPasswordField(15);
		 login=new JButton("LOGIN");
		 b1=new JButton("NEW USER");
		 fp=new JButton("Forget password?");
		 ImageIcon icon = new ImageIcon("h2.jpg");
		
        label = new JLabel(icon);
		
	}
	public void design()
	{
	b1.setBackground(Color.PINK);
	fp.setBackground(Color.PINK);
	login.setBackground(new Color(120, 144, 250));
	ad.setBackground(new Color(120, 144, 250));
	head.setFont(new Font("Times New Roman",3,40));
	head.setForeground(new Color(120, 144, 250));
	n.setFont(new Font("Palatino Linotype", 3, 20)); 
	pwd.setFont(new Font("Palatino Linotype", 3, 20));
    fp.setFont(new Font("Microsoft JhengHei Light", 1, 18));
	login.setFont(new Font("Microsoft JhengHei Light", 1, 18));
	b1.setFont(new Font("Microsoft JhengHei Light", 1, 18));
	ad.setFont(new Font("Microsoft JhengHei Light", 1, 18));
		
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.add(head,BorderLayout.CENTER);
		p.add(b1,BorderLayout.WEST);
		p.add(ad);
		p.add(n);
		p.add(name);
		p.add(pwd);
		p.add(p1);
		p.add(login);
		p.add(fp);
		label.setLayout(new FlowLayout());
		label.add(p,BorderLayout.CENTER);
		f.add(label);
		
		
		
	}
		
	public void handleEvent()
	{

	
    login.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          
          String puname = name.getText().trim();
          String ppaswd = p1.getText();
		 
		 while(rs.next())
		 {
		  String usename = rs.getString(1).trim();
          String usepwd = rs.getString(2);
		  

         if(puname.equals(usename) && ppaswd.equals(usepwd))
		 {
			  new Quizzes();
            f.dispose();
          } 
          else if(puname.equals("") && ppaswd.equals(""))
		  {
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
 
		 }
		}
         catch (Exception d) {
          d.printStackTrace();
        }
	  }
	  
     });

	
	login.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			login.setCursor(new Cursor(Cursor.HAND_CURSOR));
			login.setBackground(Color.PINK);
		}
		public void mouseExited(MouseEvent me){
			login.setBackground(new Color(120, 144, 250));
			login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	ad.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			ad.setCursor(new Cursor(Cursor.HAND_CURSOR));
			ad.setBackground(Color.PINK);
		}
		public void mouseExited(MouseEvent me){
			ad.setBackground(new Color(120, 144, 250));
			ad.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	b1.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b1.setBackground(new Color(120, 144, 250));
		}
		public void mouseExited(MouseEvent me){
			b1.setBackground(Color.PINK);
			b1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	fp.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			fp.setCursor(new Cursor(Cursor.HAND_CURSOR));
			fp.setBackground(new Color(120, 144, 250));
		}
		public void mouseExited(MouseEvent me){
			fp.setBackground(Color.PINK);
			fp.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});

	b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new NewUser();
			}
	});
	fp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new Reset();
			}
	});
	ad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new AdminLogin();
			}
	});
}
	

    public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}


	public static void main(String[] args)
	{
	new Merriment();
    }
}
class Reset{
	private JFrame f = new JFrame("RESET PASSWORD");
	JTextField n,pass;
	JLabel l1,l2,label;
	JPanel p;
	JButton b,r;
	Connection con;
	Statement st;
	ResultSet rs;
	int count=0;
	
	public Reset() {
	
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
		f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		try{
		makeConnection();
		rs=st.executeQuery("select * from user1");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		l1=new JLabel("ENTER THE USER NAME:");
		l2=new JLabel("ENTER THE NEW PASSWORD:");
		pass=new JTextField(15);
		n=new JTextField(15);
		b=new JButton("BACK");	
		r=new JButton("RESET PASSWORD");
		p=new JPanel(new GridLayout(3,2));
		ImageIcon i = new ImageIcon("back.jpg");
		label = new JLabel(i);
		
		
		l1.setFont(new Font("Palatino Linotype", 3, 20)); 
	    l2.setFont(new Font("Palatino Linotype", 3, 20));
	    b.setFont(new Font("Microsoft JhengHei Light", 1, 18));
	    r.setFont(new Font("Microsoft JhengHei Light", 1, 18));
		b.setBackground(new Color(120, 144, 250));
		r.setBackground(new Color(120, 144, 250));
		
		p.add(l1);
		p.add(n);
		p.add(l2);
		p.add(pass);
		p.add(b);
		p.add(r);
		label.setLayout(new FlowLayout());
		label.add(p,BorderLayout.CENTER);
		f.add(label);
		
		
		r.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        try {
          
          String puname = n.getText(); 
		 while(rs.next())
		 {
		  String usename = rs.getString(1);
         if(puname.equals(usename))
		 {
			 if(count==0)
			 {
			st.executeUpdate("update user1 set pwd='"+pass.getText()+"' where name='"+n.getText()+"'");
			rs=st.executeQuery("select * from user1");
			JOptionPane.showMessageDialog(null,"Password reset successfull!!!");
            new Merriment();
            f.dispose();
			count++;
			}
          } 
          else if(puname.equals(""))
		  {
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
		 }
		 }
         catch (Exception d) {
          d.printStackTrace();
        }
	  }
	  
     });
	 b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new Merriment();
			}
	});
		
	}
    public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}	
		
	
    
}
	
class AdminLogin
{
	JFrame f=new JFrame();
	JLabel n,pwd,label;
	JButton login,b1;
	JTextField name;
	JPasswordField p1;
	JPanel p;
	Connection con;
	Statement st;
	ResultSet rs;
	
    AdminLogin()
	{
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
		f.setIconImage(icon);
		f.setVisible(true);
		f.setTitle("ADMIN LOGIN");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		construct();
		design();
		handleEvent();
		try{
		makeConnection();
		rs=st.executeQuery("select * from admin");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void construct()
	{
		 p=new JPanel(new GridLayout(3,2));
		 n=new JLabel("ENTER YOUR NAME");
		 name=new JTextField(15);
		 pwd=new JLabel("ENTER YOUR PASSWORD");
		 p1=new JPasswordField(15);
		 login=new JButton("LOGIN");
		 b1=new JButton("BACK");
		 ImageIcon icon = new ImageIcon("back.jpg");
		 label = new JLabel(icon);
		 
		
	}
	public void design()
	{
		
	login.setBackground(new Color(120, 144, 250));
	b1.setBackground(new Color(120, 144, 250));
	n.setFont(new Font("Palatino Linotype", 3, 20)); 
	pwd.setFont(new Font("Palatino Linotype", 3, 20));
	login.setFont(new Font("Microsoft JhengHei Light", 1, 18));
	b1.setFont(new Font("Microsoft JhengHei Light", 1, 18));
	
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		p.add(n);
		p.add(name);
		p.add(pwd);
		p.add(p1);
		p.add(b1);
		p.add(login);
		label.setLayout(new FlowLayout());
		label.add(p,BorderLayout.CENTER);
		f.add(label);
		
		
	}
	public void handleEvent()
	{
    
    login.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          
          String puname = name.getText();
          String ppaswd = p1.getText();
		 
		 while(rs.next())
		 {
		  String usename = rs.getString(1);
          String usepwd = rs.getString(2);
		  


         if(puname.equals(usename) && ppaswd.equals(usepwd))
		 {
            new UserDetails();
            f.dispose();
          } 
          else if(puname.equals("") && ppaswd.equals(""))
		  {
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
		 }
		 }
         catch (Exception d) {
			 
          d.printStackTrace();
        }
	  }
	  
     });
	
	login.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			login.setCursor(new Cursor(Cursor.HAND_CURSOR));
			login.setBackground(Color.PINK);
		}
		public void mouseExited(MouseEvent me){
			login.setBackground(new Color(120, 144, 250));
			login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	b1.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b1.setBackground(Color.PINK);
		}
		public void mouseExited(MouseEvent me){
			b1.setBackground(new Color(120, 144, 250));
			b1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});

	b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new Merriment();
			}
	});
}
    public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

class  UserDetails{
	private JFrame f = new JFrame("USER DETAILS");
	JPanel p1,p2,p3,p4,p5;
	JLabel u,n,m,rid,iq,neet,jee,rid2,neet2,jee2,iq2,label;
	JButton next,prev,b;
	JTextField t1p3;
	Connection con;
	Statement st;
	ResultSet rs;
	
	public UserDetails() {
		try{
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		makeConnection();
		rs=st.executeQuery("select * from user1");
		rs.first();
		n.setText(rs.getString(1));
		rid2.setText(rs.getString(3));
		iq2.setText(rs.getString(4));
		neet2.setText(rs.getString(5));
		jee2.setText(rs.getString(6));
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		
				
		p1=new JPanel(new GridLayout(1,3));
		p2=new JPanel(new GridLayout(1,3));
		p3=new JPanel(new GridLayout(4,2));
		p4=new JPanel(new GridLayout(1,3));
		p5=new JPanel(new GridLayout(4,1));
		u=new JLabel("USERNAME:");
		m=new JLabel("DETAILS:");
		rid=new JLabel("DATE OF BIRTH:");
		iq=new JLabel("PHONE NUMBER:");
		neet=new JLabel("PLACE:");
		jee=new JLabel("MAIL ID:");
		rid2=new JLabel();
		n=new JLabel();
		iq2=new JLabel();
		neet2=new JLabel();
		jee2=new JLabel();
		b=new JButton("BACK");
		prev=new JButton("PREVIOUS");
		next=new JButton("NEXT");
		ImageIcon i = new ImageIcon("back.jpg");
		label = new JLabel(i);
		
		u.setFont(new Font("Yu Gothic UI Semibold", 3, 20)); 
		m.setFont(new Font("Yu Gothic UI Semibold", 3, 20)); 
		rid.setFont(new Font("Yu Gothic UI Semibold", 3, 20)); 
		iq.setFont(new Font("Yu Gothic UI Semibold", 3, 20)); 
		neet.setFont(new Font("Yu Gothic UI Semibold", 3, 20)); 
		jee.setFont(new Font("Yu Gothic UI Semibold", 3, 18)); 
		n.setFont(new Font("Microsoft JhengHei Light", 1, 18));
		rid2.setFont(new Font("Microsoft JhengHei Light", 1, 18));
		iq2.setFont(new Font("Microsoft JhengHei Light", 1, 18));
		neet2.setFont(new Font("Microsoft JhengHei Light", 1, 18));
		jee2.setFont(new Font("Microsoft JhengHei Light", 1, 18));
		b.setFont(new Font("Palatino Linotype", 1, 20)); 
		prev.setFont(new Font("Palatino Linotype", 1, 20));
		next.setFont(new Font("Palatino Linotype", 1, 20));
		p1.setBackground(new Color(120, 144, 250));
		p2.setBackground(new Color(120, 144, 250));
		p3.setBackground(new Color(120, 144, 250));
		p4.setBackground(new Color(120, 144, 250));
		p5.setBackground(new Color(120, 144, 250));
		prev.setBackground(Color.PINK);
		next.setBackground(Color.PINK);
		b.setBackground(Color.PINK);

		
		p1.add(u);
		p1.add(n);
		p2.add(m);
		p3.add(rid);
		p3.add(rid2);
		p3.add(iq);
		p3.add(iq2);
		p3.add(neet);
		p3.add(neet2);
		p3.add(jee);
		p3.add(jee2);
		p4.add(prev);
		p4.add(b);
		p4.add(next);
		p5.add(p1);
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		label.setLayout(new FlowLayout());
		label.add(p5);
		f.add(label);
		
		
		
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.next())
					{
						n.setText(rs.getString(1));
						rid2.setText(rs.getString(3));
						iq2.setText(rs.getString(4));
						neet2.setText(rs.getString(5));
						jee2.setText(rs.getString(6));
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"This is Last");
					 rs.last();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		prev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.previous())
					{
						n.setText(rs.getString(1));
						rid2.setText(rs.getString(3));
						iq2.setText(rs.getString(4));
						neet2.setText(rs.getString(5));
						jee2.setText(rs.getString(6));
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"This is first");
					 rs.first();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new Merriment();
			}
	});
	b.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			b.setCursor(new Cursor(Cursor.HAND_CURSOR));
			b.setBackground(new Color(255,153,255));
		}
		public void mouseExited(MouseEvent me){
			b.setBackground(Color.PINK);
			b.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	next.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			next.setCursor(new Cursor(Cursor.HAND_CURSOR));
			next.setBackground(new Color(255,153,255));
		}
		public void mouseExited(MouseEvent me){
			next.setBackground(Color.PINK);
			next.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	prev.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			prev.setCursor(new Cursor(Cursor.HAND_CURSOR));
			prev.setBackground(new Color(255,153,255));
		}
		public void mouseExited(MouseEvent me){
			prev.setBackground(Color.PINK);
			prev.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
}
	public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		

}
	
class NewUser extends JFrame {
  JButton create,s1;
  JPanel newUserPanel;
  JTextField txuserer,dob,edu,phno,place;
  JTextField passer;
  JLabel l10,l11,l12,l13,l14,l15,l16,label;
  JComboBox g;
  Connection con;
	Statement st;
	ResultSet rs;



  public NewUser()
  {
    try{
   
		

    Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	setIconImage(icon);
	setSize(600,300);
	setLocation(500,128);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
	setTitle("REGISTRATION FORM");
	
	makeConnection();
	construct();
	design();
	events();
	}
	catch(Exception e)
		{
			System.out.println(e);
		}	
  }
	public void construct()
	{
    create = new JButton("Register");
    newUserPanel = new JPanel(new GridLayout(8,2));
	l10=new JLabel("USER NAME");
	l11=new JLabel("PASSWORD");
	l12=new JLabel("DATE OF BIRTH");
	l13=new JLabel("GENDER");
	l14=new JLabel("MAIL ID");
	l15=new JLabel("PHONE NUMBER");
	l16=new JLabel("CITY/TOWN");
	s1=new JButton("BACK");
	g=new JComboBox();
    txuserer = new JTextField(15);
	dob = new JTextField("DD-MM-YYYY",15);
	edu = new JTextField(15);
    passer = new JPasswordField(15);
	phno = new JTextField(15);
	place = new JTextField(15);
	ImageIcon pic = new ImageIcon("new-user.jpg");
	label = new JLabel(pic);
	}

	public void design()
	{
	l10.setFont(new Font("casteller",Font.BOLD,15));
	l11.setFont(new Font("casteller",Font.BOLD,15));
	l12.setFont(new Font("casteller",Font.BOLD,15));
	l13.setFont(new Font("casteller",Font.BOLD,15));
	l14.setFont(new Font("casteller",Font.BOLD,15));
	l15.setFont(new Font("casteller",Font.BOLD,15));
	l16.setFont(new Font("casteller",Font.BOLD,15));
    newUserPanel.setBounds(70,30,50,20);
    newUserPanel.setBackground(new Color(120, 144, 250));
	s1.setBackground(Color.PINK);
	create.setBackground(Color.PINK);
   
    setLayout(new FlowLayout(FlowLayout.CENTER));
    add(label);
	newUserPanel.add(l10);
    newUserPanel.add(txuserer);
	newUserPanel.add(l11);
    newUserPanel.add(passer);
	newUserPanel.add(l12);
	newUserPanel.add(dob);
	newUserPanel.add(l13);
	g.addItem("Enter here");
	g.addItem("Male");
	g.addItem("Female");
	g.addItem("Other");
	newUserPanel.add(g);
	newUserPanel.add(l15);
	newUserPanel.add(phno);
	newUserPanel.add(l16);
	newUserPanel.add(place);
	newUserPanel.add(l14);
	newUserPanel.add(edu);
	newUserPanel.add(s1);
	newUserPanel.add(create);
    add(newUserPanel);
	}
	public void events()
	{
	
	    create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					rs=st.executeQuery("select * from user1");
					int count=0;
					int check=0;
					String s1,s2,s3,s4,s5;
					s1=passer.getText();
					s2=txuserer.getText();
					s3=dob.getText();
					s4=place.getText();
					s5=edu.getText();	
					String mobile=phno.getText();
					char[] ch = new char[s5.length()];
					for (int i = 0; i < s5.length(); i++)
					{
					ch[i] = s5.charAt(i);
					}
					if(s1.length()==0 || s2.length()==0 || s3.length()==0 || s4.length()==0 || s5.length()==0)
					{
						count++;
					JOptionPane.showMessageDialog(null,"Fill the necessary deatils","Error",JOptionPane.ERROR_MESSAGE);	
					}					
					else if(s1.length()<8)
					{
					count++;
					JOptionPane.showMessageDialog(null,"Password should have atleast 8 characters","Error",JOptionPane.ERROR_MESSAGE);	
					passer.setText("");
					}
					else if(s3.length()!=10)
					{
						count++;
					JOptionPane.showMessageDialog(null,"Date of birth is invalid","Error",JOptionPane.ERROR_MESSAGE);	
					dob.setText("");
					}
					
					 while(rs.next())
		            {
		             String usename = rs.getString(1);
                      String usepwd = rs.getString(2);
					if(s2.equals(usename))
					{
						count++;
						JOptionPane.showMessageDialog(null,"Username already exist","Error",JOptionPane.ERROR_MESSAGE);
						txuserer.setText("");
					} 
					if(s1.equals(usepwd))
					{
						count++;
						JOptionPane.showMessageDialog(null,"Password already in use","Error",JOptionPane.ERROR_MESSAGE);
						passer.setText("");
					}
					}
					for (int i = 0; i < s5.length(); i++)
					{
						if(ch[i]=='@')
						{
							check=1;
						}
					}
					if(mobile.matches("^[0-9]+$")&&mobile.length()==10)
					{
						
					}
					else
					{    count++;
						JOptionPane.showMessageDialog(null,"Please enter a valid mobile number ","Error",JOptionPane.ERROR_MESSAGE);
						phno.setText("");
					}

					if(check!=1)
					{
						count++;
						JOptionPane.showMessageDialog(null,"Mail is invalid","Error",JOptionPane.ERROR_MESSAGE);
						edu.setText("");
					}
					
					if(count==0)
					{
					st.executeUpdate("insert into user1 values('"+txuserer.getText()+"','"+passer.getText()+"','"+dob.getText()+"','"+phno.getText()+"','"+place.getText()+"','"+edu.getText()+"')");
					rs=st.executeQuery("select * from user1");
					JOptionPane.showMessageDialog(null,"Account has been created.");
					dispose();
					new Merriment();
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		create.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			create.setCursor(new Cursor(Cursor.HAND_CURSOR));
			create.setBackground(new Color(30,250,140));
		}
		public void mouseExited(MouseEvent me){
			create.setBackground(Color.PINK);
			create.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
		s1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
				new Merriment();
			}
		});
		s1.addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent me){
			s1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			s1.setBackground(new Color(30,250,140));
		}
		public void mouseExited(MouseEvent me){
			s1.setBackground(Color.PINK);
			s1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
  }
  public void makeConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
 
class Quizzes
{
	private JFrame f = new JFrame("UNLIMITED QUZZIES");
	JButton q1,q2,ex,quit;
	JLabel l8,l9,label;
	JPanel p3,p4;
	
	public Quizzes() {
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		Image ic = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(ic);
		asign();
		events();
	}
	public void asign()
	{
		
		
		quit=new JButton("QUIT");
		ex=new JButton("LOGOUT");
		ImageIcon icon = new ImageIcon("fun quiz dog.jpg");
		ImageIcon i = new ImageIcon("educ quiz.jpg");
		q1=new JButton(icon);
		q2=new JButton(i);
		Border border = BorderFactory.createLineBorder(Color.PINK, 20);
		p3=new JPanel(new GridLayout(2,6));
		ImageIcon back = new ImageIcon("back.jpg");
		label = new JLabel(back);
		
		ex.setBackground(new Color(120, 144, 250));
		q1.setBackground(new Color(120, 144, 250));
		quit.setBackground(new Color(120, 144, 250));
		q2.setBackground(new Color(120, 144, 250));
		p3.setBackground(new Color(120, 144, 250));
		quit.setFont(new Font("Palatino Linotype", 1, 30));
		ex.setFont(new Font("Palatino Linotype", 1, 30));
		p3.setBorder(border);
		
		
		p3.add(q1);
		p3.add(q2);
		p3.add(quit);
		p3.add(ex);
		label.setLayout(new FlowLayout());
		label.add(p3,BorderLayout.CENTER);
		f.add(label);
		

	}
	public void events()
	{
		
		q1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
			    new Funquiz();
			}
	});
		q1.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				q1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
	});
	q2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
			    new Eduquiz();
			}
	});
	q2.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				q2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
	
	
	});
	quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showMessageDialog(null,"Click here to close the app");
				f.dispose();
			}
	});
	quit.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				quit.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
	
	
	});
	ex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
			    new Merriment();
			}
	});
	ex.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				ex.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
	});
	}
		
		
}
class Funquiz extends JFrame {
	JButton rid,iq,logout,back;
	JLabel label;
	JLabel l15,l16;
	JPanel p;

	
	
	public Funquiz() {
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		setSize(d.width,d.height);
		setVisible(true);
		setResizable(true);
		setTitle("FUN QUIZZES");
		setLayout(null);
		construct();
		design();
		events();
	}
		public void construct()
		{
		ImageIcon w = new ImageIcon("ridd.jpg");
		ImageIcon i = new ImageIcon("iq.jpg");
		l15=new JLabel(w);
		l16=new JLabel(i);
		rid =new JButton("RIDDLE");
	    iq=new JButton("IQ TEST");
		logout=new JButton("LOGOUT");
	    back=new JButton("BACK");
		
		}
		public void design()
		{
		rid.setBackground(Color.PINK);
		rid.setFont(new Font("Mongolian Baiti",1, 20));
		iq.setBackground(Color.PINK);
		iq.setFont(new Font("Mongolian Baiti",1, 20));
		logout.setFont(new Font("Mongolian Baiti",1, 20));
		back.setFont(new Font("Mongolian Baiti",1, 20));
		logout.setBackground(new Color(120,144,250));
		back.setBackground(new Color(120,144,250));
		
		
		l15.setBounds(200,30,450,600);
		l16.setBounds(750,30,450,600);
		rid.setBounds(200,500,450,70);
		iq.setBounds(750,500,450,70);
		back.setBounds(200,600,450,70);
		logout.setBounds(750,600,450,70);

		getContentPane().add(l15,BorderLayout.CENTER);
		getContentPane().add(l16,BorderLayout.CENTER);
		getContentPane().add(rid,BorderLayout.CENTER);
		getContentPane().add(iq,BorderLayout.CENTER);
		getContentPane().add(back,BorderLayout.CENTER);
		getContentPane().add(logout,BorderLayout.CENTER);
		
		}

	public void events()
	{
	rid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				new Riddle();
			}
	});
	rid.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				rid.setCursor(new Cursor(Cursor.HAND_CURSOR));
				rid.setBackground(new Color(250,120,144));
			}
	
			public void mouseExited(MouseEvent me){
				rid.setBackground(Color.PINK);
				rid.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	iq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				new IQApp();
			}
	});
	iq.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				iq.setCursor(new Cursor(Cursor.HAND_CURSOR));
				iq.setBackground(new Color(250,120,144));
			}
	
			public void mouseExited(MouseEvent me){
				iq.setBackground(Color.PINK);
				iq.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			    new Merriment();
			}
	});
	logout.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
				logout.setBackground(new Color(30,250,140));
			}
	
			public void mouseExited(MouseEvent me){
				logout.setBackground(new Color(120,144,250));
				logout.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				new Quizzes();
			}
	});
	back.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				back.setCursor(new Cursor(Cursor.HAND_CURSOR));
				back.setBackground(new Color(30,250,140));
			}
	
			public void mouseExited(MouseEvent me){
				back.setBackground(new Color(120,144,250));
				back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
		}
}
class Eduquiz extends JFrame{
	JButton rid,iq,logout,back;
	JLabel l15,l16;
	JPanel p5;
	
	public Eduquiz() {
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    setIconImage(icon);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		setSize(d.width,d.height);
		setVisible(true);
		setTitle("EDUCATION QUIZ");
		setLayout(null);
		construct();
		design();
		events();
	}
		public void construct()
		{
		ImageIcon w = new ImageIcon("neet.jpg");
		ImageIcon i = new ImageIcon("jee.jpg");
		l15=new JLabel(w);
		l16=new JLabel(i);
		rid =new JButton("NEET");
	    iq=new JButton("JEE");
		logout=new JButton("LOGOUT");
	    back=new JButton("BACK");
		}
		public void design()
		{
		rid.setBackground(Color.PINK);
		rid.setFont(new Font("Mongolian Baiti",1, 20));
		iq.setBackground(Color.PINK);
		iq.setFont(new Font("Mongolian Baiti",1, 20));
		logout.setFont(new Font("Mongolian Baiti",1, 20));
		back.setFont(new Font("Mongolian Baiti",1, 20));
		logout.setBackground(new Color(120,144,250));
		back.setBackground(new Color(120,144,250));
		
		
		l15.setBounds(200,30,450,600);
		l16.setBounds(750,30,450,600);
		rid.setBounds(200,500,450,70);
		iq.setBounds(750,500,450,70);
		back.setBounds(200,600,450,70);
		logout.setBounds(750,600,450,70);

			
		
		getContentPane().add(l15,BorderLayout.CENTER);
		getContentPane().add(l16,BorderLayout.CENTER);
		getContentPane().add(rid,BorderLayout.CENTER);
		getContentPane().add(iq,BorderLayout.CENTER);
		getContentPane().add(back,BorderLayout.CENTER);
		getContentPane().add(logout,BorderLayout.CENTER);
		}
		public void events()
		{
		rid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				new Neet();
			}
	});
	rid.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				rid.setCursor(new Cursor(Cursor.HAND_CURSOR));
				rid.setBackground(new Color(250,120,144));
			}
	
			public void mouseExited(MouseEvent me){
				rid.setBackground(Color.PINK);
				rid.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
	iq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				new Jee();
			}
	});
	iq.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				iq.setCursor(new Cursor(Cursor.HAND_CURSOR));
				iq.setBackground(new Color(250,120,144));
			}
	
			public void mouseExited(MouseEvent me){
				iq.setBackground(Color.PINK);
				iq.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			    new Merriment();
			}
	});
	logout.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
				logout.setBackground(new Color(30,250,140));
			}
	
			public void mouseExited(MouseEvent me){
				logout.setBackground(new Color(120,144,250));
				logout.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
				new Quizzes();
			}
	});
	back.addMouseListener(new MouseAdapter(){
			public void mouseEntered(MouseEvent me){
				back.setCursor(new Cursor(Cursor.HAND_CURSOR));
				back.setBackground(new Color(30,250,140));
			}
	
			public void mouseExited(MouseEvent me){
				back.setBackground(new Color(120,144,250));
				back.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
	});
		
	}
}

class Riddle extends Merriment
 {
	
	private JFrame f = new JFrame("RIDDLE");
	JPanel p6,p5,p4,p7;
	JButton n,p,sub;
	JLabel l18,l19,tf,label;
	JRadioButton a,b,c,e;
	Connection con;
	Statement st;
	ResultSet rs;
	 ButtonGroup group;
	
	int count=0;
	int sec=300;
	
	
	public Riddle() {
		
		
		 
		ArrayList<String> list=new ArrayList<String>();
		
		list.add("B)Money");
		list.add("D)Map");
		list.add("C)Letter g");
		list.add("C)Coin");
		list.add("A)cards");
		list.add("D)Tongue");
		list.add("B)Seven");
		list.add("C)Two");
		list.add("D)Envelope");
		list.add("A)Short");
		try{
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		
		p6=new JPanel(new GridLayout(3,1));
		p5=new JPanel();
		p7=new JPanel(new GridLayout(1,3));
		p4=new JPanel(new GridLayout(4,1));
		a=new JRadioButton();
		b=new JRadioButton();
		c=new JRadioButton();
		e=new JRadioButton();
		group = new ButtonGroup();
		n=new JButton("NEXT");
		p=new JButton("PREVIOUS");
		sub=new JButton("SUMBIT");
		l18=new JLabel();
		l19=new JLabel();
		tf=new JLabel();
		ImageIcon back = new ImageIcon("back.jpg");
		label = new JLabel(back);
		Border border = BorderFactory.createLineBorder(new Color(200,30,250), 10);
		
		tf.setBorder(border);
		tf.setForeground(new Color(200,30,250));
		tf.setFont(new Font("Times New Roman",Font.ITALIC,30));
		l18.setFont(new Font("Times New Roman",Font.ITALIC,15));
		l19.setFont(new Font("Times New Roman",Font.ITALIC,15));
		a.setFont(new Font("Times New Roman",Font.ITALIC,15));
		b.setFont(new Font("Times New Roman",Font.ITALIC,15));
		c.setFont(new Font("Times New Roman",Font.ITALIC,15));
		e.setFont(new Font("Times New Roman",Font.ITALIC,15));
		n.setBackground(new Color(120,144,250));
		p.setBackground(new Color(120,144,250));
		sub.setBackground(new Color(120,144,250));
		n.setFont(new Font("Mongolian Baiti",1, 20));
		p.setFont(new Font("Mongolian Baiti",1, 20));
		sub.setFont(new Font("Mongolian Baiti",1, 20));		
		
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		group.add(a);
		group.add(b);
		group.add(c);
		group.add(e);
		p5.add(l18);
		p5.add(l19);
		p6.add(p5);
		p4.add(a);
		p4.add(b);
		p4.add(c);
		p4.add(e);
		p6.add(p4);
		p6.add(p);
		p6.add(n);
		p6.add(tf);
		p6.add(sub);
		label.setLayout(new FlowLayout());
		label.add(p6,BorderLayout.CENTER);
		f.add(label);
		
		makeConnection();
		rs=st.executeQuery("select * from Riddle");
		rs.first();
		l18.setText(rs.getString(1));
		l19.setText(rs.getString(2));
		a.setText(rs.getString(3));
		b.setText(rs.getString(4));
		c.setText(rs.getString(5));
		e.setText(rs.getString(6));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		Timer t = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			sec--;
			tf.setText("Still seconds  "+sec+"s  more");
        }
        });
        t.setRepeats(true);
        t.start();
		if(sub.isSelected())
		{
			sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null,"Result:"+count+"/10....Click here to view answers");
				f.dispose();
				new Answer1();
				
			}
		});
		}
		else
		{	
		Timer timer = new Timer(300000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Time Up!!!Result:"+count+"/10");
            f.setVisible(false);
            f.dispose();
			new Answer1();
            
        }
        });
        timer.setRepeats(false);
        timer.start();
		}
		
		a.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(a.isSelected())
				{
					if(list.contains(a.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					c.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		b.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(b.isSelected())
				{
					if(list.contains(b.getText()))
					{
						count++;
					}
					a.setEnabled(false);
					c.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		c.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(c.isSelected())
				{
					if(list.contains(c.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					a.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		e.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(e.isSelected())
				{
					if(list.contains(e.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					c.setEnabled(false);
					a.setEnabled(false);
				}
			}
		});
		
		n.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.next())
					{
						l18.setText(rs.getString(1));
						l19.setText(rs.getString(2));
						a.setText(rs.getString(3));
						b.setText(rs.getString(4));
						c.setText(rs.getString(5));
						e.setText(rs.getString(6));
						b.setEnabled(true);
					    c.setEnabled(true);
					    a.setEnabled(true);
						e.setEnabled(true);
						group.clearSelection();
						
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"Click the sumbit button");
					 rs.last();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		p.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.previous())
					{
					    l18.setText(rs.getString(1));
						l19.setText(rs.getString(2));
						a.setText(rs.getString(3));
						b.setText(rs.getString(4));
						c.setText(rs.getString(5));
						e.setText(rs.getString(6));	
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"This is the first question");
					 rs.first();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null,"Result:"+count+"/10...Click here to view answers");
				f.dispose();
				new Answer1();
				
			}
		});
		
	}		
	
		public void makeConnection()
	    {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	   }
	
} 
class Answer1 {
	private JFrame f = new JFrame("RIDDLE ANSWER");
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JPanel p;
	JButton back;
	
	public Answer1() {
	
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		
		p=new JPanel(new GridLayout(13,1));
		l0=new JLabel("ANSWERS FOR RIDDLE");
		l1=new JLabel("1.Money");
		l2=new JLabel("2.Map");
		l3=new JLabel("3.Letter g");
		l4=new JLabel("4.Coin");
		l5=new JLabel("5.Cards");
		l6=new JLabel("6.Tongue");
		l7=new JLabel("7.Seven");
		l8=new JLabel("8.Two");
		l9=new JLabel("9.Envelope");
		l10=new JLabel("10.Short");
		back=new JButton("BACK");
		
		p.setBackground(new Color(120,144,250));
		l0.setFont(new Font("Times New Roman",Font.BOLD,40));
		l1.setFont(new Font("casteller",Font.ITALIC,20));
		l2.setFont(new Font("casteller",Font.ITALIC,20));
		l3.setFont(new Font("casteller",Font.ITALIC,20));
		l4.setFont(new Font("casteller",Font.ITALIC,20));
		l5.setFont(new Font("casteller",Font.ITALIC,20));
		l6.setFont(new Font("casteller",Font.ITALIC,20));
		l7.setFont(new Font("casteller",Font.ITALIC,20));
		l8.setFont(new Font("casteller",Font.ITALIC,20));
		l9.setFont(new Font("casteller",Font.ITALIC,20));
		l10.setFont(new Font("casteller",Font.ITALIC,20));
		back.setBackground(Color.PINK);
		back.setFont(new Font("Mongolian Baiti",1, 20));
		

		
		
		p.add(l0);	
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(l8);
		p.add(l9);
		p.add(l10);
		f.add(p,BorderLayout.CENTER);
		f.setLayout(new FlowLayout(FlowLayout.LEFT, 500, 25));
		f.add(back);
		
		back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
				
				f.dispose();
				new Quizzes();
				
		}
		});
	}
}
	

class IQApp {
	private JFrame f = new JFrame("IQ TEST");
	JPanel p6,p4,p5;
	JButton n,p,sub;
	JLabel l18,l19,tf,label;
	JRadioButton a,b,c,e;
	Connection con;
	Statement st;
	ResultSet rs;
	ButtonGroup group;
	int count=0;
	int sec=300;
	
	public IQApp() {
		ArrayList<String> list=new ArrayList<String>();
		
		list.add("A)S");
		list.add("A)Money");
		list.add("A)12");
		list.add("C)6");
		list.add("D)All of the above");
		list.add("D)All of the above");
		list.add("A)Three");
		list.add("A)Dictonary");
		list.add("A)Penguins don?t fly.");
		list.add("D)8 sheep");
		try{	
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		
		p6=new JPanel(new GridLayout(3,1));
		p5=new JPanel();
		p4=new JPanel(new GridLayout(4,1));
		a=new JRadioButton();
		a=new JRadioButton();
		b=new JRadioButton();
		c=new JRadioButton();
		e=new JRadioButton();
		n=new JButton("NEXT");
		p=new JButton("PREVIOUS");
		sub=new JButton("SUMBIT");
		group = new ButtonGroup();
		l18=new JLabel();
		l19=new JLabel();
		tf=new JLabel();
		ImageIcon back = new ImageIcon("back.jpg");
		label = new JLabel(back);
		Border border = BorderFactory.createLineBorder(new Color(200,30,250), 10);
		
		tf.setBorder(border);
		tf.setForeground(new Color(200,30,250));
		tf.setFont(new Font("Times New Roman",Font.ITALIC,30));
		l18.setFont(new Font("Times New Roman",Font.ITALIC,15));
		l19.setFont(new Font("Times New Roman",Font.ITALIC,15));
		a.setFont(new Font("Times New Roman",Font.ITALIC,15));
		b.setFont(new Font("Times New Roman",Font.ITALIC,15));
		c.setFont(new Font("Times New Roman",Font.ITALIC,15));
		e.setFont(new Font("Times New Roman",Font.ITALIC,15));
		n.setBackground(new Color(120,144,250));
		p.setBackground(new Color(120,144,250));
		sub.setBackground(new Color(120,144,250));
		n.setFont(new Font("Mongolian Baiti",1, 20));
		p.setFont(new Font("Mongolian Baiti",1, 20));
		sub.setFont(new Font("Mongolian Baiti",1, 20));		
		
		
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		group.add(a);
		group.add(b);
		group.add(c);
		group.add(e);
		p5.add(l18);
		p5.add(l19);
		p6.add(p5);
		p4.add(a);
		p4.add(b);
		p4.add(c);
		p4.add(e);
		p6.add(p4);
		p6.add(p);
		p6.add(n);
		p6.add(tf);
		p6.add(sub);
		label.setLayout(new FlowLayout());
		label.add(p6,BorderLayout.CENTER);
		f.add(label);
		
		makeConnection();
		rs=st.executeQuery("select * from iq");
		rs.first();
		l18.setText(rs.getString(1));
		l19.setText(rs.getString(2));
		a.setText(rs.getString(3));
		b.setText(rs.getString(4));
		c.setText(rs.getString(5));
		e.setText(rs.getString(6));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		Timer t = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			sec--;
			tf.setText("Still seconds  "+sec+"s  more");
        }
        });
        t.setRepeats(true);
        t.start();
		
		if(sub.isSelected())
		{
			sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null,"Result:"+count+"/10...Click here to view answer");
				f.dispose();
				new Answer2();
			}
		});
		}
		else
		{	
		Timer timer = new Timer(300000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			
			JOptionPane.showMessageDialog(null,"Time Up!!!Result:"+count+"/10");
            f.setVisible(false);
            f.dispose();
			new Answer2();
            
        }
        });
        timer.setRepeats(false);
        timer.start();
		}
		
		a.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(a.isSelected())
				{
					if(list.contains(a.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					c.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		b.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(b.isSelected())
				{
					if(list.contains(b.getText()))
					{
						count++;
					}
					a.setEnabled(false);
					c.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		c.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(c.isSelected())
				{
					if(list.contains(c.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					a.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		e.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(e.isSelected())
				{
					if(list.contains(e.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					c.setEnabled(false);
					a.setEnabled(false);
				}
			}
		});
		n.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.next())
					{
						l18.setText(rs.getString(1));
						l19.setText(rs.getString(2));
						a.setText(rs.getString(3));
						b.setText(rs.getString(4));
						c.setText(rs.getString(5));
						e.setText(rs.getString(6));
						b.setEnabled(true);
					    c.setEnabled(true);
					    a.setEnabled(true);
						e.setEnabled(true);
						group.clearSelection();
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"Click the sumbit button");
					 rs.last();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null,"Result:"+count+"/10...Click here to view answer");
				f.dispose();
				new Answer2();
				
			}
		});
		p.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.previous())
					{
					    l18.setText(rs.getString(1));
						l19.setText(rs.getString(2));
						a.setText(rs.getString(3));
						b.setText(rs.getString(4));
						c.setText(rs.getString(5));
						e.setText(rs.getString(6));	
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"This is the first question");
					 rs.first();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
	}
		public void makeConnection()
	    {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	   }
	
} 
class Answer2 {
	private JFrame f = new JFrame("IQ ANSWER");
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JPanel p;
	JButton back;
	
	public Answer2() {
	
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		
		p=new JPanel(new GridLayout(13,1));
		l0=new JLabel("ANSWERS FOR IQ TEST");
		l1=new JLabel("1.S");
		l2=new JLabel("2.Money");
		l3=new JLabel("3.12");
		l4=new JLabel("4.6");
		l5=new JLabel("5.All of the above");
		l6=new JLabel("6.All of the above");
		l7=new JLabel("7.Three");
		l8=new JLabel("8.Dictionary");
		l9=new JLabel("9.Penguins don?t fly.");
		l10=new JLabel("10.8 sheep");
		back=new JButton("BACK");
		
		p.setBackground(new Color(120,144,250));
		l0.setFont(new Font("Times New Roman",Font.BOLD,40));
		l1.setFont(new Font("casteller",Font.ITALIC,20));
		l2.setFont(new Font("casteller",Font.ITALIC,20));
		l3.setFont(new Font("casteller",Font.ITALIC,20));
		l4.setFont(new Font("casteller",Font.ITALIC,20));
		l5.setFont(new Font("casteller",Font.ITALIC,20));
		l6.setFont(new Font("casteller",Font.ITALIC,20));
		l7.setFont(new Font("casteller",Font.ITALIC,20));
		l8.setFont(new Font("casteller",Font.ITALIC,20));
		l9.setFont(new Font("casteller",Font.ITALIC,20));
		l10.setFont(new Font("casteller",Font.ITALIC,20));
		back.setBackground(Color.PINK);
		back.setFont(new Font("Mongolian Baiti",1, 20));
		
		
		p.add(l0);	
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(l8);
		p.add(l9);
		p.add(l10);
		f.add(p,BorderLayout.CENTER);
		f.setLayout(new FlowLayout(FlowLayout.LEFT, 500, 25));
		f.add(back);
		
		
		back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
				
				f.dispose();
				new Quizzes();
				
		}
		});
	}
}
	
class Neet {
	private JFrame f = new JFrame("NEET");
	JPanel p6,p4,p5;
	JButton n,p,sub;
	JLabel l18,l19,tf,label;
	JRadioButton a,b,c,e;
	ButtonGroup group;
	Connection con;
	Statement st;
	ResultSet rs;
	int count=0;
	int sec=600;
	
	public Neet() {
		ArrayList<String> list=new ArrayList<String>();
		
		list.add("B)Formation of secretory vesicles");
		list.add("A)Bamboo");
		list.add("A)Estrogen and Parathyroid hormone");
		list.add("C)Ligaments attached to ciliary body");
		list.add("B)Chelone");
		list.add("C)Earthworm");
		list.add("B)Cycas");
		list.add("C)Sachharomyces");
		list.add("B)NADH");
		list.add("B)Carbonyl and methyl");
		
		try{
	    Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		
		p6=new JPanel(new GridLayout(3,1));
		p5=new JPanel();
		p4=new JPanel(new GridLayout(4,1));
		a=new JRadioButton();
		a=new JRadioButton();
		b=new JRadioButton();
		c=new JRadioButton();
		e=new JRadioButton();
		n=new JButton("NEXT");
		p=new JButton("PREVIOUS");
		sub=new JButton("SUMBIT");
		group = new ButtonGroup();
		l18=new JLabel();
		l19=new JLabel();
		tf=new JLabel();
		ImageIcon back = new ImageIcon("back.jpg");
		label = new JLabel(back);
		Border border = BorderFactory.createLineBorder(new Color(200,30,250), 10);
		
		tf.setBorder(border);
		tf.setForeground(new Color(200,30,250));
		tf.setFont(new Font("Times New Roman",Font.ITALIC,30));
		l18.setFont(new Font("Times New Roman",Font.ITALIC,15));
		l19.setFont(new Font("Times New Roman",Font.ITALIC,15));
		a.setFont(new Font("Times New Roman",Font.ITALIC,15));
		b.setFont(new Font("Times New Roman",Font.ITALIC,15));
		c.setFont(new Font("Times New Roman",Font.ITALIC,15));
		e.setFont(new Font("Times New Roman",Font.ITALIC,15));
		n.setBackground(new Color(120,144,250));
		p.setBackground(new Color(120,144,250));
		sub.setBackground(new Color(120,144,250));
		n.setFont(new Font("Mongolian Baiti",1, 20));
		p.setFont(new Font("Mongolian Baiti",1, 20));
		sub.setFont(new Font("Mongolian Baiti",1, 20));		
		
		
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		group.add(a);
		group.add(b);
		group.add(c);
		group.add(e);
		p5.add(l18);
		p5.add(l19);
		p6.add(p5);
		p4.add(a);
		p4.add(b);
		p4.add(c);
		p4.add(e);
		p6.add(p4);
		p6.add(p);
		p6.add(n);
		p6.add(tf);
		p6.add(sub);
		label.setLayout(new FlowLayout());
		label.add(p6,BorderLayout.CENTER);
		f.add(label);
		
		makeConnection();
		rs=st.executeQuery("select * from neetxam");
		rs.first();
		l18.setText(rs.getString(1));
		l19.setText(rs.getString(2));
		a.setText(rs.getString(3));
		b.setText(rs.getString(4));
		c.setText(rs.getString(5));
		e.setText(rs.getString(6));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		Timer t = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			sec--;
			tf.setText("Still seconds  "+sec+"s  more");
        }
        });
        t.setRepeats(true);
        t.start();
		
		if(sub.isSelected())
		{
			sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				JOptionPane.showMessageDialog(null,"Result:"+count+"/10...Click here to view answer");
				f.dispose();
				new Answer3();
			}
		});
		}
		else
		{	
		Timer timer = new Timer(300000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Time Up!!!Result:"+count+"/10");
            f.setVisible(false);
            f.dispose();
			new Answer3();
            
        }
        });
        timer.setRepeats(false);
        timer.start();
		}
		
		a.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(a.isSelected())
				{
					if(list.contains(a.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					c.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		b.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(b.isSelected())
				{
					if(list.contains(b.getText()))
					{
						count++;
					}
					a.setEnabled(false);
					c.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		c.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(c.isSelected())
				{
					if(list.contains(c.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					a.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		e.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(e.isSelected())
				{
					if(list.contains(e.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					c.setEnabled(false);
					a.setEnabled(false);
				}
			}
		});
		n.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.next())
					{
						l18.setText(rs.getString(1));
						l19.setText(rs.getString(2));
						a.setText(rs.getString(3));
						b.setText(rs.getString(4));
						c.setText(rs.getString(5));
						e.setText(rs.getString(6));
						b.setEnabled(true);
					    c.setEnabled(true);
					    a.setEnabled(true);
						e.setEnabled(true);
						group.clearSelection();
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"Click the sumbit button");
					 rs.last();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		p.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.previous())
					{
					    l18.setText(rs.getString(1));
						l19.setText(rs.getString(2));
						a.setText(rs.getString(3));
						b.setText(rs.getString(4));
						c.setText(rs.getString(5));
						e.setText(rs.getString(6));	
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"This is the first question");
					 rs.first();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				JOptionPane.showMessageDialog(null,"Result:"+count+"/10...Click here to view answer");
				f.dispose();
				new Answer3();
				
				
			}
		});
	}
		public void makeConnection()
	    {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	   }
	
} 
class Answer3 {
	private JFrame f = new JFrame("NEET ANSWER");
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JPanel p;
	JButton back;
	
	public Answer3() {
	
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		
		p=new JPanel(new GridLayout(13,1));
		l0=new JLabel("ANSWERS FOR NEET");
		l1=new JLabel("1.Formation of secretory vesicles");
		l2=new JLabel("2.Bamboo");
		l3=new JLabel("3.Estrogen and Parathyroid hormone");
		l4=new JLabel("4.Ligaments attached to ciliary body");
		l5=new JLabel("5.Chelone");
		l6=new JLabel("6.Earthworm");
		l7=new JLabel("7.Cycas");
		l8=new JLabel("8.Sachharomyces");
		l9=new JLabel("9.NADH");
		l10=new JLabel("10.Carbonyl and methyl");
		back=new JButton("BACK");
		
		p.setBackground(new Color(120,144,250));
		l0.setFont(new Font("Times New Roman",Font.BOLD,40));
		l1.setFont(new Font("casteller",Font.ITALIC,20));
		l2.setFont(new Font("casteller",Font.ITALIC,20));
		l3.setFont(new Font("casteller",Font.ITALIC,20));
		l4.setFont(new Font("casteller",Font.ITALIC,20));
		l5.setFont(new Font("casteller",Font.ITALIC,20));
		l6.setFont(new Font("casteller",Font.ITALIC,20));
		l7.setFont(new Font("casteller",Font.ITALIC,20));
		l8.setFont(new Font("casteller",Font.ITALIC,20));
		l9.setFont(new Font("casteller",Font.ITALIC,20));
		l10.setFont(new Font("casteller",Font.ITALIC,20));
		back.setBackground(Color.PINK);
		back.setFont(new Font("Mongolian Baiti",1, 20));
			
		
		p.add(l0);	
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(l8);
		p.add(l9);
		p.add(l10);
		f.add(p,BorderLayout.CENTER);
		f.setLayout(new FlowLayout(FlowLayout.LEFT,600, 25));
		f.add(back);
		
		
		back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
				
				f.dispose();
				new Quizzes();
				
		}
		});
	}
}
	
class Jee {
	private JFrame f = new JFrame("JEE");
	JPanel p6,p4,p5;
	JButton n,p,sub;
	JLabel l18,l19,tf,label;
	JRadioButton a,b,c,e;
	ButtonGroup group;
	Connection con;
	Statement st;
	ResultSet rs;
	int count=0;
	int sec=600;
	
	public Jee() {
			ArrayList<String> list=new ArrayList<String>();
		
		list.add("B)Red colour of the ruby is due to the presence of CO3+");
		list.add("C)Linear;180 deg oxidising agent");
		list.add("D)Zn<Cr<Fe<Co<Cu");
		list.add("Styrene");
		list.add("A)O,S,Se,Te");
		list.add("B)0");
		list.add("A)AgNO3 in KI solution");
		list.add("A)Alpha-sulphur");
		list.add("B)7.4kPa");
		list.add("D)FeCl3");
		
		try{
	    Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		
		p6=new JPanel(new GridLayout(3,1));
		p5=new JPanel();
		p4=new JPanel(new GridLayout(4,1));
		a=new JRadioButton();
		a=new JRadioButton();
		b=new JRadioButton();
		c=new JRadioButton();
		e=new JRadioButton();
		n=new JButton("NEXT");
		p=new JButton("PREVIOUS");
		sub=new JButton("SUMBIT");
		group = new ButtonGroup();
		l18=new JLabel();
		l19=new JLabel();
		tf=new JLabel();
		ImageIcon back = new ImageIcon("back.jpg");
		label = new JLabel(back);
		Border border = BorderFactory.createLineBorder(new Color(200,30,250), 10);
		
		tf.setBorder(border);
		tf.setForeground(new Color(200,30,250));
		tf.setFont(new Font("Times New Roman",Font.ITALIC,30));
		l18.setFont(new Font("Times New Roman",Font.ITALIC,15));
		l19.setFont(new Font("Times New Roman",Font.ITALIC,15));
		a.setFont(new Font("Times New Roman",Font.ITALIC,15));
		b.setFont(new Font("Times New Roman",Font.ITALIC,15));
		c.setFont(new Font("Times New Roman",Font.ITALIC,15));
		e.setFont(new Font("Times New Roman",Font.ITALIC,15));
		n.setBackground(new Color(120,144,250));
		p.setBackground(new Color(120,144,250));
		sub.setBackground(new Color(120,144,250));
		n.setFont(new Font("Mongolian Baiti",1, 20));
		p.setFont(new Font("Mongolian Baiti",1, 20));
		sub.setFont(new Font("Mongolian Baiti",1, 20));		
	
		
		f.setLayout(new FlowLayout(FlowLayout.CENTER));
		group.add(a);
		group.add(b);
		group.add(c);
		group.add(e);
		p5.add(l18);
		p5.add(l19);
		p6.add(p5);
		p4.add(a);
		p4.add(b);
		p4.add(c);
		p4.add(e);
		p6.add(p4);
		p6.add(p);
		p6.add(n);
		p6.add(tf);
		p6.add(sub);
		label.setLayout(new FlowLayout());
		label.add(p6,BorderLayout.CENTER);
		f.add(label);
		
		makeConnection();
		rs=st.executeQuery("select * from jeeexam");
		rs.first();
		l18.setText(rs.getString(1));
		l19.setText(rs.getString(2));
		a.setText(rs.getString(3));
		b.setText(rs.getString(4));
		c.setText(rs.getString(5));
		e.setText(rs.getString(6));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		Timer t = new Timer(1000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			sec--;
			tf.setText("Still seconds  "+sec+"s  more");
        }
        });
        t.setRepeats(true);
        t.start();
		
		if(sub.isSelected())
		{
			sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				
				JOptionPane.showMessageDialog(null,"Result:"+count+"/10...Click here to view answer");
				f.dispose();
				new Answer4();
				
				
			}
		});
		}
		else
		{	
		Timer timer = new Timer(300000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,"Time Up!!!Result:"+count+"/10");
            f.setVisible(false);
            f.dispose();
			new Quizzes();
            
        }
        });
        timer.setRepeats(false);
        timer.start();
		}
	
		a.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(a.isSelected())
				{
					if(list.contains(a.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					c.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		b.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(b.isSelected())
				{
					if(list.contains(b.getText()))
					{
						count++;
					}
					a.setEnabled(false);
					c.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		c.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(c.isSelected())
				{
					if(list.contains(c.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					a.setEnabled(false);
					e.setEnabled(false);
				}
			}
		});
		e.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent ie)
			{
				if(e.isSelected())
				{
					if(list.contains(e.getText()))
					{
						count++;
					}
					b.setEnabled(false);
					c.setEnabled(false);
					a.setEnabled(false);
				}
			}
		});
		n.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.next())
					{
						l18.setText(rs.getString(1));
						l19.setText(rs.getString(2));
						a.setText(rs.getString(3));
						b.setText(rs.getString(4));
						c.setText(rs.getString(5));
						e.setText(rs.getString(6));
						b.setEnabled(true);
					    c.setEnabled(true);
					    a.setEnabled(true);
						e.setEnabled(true);
						group.clearSelection();
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"Click the sumbit button");
					 rs.last();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		p.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					if(rs.previous())
					{
					    l18.setText(rs.getString(1));
						l19.setText(rs.getString(2));
						a.setText(rs.getString(3));
						b.setText(rs.getString(4));
						c.setText(rs.getString(5));
						e.setText(rs.getString(6));	
					}
					else
					{
					 JOptionPane.showMessageDialog(null,"This is the first question");
					 rs.first();
					} 
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		sub.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae)
			{
				
				JOptionPane.showMessageDialog(null,"Result:"+count+"/10...Click here to view answer");
				f.dispose();
				new Answer4();
				
			}
		});
	}
		public void makeConnection()
	    {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Merriment","root","");
			st=con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	   }
}
class Answer4 {
	private JFrame f = new JFrame("JEE ANSWER");
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JPanel p;
	JButton back;
	
	public Answer4() {
	
		Image icon = Toolkit.getDefaultToolkit().getImage("icon.jpg");
	    f.setIconImage(icon);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension d=kit.getScreenSize();
		f.setSize(d.width,d.height);
		f.setVisible(true);
		
		p=new JPanel(new GridLayout(13,1));
		l0=new JLabel("ANSWERS FOR JEE");
		l1=new JLabel("1.Red colour of the ruby is due to the presence of CO3+");
		l2=new JLabel("2.Linear;180 deg oxidising agent");
		l3=new JLabel("3.Zn<Cr<Fe<Co<Cu");
		l4=new JLabel("4.Styrene");
		l5=new JLabel("5.O,S,Se,Te");
		l6=new JLabel("6.0");
		l7=new JLabel("7.AgNO3 in KI solution");
		l8=new JLabel("8.Alpha-sulphur");
		l9=new JLabel("9.7.4kPa");
		l10=new JLabel("10.FeCl3");
		back=new JButton("BACK");
		
		p.setBackground(new Color(120,144,250));
		l0.setFont(new Font("Times New Roman",Font.BOLD,40));
		l1.setFont(new Font("casteller",Font.ITALIC,20));
		l2.setFont(new Font("casteller",Font.ITALIC,20));
		l3.setFont(new Font("casteller",Font.ITALIC,20));
		l4.setFont(new Font("casteller",Font.ITALIC,20));
		l5.setFont(new Font("casteller",Font.ITALIC,20));
		l6.setFont(new Font("casteller",Font.ITALIC,20));
		l7.setFont(new Font("casteller",Font.ITALIC,20));
		l8.setFont(new Font("casteller",Font.ITALIC,20));
		l9.setFont(new Font("casteller",Font.ITALIC,20));
		l10.setFont(new Font("casteller",Font.ITALIC,20));
		back.setBackground(Color.PINK);
		back.setFont(new Font("Mongolian Baiti",1, 20));
		
		
		
		p.add(l0);	
		p.add(l1);
		p.add(l2);
		p.add(l3);
		p.add(l4);
		p.add(l5);
		p.add(l6);
		p.add(l7);
		p.add(l8);
		p.add(l9);
		p.add(l10);
		f.add(p,BorderLayout.CENTER);
		f.setLayout(new FlowLayout(FlowLayout.LEFT, 500, 25));
		f.add(back);
		
		back.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent ae)
		{
				
				f.dispose();
				new Quizzes();
				
		}
		});
	}
}
	