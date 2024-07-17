package org.example.dto;

import java.time.LocalDate;

public class PassengerDTO {
    public String name;
    public String surname;
    public String  patronymic;
    public LocalDate birthday;
    public String passportBirthCertificate;

    public PassengerDTO(){}
    public PassengerDTO(String name, String surname, String patronymic, LocalDate birthday, String passportBirthCertificate) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.passportBirthCertificate = passportBirthCertificate;
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

    public String getPassportBirthCertificate() {
        return passportBirthCertificate;
    }

    public void setPassportBirthCertificate(String passportBirthCertificate) {
        this.passportBirthCertificate = passportBirthCertificate;
    }
}
