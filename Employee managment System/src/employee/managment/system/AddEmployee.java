package employee.managment.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;


public class AddEmployee extends JFrame implements ActionListener {
	
	Random ran =new Random();
	int number=ran.nextInt(999999);
	
	JTextField tfname,tffname,tfsalary,tfdesignation,tfaddress,tfphone,tfemail,tfaadhar;
	JDateChooser dcdob;
	JComboBox cbeducation ;
	JButton add,back;
	JLabel lblempId;
	

	AddEmployee(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);		
		
		JLabel heading= new JLabel("Add Employee Detail");
		heading.setBounds(320,30,500,50);
		heading.setFont(new Font("san_serif",Font.BOLD,25));
		add(heading);
		
		
		
		JLabel labelname=new JLabel("Name");
		labelname.setBounds(50, 150, 150, 30);
		labelname.setFont(new Font("sorif",Font.PLAIN,20));
		add(labelname);
		
		
		tfname=new JTextField();
		tfname.setBounds(200, 150, 150, 30);
		add(tfname);
		
		
		JLabel labelfname=new JLabel("father's Name");
		labelfname.setBounds(400, 150, 150, 30);
		labelfname.setFont(new Font("sorif",Font.PLAIN,20));
		add(labelfname);
		
		 tffname=new JTextField();
		tffname.setBounds(600, 150, 150, 30);
		add(tffname);
		
		
		JLabel labeldob=new JLabel("Date of Birth");
		labeldob.setBounds(50, 200, 150, 30);
		labeldob.setFont(new Font("sorif",Font.PLAIN,20));
		add(labeldob);
		
		
		
		 dcdob=new JDateChooser();
		dcdob.setBounds(200,200,150,30);
	add(dcdob);
		
	
	JLabel labelsalary=new JLabel("Salary");
	labelsalary.setBounds(400, 200, 150, 30);
	labelsalary.setFont(new Font("sorif",Font.PLAIN,20));
	add(labelsalary);
	
	 tfsalary=new JTextField();
	tfsalary.setBounds(600, 200, 150, 30);
	add(tfsalary);
	
	
	JLabel labeladdress=new JLabel("Address");
	labeladdress.setBounds(50, 250, 150, 30);
	labeladdress.setFont(new Font("sorif",Font.PLAIN,20));
	add(labeladdress);
	
	 tfaddress=new JTextField();
	tfaddress.setBounds(200, 250, 150, 30);
	add(tfaddress);
	
	
	JLabel labelphone=new JLabel("phone");
	labelphone.setBounds(400, 250, 150, 30);
	labelphone.setFont(new Font("sorif",Font.PLAIN,20));
	add(labelphone);
	
	 tfphone=new JTextField();
	tfphone.setBounds(600, 250, 150, 30);
	add(tfphone);
	
	
	JLabel labelemail=new JLabel("Email");
	labelemail.setBounds(50, 300, 150, 30);
	labelemail.setFont(new Font("sorif",Font.PLAIN,20));
	add(labelemail);
	
	 tfemail=new JTextField();
	tfemail.setBounds(200, 300, 150, 30);
	add(tfemail);
	
	
	JLabel labeleducation=new JLabel("Hiest Education");
	labeleducation.setBounds(400, 300, 150, 30);
	labeleducation.setFont(new Font("sorif",Font.PLAIN,20));
	add(labeleducation);
	
	String courses[]= {"BBA","BCA","BA","BSC","B.COM","BTech","MBA","MCA","MA","MTech","MSC"};	
 cbeducation = new JComboBox(courses);
cbeducation.setBackground(Color.white);
cbeducation.setBounds(600, 300, 150, 30);
	add(cbeducation);
	
	
	JLabel labeldesignation=new JLabel("Designation");
	labeldesignation.setBounds(50, 350, 150, 30);
	labeldesignation.setFont(new Font("sorif",Font.PLAIN,20));
	add(labeldesignation);
	
	 tfdesignation=new JTextField();
	tfdesignation.setBounds(200, 350, 150, 30);
	add(tfdesignation);
	
	
	JLabel labelaadhar=new JLabel("Aadhar number");
	labelaadhar.setBounds(400, 350, 150, 30);
	labelaadhar.setFont(new Font("sorif",Font.PLAIN,20));
	add(labelaadhar);
	
	 tfaadhar=new JTextField();
	tfaadhar.setBounds(600, 350, 150, 30);
	add(tfaadhar);
	
	
	JLabel labelempId=new JLabel("Employee Id");
	labelempId.setBounds(50, 400, 150, 30);
	labelempId.setFont(new Font("sorif",Font.PLAIN,20));
	add(labelempId);
	
	
	 lblempId=new JLabel(""+number);
	lblempId.setBounds(200, 400, 150, 30);
	lblempId.setFont(new Font("sorif",Font.PLAIN,20));
	add(lblempId);
	
	
	 add =new JButton("Add Details");
		add.setBounds(250, 550, 150, 40);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(this);
		add(add);
		
		
		 back =new JButton("Back");
		back.setBounds(450, 550, 150, 40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		setSize(900,650);
		setLocation(300,50);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add) {
			String name=tfname.getText();
			String fname=tffname.getText();
			String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
			String salary=tfsalary.getText();
			String address=tfaddress.getText();
			String phone=tfphone.getText();
			String email=tfemail.getText();
			String education=(String)cbeducation.getSelectedItem();
			String designation=tfdesignation.getText();
			String aadhar=tfaadhar.getText();
			String empId=lblempId.getText();
			
			try {
				Conn conn=new Conn();
				String query="insert into employee01 values('"+name+"' , '"+fname+"'  ,'"+dob+"'  ,'"+salary+"'  ,'"+address+"' ,'"+phone+"' ,'"+email+"' ,'"+education+"' ,'"+designation+"' ,'"+aadhar+"' ,'"+empId+"')";
				conn.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details");
				setVisible(false);
				new Home();
				
						
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		
		}else {
			setVisible(false);
			new Home();
			
		}
		
	}
	
	public static void main(String[] args) {
	new	AddEmployee();
	}

	

}
