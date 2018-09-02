package ticketing.controllers;

import ticketing.entities.SeatHold;
import ticketing.ticketservice.SeatData;
import ticketing.ticketservice.TicketService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ReservationController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(path="/test", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody String test() {
        JSONObject jbt = new JSONObject();
        jbt.put("test", SeatData.seatMap);
        return jbt.toString();
    }

    @RequestMapping(path="/reset", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody String resetSeatMap() {
        JSONObject jbt = new JSONObject();
        SeatData.reset();
        jbt.put("test", SeatData.seatMap);
        return jbt.toString();
    }

    @RequestMapping(path="/numSeatsAvailable", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody String setTotalNumberOfSeats() {
        JSONObject jbt = new JSONObject();
        jbt.put("totalNumberOfSeats", ticketService.numSeatsAvailable());
        return jbt.toString();
    }

    @RequestMapping(path="/findAndHoldSeats", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity findAndHoldSeats(@RequestParam int numSeats, @RequestParam String customerEmail) {
        JSONObject jbt = new JSONObject();
        if (numSeats < 1 || customerEmail == null) {
            jbt.put("status", "failure");
            jbt.put("reason", "missing numSeats or customerEmail");
            return ResponseEntity.badRequest().body(jbt.toString());
        } else if (ticketService.numSeatsAvailable() < numSeats) {
            jbt.put("status", "failure");
            jbt.put("reason", "not enough seats available");
            return ResponseEntity.badRequest().body(jbt.toString());
        } else {
            SeatHold seatHold = ticketService.findAndHoldSeats(numSeats, customerEmail);
            jbt.put("status", "success");
            jbt.put("seatHoldId", seatHold.getSeatHoldId());
            jbt.put("customerEmail", seatHold.getCustomerEmail());
            jbt.put("seatMap", SeatData.seatMap);
            return ResponseEntity.accepted().body(jbt.toString());
        }
    }

    @RequestMapping(path="/reserveSeats", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity reserveSeats(@RequestParam int seatHoldId, @RequestParam String customerEmail) {
        JSONObject jbt = new JSONObject();
        if (seatHoldId < 1 || customerEmail == null) {
            jbt.put("status", "failure");
            jbt.put("reason", "missing numSeats or customerEmail");
            return ResponseEntity.badRequest().body(jbt.toString());
        } else {
            String confirmationCode = ticketService.reserveSeats(seatHoldId, customerEmail);
            if (confirmationCode == null) {
                jbt.put("status", "failure");
                jbt.put("reason", "incorrect email or seatHold has expired");
                return ResponseEntity.badRequest().body(jbt.toString());
            }
            jbt.put("status", "success");
            jbt.put("confirmationCode", confirmationCode);
            jbt.put("seatMap", SeatData.seatMap);
            return ResponseEntity.accepted().body(jbt.toString());
        }
    }

}
