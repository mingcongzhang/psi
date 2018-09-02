package ticketing.ticketservice;

import ticketing.entities.SeatHold;

import java.util.HashMap;
import java.util.Map;

public class SeatData {
    public static int totalNumberOfSeats = 100;
    public static int timeoutAmount = 5000;

    public static int seatHoldId = 1;
    public static int seatsOccupied = 0;
    public static int[][] seatMap = new int[10][10]; // any value greater than 0 is the seatHoldId and means the seat is occupied; value 0 means seat is empty
    public static Map<Integer, SeatHold> seatHoldMap = new HashMap<Integer, SeatHold>(); // Store list of seatHold id and object pairs on hold
    public static Map<Integer, SeatHold> seatReservedMap = new HashMap<Integer, SeatHold>(); // Store list of seatHold id and object pairs on reservation
}
