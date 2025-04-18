package ma.emsi.donationcompagne.exception;

public class CampagneNotFoundException extends RuntimeException {

    public CampagneNotFoundException(String message) {
        super(message);
    }
}