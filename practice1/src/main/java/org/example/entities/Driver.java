package org.example.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity @Table(name = "driver")
public class Driver extends BaseEntity{
    private String name;
    private String surname;
    private String patronymic;
    private LocalDate birthday;
    private int passport;
    private int driverLicense;
    private LocalDate dateStartDriverLicense;
    private String category;

    private Set<Trip> trips;

    public Driver(String name, String surname, String patronymic, LocalDate birthday, int passport, int driverLicense, LocalDate dateStartDriverLicense, String category) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.passport = passport;
        this.driverLicense = driverLicense;
        this.dateStartDriverLicense = dateStartDriverLicense;
        this.category = category;
    }

    protected Driver(){}

    @Column(name = "name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }


    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    @Column(name = "birthday")
    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Column(name = "passport")
    public int getPassport() {
        return passport;
    }
    public void setPassport(int passport) {
        this.passport = passport;
    }


    @Column(name = "driver_license")
    public int getDriverLicense() {
        return driverLicense;
    }
    public void setDriverLicense(int driverLicense) {
        this.driverLicense = driverLicense;
    }


    @Column(name = "date_start_driver_license")
    public LocalDate getDateStartDriverLicense() {
        return dateStartDriverLicense;
    }
    public void setDateStartDriverLicense(LocalDate dateStartDriverLicense) {
        this.dateStartDriverLicense = dateStartDriverLicense;
    }


    @Column(name = "category")
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "driver", targetEntity = Trip.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Trip> getTrips() {
        return trips;
    }

    public void setTrips(Set<Trip> trips) {
        this.trips = trips;
    }
}
