package cinema.controller;


import cinema.entity.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import java.sql.Ref;
import java.util.UUID;

@RestController

public class SeatsRestController {

    private Seats seating = new Seats();
    Stats status = new Stats();


    @GetMapping("/seats")
    public Seats getSeating() {
        return seating;
    }

    @PostMapping("/purchase")
    public Ticket purchaseSeat(@RequestBody Seat seat) throws SeatPurchaseException {
        if (seat.getColumn() > seating.getTotal_columns()
                || seat.getRow() > seating.getTotal_rows()
                || seat.getRow() < 0
                || seat.getColumn() < 0
        ) {
            throw new SeatPurchaseException("The number of a row or a column is out of bounds!");
        }
        Seat purchasedSeat = null;

        for (Seat availableSeat: seating.getAvailable_seats()) {
            if(availableSeat.equals(seat)) {
                if (availableSeat.isAvailable()) {
                    availableSeat.setAvailable(false);
                    purchasedSeat = availableSeat;
                    status.setCurrent_income(
                            seating.getTaken_seats()
                                    .stream()
                                    .reduce(0, (a,b) -> a + b.getPrice(), Integer::sum)
                    );
                    status.setNumberOfAvailabeSeats(seating.getAvailable_seats().size());
                    status.setNumberOfPurchasedTickets(seating.getTaken_seats().size());
                }
                break;
            }
        }

        if (purchasedSeat == null) {
            throw new SeatPurchaseException("The ticket has been already purchased!");
        }
        return new Ticket(purchasedSeat.getToken(), purchasedSeat);

    }

    @PostMapping("/return")
    public Refund refund(@RequestBody Refund refund) throws SeatPurchaseException {
        Refund refunded = null;
        System.out.println(refund);
        for (Seat seat: seating.getTaken_seats()) {
            if(seat.getToken().equals(refund.getToken())) {
                seat.setAvailable(true);
                refunded = new Refund(refund.getToken(), seat);
                status.setCurrent_income(
                        seating.getTaken_seats()
                                .stream()
                                .reduce(0, (a,b) -> a + b.getPrice(), Integer::sum)
                );
                status.setNumberOfAvailabeSeats(seating.getAvailable_seats().size());
                status.setNumberOfPurchasedTickets(seating.getTaken_seats().size());
                break;
            }
        }

        if (refunded == null) {
            throw new SeatPurchaseException("Wrong token!");
        }

        return refunded;
    }

    @PostMapping("/stats")
    public Stats seatStatus(@RequestParam(value = "password", required = false) String password) throws SeatAuthorizationException {
        if(password == null) {
            throw new SeatAuthorizationException("The password is wrong!");
        }
        return status;
    }


    @ExceptionHandler(SeatPurchaseException.class)
    public ResponseEntity<Error> handleException(SeatPurchaseException e) {
        Error error = new Error(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getStatus());
    }

    @ExceptionHandler(SeatAuthorizationException.class)
    public ResponseEntity<Error> handleAuthorizationException(SeatAuthorizationException e) {
        Error error = new Error(HttpStatus.UNAUTHORIZED, e.getLocalizedMessage());
        return new ResponseEntity<>(error, error.getStatus());
    }
}