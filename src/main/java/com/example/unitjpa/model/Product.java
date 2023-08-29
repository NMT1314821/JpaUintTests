package com.example.unitjpa.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.core.sym.Name;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
/*
 * use single nameQuery also and multple namedquerys also
@NamedQuery(name="Product.fingByPrice",
			 query="SELECT p from Product p where p.price=?1")
*/
@NamedQueries(
		{
			@NamedQuery(name="Product.findAllOrderByNameDesc",
					query="SELECT p from Product p ORDER By p.name DESC"),
			@NamedQuery(name="Product.findByPrice",
					query="select p from Product p where p.price=:price")
		}		
		)
@NamedNativeQuery(
		name="Product.findBySku",
		query="select * from protb p where p.sku=:sku",
		resultClass=Product.class		
		)
@NamedNativeQueries(
		{
			@NamedNativeQuery(name="Product.findByDescri",
							query="select * from protb p where p.descri=?1",
							resultClass=Product.class),
			@NamedNativeQuery(name="Product.findAllOrderByNameAsc",
							query="select * from protb order by name asc",
							resultClass=Product.class)
		})
@Table(name="protb")
@Entity
public class Product
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String sku;
	private String name;
	private String descri;
	private BigDecimal price;
	private boolean active;
	private String imagurl;
	@CreationTimestamp
	private LocalDateTime dateCreated;
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	
	@ManyToOne()
	@JoinColumn(name="category_id",referencedColumnName = "id")
	private ProductCategory category;
}
