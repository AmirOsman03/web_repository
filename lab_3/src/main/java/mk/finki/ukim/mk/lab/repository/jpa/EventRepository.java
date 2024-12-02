package mk.finki.ukim.mk.lab.repository.jpa;

import jakarta.transaction.Transactional;
import mk.finki.ukim.mk.lab.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {
    Optional<Event> findByName(String name);

    List<Event> findAllByLocation_Id(Long locationId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Event e WHERE e.id = :id")
    void deleteByName(@Param("id") Long id);

    List<Event> searchEventsByName(String location);

//    @Query("SELECT e from  Event e where e.location.name = :locationName")
//    List<Event> searchEventsByLocation_Name(@Param("locationName") String locationName);
}
