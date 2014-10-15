package EllerBank;

import java.util.Scanner;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BankDatabase {

	public static void main(String[] args) {
		Connection con = null;
        Statement st = null;
        ResultSet rs = null;

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
            String sql = "CREATE TABLE" +
                    "(id INTEGER not NULL, " +
                    " first VARCHAR(255), " + 
                    " last VARCHAR(255), " + 
                    " account INTEGER, " + 
                    " balance DOUBLE, " + 
                    " PRIMARY KEY ( id ));"; 

            st.executeUpdate(sql);   
         

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