package com.reservation.app.Controller;
import com.reservation.app.Data.Event;
import com.reservation.app.Exceptions.RecordUpdateException;
import com.reservation.app.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getEvents());
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createEvent(@RequestParam Event event) {
        try {
            return ResponseEntity.ok(eventService.addEvent(event));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateEvent(@RequestBody Event event) {
        try{
            return ResponseEntity.ok(eventService.updateEvent(event));
        }
        catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @GetMapping("/{eventName}")
    public ResponseEntity<Event> getEventDetails(@PathVariable String eventName) {
        try{
            return ResponseEntity.ok(eventService.getEvent(eventName));
        }
        catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{eventName}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteEvent(@PathVariable String eventName) {
        if(eventService.deleteEvent(eventName)){
            return ResponseEntity.noContent().build();
        }
        else return ResponseEntity.notFound().build();
    }
}
