package cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class Ticket {

    UUID token;

    Seat ticket;

    public Ticket(UUID token, Seat ticket) {
        this.token = token;
        this.ticket = ticket;
    }
    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getTicket() {
        return ticket;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "token=" + token +
                ", ticket=" + ticket +
                '}';
    }

}
