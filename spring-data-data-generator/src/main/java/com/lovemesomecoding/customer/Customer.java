package com.lovemesomecoding.customer;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.employee.Employee;
import com.lovemesomecoding.order.Order;
import com.lovemesomecoding.paymentmethod.PaymentMethod;

@JsonInclude(value = Include.NON_NULL)
@Entity
@Table(name = "customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "credit_limit")
	private double creditLimit;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="address_id", nullable=true, updatable=true)
	private Address address;
	
	@JsonIgnoreProperties(value= {"customers"})
	@ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
    @JoinColumn(name = "sales_rep_id", nullable=true, updatable=true)
	private Employee employee;
	
	@JsonIgnoreProperties(value= {"customer"})
	@OneToMany(mappedBy = "customer", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Order> orders;
	
	@JsonIgnoreProperties(value= {"customer"})
	@OneToMany(mappedBy = "customer", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<PaymentMethod> paymentMethods;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	public void addOrders(Order order) {
		if(this.orders == null){
			this.orders = new HashSet<>();
		}
		this.orders.add(order);
	}

	public Set<PaymentMethod> getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(Set<PaymentMethod> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	
	public void addPaymentMethod(PaymentMethod paymentMethod) {
		if(this.paymentMethods == null){
			this.paymentMethods = new HashSet<>();
		}
		this.paymentMethods.add(paymentMethod);
	}
}
