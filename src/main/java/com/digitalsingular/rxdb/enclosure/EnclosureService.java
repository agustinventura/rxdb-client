package com.digitalsingular.rxdb.enclosure;

import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

public class EnclosureService {

	private WebClient client;

	public EnclosureService() {
		super();
		this.client = WebClient.create("http://localhost:8080");
	}

	public Flux<Enclosure> getByPlot(int plot) {
		return client.get().uri(uriBuilder -> uriBuilder.path("/enclosures").queryParam("plot", plot).build())
				.retrieve()
			    .bodyToFlux(Enclosure.class);
	}

}
