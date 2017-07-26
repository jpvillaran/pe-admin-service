package com.patriotenergygroup.peadminservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/rates")
public class RateController {
	private final Logger logger = LoggerFactory.getLogger(RateController.class);
	
	@RequestMapping(path="/list", method = RequestMethod.GET)
	public ResponseEntity<?> getRates() {
        logger.debug("Fetching rates");
		
        return new ResponseEntity<>("Retrieved", new HttpHeaders(), HttpStatus.OK);
	}

	@RequestMapping(path="/list-files", method = RequestMethod.GET)
	public ResponseEntity<?> getFileList() {
        logger.debug("Fetching files");
		
        return new ResponseEntity<>("Retrieved", new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        logger.debug("Loading the file");

        return new ResponseEntity<>("Successfully uploaded - ", new HttpHeaders(), HttpStatus.OK);
	}
}
