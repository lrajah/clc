/**
 * 
 */
package com.formation.project3.application.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Dell
 *
 */
@Entity
@Table(name="benevole")
public class Benevole {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "ID", unique = true, nullable = false)
	private Long id;
	@Column(name="Nom", length=100, nullable=false)
	private String nom;
	@Column(name="Prenom", length=100, nullable=false)
	private String prenom;
	@Column(name="Adresse", nullable=false)
	private String adresse;
	@Column(name="Telephone", length=14, nullable=false)
	private String telephone;
	@Column(name="Portable", length=14, nullable=false)
	private String portable;
	@Lob
	@Column (name = "photo", nullable=true)
	private byte[] photo;
	@ManyToOne()
	@JoinColumn(name="IDTypeBenevole", referencedColumnName="ID")
	private TypeBenevole typeBenevole;
	@OneToMany()
	@JoinColumn(name="IDBenevole", referencedColumnName="ID")
	private List<Cotisation> cotisation;
	
	@Column(name="Login", length=50, nullable=true)
	private String login;
	@Column(name="Password", length=50, nullable=true)
	private String password;
	
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Cotisation> getCotisation() {
		return cotisation;
	}
	public void setCotisation(List<Cotisation> cotisation) {
		this.cotisation = cotisation;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPortable() {
		return portable;
	}
	public void setPortable(String portable) {
		this.portable = portable;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypeBenevole getTypeBenevole() {
		return typeBenevole;
	}
	public void setTypeBenevole(TypeBenevole typeBenevole) {
		this.typeBenevole = typeBenevole;
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
	

}
