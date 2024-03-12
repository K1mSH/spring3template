package boot.mytemp.service;

import boot.mytemp.dto.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> getAllReservations();
    public void insertReservation(Reservation reservation);
}
