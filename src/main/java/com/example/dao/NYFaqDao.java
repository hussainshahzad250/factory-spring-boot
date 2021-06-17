package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Faq;
import com.example.repository.FaqRepository;

@Component
public class NYFaqDao implements FaqDao {

	@Autowired
	private FaqRepository faqRepository;

	@Override
	public List<Faq> findByActiveTrue() {
		return faqRepository.findAll();
	}
}
