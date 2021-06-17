/**
 * 
 */
package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

/**
 * @author Shahzad Hussain
 */
@Data
@Service
@ConfigurationProperties("app")
public class AppProperties {

	private String regionName;

}
