package employee.managment.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Splash extends JFrame  implements ActionListener{

	
	Splash(){
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		JLabel heading =new JLabel("EMPLOYEE MANAGMENT SYSTEM");
		heading.setBounds(80, 30, 1200, 60);
		heading.setFont(new Font ("serif",Font.PLAIN,60));
		heading.setForeground(Color.red);
		add(heading);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
		Image i2=i1.getImage().getScaledInstance(1100, 700,Image.SCALE_DEFAULT );
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(50, 100, 1050, 500);
		add(image);
		
		
		JButton clickhere=new JButton("CLICK HERE FOR CONTINUE");
		clickhere.setBounds(400, 400, 300, 70);
		clickhere.setBackground(Color.black);
		clickhere.setForeground(Color.white);
		clickhere.addActionListener(this);
		image.add(clickhere);
		
		setSize(1170,650);      //(length,width,)
		
		setLocation(180,50);             //this method use for set a pericular location.	                                  
		                                  //it take 2 arguments 1st is left distance & 2nd is top distance.
	      setVisible(true);	
	      
	      while(true) {
	    	  heading.setVisible(false);
	    	  try {
	    		  Thread.sleep(500);
	    		  
	    	  }catch(Exception e) {
	    		  
	    	  }
	    	  heading.setVisible(true);
	    	  try {
	    		  Thread.sleep(500);
	    		  
	    	  }catch(Exception e) {
	    		  
	    	  }
	      }
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Login();
		
	}
	public static void main(String str[]) {
		new Splash();
	}

	
}
