package com.quest.demographics.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DemographicsDatabaseAccessException
 * @Author - Alan Kavanagh
 */
public class DemographicsDatabaseAccessException extends Exception {

	private static final Logger logger = LoggerFactory.getLogger(DemographicsDatabaseAccessException.class);

	public DemographicsDatabaseAccessException(String errorMessage) {
		super(errorMessage);
		logger.error(errorMessage);
	}
}
