package mk.finki.ukim.mk.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.jpa.EventRepository;
import mk.finki.ukim.mk.lab.repository.jpa.LocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository repository, LocationRepository locationRepository) {
        this.repository = repository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Event> searchEventsByLocation_Id(Long locationId) {
        return this.repository.findAllByLocation_Id(locationId);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Event> findByName(String name) {
        return repository.findByName(name);
    }


    @Transactional
    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long locationId) {
        Location location = locationRepository.findById(locationId)
                .orElseThrow(() -> new IllegalArgumentException("Location not found with id: " + locationId));

        Event event = new Event(name, description, popularityScore, location);

        return Optional.of(repository.save(event));
    }



    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Event> update(Long id, String name, String description, double popularityScore, Long locationId) {
        Event event = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Event not found with id: " + id));
        Location location = this.locationRepository.findById(locationId).orElseThrow(() -> new IllegalArgumentException("Location not found with id: " + locationId));
        event.setName(name);
        event.setDescription(description);
        event.setPopularityScore(popularityScore);
        event.setLocation(location);

        return Optional.of(repository.save(event));
    }

    @Override
    public List<Event> searchEventsByLocation_Name(Long locationId) {
        return this.repository.findAllByLocation_Id(locationId);
    }
}