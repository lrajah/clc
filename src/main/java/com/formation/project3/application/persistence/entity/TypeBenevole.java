/**
 * 
 */
package com.formation.project3.application.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Dell
 *
 */
@Entity
@Table(name="typebenevole")
public class TypeBenevole {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;
	@Column(name="LibelleCourt", length=50, nullable=false)
	private String libCourt;

	public String getLibCourt() {
		return libCourt;
	}

	public void setLibCourt(String libCourt) {
		this.libCourt = libCourt;
	}
	
	

}
