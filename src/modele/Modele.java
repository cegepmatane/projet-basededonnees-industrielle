package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Modele 
{
	
	private Connection conn;
	static final String DB_URL = "jdbc:mysql://localhost/portmatane";
	
	static final String USER = "root";
	static final String PASS = "";
	
	
	public Modele() throws ClassNotFoundException, SQLException
	{
		conn = null;
		Statement stmt = null;
	      //STEP 2: Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      //STEP 3: Open a connection
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      
	      System.out.println("modele creer");
	}
	
	public void sauvegarderArmateur(Armateur armateur) throws SQLException
	{
		//System.out.println("modele: sauvegarde, " + armateur.getNom() + " id:" + armateur.getIdArmateur());
		
		//System.out.println("Creating statement...");
	      Statement stmt = conn.createStatement();
	      String sql;
	      sql = "UPDATE `armateur` SET `nom`= \"" + armateur.getNom() + "\" WHERE `idArmateur` = " + armateur.getIdArmateur();
	      System.out.println(sql);
	      stmt.executeUpdate(sql);
	}
}
