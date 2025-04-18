package ma.emsi.donationcompagne.controller;

import ma.emsi.donationcompagne.projection.CampagneResume;
import ma.emsi.donationcompagne.service.ServiceCampagne;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/campagnes")
@Tag(name = "Campagnes", description = "API pour gérer les campagnes")
public class CampagneController {

    private final ServiceCampagne serviceCampagne;

    @Autowired
    public CampagneController(ServiceCampagne serviceCampagne) {
        this.serviceCampagne = serviceCampagne;
    }

    @GetMapping("/actives")
    @Operation(summary = "Récupérer les campagnes actives",
            description = "Retourne la liste des campagnes actuellement actives (date actuelle comprise entre dateDebut et dateFin)")
    public ResponseEntity<List<CampagneResume>> getCampagnesActives() {
        List<CampagneResume> campagnesActives = serviceCampagne.getCampagnesActives();
        return ResponseEntity.ok(campagnesActives);
    }
}