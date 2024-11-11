package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.model.Location;
import mk.finki.ukim.mk.lab.repository.InMemoryEventRepository;
import mk.finki.ukim.mk.lab.repository.InMemoryLocationRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    private final InMemoryEventRepository repository;
    private final InMemoryLocationRepository locationRepository;

    public EventServiceImpl(InMemoryEventRepository repository, InMemoryLocationRepository locationRepository) {
        this.repository = repository;
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Event> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text, double rating) {
        return repository.searchEvents(text, rating);
    }

    @Override
    public Optional<Event> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Event> findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public Optional<Event> save(String name, String description, double popularityScore, Long locationId) {
        Location location = locationRepository.findById(locationId).orElseThrow(IllegalArgumentException::new);
        return this.repository.saveOrUpdate(name, description, popularityScore, location);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
