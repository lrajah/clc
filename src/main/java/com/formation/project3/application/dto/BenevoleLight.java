/**
 * 
 */
package com.formation.project3.application.dto;


import com.formation.project3.application.persistence.entity.Benevole;
import com.formation.project3.application.persistence.entity.TypeBenevole;
/**
 * @author Dell
 *
 */

public class BenevoleLight {
	private  Long id;
	private  String nom;
	private String prenom;
	private  String type;
	private Double sumCotisation;
	
	public BenevoleLight(Benevole benevole) {
		this.id=benevole.getId();
		this.nom=benevole.getNom();
		this.prenom=benevole.getPrenom();
		this.type= ((TypeBenevole) benevole.getTypeBenevole()).getLibCourt();
		this.sumCotisation= benevole.getCotisation().stream().mapToDouble(c -> c.getFactures()).sum();
				
	}
	public Long getId() {
		return id;
	}

	public Double getSumCotisation() {
		return sumCotisation;
	}

	public void setSumCotisation(Double sumCotisation) {
		this.sumCotisation = sumCotisation;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
