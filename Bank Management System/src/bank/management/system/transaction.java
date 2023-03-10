package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class transaction extends JFrame implements ActionListener{
    
    JLabel l1;
    JButton b1,b2,b5,b6,b7;
    
    public transaction(){
        super("Bank Management System");
        setBounds(150,80,600,554);
        setVisible(true);
        setLayout(null);
        
        l1=new JLabel("Please Select Your Transaction");
        l1.setBackground(new Color(255,204,204));
        l1.setFont(new Font("Trebuchet MS",1,21));
        l1.setForeground(new Color(63,154,142));
        l1.setBounds(170,40,300,40);
        add(l1);
        
        b1=new JButton("Pin Change");
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setFont(new Font("Tahoma",1,16));
        b1.setForeground(Color.black);
        b1.setBounds(80,130,200,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Balance Enquiry");
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setFont(new Font("Tahoma",1,16));
        b2.setForeground(Color.black);
        b2.setBounds(310,130,200,30);
        add(b2);
        b2.addActionListener(this);
        
        b5=new JButton("Cash Withdrawl");
        b5.setBackground(Color.LIGHT_GRAY);
        b5.setFont(new Font("Tahoma",1,16));
        b5.setForeground(Color.black);
        b5.setBounds(80,210,200,30);
        add(b5);
        b5.addActionListener(this);
        
        b6=new JButton("Deposit");
        b6.setBackground(Color.LIGHT_GRAY);
        b6.setFont(new Font("Tahoma",1,16));
        b6.setForeground(Color.black);
        b6.setBounds(310,210,200,30);
        add(b6);
        b6.addActionListener(this);
        
        b7=new JButton("Exit");
        b7.setBackground(Color.LIGHT_GRAY);
        b7.setFont(new Font("Tahoma",1,16));
        b7.setForeground(Color.black);
        b7.setBounds(210,270,180,40);
        add(b7);
        b7.addActionListener(this);

        repaint();
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            setVisible(false);
            new changepin();
        }
        else if(e.getSource()==b2){
            try{
                String pin=JOptionPane.showInputDialog("Enter Your PIN = ");
                conn c=new conn();
                String q="Select * from login where pin='"+pin+"'";
                ResultSet rs=c.s.executeQuery(q);
                
                if(rs.next()){
                    int balance=rs.getInt(3);
                    JOptionPane.showMessageDialog(null,"Your Balance is = "+balance);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid PIN Entered!");
                }
            }
            catch(SQLException ex){
                Logger.getLogger(transaction.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
        else if(e.getSource()==b5){
            setVisible(false);
            new deposit();
        }
        else if(e.getSource()==b6){
            setVisible(false);
            //new withdrawl();
        }
        else if(e.getSource()==b7){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args){
       new transaction();
    }
}