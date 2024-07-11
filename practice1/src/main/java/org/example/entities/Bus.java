package org.example.entities;
import jakarta.persistence.*;
import java.time.LocalDate;


@Entity @Table(name = "bus")
public class Bus extends BaseEntity {
    private String mark;
    private String numberBus;
    private Integer numberSeats;
    private String classBus;
    private LocalDate year;







    @Column(name = "mark")
    public String getMark() {
        return mark;
    }
    public void setMark(String mark) {
        this.mark = mark;
    }


    @Column(name = "number_bus")
    public String getNumberBus() {
        return numberBus;
    }
    public void setNumberBus(String numberBus) {
        this.numberBus = numberBus;
    }


    @Column(name = "number_seats")
    public Integer getNumberSeats() {
        return numberSeats;
    }
    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }


    @Column(name = "class_bus")
    public String getClassBus() {
        return classBus;
    }
    public void setClassBus(String classBus) {
        this.classBus = classBus;
    }


    @Column(name = "year")
    public LocalDate getYear() {
        return year;
    }
    public void setYear(LocalDate year) {
        this.year = year;
    }
}
