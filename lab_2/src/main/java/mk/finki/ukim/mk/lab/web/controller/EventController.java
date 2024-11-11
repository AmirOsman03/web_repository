package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.EventBooking;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.service.EventBookingService;
import mk.finki.ukim.mk.lab.service.EventService;
import mk.finki.ukim.mk.lab.service.LocationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;
    private final LocationService locationService;
    private final EventBookingService bookingService;

    public EventController(EventService eventService, LocationService locationService, EventBookingService bookingService) {
        this.eventService = eventService;
        this.locationService = locationService;
        this.bookingService = bookingService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        model.addAttribute("events", eventService.listAll());
        return "newEvents";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEvent(@PathVariable Long id) {
        this.eventService.deleteById(id);
        return "redirect:/events";
    }

    @GetMapping("event/add")
    public String addEventPage(Model model) {
        model.addAttribute("locations", locationService.findAll());
        model.addAttribute("events", eventService.listAll());
        return "add-event";
    }

    @GetMapping("/edit-event/{id}")
    public String editEventPage(Model model, @PathVariable Long id) {
        if (this.eventService.findById(id).isPresent()) {
            Event event = this.eventService.findById(id).get();
            model.addAttribute("event", event);
            model.addAttribute("locations", locationService.findAll());
            return "add-event";
        }
        return "redirect:/events?error=EventNotFound";
    }

    @PostMapping("/add")
    public String saveEvent(@RequestParam String name,
                            @RequestParam String description,
                            @RequestParam Double popularity,
                            @RequestParam Long locationId) {
     this.eventService.save(name, description, popularity, locationId);
     return "redirect:/events";
    }

    
}
