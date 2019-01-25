/**
 * 
 */
package com.formation.project3.application.service.iml;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.project3.application.dto.BenevoleLight;
import com.formation.project3.application.dto.BenevoleLightById;
import com.formation.project3.application.exception.NotFoundException;
import com.formation.project3.application.persistence.entity.Benevole;
import com.formation.project3.application.persistence.repository.BenevoleRepository;
import com.formation.project3.application.service.IBenevoleService;

/**
 * @author Dell
 *
 */
@Service

public class BenevoleService implements IBenevoleService{
	@Autowired
	private BenevoleRepository benevoleRepo;
	
	public Benevole save(Benevole benevole) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BenevoleLight> findAll() {
		// TODO Auto-generated method stub
		List<Benevole> opt=benevoleRepo.findAll();
		

	    
		return (ArrayList<BenevoleLight>) opt.stream()
				.map(b->new BenevoleLight(b))
				.sorted((b1,b2)->b2.getSumCotisation().compareTo(b1.getSumCotisation()))
				.collect(Collectors.toList());
		
		
		
//		for(int i=0; i<opt.size();i++) {
//			
//			listBenevoleLight.add(new BenevoleLight(opt.get(i)));
//		}
//		return listBenevoleLight;
//	
	}

	public BenevoleLightById findById(long id) {
		// TODO Auto-generated method stub
		Optional<Benevole> opt=benevoleRepo.findById(id);
		if(opt.isPresent()) {
			return new BenevoleLightById(opt.get());
		}else {
			throw new NotFoundException("USER " + id + " WAS NOT FOUND !");
		}
		
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] getPhoto(long id) throws NotFoundException {
		Optional<Benevole> opt = benevoleRepo.findById(id);
		if (opt.isPresent()) {
			if (opt.get().getPhoto() != null) {
				return opt.get().getPhoto();
			} else {
				throw new NotFoundException("USER " + id + " HAS NO PHOTO !");				
			}
		} else {
			throw new NotFoundException("USER " + id + " WAS NOT FOUND !");
		}
	}

	@Override
	public Benevole findByLogin(String login, String pwd) {
		// TODO Auto-generated method stub
		Optional<Benevole> opt=benevoleRepo.findByLogin(login, pwd);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new NotFoundException("USER " + login + " WAS NOT FOUND !");
		}
	}

}
