package com.reservation.app.Implementation;

import com.reservation.app.Data.Event;
import com.reservation.app.Data.Repository.EventRepository;
import com.reservation.app.Exceptions.RecordUpdateException;
import com.reservation.app.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(String eventName) {
        return eventRepository.findByTitle(eventName)
                .orElseThrow();
    }

    @Override
    public Event addEvent(Event event) {
        if(eventRepository.existsByTitle(event.getTitle())) {
            throw new RecordUpdateException(0, "Event with title '" + event.getTitle() + "' already exists");
        } else if (event.getDateTime().isBefore(LocalDateTime.now())) {
            throw new RecordUpdateException(1, "Date of event must be in the future");
        } else{
            return eventRepository.save(event);
        }
    }

    @Override
    public Event updateEvent(Event event) {
        if(!eventRepository.existsById(event.getId())){
            throw new NoSuchElementException();
        }
        if(eventRepository.existsByTitle(event.getTitle())) {
            throw new RecordUpdateException(0, "Cannot change event title: event with title '" + event.getTitle() + "' already exists");
        } else if (event.getDateTime().isBefore(LocalDateTime.now())) {
            throw new RecordUpdateException(1, "Date of event must be in the future");
        } else{
            return eventRepository.save(event);
        }
    }

    @Override
    public boolean deleteEvent(String eventName) {
        if(eventRepository.deleteByTitle(eventName)==0){
            throw new NoSuchElementException();
        }
        return true;
    }
}
