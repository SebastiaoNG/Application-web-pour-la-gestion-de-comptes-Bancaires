package org.upec.servlets;
import org.upec.comptes.Account;
import org.upec.comptes.Customer;

public interface AccountService {
public Customer addAccount(Account AcountNumber);
	
	public Account deleteAccount(int AcountNumber);
	
	public Account getAccount(int AcountNumber);
	
	public Account[] getAllAccount();

}
