package com.example.service;

import java.util.List;

import com.example.dto.FaqRequest;
import com.example.dto.FaqResponse;
import com.example.entity.Faq;

/**
 * @author Shahzad Hussain
 */
public interface FaqService {
	FaqResponse save(FaqRequest request);

	FaqResponse getById(Long id);

	List<FaqResponse> getAll();

	List<Faq> getDataByBeanName();

	FaqResponse updateStatus(Long id, boolean isActive);

}