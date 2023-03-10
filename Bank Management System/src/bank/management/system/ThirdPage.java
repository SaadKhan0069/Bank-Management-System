package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThirdPage extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1;
    JRadioButton r1,r2,r3,r4;
    ButtonGroup bg;
    JCheckBox c1,c2,c3,c4,c5,c6;
    JButton b1,b2;
    Random r20,r21,r22,r23,r24;
    int n1,n2,n3,n4,pin;
    String card,form_no;
    
    public ThirdPage(String x){
        super("Bank Management System");
        form_no= x;
        setBounds(150,80,710,527);
        setVisible(true);
        setLayout(null);
        
        l1=new JLabel("Form_No :");
        l1.setBackground(new Color(255,204,204));
        l1.setFont(new Font("Trebuchet MS",1,14));
        l1.setForeground(new Color(102,51,0));
        l1.setBounds(525,10,100,20);
        getContentPane().add(l1);
        
        t1=new JTextField(form_no);
        t1.setBounds(600, 10,70,20);
        add(t1);
        
        l2=new JLabel("Page 03 : ACCOUNT DETAILS");
        l2.setBackground(Color.black);
        l2.setFont(new Font("Tahoma",1,18));
        l2.setForeground(new Color(0,0,0));
        l2.setBounds(190,50,300,40);
        getContentPane().add(l2);
        
        l3=new JLabel("Account Type :");
        l3.setBackground(new Color(255,255,255));
        l3.setFont(new Font("Trebuchet MS",1,16));
        l3.setForeground(new Color(51,51,255));
        l3.setBounds(80,70,120,30);
        add(l3);
        
        r1= new JRadioButton("Saving Account");
        r1.setBackground(new Color(0,0,0));
        r1.setFont(new Font("Tahoma",1,12));
        r1.setForeground(new Color(255,255,255));
        r1.setBounds(180,110,130,30);
        add(r1);
        
        r2= new JRadioButton("Fixed Deposit Account");
        r2.setBackground(new Color(0,0,0));
        r2.setFont(new Font("Tahoma",1,12));
        r2.setForeground(new Color(255,255,255));
        r2.setBounds(340,110,190,30);
        add(r2);
        
        r3= new JRadioButton("Current Account");
        r3.setBackground(new Color(0,0,0));
        r3.setFont(new Font("Tahoma",1,12));
        r3.setForeground(new Color(255,255,255));
        r3.setBounds(180,160,130,30);
        add(r3);
        
        r4= new JRadioButton("Recurring Deposit Account");
        r4.setBackground(new Color(0,0,0));
        r4.setFont(new Font("Tahoma",1,12));
        r4.setForeground(new Color(255,255,255));
        r4.setBounds(340,160,190,30);
        add(r4);
        
        bg=new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        
        l4=new JLabel("Card Number: ");
        l4.setBackground(new Color(255,255,255));
        l4.setFont(new Font("Trebuchet MS",1,16));
        l4.setForeground(new Color(51,51,255));
        l4.setBounds(80,220,120,30);
        add(l4);
        
        r24=new Random();
        n4=1000+r24.nextInt(9999-1000);
        
        l5=new JLabel("XXXX-XXXX-XXXX-"+n4);
        l5.setBackground(new Color(0,0,0));
        l5.setFont(new Font("Trebuchet MS",1,16));
        l5.setForeground(new Color(51,51,255));
        l5.setBounds(240,220,190,30);
        add(l5);
        
        l6=new JLabel("PIN: ");
        l6.setBackground(new Color(0,0,0));
        l6.setFont(new Font("Trebuchet MS",1,16));
        l6.setForeground(new Color(51,51,255));
        l6.setBounds(80,260,120,30);
        add(l6);
        
        l7=new JLabel("XXXX");
        l7.setBackground(new Color(0,0,0));
        l7.setFont(new Font("Trebuchet MS",1,16));
        l7.setForeground(new Color(51,51,255));
        l7.setBounds(240,260,230,30);
        add(l7);
        
        l8=new JLabel("Services Required:");
        l8.setBackground(new Color(0,0,0));
        l8.setFont(new Font("Trebuchet MS",1,16));
        l8.setForeground(new Color(51,51,255));
        l8.setBounds(80,310,140,30);
        add(l8);
        
        c1=new JCheckBox("ATM Card");
        c1.setBackground(new Color(0,0,0));
        c1.setFont(new Font("Trebuchet MS",1,16));
        c1.setForeground(new Color(255,255,255));
        c1.setBounds(190,350,120,23);
        add(c1);
        
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(new Color(0,0,0));
        c2.setFont(new Font("Trebuchet MS",1,12));
        c2.setForeground(new Color(255,255,255));
        c2.setBounds(340,350,140,23);
        add(c2);
        
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(0,0,0));
        c3.setFont(new Font("Trebuchet MS",1,12));
        c3.setForeground(new Color(255,255,255));
        c3.setBounds(190,390,120,23);
        add(c3);
        
        c4=new JCheckBox("Email Alerts");
        c4.setBackground(new Color(0,0,0));
        c4.setFont(new Font("Trebuchet MS",1,12));
        c4.setForeground(new Color(255,255,255));
        c4.setBounds(340,390,140,23);
        add(c4);
        
        c5=new JCheckBox("Cheque Book");
        c5.setBackground(new Color(0,0,0));
        c5.setFont(new Font("Trebuchet MS",1,12));
        c5.setForeground(new Color(255,255,255));
        c5.setBounds(190,430,120,23);
        add(c5);
        
        c6=new JCheckBox("E-Statement");
        c6.setBackground(new Color(0,0,0));
        c6.setFont(new Font("Trebuchet MS",1,12));
        c6.setForeground(new Color(255,255,255));
        c6.setBounds(190,430,120,23);
        add(c6);
        
        b1=new JButton("Submit");
        b1.setBackground(Color.LIGHT_GRAY);
        b1.setFont(new Font("Tahoma",1,16));
        b1.setForeground(Color.black);
        b1.setBounds(565,450,110,30);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.LIGHT_GRAY);
        b2.setFont(new Font("Tahoma MS",1,16));
        b2.setForeground(Color.black);
        b2.setBounds(20,450,110,30);
        add(b2);
        b2.addActionListener(this);
        
        repaint();
        
        r20=new Random();
        pin=1000+r20.nextInt(9999-1000);
        
        r21=new Random();
        n1=1000+r20.nextInt(9999-1000);
        
        r22=new Random();
        n2=1000+r20.nextInt(9999-1000);
        
        r23=new Random();
        n3=1000+r20.nextInt(9999-1000);
        
        card=String.valueOf(n1)+String.valueOf(n2)+String.valueOf(n3)+String.valueOf(n4);
    }
    public void actionPerformed(ActionEvent e){
        String account="",services="";
        if(r1.isSelected())
            account="Saving Account";
        else if(r2.isSelected())
                account="Fixed Deposit Account";
        else if(r3.isSelected())
                account="Current Account";
        else if(r4.isSelected())
                account="Recurring Deposit Account";
        
        if(c1.isSelected())
            services="ATM Card";
        if(c2.isSelected())
            services=services+"Internet Banking";
        if(c3.isSelected())
            services=services+"Mobile Banking";
        if(c4.isSelected())
            services=services+"Email Alert";
        if(c4.isSelected())
            services=services+"Cheque Book";
        if(c5.isSelected())
            services=services+"E-Statement";
        
        conn c=new conn();
        if(e.getSource()==b1){
            if(form_no.equals(t1.getText())){
                try{
                    String q="Insert into ThirdPage values ('"+form_no+"','"+card+"','"+pin+"','"+account+"','"+services+"'";
                    c.s.executeUpdate(q);
                    int bal=0;
                    String q1="Insert Into login (card,pin,balance) values('"+card+"','"+pin+"','"+bal+"'";
                    c.s.executeUpdate(q1);
                    
                    JOptionPane.showMessageDialog(null,"Your Card Number = "+card+"\nYour Pin = "+pin);
                    setVisible(false);
                    new transaction();
                }
                catch(SQLException ex){
                    Logger.getLogger(ThirdPage.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Check Your Form Number");
            }
        }
        else{
            try{
                String q="delete from FirstPage where id='"+form_no+"'";
                String q1="delete from SecondPage where id='"+form_no+"'";
                c.s.executeUpdate(q);
                c.s.executeUpdate(q1);
                setVisible(false);
            }
            catch(SQLException ex){
                Logger.getLogger(ThirdPage.class.getName()).log(Level.SEVERE,null,ex);
            }
    }
}
}