package com.quest.demographics.repository;

import java.util.List;

import javax.persistence.OrderBy;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.quest.demographics.entity.RecordEntity;

/**
 * RecordRepository
 * 
 * @Author - Alan Kavanagh
 */
@Repository
public interface RecordRepository extends CrudRepository<RecordEntity, Long> {
	public List<RecordEntity> findAllByOrderByCreateDtAsc();
} 