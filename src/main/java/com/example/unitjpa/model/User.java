package com.example.unitjpa.model;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users",
		uniqueConstraints = @UniqueConstraint(
		name="unique_email",
		columnNames = "email")
		)
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="users_rolest",
			joinColumns = @JoinColumn(
					name="u_id",
					referencedColumnName ="id"
					),
			inverseJoinColumns = @JoinColumn(
					name="r_id",
					referencedColumnName ="id"
					)
			)			
	
	private Set<Role> roles=new HashSet<>();
}
