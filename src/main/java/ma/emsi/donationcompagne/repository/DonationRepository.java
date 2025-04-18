package ma.emsi.donationcompagne.repository;

import ma.emsi.donationcompagne.entity.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findByCampagneId(Long campagneId);
}