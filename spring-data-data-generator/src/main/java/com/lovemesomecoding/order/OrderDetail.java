package com.lovemesomecoding.order;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lovemesomecoding.product.Product;

@JsonInclude(value = Include.NON_NULL)
@Entity
@Table(name = "customer_order_detail")
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false, unique = true)
	private Long id;
	
	@Column(name = "total_price")
	private double totalPrice;
	
	@Column(name = "total_product_count")
	private int totalProductCount;
	
	@JsonIgnoreProperties(value= {"orderDetail"})
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="order_id", nullable=true, updatable=true)
	private Order order;
	
	@ManyToMany(cascade=CascadeType.DETACH, fetch=FetchType.EAGER)
	@JoinTable(
	          name = "customer_order_product",
	          joinColumns = { @JoinColumn(name = "order_detail_id",unique=false, referencedColumnName="id") },
	          inverseJoinColumns = { @JoinColumn(name = "product_id",unique=false,referencedColumnName="id") })
	private Set<Product> products;

	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getTotalProductCount() {
		return totalProductCount;
	}

	public void setTotalProductCount(int totalProductCount) {
		this.totalProductCount = totalProductCount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	
	public void addProducts(Product product) {
		if(this.products == null){
			this.products = new HashSet<>();
		}
		this.products.add(product);
	}
	
	
	
	

}
