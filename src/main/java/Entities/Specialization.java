package Entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "specialization", cascade = CascadeType.ALL)
    private List<User> doctors = new ArrayList<>();

    public Specialization() {}

    public Specialization(String name) {
        this.name = name;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<User> getDoctors() {
        return doctors;
    }
    public void setDoctors(List<User> doctors) {
        this.doctors = doctors;
    }
}
