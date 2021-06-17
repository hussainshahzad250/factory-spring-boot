package com.example.dto;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shahzad Hussain
 */
@Data
@NoArgsConstructor
public class Response {

	private int code;
	private String message;
	private HttpStatus status;
	private Object responseObject;

	public Response(String message, HttpStatus status) {
		this.message = message;
		this.status = status;
		this.code = status.value();
	}

	public Response(String message, Object responseObject, HttpStatus status) {
		this.message = message;
		this.status = status;
		this.code = status.value();
		this.responseObject = responseObject;
	}

}
