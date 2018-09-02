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
            int[] startingSeat = new int[2];
            int adjacentSeatsCount = 0;
            for(int i = 0; i < SeatData.seatMap.length; i ++) {
                for(int j = 0; j < SeatData.seatMap[i].length; j ++) {
                    if (SeatData.seatMap[i][j] != 1) {
                        if (adjacentSeatsCount == 0) {
                            startingSeat[0] = i;
                            startingSeat[1] = j;
                        }
                        adjacentSeatsCount++;
                        if (adjacentSeatsCount == numSeats) {
                            this.markSeatMap(numSeats, startingSeat, SeatData.seatHoldId);
                            SeatHold seatHold = new SeatHold(numSeats, SeatData.seatHoldId, customerEmail);
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
        return null;
    }

    private void markSeatMap(int numOfSeats, int[] startingSeat, int seatHoldId) {
        int numOfSeatsCount = 0;
        outerloop:
        for(int i = startingSeat[0]; i < SeatData.seatMap.length; i ++) {
            for(int j = startingSeat[1]; j < SeatData.seatMap[i].length; j ++) {
                SeatData.seatMap[i][j] = seatHoldId;
                numOfSeatsCount++;
                if (numOfSeatsCount == numOfSeats) {
                    break outerloop;
                }
            }
        }
    }

}
