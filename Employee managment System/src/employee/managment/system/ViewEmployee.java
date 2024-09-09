package employee.managment.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
import net.proteanit.sql.DbUtils;

public class ViewEmployee extends JFrame implements ActionListener{
	
	JTable table;
	Choice cemployeeId;
	JButton search,print,update,back;
	
	ViewEmployee(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel searchlbl =new JLabel("Search By Employee Id");
		searchlbl.setBounds(20,20,150,20);
		add(searchlbl);
		
		cemployeeId=new Choice();
		cemployeeId.setBounds(180,20,150,20);
		add(cemployeeId);
		
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from employee01");
			
			while(rs.next()) {
				cemployeeId.add(rs.getString("empId"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		table=new JTable();
		
		
		try {
			Conn c=new Conn();
			ResultSet rs=c.s.executeQuery("select * from employee01");
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0,100,900,600);
		add(jsp);
		
		
		search=new JButton("search");
		search.setBounds(20,70,80,20);
		search.addActionListener(this);
		add(search);
		
		
		print=new JButton("print");
		print.setBounds(120,70,80,20);
		print.addActionListener(this);
		add(print);
		

		update=new JButton("update");
		update.setBounds(220,70,80,20);
		update.addActionListener(this);
		add(update);
		
		back=new JButton("back");
		back.setBounds(320,70,80,20);
		back.addActionListener(this);
		add(back);
		
		setSize(900,700);
		setLocation(300,100);
		setVisible(true);
		
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==search) {
			String query="select * from employee01 where empId='"+cemployeeId.getSelectedItem()+"'";
			try {
				Conn c=new Conn();
				ResultSet rs=c.s.executeQuery(query);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource()==print) {
			
			try {
				table.print();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}else if(ae.getSource()==update) {
			setVisible(false);
			new UpdateEmployee(cemployeeId.getSelectedItem());
			
		}else {
			setVisible(false);
			new Home();
		}
		
	}
	

	public static void main(String[] args) {
		new ViewEmployee();

	}





}
