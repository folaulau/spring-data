package com.lovemesomecoding.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lovemesomecoding.address.Address;
import com.lovemesomecoding.role.Role;
import com.lovemesomecoding.utils.ObjectUtils;

@JsonInclude(value = Include.NON_NULL)
@Entity
@Table(name = "user")
public class User implements Serializable {
	
	@JsonIgnore
	@Transient
	private Logger log = LoggerFactory.getLogger(this.getClass());

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private Long id;
	
	@Column(name = "uid", unique = true, nullable=false, updatable=false)
	private String uid;

	@Column(name = "email", nullable=false, unique=true)
	private String email;
	
	@Column(name = "password", nullable=false)
	private String password;
	
	@JsonIgnoreProperties(value= {"user"})
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	

	@JsonIgnoreProperties(value= {"users"})
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(
	        name = "user_roles",
	        joinColumns = { @JoinColumn(name = "user_id") },
	        inverseJoinColumns = { @JoinColumn(name = "role_id") })
	private Set<Role> roles;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		if(this.roles == null){
			this.roles = new HashSet<>();
		}
		this.roles.add(role);
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<String> getAuthorities() {
		List<String> authorities = new ArrayList<>();
		if(this.roles==null) {
			return authorities;
		}
		
		for(Role role : roles) {
			authorities.add(role.getAuthority());
		}
		
		return authorities;
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

	/*
	 * Executed before the entity manager persist operation is actually 
	 * executed or cascaded. This call is synchronous with the persist operation.
	 */
	@PrePersist
	private void preSave() {
		log.info("preSave={}",ObjectUtils.toJson(this));
	}
	
	/*
	 * Executed after the entity manager persist operation is actually 
	 * executed or cascaded. This call is invoked after the database 
	 * INSERT is executed.
	 */
	@PostPersist
	private void postSave() {
		log.info("postSave={}",ObjectUtils.toJson(this));
	}
	
	/*
	 * Executed after an entity has been loaded into the current persistence 
	 * context or an entity has been refreshed.
	 */
	@PostLoad
	private void postLoad() {
		log.info("postLoad={}",ObjectUtils.toJson(this));
	}
	
	/*
	 * Executed before the database UPDATE operation.
	 */
	@PreUpdate
	private void preUpdate() {
		log.info("preUpdate={}",ObjectUtils.toJson(this));
	}
	
	/*
	 * Executed after the database UPDATE operation.
	 */
	@PostUpdate
	private void postUpdate() {
		log.info("postUpdate={}",ObjectUtils.toJson(this));
	}
	
	
	

	
	/*
	 * Executed before the entity manager remove operation is actually 
	 * executed or cascaded. This call is synchronous with the remove operation.
	 */
	@PreRemove
	private void preRemove() {
		log.info("preRemove={}",ObjectUtils.toJson(this));
	}
	
	/*
	 * Executed after the entity manager remove operation is actually 
	 * executed or cascaded. This call is synchronous with the remove operation.
	 */
	@PostRemove
	private void postRemove() {
		log.info("postRemove={}",ObjectUtils.toJson(this));
	}
}
