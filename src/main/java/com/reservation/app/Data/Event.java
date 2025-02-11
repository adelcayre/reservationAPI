package com.reservation.app.Data;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // The primary key for the Event table

    private String title; // The title of the event

    private String dateTime; // The date and time of the event

    @OneToMany(mappedBy = "event")
    private List<Table> tables;

    // Constructors, getters, setters, and toString

    public Event() {}

    public Event(String title, String dateTime) {
        this.title = title;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateTime='" + dateTime + '\'' +
                '}';
    }
}
