package com.example.unitjpa.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.criteria.Fetch;
import lombok.Data;

@Data
@Entity
@Table(name="order_itemas")
public class OrderItem
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String imgurl;
	private BigDecimal price;
	private int quentity;
	
	@OneToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	//by default manytoone is eagar;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="order_id",referencedColumnName = "id")
	private Order order;
	
}
