package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class withdrawl extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField t1,t2,t3;
    JButton b1,b2;
    
    public withdrawl(){
        super("Bank Management System");
        setBounds(150,80,600,500);
        setVisible(true);
        setLayout(null);
        
        l1=new JLabel("MONEY WITHDRAWL");
        l1.setBackground(new Color(255,255,255));
        l1.setFont(new Font("Tahoma",1,20));
        l1.setForeground(new Color(63,154,142));
        l1.setBounds(210,50,230,40);
        add(l1);
        
        l2=new JLabel("Enter Your PIN =");
        l2.setBackground(new Color(255,255,255));
        l2.setFont(new Font("Tahoma",1,14));
        l2.setForeground(Color.black);
        l2.setBounds(80,130,160,30);
        add(l2);
        
        t1=new JTextField();
        t1.setBounds(290,130,220,30);
        add(t1);
        
        l2=new JLabel("Enter Amout To Withdraw =");
        l2.setBackground(new Color(255,255,255));
        l2.setFont(new Font("Tahoma",1,14));
        l2.setForeground(Color.black);
        l2.setBounds(80,190,220,30);
        add(l2);
        
        t2=new JTextField();
        t2.setBounds(290,190,220,30);
        add(t2);
        
        b1=new JButton("Withdraw");
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setFont(new Font("Tahoma",1,16));
        b1.setForeground(Color.black);
        b1.setBounds(320,300,130,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setFont(new Font("Tahoma",1,16));
        b2.setForeground(Color.black);
        b2.setBounds(120,300,130,30);
        add(b2);
        b2.addActionListener(this);
        
        repaint();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            try{
                conn c=new conn();
                String q="Select * from login where pin='"+t1.getText()+"'";
                ResultSet rs=c.s.executeQuery(q);
                if(rs.next()){
                    int bal=rs.getInt(3);
                    int amount=Integer.parseInt(t2.getText());
                    int rem=bal-amount;
                    
                    if(bal>amount){
                        String q1="Update login set balance='"+rem+"'where pin='"+t1.getText()+"'";
                        c.s.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null,"Money Withdraw Successfull!");
                        t1.setText("");
                        t2.setText("");
                    }
                    else
                    JOptionPane.showMessageDialog(null,"Insufficient Balance!");
                }
                else
                    JOptionPane.showMessageDialog(null,"Entered PIN is Invalid!");
            }
            catch(SQLException ex){
                Logger.getLogger(changepin.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        else{
            setVisible(false);
            new transaction();
        }
    }
    public static void main(String[] args){
       new withdrawl();
    }
}
