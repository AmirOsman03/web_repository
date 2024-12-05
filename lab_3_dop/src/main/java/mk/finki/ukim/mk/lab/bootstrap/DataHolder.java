package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> eventList = new ArrayList<>(10);
    public static List<Location> locations = new ArrayList<>(5);

    @PostConstruct
    public void init() {
//        Location location = new Location("Skopje", "Ul.Rugjer Boskovik", "150", "Rugjer Boskovik desc");
//        locations.add(location);
//        eventList.add(new Event("Concert of Isen", "Live concert featuring Isen", 10, location));
//        eventList.add(new Event("Amir's Birthday Party", "Celebration for Amir", 12, location));
//        eventList.add(new Event("Amir's Birthday Party", "Annual technology conference", 15, location));
//        eventList.add(new Event("Amir's Birthday Party", "Showcasing local artists", 8, location));
//        eventList.add(new Event("Amir's Birthday Party", "A festival celebrating local cuisine", 20, location));
//        eventList.add(new Event("Amir's Birthday Party", "Annual marathon event", 25, location));
    }

    //da se napravi kategorija za sekoj event i da se napravi filter za listanje na tie kategorii so koristenje na servlets i thymeleaf
    //primer muzicka kategorija da ima kopce i koga ke se stisne da izlezat eventite na taa muzicka kategorija
}
