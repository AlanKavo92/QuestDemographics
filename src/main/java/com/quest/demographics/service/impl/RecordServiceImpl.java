package com.quest.demographics.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quest.demographics.dao.RecordDAO;
import com.quest.demographics.entity.RecordEntity;
import com.quest.demographics.service.RecordService;

/**
 * RecordServiceImpl
 * 
 * @Author - Alan Kavanagh
 */
@Service
public class RecordServiceImpl implements RecordService {

	private static final Logger logger = LoggerFactory.getLogger(RecordServiceImpl.class);

	@Autowired
	RecordDAO recordDao;

	@Override
	public RecordEntity processRecord(RecordEntity record) {
		logger.debug("RecordServiceImpl: processRecord executed");

		RecordEntity result = null;
		try {
			logger.debug("RecordServiceImpl: Attempting to insert record");
			Date date = new Date();
			record.setCreateDt(date);
			result = recordDao.insertRecord(record);
			logger.info("RecordServiceImpl: Finished inserting record");
		} 
		catch (Exception e) {
			logger.error(String.format("RecordServiceImpl: Failed to process record %s", record));
		}
		return result;
	}

	@Override
	public List<RecordEntity> getOrderedRecords() {
		logger.debug("RecordServiceImpl: getOrderedRecords executed");
		
		List<RecordEntity> result = null;
		try {
			logger.debug("RecordServiceImpl: Attempting to get records in order");
			result = recordDao.getRecordsOrderByCreateDtAsc();
			logger.info("RecordServiceImpl: Finished getting records in order");
		} 
		catch (Exception e) {
			logger.error("RecordServiceImpl: Failed to get all records in order");
		}

		return result;
	}

	@Override
	public boolean isPpsExists(String pps) {
		logger.debug("RecordServiceImpl: isPpsExists executed");
		logger.debug("RecordServiceImpl: Attempting to checking if PPS already exists in database");
		RecordEntity record = recordDao.getRecordByPps(pps);
		logger.info("RecordServiceImpl: Finished checking if PPS already exists in database");

		return (record == null) ? false : true;
	}
}
