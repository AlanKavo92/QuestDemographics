package com.quest.demographics.service;

import java.util.List;

import com.quest.demographics.entity.RecordEntity;
/**
 * DemographicsService
 * @Author - Alan Kavanagh
 */
public interface DemographicsService {
	public RecordEntity insertRecord(RecordEntity record);
	public Iterable<RecordEntity> getRecords();
	public List<RecordEntity> getRecordsOrderByCreateDtAsc();
}
