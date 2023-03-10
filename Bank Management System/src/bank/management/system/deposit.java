package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class deposit extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2,b3;
    public deposit(){
        super("Bank Management System");
        setBounds(150,80,660,500);
        setVisible(true);
        setLayout(null);
        
        l1=new JLabel("Enter PIN =");
        l1.setBackground(new Color(255,204,204));
        l1.setFont(new Font("Trebuchet MS",1,13));
        l1.setForeground(new Color(102,51,0));
        l1.setBounds(490,10,90,20);
        add(l1);
        
        t1=new JTextField();
        t1.setBounds(560,10,70,20);
        add(t1);
        
        l2=new JLabel("Enter Amount You Want to Deposit");
        l2.setBackground(new Color(255,204,204));
        l2.setFont(new Font("Trebuchet MS",1,18));
        l2.setForeground(new Color(63,154,142));
        l2.setBounds(170,70,400,20);
        add(l2);
        
        t2=new JTextField();
        t2.setBounds(180,130,280,40);
        add(t2);
        
        b1=new JButton("Deposit");
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setFont(new Font("Tahoma",1,16));
        b1.setForeground(Color.black);
        b1.setBounds(180,220,120,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setFont(new Font("Tahoma",1,16));
        b2.setForeground(Color.black);
        b2.setBounds(330,220,130,30);
        add(b2);
        b2.addActionListener(this);
        
        b3=new JButton("Exit");
        b3.setBackground(Color.LIGHT_GRAY);
        b3.setFont(new Font("Tahoma",1,16));
        b3.setForeground(Color.black);
        b3.setBounds(250,290,130,30);
        add(b3);
        b3.addActionListener(this);  
        
        repaint();
        
    }
    public void actionPerformed(ActionEvent e){
        try{
            conn c=new conn();
            int bal=Integer.parseInt(t2.getText());
            if(e.getSource()==b1){
                if(t1.getText()==" "||t2.getText()==" ")
                    JOptionPane.showMessageDialog(null,"Feilds can't be empty");
                else{
                    String q1="Update login set balance=balance+'"+bal+"'where pin='"+t1.getText()+"'";
                    int result=c.s.executeUpdate(q1);
                    if(result==1){
                        JOptionPane.showMessageDialog(null,"Amounts deposited successfully!");
                        t1.setText("");
                        t2.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please Check Your Pin or Amount!");
                    }
                }
            }
            else if(e.getSource()==b2){
                setVisible(false);
                new transaction();
            }
            else if(e.getSource()==b3){
                System.exit(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(deposit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args){
       new deposit();
    }
}