package org.upec.comptes;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Implementation {

	  public static void main(String[] args) throws ClassNotFoundException, SQLException 
	  {
		  
		System.out.println (" LISTE DE CLIENT ENREGISTREE SUR LA BASE DE DONNEE   ");  
        //GestionBDD bd = new GestionBDD(); //object pour recuperer la base de données sur Classe  GestionBDD
      	//bd.lectureBDD(); //afficher les données de la base de données sur web
      	 
      	
      	System.out.println (" \n IMPLEMENTATION DE CLASSES CREE"); 
//public Customer(int _num, String fName, String lName,String _Date)
		Customer seb = new Customer(5475,"SEBASTIAO","MASSI","01/04/2000");
		System.out.println (" Client");
		System.out.println ("*********************************** ");
		System.out.println ("Client Number:"+seb.getNum());
		System.out.println ("First Name: "+seb.getFirstName());
		System.out.println ("Laste Name: "+seb.getLastName());
		System.out.println ("BirthDay Date: "+seb.getBirthdate());
		System.out.println ("\n***********Compte**************");
		
	/**/
		
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    try {  
		        Date date1= formatter.parse("08/10/2000"); 
		        Date date3= formatter.parse("04/12/2004");
		        
		 //Account(int _accountNumber, float _solde, Date _creationDate, Customer _customer)
		         Account account1 = new Account(2432,13,date1);
				 System.out.println("Numero compte :"+ account1.getAcountNumber());
				 System.out.println("Ancien solde :"+ account1. getSolde() );
				 System.out.println("Date de creation :"+ account1. getCreationDate() );
				 System.out.println(" Customer full name :"+ account1.idCustomer.firstName+" "+account1.idCustomer.lastName);
				
				 System.out.println ("\n************Solde apres le depot************ ");
				 account1.deposition(55);//depot
				 System.out.println("Nouveau solde :"+ account1.getSolde()); //affichage nouveau solde
				 
				 System.out.println ("\n************Solde apres le retrait************ ");
				 account1.WithDraw(50); //retrait
				 System.out.println("solde :"+ account1.getSolde());
				 System.out.println("\n");
				 
				 //currentAccount(int _accountNumber, double _solde, Date _creationDate, Customer _customer, int _creditCardNumber,double _overdraft)
				 System.out.println ("************CURRENT ACCOUNT************ ");
				 currentAccount curAccount = new currentAccount(242,100,date1, 439045354, 300);
				 System.out.println("Ancien solde :"+ curAccount. getSolde() );
				 System.out.println("Date de creation :"+ curAccount. getCreationDate() );
				 System.out.println(" Customer full name :"+ curAccount.idCustomer.firstName+" "+account1.idCustomer.lastName);
				 System.out.println("currentCardNumber :"+ curAccount. getCreditCardNumber() );
				 System.out.println("Value Overdraft :"+ curAccount.getOverdraft());
				 System.out.println("");
				
				 
				  
				//savingAccount(int accountNumber, double solde, Date creationDate, Customer customer, double rate,Date AvailableAt)
				/**/	
				        System.out.println ("\n************SAVING ACCOUNT************ ");
						savingAccount sav_Account = new savingAccount(242, 435, date1, 34.2,date3 );
						System.out.println(" Customer full name :"+ sav_Account.idCustomer.firstName+" "+sav_Account.idCustomer.lastName);
						System.out.println("rate :"+ sav_Account. getRate() );
						System.out.println("available :"+ sav_Account.getAvailableAt() ); 
						System.out.println("date de creation :"+ sav_Account. getCreationDate() );
						System.out.println("\n\n");	 
						
		        //System.out.println("Date is: "+date1);  
		    } catch (ParseException e) {e.printStackTrace();}  
		    
		 //date1="21/01/2000";

	  } 
	  }
	  