package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> eventList = new ArrayList<>(10);

    @PostConstruct
    public void init() {
        eventList.add(new Event("Concert of Isen", "Live concert featuring Isen", 10, new Category("Music")));
        eventList.add(new Event("Amir's Birthday Party", "Celebration for Amir", 12, new Category("Music")));
        eventList.add(new Event("Amir's Birthday Party", "Annual technology conference", 15, new Category("Movies")));
        eventList.add(new Event("Amir's Birthday Party", "Showcasing local artists", 8, new Category("Sport")));
        eventList.add(new Event("Amir's Birthday Party", "A festival celebrating local cuisine", 20, new Category("Atlethics")));
        eventList.add(new Event("Amir's Birthday Party", "Annual marathon event", 25, new Category("blabla")));
    }

    //da se napravi kategorija za sekoj event i da se napravi filter za listanje na tie kategorii so koristenje na servlets i thymeleaf
    //primer muzicka kategorija da ima kopce i koga ke se stisne da izlezat eventite na taa muzicka kategorija
}
