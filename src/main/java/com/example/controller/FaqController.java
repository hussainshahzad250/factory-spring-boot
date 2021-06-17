package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.RestMappingConstants;
import com.example.dto.FaqRequest;
import com.example.dto.FaqResponse;
import com.example.dto.Response;
import com.example.entity.Faq;
import com.example.exception.ObjectNotFoundException;
import com.example.service.FaqService;

/**
 * @author Shahzad Hussain
 */
@RestController
@RequestMapping(value = "/faq")
public class FaqController implements RestMappingConstants {

	@Autowired
	private FaqService faqService;

	@PostMapping
	public ResponseEntity<Response> saveFaq(@RequestBody FaqRequest request) throws ObjectNotFoundException {
		FaqResponse response = faqService.save(request);
		if (response == null) {
			throw new ObjectNotFoundException(NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Response(SUCCESS, response, HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(path = ID_PARAM)
	public ResponseEntity<Response> getById(@PathVariable(ID) Long id) throws ObjectNotFoundException {
		FaqResponse response = faqService.getById(id);
		if (response == null) {
			throw new ObjectNotFoundException(NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Response(SUCCESS, response, HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<Response> getAll() throws ObjectNotFoundException {
		List<FaqResponse> response = faqService.getAll();
		if (CollectionUtils.isEmpty(response)) {
			throw new ObjectNotFoundException(NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Response(SUCCESS, response, HttpStatus.OK), HttpStatus.OK);
	}

	@PostMapping(value = "/{id}/updateStatus")
	public ResponseEntity<Response> updateStatus(@PathVariable("id") Long id, @RequestParam boolean isActive)
			throws ObjectNotFoundException {
		FaqResponse response = faqService.updateStatus(id, isActive);
		if (response == null) {
			throw new ObjectNotFoundException(NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Response(SUCCESS, response, HttpStatus.OK), HttpStatus.OK);
	}

	@GetMapping(value = "/getDataByBeanName")
	public ResponseEntity<Response> getDataByBeanName() throws ObjectNotFoundException {
		List<Faq> response = faqService.getDataByBeanName();
		if (CollectionUtils.isEmpty(response)) {
			throw new ObjectNotFoundException(NOT_FOUND, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new Response(SUCCESS, response, HttpStatus.OK), HttpStatus.OK);
	}
}