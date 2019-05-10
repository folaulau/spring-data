package com.lovemesomecoding.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.laptop.Laptop;

@JsonInclude(value=Include.NON_NULL)
@Where(clause = "active = 'T'")
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Transient
    @JsonIgnore
    private Logger                log                     = LoggerFactory.getLogger(this.getClass());

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private Long id;
	
	@Column(name = "uid", unique = true, nullable=false, updatable=false)
	private String uid;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;
	
	@Column(name = "date_of_birth")
	private Date dob;
	
	@Type(type = "true_false")
    @Column(name = "active", nullable = false, updatable = true)
	private Boolean active;
	
	@JsonIgnoreProperties(value= {"user"})
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@JsonIgnoreProperties(value= {"user"})
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="user")
	private Laptop laptop;

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

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Boolean getActive() {
		return active;
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

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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
		return new EqualsBuilder().append(this.id, other.id).append(this.email, other.email)
				.append(this.uid, other.uid).isEquals();
	}
	
	@PrePersist
    public void prePersist() {
		log.info("User - prePersist");
        if(this.active==null) {
        	this.active = true;
        }
    }

}
