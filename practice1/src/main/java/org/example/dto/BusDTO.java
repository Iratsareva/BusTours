package org.example.dto;

import java.time.LocalDate;


public class BusDTO {
    public Integer id;
    public String mark;
    public String numberBus;
    public Integer numberSeats;
    public String classBus;
    public LocalDate year;

    protected BusDTO (){}

    public BusDTO(Integer id, String mark, String numberBus, Integer numberSeats, String classBus, LocalDate year) {
        this.id = id;
        this.mark = mark;
        this.numberBus = numberBus;
        this.numberSeats = numberSeats;
        this.classBus = classBus;
        this.year = year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getNumberBus() {
        return numberBus;
    }

    public void setNumberBus(String numberBus) {
        this.numberBus = numberBus;
    }

    public Integer getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(Integer numberSeats) {
        this.numberSeats = numberSeats;
    }

    public String getClassBus() {
        return classBus;
    }

    public void setClassBus(String classBus) {
        this.classBus = classBus;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
