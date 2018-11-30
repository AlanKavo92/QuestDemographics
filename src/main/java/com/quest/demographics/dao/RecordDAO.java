package com.quest.demographics.dao;

import java.util.List;

import com.quest.demographics.entity.RecordEntity;

/**
 * RecordDAO
 * 
 * @Author - Alan Kavanagh
 */
public interface RecordDAO {
	public RecordEntity getRecordByPps(String pps);
	public RecordEntity insertRecord(RecordEntity record);
	public List<RecordEntity> getRecordsOrderByCreateDtAsc();
}