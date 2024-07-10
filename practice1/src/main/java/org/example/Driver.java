package org.example;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity @Table(name = "driver")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_driver")
    private int id_driver;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "passport")
    private int passport;

    @Column(name = "driver_license")
    private int driver_license;

    @Column(name = "date_start_driver_license")
    private LocalDate date_start_driver_license;

    @Column(name = "category")
    private String category;


    public int getId_driver() {
        return id_driver;
    }

    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getPassport() {
        return passport;
    }

    public void setPassport(int passport) {
        this.passport = passport;
    }

    public int getDriver_license() {
        return driver_license;
    }

    public void setDriver_license(int driver_license) {
        this.driver_license = driver_license;
    }

    public LocalDate getDate_start_driver_license() {
        return date_start_driver_license;
    }

    public void setDate_start_driver_license(LocalDate date_start_driver_license) {
        this.date_start_driver_license = date_start_driver_license;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
