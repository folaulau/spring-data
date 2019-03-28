package com.lovemesomecoding.user;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.cardmanager.CardManager;
import com.lovemesomecoding.laptop.Laptop;
import com.lovemesomecoding.order.Order;
import com.lovemesomecoding.role.Role;

@JsonInclude(value = Include.NON_NULL)
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private Long id;

	@Column(name = "uid", unique = true, nullable = false, updatable = false)
	private String uid;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "age")
	private int age;

	@JsonIgnoreProperties(value = { "user" })
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@JsonIgnoreProperties(value = { "user" })
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
	private Laptop laptop;

	@JsonIgnoreProperties(value = { "user" })
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Order> orders;

	@JsonIgnoreProperties(value = { "users" })
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	private Set<Role> roles;

	@JsonIgnoreProperties(value = { "user", "card" })
	@OneToMany(mappedBy = "user")
	private Set<CardManager> cardManagers;



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		if (this.orders == null) {
			this.orders = new HashSet<>();
		}
		this.orders.add(order);
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void addRole(Role role) {
		if (this.roles == null) {
			this.roles = new HashSet<>();
		}
		this.roles.add(role);
	}
	public Set<CardManager> getCardManagers() {
		return cardManagers;
	}

	public void setCardManagers(Set<CardManager> cardManagers) {
		this.cardManagers = cardManagers;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.id).append(this.email).append(this.uid).toHashCode();

		// return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		User other = (User) obj;
		return new EqualsBuilder().append(this.id, other.id).append(this.email, other.email).append(this.uid, other.uid)
				.isEquals();
	}

}
