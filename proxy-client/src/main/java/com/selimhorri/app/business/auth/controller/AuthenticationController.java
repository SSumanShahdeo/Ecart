package com.selimhorri.app.business.auth.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.selimhorri.app.business.auth.model.request.AuthenticationRequest;
import com.selimhorri.app.business.auth.model.response.AuthenticationResponse;
import com.selimhorri.app.business.auth.service.AuthenticationService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/authenticate")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationController {

	@GetMapping()
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		System.out.println("\n\t\tIn Authenticate");
		String user = getUser(authHeader);
		System.out.println("Auth Header  : " + authHeader);
		System.out.println("User : " + user);
		String role = "ROLE_ADMIN";//SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		Map<String, String> auth = new HashMap<String, String>();

		String email = SecurityContextHolder.getContext().getAuthentication().getName();
			auth.put("token", generateJwt(user));
		auth.put("role", role);
		return auth;
	}

	private String getUser(String authHeader) {
		byte[] auth = Base64.getDecoder().decode(authHeader.split(" ")[1]);
		String authString = new String(auth);
		System.out.println("Auth String " + authString);
		return authString.split(":")[0];
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretKey");
		String token = builder.compact();
		return token;
	}
	
	
	
}










