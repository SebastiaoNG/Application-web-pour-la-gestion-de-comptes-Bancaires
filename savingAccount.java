package org.upec.comptes;
import java.util.Date;
public class savingAccount extends Account {
	
	double rate;
	Date AvailableAt;
	Date creationDate;
	
		//constructeur
	public savingAccount(int accountNumber, float solde, Date creationDate, double rate,Date AvailableAt)
	{
		super(accountNumber, solde, creationDate);
		this.rate = rate;
		this.AvailableAt =AvailableAt;
		this.creationDate = creationDate;
	}
	  public void simulateSaving() {
	  }
	  
	  public void Withdraw() {
	
		  }
	  
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public Date getAvailableAt() {
		return AvailableAt;
	}
	public void setAvailableAt(Date availableAt) {
		AvailableAt = availableAt;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
		
	

}
