package com.lovemesomecoding.card;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lovemesomecoding.cardmanager.CardManager;

@JsonInclude(value = Include.NON_NULL)
@Entity
@Table(name = "card")
public class Card implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private Long id;

	@Column(name = "last4")
	private String last4;

	@Column(name = "brand")
	private String brand;

	@Column(name = "name")
	private String name;

	@JsonIgnoreProperties(value = { "card" })
	@OneToMany(mappedBy = "card", fetch=FetchType.EAGER)
	private Set<CardManager> cardManagers;

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Set<CardManager> getCardManagers() {
		return cardManagers;
	}

	public void setCardManagers(Set<CardManager> cardManagers) {
		this.cardManagers = cardManagers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLast4() {
		return last4;
	}

	public void setLast4(String last4) {
		this.last4 = last4;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
