package ticketing.entities;

import ticketing.ticketservice.SeatData;

import java.sql.Timestamp;
import java.util.concurrent.CompletableFuture;

public class SeatHold {

    private int seatHoldId;
    private int numberOfSeatsHeld;
    private int timeLengthOfSeatsHeld;
    private boolean holdValidity;
    private boolean reserved;
    private String customerEmail;
    private Timestamp timeCreated;
    private Timestamp timeUpdated;

    public SeatHold(
            int numberOfSeatsHeld,
            int seatHoldId,
            String customerEmail,
            int timeLengthOfSeatsHeld
    ) {
        this.holdValidity = true;
        this.timeLengthOfSeatsHeld = timeLengthOfSeatsHeld;
        this.seatHoldId = seatHoldId;
        this.numberOfSeatsHeld = numberOfSeatsHeld;
        this.customerEmail = customerEmail;
        this.timeCreated = getCurrentUTCTimestamp();
        CompletableFuture.runAsync(this::setTimeout);
    }

    public int getSeatHoldId() {
        return seatHoldId;
    }

    public void setSeatHoldId(int seatHoldId) {
        this.seatHoldId = seatHoldId;
    }

    public int getNumberOfSeatsHeld() {
        return numberOfSeatsHeld;
    }

    public void setNumberOfSeatsHeld(int numberOfSeatsHeld) {
        this.numberOfSeatsHeld = numberOfSeatsHeld;
    }

    public int getTimeLengthOfSeatsHeld() {
        return timeLengthOfSeatsHeld;
    }

    public void setTimeLengthOfSeatsHeld(int timeLengthOfSeatsHeld) {
        this.timeLengthOfSeatsHeld = timeLengthOfSeatsHeld;
    }

    public Timestamp getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Timestamp timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Timestamp getTimeUpdated() {
        return timeUpdated;
    }

    public void setTimeUpdated(Timestamp timeUpdated) {
        this.timeUpdated = timeUpdated;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isHoldValidity() {
        return holdValidity;
    }

    public void setHoldValidity(boolean holdValidity) {
        this.holdValidity = holdValidity;
    }

    public String setReservation(String customerEmail) {
        if (this.holdValidity && customerEmail.equalsIgnoreCase(this.customerEmail)) {
            this.reserved = true;
            return this.getReservationConfirmationCode();
        } else {
            return null;
        }
    }

    public String getReservationConfirmationCode() {
        return String.valueOf(this.timeCreated.getTime()) + this.customerEmail;
    }

    private Timestamp getCurrentUTCTimestamp() {
        return new Timestamp(System.currentTimeMillis() / 1000);
    }


    private void setTimeout() {
        try{
            Thread.sleep(this.timeLengthOfSeatsHeld);
            if (!this.reserved) {
                this.holdValidity = false;
                this.updateSeatMap();
                SeatData.seatsOccupied -= this.numberOfSeatsHeld;
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    private void updateSeatMap() {
        int numOfSeatsCount = 0;
        outerloop:
        for(int i = 0; i < SeatData.seatMap.length; i ++) {
            for(int j = 0; j < SeatData.seatMap[i].length; j ++) {
                if (SeatData.seatMap[i][j] == seatHoldId) {
                    SeatData.seatMap[i][j] = 0;
                    numOfSeatsCount++;
                }
                if (numOfSeatsCount == this.numberOfSeatsHeld) {
                    break outerloop;
                }
            }
        }
        SeatData.seatHoldMap.remove(this.seatHoldId);
    }
}
