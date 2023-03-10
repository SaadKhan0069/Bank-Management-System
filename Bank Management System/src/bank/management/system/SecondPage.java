package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecondPage extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3;
    JComboBox c1,c2,c3,c4;
    JButton b1,b2;
    String form_no;
    
    public SecondPage(int x){
        super("Bank Management System");
        form_no = String.valueOf(x);
        
        setBounds(150,80,710,527);
        getContentPane().setBackground(Color.white);
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
        
        l2=new JLabel("Page 02 : ADDITIONAL DETAILS");
        l2.setBackground(Color.black);
        l2.setFont(new Font("Tahoma",1,18));
        l2.setForeground(new Color(0,0,0));
        l2.setBounds(190,50,300,40);
        getContentPane().add(l2);
        
        l3=new JLabel("Religion :");
        l3.setBackground(new Color(255,204,204));
        l3.setFont(new Font("Trebuchet MS",1,16));
        l3.setForeground(new Color(102,51,0));
        l3.setBounds(120,130,160,30);
        add(l3);
        
        String religion[]={"Muslim","Hindu","Sikh","Christian","Other"};
        c1=new JComboBox(religion);
        c1.setBounds(240,130,250,30);
        add(c1);
        
        l4=new JLabel("Catagory :");
        l4.setBackground(new Color(255,204,204));
        l4.setFont(new Font("Trebuchet MS",1,16));
        l4.setForeground(new Color(102,51,0));
        l4.setBounds(120,180,170,30);
        add(l4);
        
        String catagory[]={"General","OBC","SC","ST","Other"};
        c2=new JComboBox(catagory);
        c2.setBounds(240,180,250,30);
        add(c2);
        
        l5=new JLabel("Occupation :");
        l5.setBackground(new Color(255,204,204));
        l5.setFont(new Font("Trebuchet MS",1,16));
        l5.setForeground(new Color(102,51,0));
        l5.setBounds(120,230,170,30);
        add(l5);
        
        String occupation[]={"Salaried","Self-Employeed","Business","Student","Retired","Other"};
        c3=new JComboBox(occupation);
        c3.setBounds(240,230,250,30);
        add(c3);
        
        l6=new JLabel("Education :");
        l6.setBackground(new Color(255,204,204));
        l6.setFont(new Font("Trebuchet MS",1,16));
        l6.setForeground(new Color(102,51,0));
        l6.setBounds(120,280,170,30);
        add(l6);
        
        String education[]={"Matric","Intermidiate","Graduate","Post-Graduate","Non-Graduate"};
        c4=new JComboBox(education);
        c4.setBounds(240,280,250,30);
        add(c4);
        
        l7=new JLabel("CNIC No :");
        l7.setBackground(new Color(255,204,204));
        l7.setFont(new Font("Trebuchet MS",1,16));
        l7.setForeground(new Color(102,51,0));
        l7.setBounds(120,330,170,30);
        add(l7);
        
        t2=new JTextField();
        t2.setBounds(240, 330,250,30);
        add(t2);
        
        l8=new JLabel("PAN Number :");
        l8.setBackground(new Color(255,204,204));
        l8.setFont(new Font("Trebuchet MS",1,16));
        l8.setForeground(new Color(102,51,0));
        l8.setBounds(120,380,170,30);
        add(l8);
        
        t3=new JTextField();
        t3.setBounds(240, 380,250,30);
        add(t3);
        
        b1=new JButton("Next");
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
    }
    
    public void actionPerformed(ActionEvent e){
        String form,rel,cat,occ,edu,aad,pan;
        rel=(String) c1.getSelectedItem();
        cat=(String) c2.getSelectedItem();
        occ=(String) c3.getSelectedItem();
        edu=(String) c4.getSelectedItem();
        aad=t2.getText();
        pan=t3.getText();
        
        conn c=new conn();
        form=t1.getText();
        int aa=1;
        if(e.getSource()==b1){
            if(form_no.equals(form)){
                if(t1.getText().equals("")||t2.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please Check All Input Fields");
                }
                else{
                    try{
                        String q="Insert into SecondPage values('"+form_no+"','"+rel+"','"+cat+"','"+occ+"','"+edu+"','"+aad+"','"+pan+"')";
                        int result=c.s.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Data Inserted Successfully");
                        setVisible(false);
                        new ThirdPage(form_no);
                    }
                    catch(Exception ex){
                        Logger.getLogger(SecondPage.class.getName()).log(Level.SEVERE,null,ex);
                    }
                }
            }
        }
        else{
            try{
                String q2="'Delete from FirstPage where id='"+form_no+"' ";
                c.s.executeUpdate(q2);
                setVisible(false);
            }
            catch(SQLException ex){
                Logger.getLogger(SecondPage.class.getName()).log(Level.SEVERE,null,ex);
            }            
        }
    }
}