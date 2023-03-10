package bank.management.system;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conn {
    Connection c;
    Statement s;
    
    public conn(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        c=DriverManager.getConnection("jdbc:mysql://bank","root","");
        s=c.createStatement();
        }
        catch(Exception ex){
              Logger.getLogger(conn.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}