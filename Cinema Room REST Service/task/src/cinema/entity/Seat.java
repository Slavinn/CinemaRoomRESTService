package cinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class Seat {

    int row;
    int column;

    @JsonIgnore
    private final UUID token = randomUUID();

    @JsonIgnore
    boolean available;

    int price;

    public Seat() {
    }

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
        this.available = true;
        this.price = (row <= 4) ? 10: 8;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public UUID getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "row=" + row +
                ", column=" + column +
                ", available=" + available +
                ", price=" + price +
                '}';
    }

    public boolean equals(Seat seat) {
        if (this.getRow() != seat.getRow()) {
            return false;
        }
        if (this.getColumn() != seat.getColumn()) {
            return false;
        }
        return true;
    }

}
