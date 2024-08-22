package org.example.domain;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity @Table(name = "passenger")
public class Passenger extends BaseEntity{
    private String name;
    private String surname;
    private String  patronymic;
    private LocalDate birthday;
    private String passportBirthCertificate;

    private Set<Ticket> tickets;

    public Passenger(String name, String surname, String patronymic, LocalDate birthday, String passportBirthCertificate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.passportBirthCertificate = passportBirthCertificate;
    }

    protected Passenger(){}

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


    @Column(name = "passport_birth_certificate", length = 10)
    public String getPassportBirthCertificate() {
        return passportBirthCertificate;
    }
    public void setPassportBirthCertificate(String passportBirthCertificate) {
        this.passportBirthCertificate = passportBirthCertificate;
    }


    @OneToMany(mappedBy = "passenger", targetEntity = Ticket.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
