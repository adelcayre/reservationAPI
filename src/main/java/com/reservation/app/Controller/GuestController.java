package com.reservation.app.Controller;
/**
import com.reservation.app.Data.Guest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events/{eventName}/register")
public class GuestController {

    @PostMapping
    public ResponseEntity<Guest> registerGuest(@PathVariable String eventName, @RequestBody Guest guest) {
        // Code to register a new guest for an event
    }

    @PostMapping("/login")
    public ResponseEntity<Guest> loginGuest(@PathVariable String eventName, @RequestBody Guest guest) {
        // Code to login a guest/host
    }
}
 */
