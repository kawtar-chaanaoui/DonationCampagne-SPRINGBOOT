package ma.emsi.donationcompagne.service;

import ma.emsi.donationcompagne.entity.Campagne;
import ma.emsi.donationcompagne.projection.CampagneResume;
import ma.emsi.donationcompagne.repository.CampagneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceCampagneImpl implements ServiceCampagne {

    private final CampagneRepository campagneRepository;

    @Autowired
    public ServiceCampagneImpl(CampagneRepository campagneRepository) {
        this.campagneRepository = campagneRepository;
    }

    @Override
    public List<CampagneResume> getCampagnesActives() {
        return campagneRepository.findActiveCampaigns(LocalDate.now());
    }

    @Override
    public Optional<Campagne> getCampagneById(Long id) {
        return campagneRepository.findById(id);
    }

    @Override
    public Campagne saveCampagne(Campagne campagne) {
        return campagneRepository.save(campagne);
    }
}