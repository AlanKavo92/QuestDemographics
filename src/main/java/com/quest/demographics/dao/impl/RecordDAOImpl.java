package com.quest.demographics.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quest.demographics.dao.RecordDAO;
import com.quest.demographics.entity.RecordEntity;
import com.quest.demographics.exceptions.DemographicsDatabaseAccessException;
import com.quest.demographics.repository.RecordRepository;

/**
 * RecordDAOImpl
 * 
 * @Author - Alan Kavanagh
 */
@Component
public class RecordDAOImpl implements RecordDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(RecordDAOImpl.class);

	@Autowired
	RecordRepository recordRepository;

	@Override
	public RecordEntity insertRecord(RecordEntity record) {
		logger.debug("RecordDAOImpl: insertRecord executed");

		RecordEntity result = null;
		try {
			logger.debug(String.format("RecordDAOImpl: Attempting to insert the following record into database: %s", record));
			result = recordRepository.save(record);
			if (null == result) {
				throw new DemographicsDatabaseAccessException(
						String.format("Failed to insert the following record into the database: %s", record));
			}
			logger.info(String.format("RecordDAOImpl: Record inserted: %s", result.toString()));
		} catch (DemographicsDatabaseAccessException e) {
			logger.error(String.format("RecordDAOImpl: Failed to insert the following record into the database: %s", record));
		}
		return result;
	}

	@Override
	public List<RecordEntity> getRecordsOrderByCreateDtAsc() {
		logger.debug("RecordDAOImpl: getRecordsOrderByCreateDtAsc executed");

		List<RecordEntity> result = null;
		try {
			logger.debug("RecordDAOImpl: Attempting to get all record rows in the database ordered by create date ascending");
			result = recordRepository.findAllByOrderByCreateDtAsc();
			if (null == result) {
				throw new DemographicsDatabaseAccessException("Failed to get all record rows in the database ordered by create date ascending");
			}
			logger.info(String.format("RecordDAOImpl: %s records found", result.size()));
		} catch (DemographicsDatabaseAccessException e) {
			logger.error("RecordDAOImpl: Failed to get all record rows in the database ordered by create date ascending");
		}

		return result;
	}

	@Override
	public RecordEntity getRecordByPps(String pps) {
		logger.debug("RecordDAOImpl: getRecordByPps executed");
		RecordEntity result = null;
		
		try {
			logger.debug(String.format("RecordDAOImpl: Attempting to get record by PPS: %s", pps));
			result = recordRepository.findByPps(pps);
			if (null == result) {
				throw new DemographicsDatabaseAccessException(String.format("Failed to get record by PPS: %s", pps));
			}
			logger.info(String.format("RecordDAOImpl: Record found: %s", result.toString()));
		}
		catch (DemographicsDatabaseAccessException e) {
			logger.error(String.format("RecordDAOImpl: Failed to get record by PPS: %s", pps));
		}
		
		return result;
	}
}
