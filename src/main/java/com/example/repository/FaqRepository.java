package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Faq;

/**
 * @author Shahzad Hussain 
 */
@Repository
public interface FaqRepository extends JpaRepository<Faq, Long>{

	List<Faq> findByActiveTrue();
}