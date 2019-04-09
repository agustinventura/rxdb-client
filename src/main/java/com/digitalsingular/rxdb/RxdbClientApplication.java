package com.digitalsingular.rxdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.digitalsingular.rxdb.enclosure.Enclosure;
import com.digitalsingular.rxdb.enclosure.EnclosureService;

import reactor.core.publisher.Flux;

public class RxdbClientApplication {

	private static Logger logger = LoggerFactory.getLogger(RxdbClientApplication.class);
	
	private static long startTime;
	
	public static void main(String[] args) throws InterruptedException {
		EnclosureService enclosureService = new EnclosureService();
		Flux<Enclosure> enclosures = enclosureService.getByPlot(1);
		startTime = System.currentTimeMillis();
		enclosures.doOnComplete(() -> {logger.info("Total time " + (System.currentTimeMillis() - startTime));}).subscribe(enclosure -> logger.info("Enclosure " + enclosure.getId()));
		Thread.sleep(30000L);
	}

}
