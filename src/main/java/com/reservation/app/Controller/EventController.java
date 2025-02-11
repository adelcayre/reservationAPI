package com.reservation.app.Controller;
import com.reservation.app.Data.Event;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/events")
public class EventController {

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        // Code to fetch all events
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        // Code to create a new event
    }

    @GetMapping("/{eventName}")
    public ResponseEntity<EventDetails> getEventDetails(@PathVariable String eventName) {
        // Code to fetch event details along with tables
    }

    @DeleteMapping("/{eventName}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteEvent(@PathVariable String eventName) {
        // Code to delete event
    }
}
