package org.upec.comptes;
import java.util.Date;
public class Account {

	Customer idCustomer;
	private  int AcountNumber;
	private float Solde;
	Date creationDate;
	
//constructeur
	public Account(int _accountNumber, float _solde, Date _creationDate) {
		super();
		this.AcountNumber = _accountNumber;
		this.Solde = _solde;
		this.creationDate = _creationDate;
		//this.idCustomer = _customer;
	}

	public void deposition(float depot) {
		  Solde = Solde+depot;
	  }
	 
		public void WithDraw(float valueWithDraw) {
			Solde = Solde-valueWithDraw;
	}
		
	  //getters et setters
	    public Customer getIdCustomer() {
		return idCustomer;
	}
	
	public void setIdCustomer(Customer idCustomer) {
		this.idCustomer = idCustomer;
	}


	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public float getSolde() {
		return Solde;
	}

	public void setSolde(float solde) {
		Solde = solde;
	}
	
	
	public int getAcountNumber() {
		return AcountNumber;
	}
	public void setAcountNumber(int acountNumber) {
		AcountNumber = acountNumber;
	}
}