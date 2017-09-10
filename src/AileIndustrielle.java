import vue.VuePrincipale;
import java.sql.*;

public class AileIndustrielle 
{
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost/portmatane";
	
	static final String USER = "root";
	static final String PASS = "";
	
	@SuppressWarnings("static-access")
	public static void main(String[] args) 
	{
		Connection conn = null;
		   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		      
		      /*//STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT idArmateur, nom FROM armateur";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int idArmateur  = rs.getInt("idArmateur");
		         String nom = rs.getString("nom");

		         //Display values
		         System.out.print("ID: " + idArmateur);
		         System.out.println(", Nom: " + nom);
		         System.out.println("Allo");
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();*/
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		   
		   
		
		   VuePrincipale vuePrincipale = new VuePrincipale();
		   vuePrincipale.launch(VuePrincipale.class, args);
		
	}
}
