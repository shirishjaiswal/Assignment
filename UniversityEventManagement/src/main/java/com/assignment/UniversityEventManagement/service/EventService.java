package com.assignment.UniversityEventManagement.service;

import com.assignment.UniversityEventManagement.model.Event;
import com.assignment.UniversityEventManagement.repository.IEventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EventService {
    @Autowired
    IEventRepo eventRepo;

//    public String updateEvent () {
//
//    }

    public String addEvent (Event event) {
        Event event1 = eventRepo.save(event);
        if(event1 != null) {
            return "Event saved SuccessFully";
        }
        return "Event Not Saved";
    }

    public String deleteEvent (String id) {
        eventRepo.deleteById(Integer.parseInt(id));
        if(!eventRepo.existsById(Integer.parseInt(id))){
            return "Event with id " + id + " has been deleted";
        }
        return "Event with id " + id + " has not been deleted";
    }

    public Iterable<Event> getAllEventByDate (String date) {
        return eventRepo.getAllEventByDate(LocalDate.parse(date));
    }

    public String updateLocationById (String location, String id) {
        int noOfRowsAffected = eventRepo.updateEventSetLocationForId(location, Integer.parseInt(id));
        if(noOfRowsAffected > 0) {
            return "Updated";
        }
        return "not Updated";
    }

}
