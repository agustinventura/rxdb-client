package com.digitalsingular.rxdb.enclosure;

import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class EnclosureService {

	public Set<Enclosure> getByPlot(int plot) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Set<Enclosure>> response = restTemplate.exchange(
		  "http://localhost:8080/enclosures?plot=" + plot,
		  HttpMethod.GET,
		  null,
		  new ParameterizedTypeReference<Set<Enclosure>>(){});
		return response.getBody();
	}
}
