package app.trufi.mobidatabw;

import app.trufi.mobidatabw.model.Facility;
import app.trufi.mobidatabw.model.FacilityState;
import app.trufi.mobidatabw.model.FacilityType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FacilitiesController {

    FacilitiesLoader facilitiesLoader;

    public FacilitiesController(@Autowired FacilitiesLoader facilitiesLoader) {
        this.facilitiesLoader = facilitiesLoader;
    }

    @GetMapping("/facilities")
    public List<Facility> getFacilities(
            @RequestParam(value = "type", required = false) List<FacilityType> types,
            @RequestParam(value = "state", required = false) List<FacilityState> states,
            @RequestParam(value = "equipmentnumbers", required = false) List<Long> equipmentNumbers,
            @RequestParam(value = "stationnumber", required = false) Long stationNumber) {
        Stream<Facility> facilities = facilitiesLoader.getCachedFacilities().stream();
        if (types != null && !types.isEmpty()) {
            facilities = facilities.filter(facility -> types.contains(facility.getType()));
        }
        if (states != null && !states.isEmpty()) {
            facilities = facilities.filter(facility -> states.contains(facility.getState()));
        }
        if (equipmentNumbers != null && !equipmentNumbers.isEmpty()) {
            facilities =
                    facilities.filter(
                            facility -> equipmentNumbers.contains(facility.getEquipmentnumber()));
        }
        if (stationNumber != null) {
            facilities =
                    facilities.filter(facility -> facility.getStationnumber() == stationNumber);
        }
        return facilities.collect(Collectors.toList());
    }
}
