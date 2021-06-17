package com.example.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.config.AppProperties;
import com.example.constants.FactoryConstants;
import com.example.dao.FaqDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FaqFactoryDao implements FactoryConstants {

	@Autowired
	private BeanFactory beanFactory;

	@Autowired
	private AppProperties appProperties;

	public FaqDao getInstance() {
		return beanFactory.getBean(getDaoBeanName(appProperties.getRegionName()), FaqDao.class);
	}

	private String getDaoBeanName(String bucketName) {
		String beanName = bucketName + BEAN_DAO;
		log.info("Qualified bean for region {}  => {}", bucketName, beanName);
		return beanName;
	}
}
