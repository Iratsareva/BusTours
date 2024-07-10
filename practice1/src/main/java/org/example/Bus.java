package org.example;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity @Table(name = "bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bus")
    private int id_bus;
    @Column(name = "mark")
    private String mark;
    @Column(name = "number_bus")
    private String number_bus;
    @Column(name = "number_seats")
    private Integer number_seats;
    @Column(name = "class_bus")
    private String class_bus;
    @Column(name = "year")
    private LocalDate year;
    public int getId_bus() {
        return id_bus;
    }
    public void setId_bus(int id_bus) {
        this.id_bus = id_bus;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getNumber_bus() {
        return number_bus;
    }

    public void setNumber_bus(String number_bus) {
        this.number_bus = number_bus;
    }

    public Integer getNumber_seats() {
        return number_seats;
    }

    public void setNumber_seats(Integer number_seats) {
        this.number_seats = number_seats;
    }

    public String getClass_bus() {
        return class_bus;
    }

    public void setClass_bus(String class_bus) {
        this.class_bus = class_bus;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
