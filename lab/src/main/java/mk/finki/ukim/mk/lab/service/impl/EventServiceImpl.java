package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Category;
import mk.finki.ukim.mk.lab.model.Event;
import mk.finki.ukim.mk.lab.repository.InMemoryEventRepository;
import mk.finki.ukim.mk.lab.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final InMemoryEventRepository repository;

    public EventServiceImpl(InMemoryEventRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Event> listAll() {
        return repository.findAll();
    }

    @Override
    public List<Event> searchEvents(String text, double rating) {
        return repository.searchEvents(text, rating);
    }

    public List<Event> listByCategory (String category) {
        return repository.listByCategory(category);
    }
}
