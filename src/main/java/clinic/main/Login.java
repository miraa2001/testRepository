package clinic.main;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class Login extends JFrame implements ActionListener,ItemListener{
	JPanel Panel;
	JLabel Username,Password;
	JTextField UsernameTF;
	JPasswordField PasswordPF;
	private JButton SignIn;
	JSeparator s1,s2;
	JCheckBox showPassword;
	JLabel b;
	JLabel w;
	int res;
	static Scanner in=new Scanner(System.in);
	static int index=-1;
	public Login() 
	{
		init();
		setLayout(null);
		
		w=new JLabel("MyClinic's Login portal");
		w.setFont(new Font("SansSerif",Font.BOLD+Font.ITALIC,24));
		w.setBackground(new Color(0,0,0));
		w.setForeground(new Color(0,0,0));
		w.setSize(280,100);
		w.setLocation(70,20);
		add(w);
		Username=new JLabel("Username");
		Font f=new Font("SansSerif",Font.BOLD,18);
		Username.setForeground(new Color(0,0,0));
		Username.setFont(f);
		Username.setLocation(40, 100);
		Username.setSize(100,100);
		add(Username);
		UsernameTF=new JTextField();
		UsernameTF.setText("Username");
		UsernameTF.setForeground(Color.GRAY);
		UsernameTF.setBackground(new Color(255,203,230));
		UsernameTF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		UsernameTF.setFont(new Font("SansSerif",Font.ITALIC,14));
		UsernameTF.setSize(170, 20);
		UsernameTF.setLocation(145,140);
		UsernameTF.addMouseListener(new MouseListener() {

		    public void mouseClicked(MouseEvent e) {
		    	UsernameTF.setText("");
		    	UsernameTF.setForeground(Color.BLACK);
		    	UsernameTF.setFont(new Font("SansSerif",Font.PLAIN,14));
		    }
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				UsernameTF.setText("");
				UsernameTF.setForeground(Color.BLACK);
				UsernameTF.setFont(new Font("SansSerif",Font.PLAIN,14));
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(UsernameTF);
		s1=new JSeparator();
		s1.setBackground(new Color(0,0,0));
		s1.setForeground(new Color(0,0,0));
		s1.setSize(170, 5);
		s1.setLocation(145, 160);
		add(s1);
		
		Password=new JLabel("Password");
		Password.setForeground(new Color(0,0,0));
		Password.setFont(f);
		Password.setLocation(40, 160);
		Password.setSize(100,100);
		add(Password);
		PasswordPF=new JPasswordField(15);
		PasswordPF.setText("");
		PasswordPF.setForeground(Color.BLACK);
		PasswordPF.setBackground(new Color(255,203,230));
		PasswordPF.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		PasswordPF.setEchoChar('\u26AB');
		PasswordPF.setSize(170, 20);
		PasswordPF.setLocation(145,200);
		PasswordPF.addMouseListener(new MouseListener() {

		    public void mouseClicked(MouseEvent e) {
		    	PasswordPF.setText("");
		    }
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				PasswordPF.setText("");
			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(PasswordPF);
		s2=new JSeparator();
		s2.setBackground(new Color(0,0,0));
		s2.setForeground(new Color(0,0,0));
		s2.setSize(170, 5);
		s2.setLocation(145, 220);
		add(s2);
		showPassword=new JCheckBox("Show Password");
		showPassword.setFont(new Font("SansSerif",Font.BOLD,12));
		showPassword.setBackground(new Color(255,203,230));
		showPassword.setForeground(new Color(0,0,0));
		showPassword.setSize(170,30);
		showPassword.setLocation(135,240);
		showPassword.addActionListener(this);
		add(showPassword);
		setSignIn(new JButton("Log in"));
		getSignIn().setFont(new Font("SansSerif",Font.BOLD,16));
		getSignIn().setBackground(new Color(0,0,0));
		getSignIn().setForeground(new Color(255,203,230));
		getSignIn().setSize(100,35);
		getSignIn().setLocation(145,310);
		add(getSignIn());
		getSignIn().addActionListener(this);
		b=new JLabel("");
		b.setSize(100,100);
		b.setLocation(145,350);
		ImageIcon icon=new ImageIcon("C:\\Users\\miraj\\eclipse-workspace\\MyBookStore\\MyBookStore\\src\\book\\store\\book.gif");
		b.setIcon(icon);
		add(b);
		setVisible(true);
		setLocation(480,100);
		setSize(400, 440);
		setResizable(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==showPassword)
		{
			if(showPassword.isSelected())
			{
				PasswordPF.setFont(new Font("SansSerif",Font.PLAIN,14));
				PasswordPF.setEchoChar((char) 0);
			}
			else
			{	
				PasswordPF.setEchoChar('\u26AB');
				PasswordPF.setFont(new Font("SansSerif",Font.PLAIN,12));
			}
		}
		if(e.getSource()==getSignIn())
		{
			res=checkLoginStatus(UsernameTF.getText(),String.valueOf(PasswordPF.getPassword()));
			if(res == -2)
			{
				UIManager UI=new UIManager();
				UI.put("OptionPane.background",new ColorUIResource(0,0,0));
				UI.put("OptionPane.messageForeground",new ColorUIResource(255,203,230));
				UI.put("Panel.background",new ColorUIResource(0,0,0));
				ImageIcon icon=new ImageIcon("C:\\Users\\Lenovo\\Desktop\\clinic\\pics\\Success.gif");
				JOptionPane.showMessageDialog(this, "Admin Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE, icon);
				AdminMethods.Admins.get(index).setLogState(true);
				AdminMethods ac=new AdminMethods();//index);
			}
			else if(res == -1)
			{
				AdminMethods.Admins.get(index).setLogState(false);
				UIManager UI=new UIManager();
				UI.put("OptionPane.background",new ColorUIResource(0,0,0));
				UI.put("OptionPane.messageForeground",new ColorUIResource(255,203,230));
				UI.put("Panel.background",new ColorUIResource(0,0,0));
				ImageIcon icon=new ImageIcon("C:\\Users\\Lenovo\\Desktop\\clinic\\pics\\Error.gif");
				JOptionPane.showMessageDialog(this, "Invalid Credentialis. Try again", "Error", JOptionPane.INFORMATION_MESSAGE, icon);
			}
			else if(res == 2)
			{
				UIManager UI=new UIManager();
				UI.put("OptionPane.background",new ColorUIResource(0,0,0));
				UI.put("OptionPane.messageForeground",new ColorUIResource(255,203,230));
				UI.put("Panel.background",new ColorUIResource(0,0,0));
				ImageIcon icon=new ImageIcon("C:\\Users\\Lenovo\\Desktop\\clinic\\pics\\Success.gif");
				JOptionPane.showMessageDialog(this, "Patient Login Successful", "Success", JOptionPane.INFORMATION_MESSAGE, icon);
				PatientMethods.Patients.get(index).setLogState(true);
				PatientMethods pm=new PatientMethods();//index);
			}
			else if(res == 1)
			{
				UIManager UI=new UIManager();
				UI.put("OptionPane.background",new ColorUIResource(0,0,0));
				UI.put("OptionPane.messageForeground",new ColorUIResource(255,203,230));
				UI.put("Panel.background",new ColorUIResource(0,0,0));
				ImageIcon icon=new ImageIcon("C:\\Users\\Lenovo\\Desktop\\clinic\\pics\\Error.gif");
				JOptionPane.showMessageDialog(this, "Invalid Credentials. Try again", "Error", JOptionPane.INFORMATION_MESSAGE, icon);
				PatientMethods.Patients.get(index).setLogState(false);
				System.out.println("Invalid Credentials. Try again");
			}
			else if(res == 0)
			{
				UIManager UI=new UIManager();
				UI.put("OptionPane.background",new ColorUIResource(0,0,0));
				UI.put("OptionPane.messageForeground",new ColorUIResource(255,203,230));
				UI.put("Panel.background",new ColorUIResource(0,0,0));
				ImageIcon icon=new ImageIcon("C:\\Users\\Lenovo\\Desktop\\clinic\\pics\\Error.gif");
				JOptionPane.showMessageDialog(this, "Non-existent Credentials. Do you want to sign up?", "Error", JOptionPane.INFORMATION_MESSAGE, icon);
			}
		}
	}
	
	public static int checkLoginStatus(String u,String p)
	{

		for(int i=0;i<PatientMethods.Patients.size();i++)
		{
			if(u.equals(PatientMethods.Patients.get(i).getUsername()))
			{	
				index=i;
				if(p.equals(PatientMethods.Patients.get(i).getPassword()))
					return 2;
				else
					return 1;
			}
		}
		for(int i=0;i<AdminMethods.Admins.size();i++)
		{
			if(u.equals(AdminMethods.Admins.get(i).getUsername()))
			{	
				index=i;
				if(p.equals(AdminMethods.Admins.get(i).getPassword()))
					return -2;
				else
					return -1;
			}
		}
		return 0;
	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
	}
	public void init()
	{
		if((AdminMethods.Admins.size()<=3)&&(PatientMethods.Patients.size()<=3))
		{
			Admin a1=new Admin("miraj","1212001","Mira Jamous");
			Admin a2=new Admin("talahamad","tala2001","Tala Hamad");
			Admin a3=new Admin("areenateeq","areen2002","Areen Ateeq");
			AdminMethods.Admins.add(a1);
			AdminMethods.Admins.add(a2);
			AdminMethods.Admins.add(a3);
			Patient c1=new Patient("ayaayman","aya2001","Aya Ayman");		
			Patient c2=new Patient("leenh","leen21","Leen Hodally");
			Patient c3=new Patient("suha2001","suhaa2001","Suha Mansour");
			PatientMethods.Patients.add(c1);
			PatientMethods.Patients.add(c2);
			PatientMethods.Patients.add(c3);
		}
	}
	public void setPasswordField(String p)
	{
		PasswordPF.setText(p);
	}
	public void setUsernameField(String u)
	{
		UsernameTF.setText(u);
	}
	public static void main(String[] args)
	{
		Login login=new Login();
		login.setVisible(true);
		login.getContentPane().setBackground(new Color(255,203,230));
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
	}


	public JButton getSignIn() {
		return SignIn;
	}
	public int getResult()
	{
		return res;
	}

	public void setSignIn(JButton signIn) {
		SignIn = signIn;
	}
}

