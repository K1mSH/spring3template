package boot.mytemp.mapper;

import boot.mytemp.dto.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    public List<Reservation> getAllReservations();
    public void insertReservation(Reservation reservation);
}
