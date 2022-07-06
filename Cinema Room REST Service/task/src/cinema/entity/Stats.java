package cinema.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {

    private int current_income;

    @JsonProperty("number_of_available_seats")
    private int numberOfAvailabeSeats;

    @JsonProperty("number_of_purchased_tickets")
    private int numberOfPurchasedTickets;


    public Stats() {
        this.current_income = 0;
        this.numberOfAvailabeSeats = Seats.available_seats.size();
        this.numberOfPurchasedTickets = 0;
    }

    public int getCurrent_income() {
        return current_income;
    }

    public void setCurrent_income(int current_income) {
        this.current_income = current_income;
    }

    public int getNumberOfAvailabeSeats() {
        return numberOfAvailabeSeats;
    }

    public void setNumberOfAvailabeSeats(int numberOfAvailabeSeats) {
        this.numberOfAvailabeSeats = numberOfAvailabeSeats;
    }

    public int getNumberOfPurchasedTickets() {
        return numberOfPurchasedTickets;
    }

    public void setNumberOfPurchasedTickets(int numberOfPurchasedTickets) {
        this.numberOfPurchasedTickets = numberOfPurchasedTickets;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "current_income=" + current_income +
                ", numberOfAvailabeSeats=" + numberOfAvailabeSeats +
                ", numberOfPurchasedTickets=" + numberOfPurchasedTickets +
                '}';
    }
}
