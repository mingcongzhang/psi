package ticketing.entities;

import java.sql.Timestamp;

public class SeatHold {

    private int seatHoldId;
    private int numberOfSeatsHeld;
    private int timeLengthOfSeatsHeld;
    private String customerEmail;
    private Timestamp timeCreated;
    private Timestamp timeUpdated;

    public SeatHold(int numberOfSeatsHeld, int seatHoldId, String customerEmail) {
        this.seatHoldId = seatHoldId;
        this.numberOfSeatsHeld = numberOfSeatsHeld;
        this.customerEmail = customerEmail;
        this.timeCreated = getCurrentUTCTimestamp();
        this.timeUpdated =getCurrentUTCTimestamp();
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

    private Timestamp getCurrentUTCTimestamp() {
        return new Timestamp(System.currentTimeMillis() / 1000);
    }

}
