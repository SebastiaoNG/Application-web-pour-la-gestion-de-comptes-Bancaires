package org.upec.comptes;

public class Customer {

	
	Account[]  ListAcount;
	private  int num;
	String firstName;
	String lastName;
	String birthdate;
	
	public Customer(){

	}
	
	//CONSTRUCTEU
	public Customer(int _num, String fName, String lName,String _Date){
		this.num = _num;
		this.firstName = fName;
		this.lastName =lName ;
		this.birthdate =_Date;
	}
	
	
	public Account[] getListAcount() {
		return ListAcount;
	}
	public void setListAcount(Account[] listAcount) {
		ListAcount = listAcount;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	

	
}
