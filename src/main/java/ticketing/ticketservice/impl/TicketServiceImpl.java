package ticketing.ticketservice.impl;

import ticketing.entities.SeatHold;
import ticketing.ticketservice.SeatData;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements ticketing.ticketservice.TicketService {
    /**
     * The number of seats in the venue that are neither held nor reserved
     *
     * @return the number of tickets available in the venue
     */
    public int numSeatsAvailable() {
        return SeatData.totalNumberOfSeats - SeatData.seatsOccupied;
    }
    /**
     * Find and hold the best available seats for a customer
     *
     * @param numSeats the number of seats to find and hold
     * @param customerEmail unique identifier for the customer
     * @return a SeatHold object identifying the specific seats and related
    information
     */
    public SeatHold findAndHoldSeats(int numSeats, String customerEmail) {
        if (numSeats < 1 || customerEmail == null) {
            return null;
        } else {
            int adjacentSeatsCount = 0;
            for(int i = 0; i < SeatData.seatMap.length; i ++) {
                for(int j = 0; j < SeatData.seatMap[i].length; j ++) {
                    if (SeatData.seatMap[i][j] == 0) {
                        SeatData.seatMap[i][j] = SeatData.seatHoldId;
                        adjacentSeatsCount++;
                        if (adjacentSeatsCount == numSeats) {
                            SeatHold seatHold = new SeatHold(numSeats, SeatData.seatHoldId, customerEmail, SeatData.timeoutAmount);
                            SeatData.seatHoldMap.put(SeatData.seatHoldId, seatHold);
                            SeatData.seatHoldId++;
                            SeatData.seatsOccupied += numSeats;
                            return seatHold;
                        }
                    } else {
                        adjacentSeatsCount = 0;
                    }
                }
            }
            return null;
        }
    }
    /**
     * Commit seats held for a specific customer
     *
     * @param seatHoldId the seat hold identifier
     * @param customerEmail the email address of the customer to which the
    seat hold is assigned
     * @return a reservation confirmation code
     */
    public String reserveSeats(int seatHoldId, String customerEmail) {
        String reservationCode = SeatData.seatHoldMap.get(seatHoldId).setReservation(customerEmail);
        if (reservationCode != null) {
            SeatData.seatReservedMap.put(seatHoldId, SeatData.seatHoldMap.get(seatHoldId));
            SeatData.seatHoldMap.remove(seatHoldId);
        }
        return reservationCode;
    }

}
