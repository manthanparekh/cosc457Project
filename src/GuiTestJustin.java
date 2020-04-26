/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Justin
 */
public class GuiTestJustin extends javax.swing.JFrame { //class created to test gui and jar
    GUI gooey = new GUI(); //creating a gui because the gui insists on being private for some reason. 
    public GuiTestJustin() {
        gooey.unlock();
    }
    public ArrayList<User> userList() {
        ArrayList<User> usersList = new ArrayList<>();
        
        
         //Time to make the connection...
        
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
            User user;
            while(rs.next()){
                user=new User(rs.getString("fName"), rs.getString("lName"));
                usersList.add(user);
            }
            
            //The while statement to print names used to go right below here
            
            
        }catch(SQLException e) {
            System.err.println(e);
        }
        return usersList;
        
    }
    public void show_user() {
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)gooey.jTable_Display_User.getModel();
        Object[] row = new Object[2];
        for(int i=0; i<list.size();i++){
            row[0] = list.get(i).getfName();
            row[1] = list.get(i).getlName();
            model.addRow(row);
        }
    }
}
