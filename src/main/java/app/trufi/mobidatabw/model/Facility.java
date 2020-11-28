package app.trufi.mobidatabw.model;

public class Facility {
    // names taken from API model schema
    long equipmentnumber;
    FacilityType type;
    String description;
    double geocoordX;
    double geocoordY;
    FacilityState state;
    String stateExplanation;
    long stationnumber;
    String operatorName;

    public long getEquipmentnumber() {
        return equipmentnumber;
    }

    public void setEquipmentnumber(long equipmentnumber) {
        this.equipmentnumber = equipmentnumber;
    }

    public FacilityType getType() {
        return type;
    }

    public void setType(FacilityType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getGeocoordX() {
        return geocoordX;
    }

    public void setGeocoordX(double geocoordX) {
        this.geocoordX = geocoordX;
    }

    public double getGeocoordY() {
        return geocoordY;
    }

    public void setGeocoordY(double geocoordY) {
        this.geocoordY = geocoordY;
    }

    public FacilityState getState() {
        return state;
    }

    public void setState(FacilityState state) {
        this.state = state;
    }

    public String getStateExplanation() {
        return stateExplanation;
    }

    public void setStateExplanation(String stateExplanation) {
        this.stateExplanation = stateExplanation;
    }

    public long getStationnumber() {
        return stationnumber;
    }

    public void setStationnumber(long stationnumber) {
        this.stationnumber = stationnumber;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    @Override
    public String toString() {
        return "Facility{"
                + "equipmentNumber="
                + equipmentnumber
                + ", type="
                + type
                + ", description='"
                + description
                + '\''
                + ", geocoordX="
                + geocoordX
                + ", geocoordY="
                + geocoordY
                + ", state="
                + state
                + ", stateExplanation='"
                + stateExplanation
                + '\''
                + ", stationnumber="
                + stationnumber
                + (operatorName != null ? ", operatorName='" + operatorName + '\'' : "")
                + '}';
    }
}
