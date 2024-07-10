package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity @Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_passenger")
    private int id_passenger;


    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String  patronymic;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "passport_birth_certificate")
    private String passport_birth_certificate;


    public int getId_passenger() {
        return id_passenger;
    }

    public void setId_passenger(int id_passenger) {
        this.id_passenger = id_passenger;
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

    public String getPassport_birth_certificate() {
        return passport_birth_certificate;
    }

    public void setPassport_birth_certificate(String passport_birth_certificate) {
        this.passport_birth_certificate = passport_birth_certificate;
    }
}
