/**
 * 
 */
package com.formation.project3.application.dto;


import java.util.List;

import java.util.stream.Collectors;

import com.formation.project3.application.persistence.entity.Benevole;
import com.formation.project3.application.persistence.entity.TypeBenevole;

/**
 * @author Dell
 *
 */
public class BenevoleLightById {
	private  Long id;
	private  String nom;
	private String prenom;
	private  String type;
	private List<CotisationLight> cotisation;
	
	public BenevoleLightById(Benevole benevole) {
		this.id=benevole.getId();
		this.nom=benevole.getNom();
		this.prenom=benevole.getPrenom();
		this.type= ((TypeBenevole) benevole.getTypeBenevole()).getLibCourt();
		this.cotisation= benevole.getCotisation().stream().sorted((c1,c2)-> c1.getDate().compareTo(c2.getDate()))
				.map(c -> new CotisationLight(c))
				.collect(Collectors.toList());
				
	}
	public Long getId() {
		return id;
	}

	

	
	public List<CotisationLight> getCotisation() {
		return cotisation;
	}
	public void setCotisation(List<CotisationLight> cotisation) {
		this.cotisation = cotisation;
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
