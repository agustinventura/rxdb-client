package com.digitalsingular.rxdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.digitalsingular.rxdb.enclosure.EnclosureService;

@SpringBootApplication
public class RxdbClientApplication {

	private static Logger logger = LoggerFactory.getLogger(RxdbClientApplication.class);
	
	public static void main(String[] args) {
		EnclosureService service = new EnclosureService();
		long startTime = System.currentTimeMillis();
		service.getByPlot(1);
		long endTime = System.currentTimeMillis();
		logger.info("Total time " + (endTime - startTime));
	}

}
