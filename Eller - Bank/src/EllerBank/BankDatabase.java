package EllerBank;

import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankDatabase {

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://mora:3306/jacksmysqluser";

	static final String USER = "jacksmysqluser";
	static final String PASS = "LG6pM5pNybXH73yX";
	private String output;
	private double bal;
	

	public BankDatabase(){
		
	}
	

public String setUser(String first, String last, int accnt, double bal){
		
	
	
		Connection conn = null;
		Statement stmt = null;
		
		String firstN;
		String lastN;
		int accntNum;
		double balance;
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Adding user to bank database");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connection Success!");
		      System.out.println("Adding user...");
		      stmt = conn.createStatement();
		      String sql = "INSERT INTO Bank " +
		                   "VALUES ('"+first+"', '"+last+"', '"+accnt+"', '"+bal+"')";
		      stmt.executeUpdate(sql);
		      String get = ("SELECT * FROM Bank WHERE account=" + accnt +";");
		      ResultSet rs = stmt.executeQuery(get);
		      if(rs.next()) { 
		       int str1 = rs.getInt("account");
		       String dataName = rs.getString("first");
		       String out = ("Thanks " + dataName +"! You now have an account! \nPlease remember this account number \n" + str1 +" \nor you will not be able to access your account!");
		       this.output = out;


		       
		      }
		      
		      
		      

		      conn.close();

		   }catch(SQLException se){
		      se.printStackTrace();
		      output = null;
		   }catch(Exception e){
			      output = null;
		      e.printStackTrace();
		   }finally{
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }
		   }
		
		   System.out.println("Goodbye!");
		   return output;
		

	}
public void getAccount(String accnt, String name){
	
	Connection conn = null;
	Statement stmt = null;
	
	String firstN;
	String lastN;
	int accntNum;
	double balance;
	
	try{
	      Class.forName("com.mysql.jdbc.Driver");
	      System.out.println("Adding user to bank database");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connection Success!");
	      System.out.println("Getting user...");
	      stmt = conn.createStatement();
	      String get = ("SELECT * FROM Bank WHERE account=" + accnt +";");
	      ResultSet rs = stmt.executeQuery(get);
	      if(rs.next()) { 
	       int str1 = rs.getInt("account");
	       String dataName = rs.getString("first");
	       double bal1 = rs.getDouble("balance");
		   System.out.println("Debug: " + str1 + " " + dataName + " " + bal1);
		   this.output = str1+"";
		   this.bal = bal1;
	      }


	      conn.close();

	   }catch(SQLException se){
	      se.printStackTrace();
	      output = null;
	   }catch(Exception e){
		      output = null;
	      e.printStackTrace();
	   }finally{
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
	
	   System.out.println("Goodbye!");
	   
	
	
	
}
public String getOutput() {
	return output;
}
public double getBal() {
	return bal;
}





}







































//Used to create new table, ignore unless needed
/** package EllerBank;

import java.sql.*;

public class BankDatabase {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://mora:3306/jacksmysqluser";

   static final String USER = "jacksmysqluser";
   static final String PASS = "LG6pM5pNybXH73yX";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE REGISTRATION " +
              "(id INTEGER not NULL, " +
              " first VARCHAR(255), " + 
              " last VARCHAR(255), " + 
              " account INTEGER, " + 
              " balance DOUBLE, " + 
              " PRIMARY KEY ( id ));"; 

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
   }catch(SQLException se){

      se.printStackTrace();
   }catch(Exception e){

      e.printStackTrace();
   }finally{

      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }
   }
   System.out.println("Goodbye!");
}//end main
}//end JDBCExample



/**package EllerBank;

import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankDatabase {

	public static void main(String[] args) {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;
	Connection conn = null;
	Statement stmt = null;

        String url = "jdbc:mysql://mora:3306/jacksmysqluser";
        String user = "jacksmysqluser";
        String password = "LG6pM5pNybXH73yX";

        try {
            System.out.println("Connecting to database...");
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println("Success! mySQL version is: " + rs.getString(1));
            }
	    
	          stmt = conn.createStatement();

            String sql = "CREATE TABLE REGISTRATION " +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " + 
                    " last VARCHAR(255), " + 
                    " account INTEGER, " + 
                    " balance DOUBLE, " + 
                    " PRIMARY KEY ( id ));"; 

            st.executeUpdate(sql);   
            System.out.println("Created table!");


        } catch (SQLException ex) {

ex.printStackTrace();

        } 
        
        
        
        
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {

            }
        }
    }
}
**/