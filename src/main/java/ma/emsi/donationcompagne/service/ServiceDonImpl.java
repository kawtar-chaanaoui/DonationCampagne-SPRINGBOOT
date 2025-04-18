package ma.emsi.donationcompagne.service;

import ma.emsi.donationcompagne.dto.DonDTO;
import ma.emsi.donationcompagne.entity.Campagne;
import ma.emsi.donationcompagne.entity.Donation;
import ma.emsi.donationcompagne.exception.CampagneNotFoundException;
import ma.emsi.donationcompagne.repository.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ServiceDonImpl implements ServiceDon {

    private final DonationRepository donationRepository;
    private final ServiceCampagne serviceCampagne;

    @Autowired
    public ServiceDonImpl(DonationRepository donationRepository, ServiceCampagne serviceCampagne) {
        this.donationRepository = donationRepository;
        this.serviceCampagne = serviceCampagne;
    }

    @Override
    @Transactional
    public DonDTO enregistrerDon(Long campagneId, DonDTO donDTO) {
        Campagne campagne = serviceCampagne.getCampagneById(campagneId)
                .orElseThrow(() -> new CampagneNotFoundException("Campagne non trouvée avec l'ID: " + campagneId));

        Donation donation = new Donation();
        donation.setCampagne(campagne);
        donation.setNomDonateur(donDTO.getNomDonateur());
        donation.setMontant(donDTO.getMontant());
        donation.setDate(LocalDateTime.now());

        Donation savedDonation = donationRepository.save(donation);
        return convertToDTO(savedDonation);
    }

    @Override
    public DonDTO convertToDTO(Donation donation) {
        DonDTO donDTO = new DonDTO();
        donDTO.setId(donation.getId());
        donDTO.setNomCampagne(donation.getCampagne().getNom());
        donDTO.setNomDonateur(donation.getNomDonateur());
        donDTO.setMontant(donation.getMontant());
        donDTO.setDate(donation.getDate());
        return donDTO;
    }

    @Override
    public Donation convertToEntity(DonDTO donDTO) {
        Donation donation = new Donation();
        donation.setNomDonateur(donDTO.getNomDonateur());
        donation.setMontant(donDTO.getMontant());
        donation.setDate(donDTO.getDate() != null ? donDTO.getDate() : LocalDateTime.now());
        return donation;
    }
}