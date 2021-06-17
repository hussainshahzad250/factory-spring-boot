package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.assembler.FaqConverter;
import com.example.dto.FaqRequest;
import com.example.dto.FaqResponse;
import com.example.entity.Faq;
import com.example.factory.FaqFactoryDao;
import com.example.repository.FaqRepository;
import com.example.service.FaqService;

/**
 * @author Shahzad Hussain
 */
@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqRepository faqRepository;

	@Autowired
	private FaqFactoryDao faqFactoryDao;

	@Override
	public FaqResponse save(FaqRequest request) {
		Faq entity = FaqConverter.getEntityFromRequest(request);
		faqRepository.save(entity);
		return FaqConverter.getResponseFromEntity(entity);
	}

	@Override
	public FaqResponse getById(Long id) {
		return FaqConverter.getResponseFromEntity(faqRepository.findById(id).orElse(null));
	}

	@Override
	@Cacheable(value = "faqs")
	public List<FaqResponse> getAll() {
		return FaqConverter.getResponseListFromEntityList(faqRepository.findByActiveTrue());
	}

	@Override
	public List<Faq> getDataByBeanName() {
		return faqFactoryDao.getInstance().findByActiveTrue();
	}

	@Override
	public FaqResponse updateStatus(Long id, boolean isActive) {
		Optional<Faq> findById = faqRepository.findById(id);
		if (findById.isPresent()) {
			Faq faq = findById.get();
			faq.setActive(isActive);
			faqRepository.save(faq);
			return FaqConverter.getResponseFromEntity(faq);
		}
		return null;
	}

}