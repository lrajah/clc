/**
 * 
 */
package com.formation.project3.application.persistence.entity;

import java.sql.Date;

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
@Table(name="cotisation")
public class Cotisation {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;
	@Column (name = "IDBenevole", length = 20, nullable = false)
	private Long idBenevole;
	@Column (name = "DateCotisation",  nullable = false)
	private Date date;
	@Column (name = "Montant", nullable = false)
	private Double factures;
	@Column (name = "Details", length = 50, nullable = false)
	private String details;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdBenevole() {
		return idBenevole;
	}
	public void setIdBenevole(Long idBenevole) {
		this.idBenevole = idBenevole;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getFactures() {
		return factures;
	}
	public void setFactures(Double factures) {
		this.factures = factures;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
