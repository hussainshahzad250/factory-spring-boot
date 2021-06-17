/**
 * 
 */
package com.example.enums;

import org.springframework.util.StringUtils;

/**
 * @author Shahzad Hussain
 */
public enum Gender {

	MALE("Male"), FEMALE("Female"), UNKNOWN("Unknown");

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@SuppressWarnings("deprecation")
	public static String findByName(String name) {
		if (!StringUtils.isEmpty(name)) {
			for (Gender gender : values()) {
				if (gender.name().equals(name)) {
					return gender.getValue();
				}
			}
		}
		return "";
	}
}
