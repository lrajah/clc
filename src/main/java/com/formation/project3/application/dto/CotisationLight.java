/**
 * 
 */
package com.formation.project3.application.dto;

import java.sql.Date;


import com.formation.project3.application.persistence.entity.Cotisation;

/**
 * @author Dell
 *
 */
public class CotisationLight {

	
	private Date date;
	
	private Double factures;
	public CotisationLight(Cotisation cotisation) {
		this.setDate(cotisation.getDate());
		this.setFactures(cotisation.getFactures());
				
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
	
	
	

}
