package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();

    List<Event> searchEvents(String text, double rating);

    public List<Event> listByCategory (String category);
}
