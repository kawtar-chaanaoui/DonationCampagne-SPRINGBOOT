package ma.emsi.donationcompagne.repository;

import ma.emsi.donationcompagne.entity.Campagne;
import ma.emsi.donationcompagne.projection.CampagneResume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CampagneRepository extends JpaRepository<Campagne, Long> {

    @Query("SELECT c FROM Campagne c WHERE c.dateDebut <= ?1 AND c.dateFin >= ?1")
    List<CampagneResume> findActiveCampaigns(LocalDate currentDate);
}