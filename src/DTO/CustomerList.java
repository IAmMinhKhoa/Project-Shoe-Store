package DTO;

import java.util.ArrayList;

public class CustomerList {
	private ArrayList<Customer> customerList;

	public CustomerList() {
		this.customerList = new ArrayList<Customer>();
	}

	public CustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
	
	public void insert (Customer customer)
	{
		this.customerList.add(customer);
	}
	
	public void delete (Customer customer) {
		this.customerList.remove(customer);
	}
	
	public void update (Customer customer) {
		this.customerList.remove(customer);
		this.customerList.add(customer);
	}
}
