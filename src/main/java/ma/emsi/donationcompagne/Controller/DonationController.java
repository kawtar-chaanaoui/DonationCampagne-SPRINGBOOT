package ma.emsi.donationcompagne.controller;

import ma.emsi.donationcompagne.dto.DonDTO;
import ma.emsi.donationcompagne.service.ServiceDon;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/campagnes")
@Tag(name = "Dons", description = "API pour gérer les dons aux campagnes")
public class DonationController {

    private final ServiceDon serviceDon;

    @Autowired
    public DonationController(ServiceDon serviceDon) {
        this.serviceDon = serviceDon;
    }

    @PostMapping("/{id}/dons")
    @Operation(summary = "Enregistrer un don pour une campagne",
            description = "Enregistre un nouveau don pour la campagne spécifiée")
    public ResponseEntity<DonDTO> enregistrerDon(
            @PathVariable Long id,
            @Valid @RequestBody DonDTO donDTO) {
        DonDTO savedDon = serviceDon.enregistrerDon(id, donDTO);
        return new ResponseEntity<>(savedDon, HttpStatus.CREATED);
    }
}