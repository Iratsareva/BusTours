package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity @Table(name = "passenger")
public class Passenger extends BaseEntity{
    private String name;
    private String surname;
    private String  patronymic;
    private LocalDate birthday;
    private String passportBirthCertificate;



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


    @Column(name = "passport_birth_certificate")
    public String getPassportBirthCertificate() {
        return passportBirthCertificate;
    }
    public void setPassportBirthCertificate(String passportBirthCertificate) {
        this.passportBirthCertificate = passportBirthCertificate;
    }
}
