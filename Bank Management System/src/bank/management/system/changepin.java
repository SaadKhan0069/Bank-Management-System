package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class changepin extends JFrame implements ActionListener{
 JLabel l1,l2,l3,l4;
 JTextField t1,t2,t3;
 JButton b1,b2;
 public changepin(){
     super("Bank Management System");
     setBounds(150,80,600,530);
     setVisible(true);
     setLayout(null);
     
     l1=new JLabel("CHANGE THE PIN");
     l1.setBackground(new Color(255,255,255));
     l1.setFont(new Font("Tahoma",1,18));
     l1.setForeground(new Color(63,154,142));
     l1.setBounds(210,50,230,40);
     add(l1);
     
     l2=new JLabel("Enter Old PIN =");
     l2.setBackground(new Color(255,255,255));
     l2.setFont(new Font("Tahoma",1,14));
     l2.setForeground(Color.black);
     l2.setBounds(80,130,160,30);
     add(l2);
     
     t1=new JTextField();
     t1.setBounds(290,130,220,30);
     add(t1);
     
     l3=new JLabel("Enter New PIN =");
     l3.setBackground(new Color(255,255,255));
     l3.setFont(new Font("Tahoma",1,14));
     l3.setForeground(Color.black);
     l3.setBounds(80,190,160,30);
     add(l3);
     
     t2=new JTextField();
     t2.setBounds(290,190,220,30);
     add(t2);
     
     l4=new JLabel("Re-Enter New PIN =");
     l4.setBackground(new Color(255,255,255));
     l4.setFont(new Font("Tahoma",1,14));
     l4.setForeground(Color.black);
     l4.setBounds(80,250,160,30);
     add(l4);
     
     t3=new JTextField();
     t3.setBounds(290,250,220,30);
     add(t3);
     
     b1=new JButton("Change");
     b1.setBackground(Color.LIGHT_GRAY);
     b1.setFont(new Font("Tahoma",1,16));
     b1.setForeground(Color.black);
     b1.setBounds(140,320,110,30);
     add(b1);
     b1.addActionListener(this);
     
     b2=new JButton("Cancel");
     b2.setBackground(Color.LIGHT_GRAY);
     b2.setFont(new Font("Tahoma",1,16));
     b2.setForeground(Color.black);
     b2.setBounds(300,320,110,30);
     add(b2);
     b2.addActionListener(this);
     
     repaint();
 }
 public void actionPerformed(ActionEvent e){
     try{
         conn c=new conn();
         String q="Select * from ThirdPage where pin='"+t1.getText()+"";
         ResultSet rs=c.s.executeQuery(q);
         
         if(e.getSource()==b1){
             if(rs.next()){
                 if(t2.getText().length()==4){
                     if(t2.getText().equals(t3.getText())){
                         String q1="Update ThirdPage set pin='"+t2.getText()+"where pin='"+t1.getText()+"'";
                         c.s.executeUpdate(q1);
                         String q2="Update login set pin='"+t2.getText()+"'where pin='"+t1.getText()+"'";
                         c.s.executeUpdate(q2);
                         
                         JOptionPane.showMessageDialog(null,"PIN Changed Successfully!");
                         t1.setText("");
                         t2.setText("");
                         t3.setText("");
                         setVisible(false);
                         new transaction();
                     }
                     else
                         JOptionPane.showMessageDialog(null,"New PIN Mismatch!");
                 }
                 else
                 JOptionPane.showMessageDialog(null,"Check Your PIN Length");
             }
             else
                 JOptionPane.showMessageDialog(null,"No Such PIN Exist!");
         }
     }
     catch(SQLException ex){
          Logger.getLogger(changepin.class.getName()).log(Level.SEVERE,null,ex);
     }
 }
 public static void main(String[] args){
       new changepin();
    }
}