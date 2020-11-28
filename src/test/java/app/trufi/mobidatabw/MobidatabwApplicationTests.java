package app.trufi.mobidatabw;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.trufi.mobidatabw.model.Facility;
import app.trufi.mobidatabw.model.FacilityState;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MobidatabwApplicationTests {

    public static final int EQUIPMENT_NUMBER = 10467564;
    @Autowired FacilitiesLoader facilitiesLoader;

    @Test
    void facilityFilteringWorks() {
        List<Facility> cachedFacilities = facilitiesLoader.getCachedFacilities();
        Optional<Facility> station =
                cachedFacilities.stream()
                        .filter(facility -> facility.getEquipmentnumber() == 10547808)
                        .findFirst();
        assertTrue(station.isPresent());
        assertEquals(3925, station.get().getStationnumber());
    }

    @Test
    void mockDisablingWorks() {
        facilitiesLoader.markAsDisabled(EQUIPMENT_NUMBER);
        assertEquals(
                FacilityState.INACTIVE,
                facilitiesLoader.getFacility(EQUIPMENT_NUMBER).get().getState());
    }
}
