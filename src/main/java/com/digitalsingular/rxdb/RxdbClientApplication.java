package com.digitalsingular.rxdb;

import com.digitalsingular.rxdb.enclosure.Enclosure;
import com.digitalsingular.rxdb.enclosure.EnclosureService;

import reactor.core.publisher.Flux;

public class RxdbClientApplication {

	public static void main(String[] args) {
		EnclosureService enclosureService = new EnclosureService();
		Flux<Enclosure> enclosures = enclosureService.getByPlot(1);
		//enclosures.subscribe(RxdbClientApplication::handleEnclosure);
		handleEnclosure(enclosures.blockLast());
	}

	private static void handleEnclosure(Enclosure enclosure) {
		System.out.println("Enclosure " + enclosure.getId());
	}

}
