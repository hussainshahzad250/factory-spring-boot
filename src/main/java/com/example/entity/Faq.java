package com.example.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shahzad Hussain
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = Faq.Columns.TABLE)
public class Faq {
	public interface Columns {
		String TABLE = "faqs";
		String ID = "ID";
		String ACTIVE = "ACTIVE";
		String CREATED_ON = "CREATED_ON";
		String QUESTION = "question";
		String ANSWER = "answer";
	}

	@Id
	@Column(name = Columns.ID)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = Columns.QUESTION)
	private String question;

	@Column(name = Columns.ANSWER)
	private String answer;

	@Column(name = Columns.ACTIVE)
	private boolean active;

	@CreatedDate
	@Column(name = Columns.CREATED_ON)
	private LocalDateTime createdOn;

	public Faq(Long id, String question, boolean active) {
		this.id = id;
		this.question = question;
		this.active = active;
	}
	
	

}