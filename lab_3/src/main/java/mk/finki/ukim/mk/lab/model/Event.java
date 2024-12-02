package mk.finki.ukim.mk.lab.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
public class Event {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;

     String name;

     String description;

     double popularityScore;

     @ManyToOne
     @JoinColumn(name = "location_id", referencedColumnName = "id")
     Location location;

     public Event(String name, String description, double popularityScore, Location location) {
          this.name = name;
          this.description = description;
          this.popularityScore = popularityScore;
          this.location = location;
     }

     public Event() {}

}
