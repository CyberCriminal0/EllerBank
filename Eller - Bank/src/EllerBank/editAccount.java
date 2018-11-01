package EllerBank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;


public class editAccount {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://mora:3306/jacksmysqluser";

	static final String USER = "jacksmysqluser";
	static final String PASS = "LG6pM5pNybXH73yX";
	private String output;
	private double bal;

	public editAccount(){
		
	}
	public String setUser(int accnt, double bal){
		
		
		
		Connection conn = null;
		Statement stmt = null;
		
		String firstN;
		String lastN;
		int accntNum;
		double balance;
		
		try{
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Editing database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connection Success!");
		      System.out.println("Edit...");
		      String get = "SELECT * FROM Bank WHERE account=?;";
		      stmt = conn.prepareStatement(get);
                      stmt.setInt(1, accnt);
		      ResultSet rs = stmt.executeQuery();
		      if(rs.next()) { 
			   String query = "update Bank set balance = ? where `account` = ?";
			   Statement updateEXP = conn.prepareStatement();
                           updateEXP.setDouble(1, bal);
                           updateEXP.setInt(2, accnt);
			   int updateEXP_done = updateEXP.executeUpdate(query);
		       int str1 = rs.getInt("account");
		       String dataName = rs.getString("first");
		       String out = ("Changes made");
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
}

