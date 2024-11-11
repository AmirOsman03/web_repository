package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Location {
    Long id;
    String name;
    String address;
    String capacity;
    String description;

    public Location(String name, String address, String capacity, String description) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
        this.id = (long) (Math.random() * 1000);
    }
}
