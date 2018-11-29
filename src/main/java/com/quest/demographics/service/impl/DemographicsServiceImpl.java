package com.quest.demographics.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.demographics.entity.RecordEntity;
import com.quest.demographics.exceptions.DemographicsDatabaseAccessException;
import com.quest.demographics.repository.RecordRepository;
import com.quest.demographics.service.DemographicsService;
import com.quest.demographics.util.Utilities;

/**
 * DemographicsServiceImpl
 * 
 * @Author - Alan Kavanagh
 */
@Service
public class DemographicsServiceImpl implements DemographicsService {

	private static final Logger logger = LoggerFactory.getLogger(DemographicsServiceImpl.class);

	@Autowired
	RecordRepository recordRepository;

	@Override
	public RecordEntity insertRecord(RecordEntity record) {
		RecordEntity result = null;
		Date date = new Date();
		try {
			logger.debug(String.format("Attempting to insert the following record into database: %s", record));
			record.setCreateDt(date);
			result = recordRepository.save(record);
			if (null == result) {
				throw new DemographicsDatabaseAccessException(
						String.format("Failed to insert the following record into the database: %s", record));
			}
		} catch (DemographicsDatabaseAccessException e) {
			logger.error(String.format("Failed to insert the following record into the database: %s", record));
		}
		return result;
	}

	@Override
	public Iterable<RecordEntity> getRecords() {
		Iterable<RecordEntity> result = null;

		try {
			logger.debug(String.format("Attempting to get all record rows in the database"));
			result = recordRepository.findAll();
			if (null == result) {
				throw new DemographicsDatabaseAccessException("Failed to get all record rows in the database");
			}

		} catch (DemographicsDatabaseAccessException e) {
			logger.error("Failed to get all record rows in the database");
		}

		return result;
	}
	
	@Override
	public List<RecordEntity> getRecordsOrderByCreateDtAsc() {
		List<RecordEntity> result = null;

		try {
			logger.debug(String.format("Attempting to get all record rows in the database ordered by create date ascending"));
			result = recordRepository.findAllByOrderByCreateDtAsc();
			if (null == result) {
				throw new DemographicsDatabaseAccessException("Failed to get all record rows in the database ordered by create date ascending");
			}

		} catch (DemographicsDatabaseAccessException e) {
			logger.error("Failed to get all record rows in the database ordered by create date ascending");
		}

		return result;
	}
}
