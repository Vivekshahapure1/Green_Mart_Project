package com.app.pojos;

//id,name,price,quantity,creation date, expire date
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 30)
	private String prodName;

	private double prodPrice;

	private int prodQuantity;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate prodMfgDate;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate prodExpDate;
	
	@Column(name = "product_image")
	private String productImage;
	private double weight;

	//many users one product
	@ManyToOne(fetch = FetchType.LAZY, optional = false)	//lazy-dont unnecessary load data that we havent asked for
	@JoinColumn(name = "user_id", nullable = false) //name- foriegn key
	@OnDelete(action = OnDeleteAction.CASCADE)		
	@JsonIgnore
	private User selectedUser;

	public Product() {
		System.out.println("in Product cnstr");
	}

	public Product(String prodName, double prodPrice, int prodQuantity, LocalDate prodMfgDate, LocalDate prodExpDate) {
		super();
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodMfgDate = prodMfgDate;
		this.prodExpDate = prodExpDate;

	}


	public Product(String prodName, double prodPrice, int prodQuantity, LocalDate prodMfgDate, LocalDate prodExpDate,
			String productImage, double weight) {
		super();
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodMfgDate = prodMfgDate;
		this.prodExpDate = prodExpDate;
		this.productImage = productImage;
		this.weight = weight;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public LocalDate getProdMfgDate() {
		return prodMfgDate;
	}

	public void setProdMfgDate(LocalDate prodMfgDate) {
		this.prodMfgDate = prodMfgDate;
	}

	public LocalDate getProdExpDate() {
		return prodExpDate;
	}

	public void setProdExpDate(LocalDate prodExpDate) {
		this.prodExpDate = prodExpDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
	}
	

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	

	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodQuantity="
				+ prodQuantity + ", prodMfgDate=" + prodMfgDate + ", prodExpDate=" + prodExpDate + ", productImage="
				+ productImage + ", weight=" + weight + "]";
	}

}
