package za.ac.cput.domain;

public class Tracking {
    private String tripId;
    private int stops;
    private int detours;

    private Tracking (Tracking.Builder builder){
        tripId = builder.tripId;
        stops = builder.stops;
        detours = builder.detours;
    }

    public String getTripId() {
        return tripId;
    }

    public int getStops() {
        return stops;
    }

    public int getDetours() {
        return detours;
    }

    @Override
    public String toString() {
        return "Tracking{" +
                "tripId='" + tripId + '\'' +
                ", stops=" + stops +
                ", detours=" + detours +
                '}';
    }

    public static class Builder{
        private String tripId;
        private int stops;
        private int detours;

        public Builder setTripId(String tripId) {
            this.tripId = tripId;
            return this;
        }

        public Builder setStops(int stops) {
            this.stops = stops;
            return this;
        }

        public Builder setDetours(int detours) {
            this.detours = detours;
            return this;
        }
        public Builder copy(Tracking tracking){
            this.tripId = tripId;
            this.stops = stops;
            this.detours = detours;
            return this;
        }
        public Tracking build(){return new Tracking(this);}
    }
}
