package com.assignment.UniversityEventManagement.controller;

import com.assignment.UniversityEventManagement.model.Event;
import com.assignment.UniversityEventManagement.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/event")
public class EventController {
    @Autowired
    EventService eventService;

    @GetMapping(value = "/byDate/{date}")
    public Iterable<Event> getAllEventByDate(@PathVariable String date){
        return eventService.getAllEventByDate(date);
    }

    @DeleteMapping(value = "/byId/{id}")
    public String deleteEventById (@PathVariable String id) {
        return eventService.deleteEvent(id);
    }
    @PostMapping (value = "/insert")
    public String addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @PutMapping(value = "/location/{location}/for/{id}")
    public String updateEventLocationForId(@PathVariable String location, @PathVariable String id) {
        return eventService.updateLocationById(location, id);
    }
}
