package com.digitalsingular.rxdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.digitalsingular.rxdb.enclosure.Enclosure;
import com.digitalsingular.rxdb.enclosure.EnclosureService;

import reactor.core.publisher.Flux;

public class RxdbClientApplication {

	private static Logger logger = LoggerFactory.getLogger(RxdbClientApplication.class);
	
	public static void main(String[] args) throws InterruptedException {
		EnclosureService enclosureService = new EnclosureService();
		Flux<Enclosure> enclosures = enclosureService.getByPlot(90140);
		long startTime = System.currentTimeMillis();
		enclosures.subscribe(enclosure -> logger.info("Enclosure " + enclosure.getId()));
		long endTime = System.currentTimeMillis();
		logger.info("Total time " + (endTime - startTime));
		Thread.sleep(30000L);
	}

}
