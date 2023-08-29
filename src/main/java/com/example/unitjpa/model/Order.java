package com.example.unitjpa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.metamodel.mapping.ordering.ast.OrderingExpression;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false,unique = true)
	private long orderTrackingnum;
	private int totalQuantity;
	private BigDecimal totalprice;
	private String status;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy = "order")
	private Address billingAddress;
	
	//lazy one many by defalut lazy;
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "order")
	private List<OrderItem> orderItems=new ArrayList<OrderItem>();
	
	public BigDecimal totalamount()
	{
		BigDecimal amount=new BigDecimal(0.0);
		for(OrderItem item: this.orderItems)
		{
			amount=amount.add(item.getPrice());					
		}
		return amount;
	}
	//by default onetomany is lazy;
	
	
}
