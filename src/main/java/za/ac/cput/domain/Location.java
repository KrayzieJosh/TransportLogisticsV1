package za.ac.cput.domain;
/* Location.java
 Entity for the Location
 Author: Joshua Jacobs (221144862)
 Date: 11 June 2023
*/

public class Location {
    private String locationId;
    private String name;
    private int streetNumber;
    private String streetName;
    private String townOrCity;
    private int areaCode;

    public Location(Location.Builder builder){
        this.locationId = builder.locationId;
        this.name = builder.name;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.townOrCity = builder.townOrCity;
        this.areaCode = builder.areaCode;
    }

    public String getLocationId() {
        return locationId;
    }
    public String getName() {
        return name;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getTownOrCity() {
        return townOrCity;
    }

    public int getAreaCode() {
        return areaCode;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + locationId + '\'' +
                ", streetNumber=" + streetNumber +
                ", streetName='" + streetName + '\'' +
                ", townOrCity='" + townOrCity + '\'' +
                ", areaCode=" + areaCode +
                '}';
    }
    public static class Builder{
        private String locationId;
        private String name;
        private int streetNumber;
        private String streetName;
        private String townOrCity;
        private int areaCode;

        public Builder setLocationId(String locationId) {
            this.locationId = locationId;
            return this;
        }
        public Builder setName(String name){
            this.name =name;
            return this;
        }

        public Builder setStreetNumber(int streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setTownOrCity(String townOrCity) {
            this.townOrCity = townOrCity;
            return this;
        }

        public Builder setAreaCode(int areaCode) {
            this.areaCode = areaCode;
            return this;
        }
        public Builder copy(Location location){
            this.locationId = locationId;
            this.name = name;
            this.streetNumber = streetNumber;
            this.streetName = streetName;
            this.townOrCity = townOrCity;
            this.areaCode = areaCode;
            return this;
        }
        public Location build(){return new Location(this);}
    }
}
