package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryEventRepository {
    public List<Event> findAll() {
        return DataHolder.eventList;
    }

    public List<Event> searchEvents(String text, double rating) {
        return DataHolder.eventList.stream().filter(r->r.getName().equals(text) && r.getPopularityScore()<=rating).toList();
    }

    public List<Event> listByCategory (String category) {
        return DataHolder.eventList.stream().filter(r->r.getCategory().getName().equals(category)).toList();
    }
}
