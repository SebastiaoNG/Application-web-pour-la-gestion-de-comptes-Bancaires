package org.upec.servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.upec.comptes.Account;
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;





public class GestionBDD {

	private String sql; 
	private java.sql.PreparedStatement stmt;
	private ResultSet rs;
	
	//********MYSQL**********************************
	private static final String connectionUrl ="jdbc:mysql://localhost:3306/gestioncomptebancaire?useSSL=false&serverTimezone=UTC";
	//private static final String connectionUrl = "jdbc:sqlserver://localhost\\\\\\\\SQL2019:1433;database=GestionCompteBancaire;integratedSecurity=true;" ;
	private static  String MotPasse= "";
	private static  String USER= "root";
	private static  String DRIVER= "com.mysql.jdbc.Driver";
	private static  Connection conne;
	
	//CONNECTION MYSQL
	public static final Connection Connection_DataBase()throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER);
		conne = DriverManager.getConnection(connectionUrl,USER,MotPasse);
		System.out.println(" connecting MYSQL.....");
		return conne;
	}
	// deconnection mysql
	public static void Deconnection_DataBase(){
		try{
			System.out.println(" Deconnecting MYSQL.....");
			conne.close();
			}
		catch(SQLException ex){
			Logger.getLogger(GestionBDD.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
	
	
	//********CONNECTEION SQL**********************************
	private static final String Url_SQL = "jdbc:sqlserver://localhost:1433;database=GestionCompteBancaire&integratedSecurity=true;" ;
	//private static final String Url_SQL =  "jdbc:sqlserver://NANKUTA/SQLEXPRESS01:1433;database=GestionCompteBancaire;integratedSecurity=true;" ;
	private static  Connection conne_SQL;
	public static final Connection Connection_SQL ()throws ClassNotFoundException, SQLException{
			conne_SQL= DriverManager.getConnection(Url_SQL);
			System.out.println(" connecting SQL.....");
		return conne_SQL;
	}
	public static void Deconnection_SQL(){
		try{
			System.out.println(" Deconnecting SQL.....");
			conne_SQL.close();
			}
		catch(SQLException ex){
			Logger.getLogger(GestionBDD.class.getName()).log(Level.SEVERE,null,ex);
		}
}

	/*
	public  ArrayList<Account> getAll() throws ClassNotFoundException, SQLException{
		ArrayList<Account> accounts = new ArrayList<>();
		 Account A= null;
		 sql = "SELECT * FROM Account";
		 conne_SQL = GestionBDD.Connection_SQL();
		 stmt = conne_SQL.prepareStatement(sql);
		 rs = stmt.executeQuery();	
		 while(rs.next()){
			   A = new Account(rs.getInt("accountNumber"),rs.getDouble("solde"),rs.getDate("creationDate"));
		       A.setAcountNumber(rs.getInt("accountNumber"));
		       A.setSolde(rs.getDouble("solde"));
		       A.setCreationDate(rs.getDate("creationDate"));    
		       System.out.println("account sql :"+rs.getInt("accountNumber"));  
		       System.out.println("date sql :"+rs.getDate("creationDate"));  
		       accounts.add(A);    
		       }
		 GestionBDD.Deconnection_DataBase();//deconnecter la base
		return accounts;
	}
	*/
	/*public static void main(String[] args)throws ClassNotFoundException, SQLException{
		GestionBDD db = new GestionBDD();
		   //Connection_DataBase();
		   Connection_SQL();
		   System.out.println(" data: "+db.getAll());
		   //Deconnection_DataBase();
		   Deconnection_SQL();
      }*/
}
