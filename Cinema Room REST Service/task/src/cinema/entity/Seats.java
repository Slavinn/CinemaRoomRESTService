package cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.UUID.randomUUID;


public class Seats {

    static final int total_rows = 9;
    static final int total_columns = 9;


    static List<Seat> available_seats;

    static {
        available_seats = new ArrayList<>();
        for (int i = 0; i < total_rows ; i++) {

            for (int j = 0; j < total_columns; j++) {
                available_seats.add(new Seat(i+1,j+1));
            }
        }
    }


    public Seats() {
    }

    public Seats(List<Seat> available_seats) {
        Seats.available_seats = available_seats;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats.stream()
                .filter(seat -> seat.available)
                .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<Seat> getTaken_seats() {
        return available_seats.stream()
                .filter(seat -> !seat.available)
                .collect(Collectors.toList());
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        Seats.available_seats = available_seats;

    }

    @Override
    public String toString() {
        return "Seats{" +
                "total_rows=" + total_rows +
                ", total_columns=" + total_columns +
                ", available_seats=" + available_seats +
                '}';
    }
}
