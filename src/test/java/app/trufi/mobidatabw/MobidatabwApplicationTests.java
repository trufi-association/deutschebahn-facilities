package app.trufi.mobidatabw;

import app.trufi.mobidatabw.model.Facility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class MobidatabwApplicationTests {

	@Autowired
	FacilitiesLoader facilitiesLoader;

	@Test
	void facilityFilteringWorks() {
		List<Facility> cachedFacilities = facilitiesLoader.getCachedFacilities();
		Optional<Facility> station = cachedFacilities.stream().filter(facility -> facility.getEquipmentnumber() == 10547808).findFirst();
		assertTrue(station.isPresent());
		assertEquals(3925, station.get().getStationnumber());
	}

}
