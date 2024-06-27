package com.cts.user.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name="ID")
	private String userId;
	
	@Column(name = "NAME", length=100)
	private String name;
	
	@Column(name="EMAIL")
	private String email;

	@Column(name="PASSWORD")
	private String password;

	@Column(name = "ABOUT")
	private String about;
	
	@Transient
    private List<Rating> ratings = new ArrayList<>();
	
	@Column(name="ROLE",columnDefinition="VARCHAR(255) DEFAULT 'USER'")
	private String role;
}
