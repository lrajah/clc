/**
 * 
 */
package com.formation.project3.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.project3.application.dto.BenevoleLight;

import com.formation.project3.application.service.IBenevoleService;

/**
 * @author Dell
 *
 */
@RestController
@RequestMapping(value="/api/public/benevole")
public class BenevoleController {
	@Autowired
	private IBenevoleService benevoleServ;
	
	@GetMapping
	@ResponseBody
	public List<BenevoleLight> findAll(){
		return benevoleServ.findAll();
	}
	
	
	
//	@GetMapping(value = "/{login}/{pwd}")
//	@ResponseBody
//	public BenevoleLightById findByLogin(@PathVariable String login, @PathVariable String pwd) throws NotFoundException {
//		return benevoleServ.findByLogin(login, pwd);
//	}
	
}
