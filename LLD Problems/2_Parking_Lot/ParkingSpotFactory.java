public class ParkingSpotFactory {
    
    public static ParkingSpot get(SpotType spotType) {
        switch(spotType) {
            case SMALL : return new SmallParkingSpot();
            case MEDIUM : return new MediumParkingSpot();
            default : {
                throw new IllegalArgumentException("Unsupported spot type.");
            }
        }
    }
}
