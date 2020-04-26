import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 


//Justin Weagly test commit to file. Trying to do something. Can you see this but not the gui. The red went away
// hollie 
//Melissa was here

public class ConnectDB {  //This main class will oversee the entire program? -Justin
    
    public static void main(String[] args) { //This is the main method, 
        //to keep the program organized, this method should only contains calls to void methods that don't take paremeters. 
        //Doing this allows us to try out different code blocks easily by commenting out all calls but the one being tested
    CustomerTest(); //Calls the original test method. 
    
    }
    
    public static void CustomerTest() { //This was orginally the main method and tested connections by printing customer names.
        //It has been moved to this method for organizational purposes. 
        
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
