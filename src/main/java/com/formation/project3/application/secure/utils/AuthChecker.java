/**
 * 
 */
package com.formation.project3.application.secure.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.formation.project3.application.persistence.entity.Benevole;



/**
 * @author Dell
 *
 */
@Component
public class AuthChecker {
	public Benevole isBenevole() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		boolean isUser = SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(new SimpleGrantedAuthority("ROLE_USER"));
		if (principal != null && principal instanceof Benevole && isUser) {
			return (Benevole)principal;
		} else {
			return null;
		}
	}
}
