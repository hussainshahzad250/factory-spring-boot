package com.example.dto;

import com.example.pojos.FaqPojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FaqResponse extends FaqPojo {
	private Long faqId;

}