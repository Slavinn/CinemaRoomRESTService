package cinema.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Refund {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    UUID token;

    Seat returned_ticket;

    public Refund() {
    }

    public Refund(UUID token, Seat returned_ticket) {
        this.token = token;
        this.returned_ticket = returned_ticket;
    }
    public UUID getToken() {
        return token;
    }


    public void setToken(UUID token) {
        this.token = token;
    }

    public Seat getReturned_ticket() {
        return returned_ticket;
    }

    public void setReturned_ticket(Seat returned_ticket) {
        this.returned_ticket = returned_ticket;
    }

    @Override
    public String toString() {
        return "Refund{" +
                "token=" + token +
                ", returned_ticket=" + returned_ticket +
                '}';
    }
}
