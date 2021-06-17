package com.example.dao;

import java.util.List;

import com.example.entity.Faq;

public interface FaqDao {
	List<Faq> findByActiveTrue();
}
