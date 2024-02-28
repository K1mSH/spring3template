package boot.mytemp.controller;

import boot.mytemp.dto.Reservation;
import boot.mytemp.service.ReservationService;
import boot.mytemp.service.ReservationServiceImpl;
import boot.mytemp.uuid.UuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    ReservationServiceImpl reservationService;

    @Autowired
    UuidGenerator uuidGenerator;

    @GetMapping("/reserve")
    public String bookView(){
        return "views/reserve";
    }

    @GetMapping("/reservation")
    public String showReservations(Model model) {
        List<Reservation> reservations = reservationService.getAllReservations();
        model.addAttribute("reservations", reservations);
        return "reservation";
    }

    @PostMapping("/insertReservation")
    public ResponseEntity<String> insertReservation(@RequestBody Reservation reservation) {
        try {
            String name = reservation.getName();
            String id = uuidGenerator.getUuid().toString();
            reservation.setId(id);

            reservationService.insertReservation(reservation);

            return new ResponseEntity<>("Reservation for " + name + " has been successfully inserted.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to insert reservation. Reason: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
