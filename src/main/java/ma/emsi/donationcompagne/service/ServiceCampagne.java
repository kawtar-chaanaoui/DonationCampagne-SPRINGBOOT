package ma.emsi.donationcompagne.service;

import ma.emsi.donationcompagne.entity.Campagne;
import ma.emsi.donationcompagne.projection.CampagneResume;

import java.util.List;
import java.util.Optional;

public interface ServiceCampagne {

    List<CampagneResume> getCampagnesActives();

    Optional<Campagne> getCampagneById(Long id);

    Campagne saveCampagne(Campagne campagne);
}