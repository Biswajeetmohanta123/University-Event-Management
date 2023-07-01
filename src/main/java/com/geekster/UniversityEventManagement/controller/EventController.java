package com.geekster.UniversityEventManagement.controller;

import com.geekster.UniversityEventManagement.model.Event;
import com.geekster.UniversityEventManagement.service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping(value = "/getAll")
    public List<Event> getAllEvents(){
        return eventService.getAllEvent();
    }

    @GetMapping("/date/{date}")
    public List<Event> getEventByDate(@PathVariable String date){
        LocalDate localDate = LocalDate.parse(date);
        return eventService.getEventByDate(localDate);
    }

    @PostMapping(value = "/addEvents")
    public String addEvent(@Valid @RequestBody List<Event> events) {
        return eventService.addEvent(events);
    }

    @PutMapping(value = "/updateInfo")
    public String updateEventByEventId(@RequestBody Event event){
        return eventService.updateEvent(event);
    }

    @DeleteMapping("/{eventId}")
    public String deleteEventByEventId(@PathVariable int eventId){
        return eventService.deleteEventByEventId(eventId);
    }
}
