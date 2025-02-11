package com.reservation.app.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events/{eventName}/tables")
public class TableController {

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Table> createTable(@PathVariable String eventName, @RequestBody Table table) {
        // Code to create a table for a specific event
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTable(@PathVariable String eventName, @RequestBody Table table) {
        // Code to delete a specific table from an event
    }

    @PostMapping("/{tableId}/claim")
    @PreAuthorize("hasRole('HOST')")
    public ResponseEntity<Void> claimTable(@PathVariable String eventName, @PathVariable Integer tableId, @RequestBody String password) {
        // Code to claim a table as host
    }

    @PostMapping("/{tableId}/join")
    public ResponseEntity<Void> joinTable(@PathVariable String eventName, @PathVariable Integer tableId, @RequestBody String password) {
        // Code to join a table as a guest
    }

    @PutMapping("/{tableId}/password")
    @PreAuthorize("hasRole('HOST')")
    public ResponseEntity<Void> changeTablePassword(@PathVariable String eventName, @PathVariable Integer tableId, @RequestBody String password) {
        // Code to change table password
    }

    @DeleteMapping("/{tableId}/guests/{guestId}")
    @PreAuthorize("hasRole('HOST') or hasRole('ADMIN')")
    public ResponseEntity<Void> removeGuestFromTable(@PathVariable String eventName, @PathVariable Integer tableId, @PathVariable String guestId) {
        // Code to remove a guest from a table
    }
}
