package com.formation.project3.application.service;

import java.util.ArrayList;
import java.util.List;

import com.formation.project3.application.dto.BenevoleLight;
import com.formation.project3.application.dto.BenevoleLightById;
import com.formation.project3.application.persistence.entity.Benevole;



public interface IBenevoleService {
	
	Benevole save(Benevole benevole);
	List<BenevoleLight> findAll();
	BenevoleLightById findById(long id);
	Benevole findByLogin(String login, String pwd);
	void deleteById(long id);
	byte[] getPhoto(long id);
}
