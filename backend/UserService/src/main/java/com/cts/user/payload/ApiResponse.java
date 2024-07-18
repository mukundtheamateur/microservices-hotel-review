package com.cts.user.payload;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {

	private String message;
	private boolean success;
	private HttpStatus status;
}
