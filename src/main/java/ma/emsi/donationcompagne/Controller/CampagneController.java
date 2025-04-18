package ma.emsi.donationcompagne.Controller;

import ma.emsi.donationcompagne.projection.CampagneResume;
import ma.emsi.donationcompagne.service.ServiceCampagne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes")
public class CampagneController {

    private final ServiceCampagne serviceCampagne;

    @Autowired
    public CampagneController(ServiceCampagne serviceCampagne) {
        this.serviceCampagne = serviceCampagne;
    }

    @GetMapping("/actives")
    public ResponseEntity<List<CampagneResume>> getCampagnesActives() {
        List<CampagneResume> campagnesActives = serviceCampagne.getCampagnesActives();
        return ResponseEntity.ok(campagnesActives);
    }
}
