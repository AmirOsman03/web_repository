package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> listAll();

    List<Event> searchEvents(String text, double rating);

    Optional<Event> findById(Long id);

    Optional<Event> findByName(String name);

    Optional<Event> save(String name, String description, double popularityScore, Long locationId);

    void deleteById(Long id);
}
