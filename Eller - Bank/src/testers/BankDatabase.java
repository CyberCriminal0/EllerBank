
/**	
package testers;

import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankDatabase {

	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://mora:3306/jacksmysqluser";

	static final String USER = "jacksmysqluser";
	static final String PASS = "LG6pM5pNybXH73yX";
	public BankDatabase(){
		
	}
	

	   public static void main(String[] args) {

	
	
	
		Connection conn = null;
		Statement stmt = null;
		
		String firstN;
		String lastN;
		int accntNum;
		double balance;
		
		
		try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Adding user to bank database");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connection Success!");
		      
		      Statement st = conn.createStatement();
		      String sql = ("SELECT * FROM REGISTRATION ORDER BY id DESC LIMIT 1;");
		      ResultSet rs = st.executeQuery(sql);
		      if(rs.next()) { 
		       int id = rs.getInt("id"); 
		       int str1 = rs.getInt("account");
		       System.out.println(str1);
		      }
		      
		      

		      conn.close();


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
		   
	   
		
	}

}





**/



























	   

/**



//Used to create new table, ignore unless needed
package testers;

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
      
      String sql = "CREATE TABLE Bank " +
              " (first VARCHAR(255), " + 
              " last VARCHAR(255), " + 
              " account INTEGER, " + 
              " balance DOUBLE, " + 
              " PRIMARY KEY ( account ));"; 

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