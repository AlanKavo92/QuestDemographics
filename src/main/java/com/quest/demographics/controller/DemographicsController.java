package com.quest.demographics.controller;

import com.quest.demographics.entity.RecordEntity;
import com.quest.demographics.service.RecordService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * DemographicsController
 * 
 * @Author - Alan Kavanagh
 */
@Controller
public class DemographicsController {

	private static final Logger logger = LoggerFactory.getLogger(DemographicsController.class);

	@Autowired
	RecordService recordService;
	
    @GetMapping("/")
    public String displayIndexPage() {
		logger.debug("DemographicsController: Get Request received for / ");
        return "landing";
    }
    
    @GetMapping("/list")
    public String displayRecordList(Model model) {
		logger.debug("DemographicsController: Get Request received for /list ");
        model.addAttribute("records", recordService.getOrderedRecords());
        return "list";
    }
	
    @GetMapping("/insert")
    public String displayInsertRecordForm(Model model) {
		logger.debug("DemographicsController: Get Request received for /insert ");
        model.addAttribute("record", new RecordEntity());
        return "insert";
    }

    @PostMapping("/insert")
    public String insertRecord(@ModelAttribute RecordEntity record) {
		logger.debug("DemographicsController: Post Request received for /insert ");
		logger.info(record.toString());
		System.out.println(record);
    	recordService.processRecord(record);
        return "landing";
    }
}
