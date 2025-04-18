package ma.emsi.donationcompagne.Controller;

import ma.emsi.donationcompagne.dto.DonDTO;
import ma.emsi.donationcompagne.service.ServiceDon;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/campagnes")
public class DonationController {

    private final ServiceDon serviceDon;

    @Autowired
    public DonationController(ServiceDon serviceDon) {
        this.serviceDon = serviceDon;
    }

    @PostMapping("/{id}/dons")
    public ResponseEntity<DonDTO> enregistrerDon(
            @PathVariable Long id,
            @Valid @RequestBody DonDTO donDTO) {
        DonDTO savedDon = serviceDon.enregistrerDon(id, donDTO);
        return new ResponseEntity<>(savedDon, HttpStatus.CREATED);
    }
}
