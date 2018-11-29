package com.quest.demographics.service;

import java.util.List;

import com.quest.demographics.entity.RecordEntity;
/**
 * RecordService
 * 
 * @Author - Alan Kavanagh
 */
public interface RecordService {
	public RecordEntity processRecord(RecordEntity record);
	public List<RecordEntity> getOrderedRecords();
}
