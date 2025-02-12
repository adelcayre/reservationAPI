package com.reservation.app.Data.Repository;

import com.reservation.app.Data.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {

    Optional<Event> findByTitle(String title);
    boolean existsByTitle(String title);
    long deleteByTitle(String title);
}
