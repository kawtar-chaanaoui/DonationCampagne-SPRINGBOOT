package ma.emsi.donationcompagne.service;

import ma.emsi.donationcompagne.dto.DonDTO;
import ma.emsi.donationcompagne.entity.Donation;

public interface ServiceDon {

    DonDTO enregistrerDon(Long campagneId, DonDTO donDTO);

    DonDTO convertToDTO(Donation donation);

    Donation convertToEntity(DonDTO donDTO);
}