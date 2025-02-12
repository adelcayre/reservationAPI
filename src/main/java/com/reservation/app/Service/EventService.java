package com.reservation.app.Service;

import com.reservation.app.Data.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {



    public List<Event> getEvents();

    public Event getEvent(String eventName);

    public Event addEvent (Event event);

    public Event updateEvent(Event event);

    public boolean deleteEvent(String eventName);


}
