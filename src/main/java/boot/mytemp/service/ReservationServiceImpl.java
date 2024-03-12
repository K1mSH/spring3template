package boot.mytemp.service;

import boot.mytemp.dto.Reservation;
import boot.mytemp.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    ReservationMapper reservationMapper;

    @Override
    public List<Reservation> getAllReservations() {
        System.out.println("kk");
        return reservationMapper.getAllReservations();
    }

    @Override
    public void insertReservation(Reservation reservation) {
        reservationMapper.insertReservation(reservation);
    }
}
