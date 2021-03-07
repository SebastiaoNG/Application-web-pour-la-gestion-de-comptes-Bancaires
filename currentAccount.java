package org.upec.comptes;
import java.util.Date;
	//CONSTRUCTEUR
	/*public currentAccount (int num_credit_card) {
		this.creditCardNumber =num_credit_card;
	}
	*/
public class currentAccount extends Account {

		private long creditCardNumber;
		private double overdraft;

		 public currentAccount(int _accountNumber, float _solde, Date _creationDate, int _creditCardNumber,double _overdraft) {
			super(_accountNumber, _solde, _creationDate);
			this.creditCardNumber = _creditCardNumber;
			this.overdraft = _overdraft;
		}
		 
	


    public long getCreditCardNumber() {
			return creditCardNumber;
		}

		public void setCreditCardNumber(int creditCardNumber) {
			this.creditCardNumber = creditCardNumber;
		}

		public double getOverdraft() {
			return overdraft;
		}
		public void setOverdraft(double overdraft) {
			this.overdraft = overdraft;
		}

	public void Withdraw() 
	{

    }
}
