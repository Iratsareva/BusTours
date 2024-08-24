package org.example.dto;

import java.time.LocalDate;

public class PassengerDTO {
    public Integer id;
    public String name;
    public String surname;
    public String  patronymic;
    public LocalDate birthday;
    public String identification_document;

    public PassengerDTO(){}
    public PassengerDTO( Integer id, String name, String surname, String patronymic, LocalDate birthday, String identification_document) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.identification_document = identification_document;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIdentification_document() {
        return identification_document;
    }

    public void setIdentification_document(String identification_document) {
        this.identification_document = identification_document;
    }
}
