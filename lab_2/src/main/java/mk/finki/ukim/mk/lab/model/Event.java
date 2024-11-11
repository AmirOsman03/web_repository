package mk.finki.ukim.mk.lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Event {
     String name;
     String description;
     double popularityScore;
     Long id;
     Location location;

     public Event(String name, String description, double popularityScore, Location location) {
          this.name = name;
          this.description = description;
          this.popularityScore = popularityScore;
          this.location = location;
          this.id = (long) (Math.random()*1000);
     }
}
