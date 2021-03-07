
package org.upec.comptes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.Level;
//import org.upec.servlets.Connection_DB;



public class GestionBDD_original{
	
		/*	private static final String connectionUrl = "jdbc:sqlserver://localhost\\\\\\\\SQL2019:1433;database=GestionCompteBancaire;integratedSecurity=true;" ;
	private static  Connection conne;
	
	public static final Connection Connection_DataBase()throws ClassNotFoundException, SQLException{
		conne = DriverManager.getConnection(connectionUrl);
		System.out.println(" connecting.....");
		return conne;
	}
	
	public static void Deconnection_DataBase(){
		try{
			System.out.println(" Deconnecting.....");
			conne.close();
			}
		catch(SQLException ex){
			Logger.getLogger(GestionBDD.class.getName()).log(Level.SEVERE,null,ex);
		}
	}
Account comptes = null;
		public  ArrayList<Account> getAllAccount() throws ClassNotFoundException, SQLException{
			ArrayList<Account> accounts = new ArrayList<>();
			 Account A= null;
			 sql = "SELECT * FROM Account";
			 conne = GestionBDD.Connection_DataBase();
			 PreparedStatement stmt = conne.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery();	
			 while(rs.next()){
				   A = new Account(rs.getInt("accountNumber"),rs.getDouble("solde"),rs.getDate("creationDate"));
			       A.setAcountNumber(rs.getInt("accountNumber"));
			       A.setSolde(rs.getDouble("solde"));
			       A.setCreationDate(rs.getDate("creationDate"));    
			       System.out.println(rs.getDate("creationDate"));  
			       accounts.add(A);
			       
			       }
			 GestionBDD.Deconnection_DataBase();//deconnecter la base
			return accounts;
			
		}
	
		public void addAccount(Account account) {
			// TODO Auto-generated method stub
		} 
		
		public static void main(String[] args) throws ClassNotFoundException, SQLException{
			GestionBDD db = GestionBDD();
			   db.Connection_DataBase();
			   GestionBDD bdd = new GestionBDD();
			   System.out.println(" Liste compte: "+bdd.getAllAccount());
			   db.Deconnection_DataBase();
	      }*/
}


