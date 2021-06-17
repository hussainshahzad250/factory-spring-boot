package com.example.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.example.dto.FaqRequest;
import com.example.dto.FaqResponse;
import com.example.entity.Faq;

/**
 * @author Shahzad Hussain
 */
public class FaqConverter {

	public static Faq getEntityFromRequest(FaqRequest request) {
		if (request != null) {
			Faq response = new Faq();
			response.setQuestion(request.getQuestion());
			response.setAnswer(request.getAnswer());
			return response;
		}
		return null;
	}

	public static FaqResponse getResponseFromEntity(Faq request) {
		if (request != null) {
			FaqResponse response = new FaqResponse();
			response.setFaqId(request.getId());
			response.setQuestion(request.getQuestion());
			response.setAnswer(request.getAnswer());
			return response;
		}
		return null;
	}

	public static List<FaqResponse> getResponseListFromEntityList(List<Faq> requestList) {
		if (!CollectionUtils.isEmpty(requestList))
			return requestList.stream().map(request -> getResponseFromEntity(request)).collect(Collectors.toList());
		return null;
	}
}