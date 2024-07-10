package org.example;

import jakarta.persistence.*;

@Entity @Table(name = "bus_driver_tour")
public class Bus_driver_tour {

    @Id
    @Column(name = "id_tour")
    private int id_tour;

    @Id
    @Column(name = "id_bus")
    private int id_bus;

    @Id
    @Column(name = "id_driver")
    private int id_driver;



    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public int getId_bus() {
        return id_bus;
    }

    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public int getId_driver() {
        return id_driver;
    }

    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
    }
}
