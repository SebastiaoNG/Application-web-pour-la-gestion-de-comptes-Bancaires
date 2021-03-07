 package org.upec.servlets;
import java.awt.List;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.swing.JOptionPane;

import org.upec.comptes.Account;

public class AccountDAO {
	private String sql; 
	private Connection conne;
	private PreparedStatement stmt;
	private ResultSet rs;
	
//----------------------------------------------------------------------------------------------------------
	//get all compte
	public ArrayList<Account> getAllAccount() throws ClassNotFoundException, SQLException{
		ArrayList<Account> accounts = new ArrayList<>();
		 sql   = "SELECT * FROM Account";
		 conne = GestionBDD.Connection_DataBase();
		 //conne = GestionBDD.Connection_SQL();
		 stmt  = conne.prepareStatement(sql);
		 rs    = stmt.executeQuery();	
		 while(rs.next()){
			   Account A= null;
			   A = new Account(rs.getInt("accountNumber"),rs.getFloat("solde"),rs.getDate("creationDate"));
		       A.setAcountNumber(rs.getInt("accountNumber"));
		       A.setSolde(rs.getFloat("solde"));
		       A.setCreationDate(rs.getDate("creationDate"));    
		       System.out.println(rs.getDate("creationDate"));  
		       accounts.add(A); 
		       }
		  //GestionBDD.Deconnection_SQL();//deconnecter la base
		GestionBDD.Deconnection_DataBase();//deconnecter la base
		return accounts;	
	}
//----------------------------------------------------------------------------------------------------------------	
	//Add a Account  OK
	public  boolean AddAccount(Account account) throws ClassNotFoundException, SQLException{
		 try {
			 sql = "INSERT INTO Account(accountNumber,solde,creationDate) VALUES (?,?,?)";
			 conne = GestionBDD.Connection_DataBase();
			 //conne = GestionBDD.Connection_SQL();
			 PreparedStatement stmt = conne.prepareStatement(sql);
			 stmt.setInt(1,account.getAcountNumber());
			 stmt.setFloat(2,account.getSolde());
			 stmt.setDate(3, new Date(account.getCreationDate().getTime())); //à révoir: stmt.setDate(3,(Date) account.getCreationDate())
			 stmt.execute(); 
			 GestionBDD.Deconnection_DataBase(); 
			 //GestionBDD.Deconnection_SQL(); 
			 System.out.println("Deconnecting in to data base");
			 return true;
		 }
		  catch(SQLException ex){
			 Logger.getLogger(GestionBDD.class.getName()).log(Level.SEVERE,null,ex);
			 System.out.println("deconnecting data base ");
			return false;// si n'arrive pas dse connecter
		  }
	}
//------------------------------------------------------------------------------------------------------------------
	//Delete Account  OK
		public boolean DeleteAccount(Account account) throws ClassNotFoundException, SQLException{
			   //ArrayList<Account> accounts = new ArrayList<>();
				try {

					String sql = "delete from Account where accountNumber = ?";
					conne = GestionBDD.Connection_DataBase(); //MYSQL
					//conne = GestionBDD.Connection_SQL();
					stmt = conne.prepareStatement(sql);
					//stmt.setDouble(2,account.getSolde());
					//stmt.setDate(3, new Date(account.getCreationDate().getTime())); //à révoir: stmt.setDate(3,(Date) account.getCreationDate())
					stmt.setInt(1,account.getAcountNumber());
					stmt.executeUpdate();
					//GestionBDD.Deconnection_SQL();
					GestionBDD.Deconnection_DataBase(); //MYSQL
		            return true;
				    }catch (SQLException e) {
					 Logger.getLogger(GestionBDD.class.getName()).log(Level.SEVERE,null,e);
					 System.out.println("error ");
					 return false;
					}
				}
		
	//-------------------------------------------------------------------------------------------------------	
		
	//Update Acount   OK
		public  boolean updateAccount(Account account) throws ClassNotFoundException{
			 try {
				 sql = "UPDATE Account SET solde =?,creationDate =? WHERE  accountNumber=?";
				 conne = GestionBDD.Connection_DataBase();
				 //conne = GestionBDD.Connection_SQL();
				 stmt = conne.prepareStatement(sql);
				 stmt.setDouble(1,account.getSolde());
				 stmt.setDate(2, new Date(account.getCreationDate().getTime())); //à révoir: stmt.setDate(3,(Date) account.getCreationDate())
				 stmt.setInt(3,account.getAcountNumber());
				 stmt.executeUpdate(); 
				 //GestionBDD.Deconnection_SQL(); 
				 GestionBDD.Deconnection_DataBase(); //deconnection de la base de données
				 return true;
			 }
			  catch(SQLException ex){
				 Logger.getLogger(GestionBDD.class.getName()).log(Level.SEVERE,null,ex);
				 System.out.println("error ");
				return false;// si n'arrive pas dse connecter
			  }
		}
//-----------------------------------------------------------------------------------------------------------------
	
		/**/	
		//GET ID 
		/*
		 public ArrayList<Account> getID_AllAccount() throws ClassNotFoundException, SQLException{
			ArrayList<Account> accounts = new ArrayList<>();
			 sql   = "SELECT * FROM Account where accountNumber=?)";
			 conne = GestionBDD.Connection_DataBase();
			 stmt  = conne.prepareStatement(sql);
			 rs    = stmt.executeQuery();	
			 while(rs.next()){
				   Account A= null;
				   A = new Account(rs.getInt("accountNumber"),rs.getDouble("solde"),rs.getDate("creationDate"));
			       A.setAcountNumber(rs.getInt("accountNumber"));
			       A.setSolde(rs.getDouble("solde"));
			       A.setCreationDate(rs.getDate("creationDate"));    
			       accounts.add(A); 
			       }
			 GestionBDD.Deconnection_DataBase();//deconnecter la base
			return accounts;	
		}
		
//--------------------------------------------------------------------------------------------------------------------		
		
	*/	
		
	/*public static void main(String[] args)throws ClassNotFoundException, SQLException{
		   AccountDAO b = new AccountDAO();
		   //Connection_DataBase();
		   System.out.println(" Liste compte: "+b.getAllAccount());
		   //Deconnection_DataBase();
      }*/
}
