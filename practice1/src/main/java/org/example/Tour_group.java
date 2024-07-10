package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "tour_group")
public class Tour_group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tour_group")
    private int id_tour_group;

    @Id
    @Column(name = "id_passenger")
    private int id_passenger;

    @Id
    @Column(name = "id_tour")
    private int id_tour;

    public int getId_tour_group() {
        return id_tour_group;
    }

    public void setId_tour_group(int id_tour_group) {
        this.id_tour_group = id_tour_group;
    }

    public int getId_passenger() {
        return id_passenger;
    }

    public void setId_passenger(int id_passenger) {
        this.id_passenger = id_passenger;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }
}
