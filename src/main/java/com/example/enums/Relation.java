/**
 * 
 */
package com.example.enums;

import org.springframework.util.StringUtils;

/**
 * @author Shahzad Hussain
 */
public enum Relation {

	SELF("Self"), SPOUSE("Spouse"), SON("Son"), DAUGHTER("Daughter"), FATHER("Father"), MATHER("Mother");

	private String value;

	private Relation(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@SuppressWarnings("deprecation")
	public static String findByName(String name) {
		if (!StringUtils.isEmpty(name)) {
			for (Relation gender : values()) {
				if (gender.name().equals(name)) {
					return gender.getValue();
				}
			}
		}
		return "";
	}
}
