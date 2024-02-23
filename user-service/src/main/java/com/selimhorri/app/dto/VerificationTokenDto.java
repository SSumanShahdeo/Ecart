package com.selimhorri.app.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.selimhorri.app.constant.AppConstant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class VerificationTokenDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer verificationTokenId;
	
	private String token;

//	@JsonFormat(pattern = "yyyy-MM-dd")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	private LocalDate expireDate;

	@JsonProperty("credential")
	@JsonInclude(value = Include.NON_NULL)
	private CredentialDto credentialDto;
	
}










