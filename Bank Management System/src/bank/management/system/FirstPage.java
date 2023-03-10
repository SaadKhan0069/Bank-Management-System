package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirstPage extends JFrame implements ActionListener{
    int no;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3;
    JRadioButton r1,r2,r3;
    ButtonGroup bg;
    JComboBox c1,c2,c3;
    JTextArea ta1;
    JButton b1,b2;
    String day[]=new String[31];
    String month[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    String year[]=new String[26];
    public FirstPage(){
        super("Bank Management System");
        
        setBounds(150,80,720,560);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        setLayout(null);
        Random r=new Random();
        no=1000+r.nextInt(9999-1000);
        l1 = new JLabel("Application Form Number = "+no);
        l1.setBackground(Color.white);
        l1.setFont(new Font("Tahoma",1,22));
        l1.setBounds(170, 10, 460, 50);
        add(l1);
        
        l2 = new JLabel("Page 01 : PERSONAL DETAILS");
        l2.setBackground(new Color(255,204,204));
        l2.setFont(new Font("Trebuchet MS",1,16));
        l2.setForeground(new Color(102,51,0));
        l2.setBounds(240,60,240,30);
        add(l2);
        
        l3 = new JLabel("Name = ");
        l3.setBackground(new Color(255,204,204));
        l3.setFont(new Font("Trebuchet MS",1,16));
        l3.setForeground(new Color(102,51,0));
        l3.setBounds(110,130,160,30);
        add(l3);
        
        t1 =new JTextField();
        t1.setBackground(new Color(232,232,232));
        t1.setBounds(240, 130, 320, 30);
        add(t1);
        
        l4 = new JLabel("Contact No = ");
        l4.setBackground(new Color(255,204,204));
        l4.setFont(new Font("Trebuchet MS",1,16));
        l4.setForeground(new Color(102,51,0));
        l4.setBounds(110,180,170,30);
        add(l4);
        
        t2 =new JTextField();
        t2.setBackground(new Color(232,232,232));
        t2.setBounds(240, 180, 320, 30);
        add(t2);
        
        l5 = new JLabel("Gender = ");
        l5.setBackground(new Color(255,204,204));
        l5.setFont(new Font("Trebuchet MS",1,16));
        l5.setForeground(new Color(102,51,0));
        l5.setBounds(110,230,170,30);
        add(l5);
        
        r1= new JRadioButton("Male", true);
        r1.setBackground(Color.white);
        r1.setBounds(240,230,80,30);
        add(r1);
        
        r2= new JRadioButton("Female");
        r2.setBackground(Color.white);
        r2.setBounds(360,230,80,30);
        add(r2);
        
        r3= new JRadioButton("Other");
        r3.setBackground(Color.white);
        r3.setBounds(480,230,80,30);
        add(r3);
        
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        
        
        l6 = new JLabel("Date of Birth = ");
        l6.setBackground(new Color(255,204,204));
        l6.setFont(new Font("Trebuchet MS",1,16));
        l6.setForeground(new Color(102,51,0));
        l6.setBounds(110,280,170,30);
        add(l6);
        
        for(int i=0;i<31;i++){
            day[i]=String.valueOf(i+1);
        }
        
        c1= new JComboBox(day);
        c1.setBounds(240, 280, 60, 30);
        add(c1);
        
        c2= new JComboBox(month);
        c2.setBounds(330, 280, 110, 30);
        add(c2);
        
        for(int i=0;i<26;i++){
            year[i]=String.valueOf(i+1990);
        }
        
        c3= new JComboBox(year);
        c3.setBounds(480, 280, 80, 30);
        add(c3);
        
        l7 = new JLabel("Email Address = ");
        l7.setBackground(new Color(255,204,204));
        l7.setFont(new Font("Trebuchet MS",1,16));
        l7.setForeground(new Color(102,51,0));
        l7.setBounds(110,330,170,30);
        add(l7);
        
        t3 =new JTextField();
        t3.setBackground(new Color(232,232,232));
        t3.setBounds(240, 330, 320, 30);
        add(t3);
        
        l8 = new JLabel("Address = ");
        l8.setBackground(new Color(255,204,204));
        l8.setFont(new Font("Trebuchet MS",1,16));
        l8.setForeground(new Color(102,51,0));
        l8.setBounds(110,380,170,30);
        add(l8);
        
        ta1= new JTextArea();
        ta1.setBackground(new Color(232,232,232));
        ta1.setBounds(240,376,320,50);
        add(ta1);
        
        b1= new JButton("Next");
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setFont(new Font("Tahoma",1,16));
        b1.setForeground(Color.black);
        b1.setBounds(575,465,110,40);;
        add(b1);
        b1.addActionListener(this);
        
        b2= new JButton("Cancel");
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setFont(new Font("Tahoma",1,16));
        b2.setForeground(Color.black);
        b2.setBounds(20,465,110,40);
        add(b2);
        b2.addActionListener(this);
        repaint();
    }
    public void actionPerformed(ActionEvent e){
        String name, contact, gender="",dob="",gmail,address;
        name= t1.getText();
        contact= t2.getText();
        
        if(r1.isSelected()){
            gender="Male";
        }
        else if(r2.isSelected()){
            gender="Female";
        }
        else
            gender="Other";
        
        dob=String.valueOf(c1.getSelectedItem())+"/"+String.valueOf(c2.getSelectedItem())+"/"+String.valueOf(c3.getSelectedItem());
        gmail=t3.getText();
        address=ta1.getText();
        
        if(e.getSource()==b1){
            if(name.equals("")||gmail.equals("")||address.equals("")){
                JOptionPane.showMessageDialog(null,"Feilds cannot be empty!");
            }
            else{
                conn c= new conn();
                String q="Insert into FirstPage values('"+no+"','"+name+"','"+contact+"','"+gender+"','"+dob+"','"+gmail+"','"+address+"')";
                try{
                    int msg=c.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Data Inserted Successfully!");
                    setVisible(false);
                    new SecondPage(no);
                }
                catch(SQLException ex){
                    Logger.getLogger(FirstPage.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }
        else
            setVisible(false);
    }
    public static void main(String[] args){
       new FirstPage();
    }
}