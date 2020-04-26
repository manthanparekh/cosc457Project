import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 


//Justin Weagly test commit to file 
// hollie 

public class ConnectDB {
    
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
          
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        
        final String ID = "emclau5"; 
        final String PW = "Cosc*r7e8"; 
        final String SERVER = "jdbc:mysql://triton.towson.edu:3360/"+ID+"db"; 
       
        
        try{
            Connection con = DriverManager.getConnection(SERVER,ID,PW); 
            Statement stmt = con.createStatement(); 
            
            ResultSet rs = stmt.executeQuery("Select * from Customers");
            
            while (rs.next()) {
                String Fname = rs.getString("FName"); 
                String Lname = rs.getString("LName"); 
                System.out.println(Fname + "," + Lname);
            }
            
        }catch(SQLException e) {
            System.err.println(e);
        }
        
        
    }
     
        
    
}
