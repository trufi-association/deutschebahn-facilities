package app.trufi.mobidatabw;

import app.trufi.mobidatabw.model.Facility;
import org.springframework.beans.factory.annotation.Value;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Component
public class FacilitiesLoader {

	Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	List<Facility> cachedFacilities;

	@Value("${accessToken}")
	String accessToken;

	@Scheduled(fixedRate=60*1000)
	public void refreshFacilities() {
		logger.info("Refreshing the facilities from the Deustchebahn API...");
		WebClient dbApiClient = WebClient.builder()//
				.baseUrl("https://api.deutschebahn.com")
				.defaultHeader("Accept", "application/json")//
				.defaultHeader("Authorization", "Bearer " + accessToken)
				.build();
		WebClient.RequestBodySpec facilitiesReq = dbApiClient.method(HttpMethod.GET).uri(URI.create("https://api.deutschebahn.com/fasta/v2/facilities"));
		try {
			ResponseEntity<List<Facility>> response = facilitiesReq.retrieve().toEntityList(Facility.class).block();
			assert response != null;
			this.cachedFacilities = response.getBody();
			logger.info("Facilities refreshed successfully");
		} catch (Exception ex) {
			logger.error("An error occured while refreshing the facilities", ex);
		}
	}

	public List<Facility> getCachedFacilities() {
		if (cachedFacilities == null) {
			refreshFacilities();
		}
		return cachedFacilities;
	}

	public Optional<Facility> getFacility(int equipmentNumber) {
		if (cachedFacilities == null) {
			refreshFacilities();
		}
		return cachedFacilities.stream().filter(facility -> facility.getEquipmentnumber() == equipmentNumber).findFirst();
	}
}
