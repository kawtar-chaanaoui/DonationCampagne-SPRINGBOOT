package ma.emsi.donationcompagne.projection;

import java.math.BigDecimal;

public interface CampagneResume {
    Long getId();
    String getNom();
    BigDecimal getObjectifMontant();
}