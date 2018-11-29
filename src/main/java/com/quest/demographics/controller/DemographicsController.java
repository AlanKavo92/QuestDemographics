package com.quest.demographics.controller;

import com.quest.demographics.entity.RecordEntity;
import com.quest.demographics.service.RecordService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    	recordService.processRecord(record);
        return "landing";
    }
    
	@RequestMapping(value = "/isPpsAvailable", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> isPpsAvailable(@RequestParam String pps) throws Exception {
		logger.debug("DemographicsController: GET Request received for /isPpsAvailable ");

		boolean isExists = recordService.isPpsExists(pps);
		return new ResponseEntity<Boolean>(!isExists, HttpStatus.OK);
	}
}
