/**
 * 
 */
package com.formation.project3.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.formation.project3.application.dto.BenevoleLightById;
import com.formation.project3.application.exception.NotFoundException;
import com.formation.project3.application.exception.NotIdentifiedException;
import com.formation.project3.application.persistence.entity.Benevole;
import com.formation.project3.application.secure.utils.AuthChecker;
import com.formation.project3.application.service.IBenevoleService;

/**
 * @author Dell
 *
 */
@RestController
@RequestMapping(value = "/api/private/benevole")
public class BenevoleSecureController {
	@Autowired
	private IBenevoleService benevoleServ;

	@Autowired
	private AuthChecker authChecker;

	@GetMapping(value = "/{id}")
	@ResponseBody
	public BenevoleLightById findById(@PathVariable long id) {
		if (authChecker.isBenevole() == null)
			throw new NotIdentifiedException();
		return benevoleServ.findById(id);

	}

	@GetMapping(value = "/{id}/photo", produces = "application/jpeg")
	@ResponseBody
	public ResponseEntity<byte[]> getPhoto(@PathVariable long id) throws NotFoundException {
		if (authChecker.isBenevole() == null)
			throw new NotIdentifiedException();
		byte[] photo = benevoleServ.getPhoto(id);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		if (photo != null) {
			return ResponseEntity.ok().headers(headers).contentType(MediaType.IMAGE_JPEG).body(photo);
		} else {
			throw new NotFoundException("USER " + id + " WAS NOT FOUND !");
		}

	}

	@GetMapping(value = "/me")
	@ResponseBody
	public BenevoleLightById findMe() {
		Benevole benevole = authChecker.isBenevole();
		if (benevole == null) throw new NotIdentifiedException();
		return benevoleServ.findById(benevole.getId());

	}
}
