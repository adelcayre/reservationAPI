package com.reservation.app.Data;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    private int capacity;

    private String password;

    @OneToOne
    @JoinColumn(name = "host_id")
    private Guest host;

    @OneToMany(mappedBy = "table")
    private List<Guest> guests;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    // Constructors, getters, setters

    public Table() {}

    public Table(int capacity, Event event) {
        this.capacity = capacity;
        this.event = event;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Guest getHost() {
        return host;
    }

    public void setHost(Guest host) {
        this.host = host;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
