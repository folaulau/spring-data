package com.lovemesomecoding.laptop;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lovemesomecoding.user.User;

@JsonInclude(value = Include.NON_NULL)
@Where(clause = "active = 'T'")
@Entity
@Table(name = "laptop")
public class Laptop implements Serializable {
	
	@Transient
    @JsonIgnore
    private Logger                log                     = LoggerFactory.getLogger(this.getClass());
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private Long id;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "serial_number")
	private String serialNumber;
	
	@Column(name = "model_number")
	private String modelNumber;
	
	@Column(name = "year")
	private LocalDate year;
	
	@Type(type = "true_false")
    @Column(name = "active", nullable = false, updatable = true)
	private Boolean active;
	
	@JsonIgnoreProperties(value= {"laptop"})
	@OneToOne
	@JoinColumn(name="user_id")
	@MapsId
	private User user;

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModelNumber() {
		return modelNumber;
	}
	
	

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@PrePersist
    public void prePersist() {
		log.info("Laptop - prePersist");
        if(this.active==null) {
        	this.active = true;
        }
    }

}
