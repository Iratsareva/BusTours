package org.example.dto;

import java.time.LocalDate;

public class DriverDTO {
    public String name;
    public String surname;
    public String patronymic;
    public LocalDate birthday;
    public String passport;
    public String driverLicense;
    public LocalDate dateStartDriverLicense;
    public String category;

    protected DriverDTO(){}
    public DriverDTO(String name, String surname, String patronymic, LocalDate birthday, String passport, String driverLicense, LocalDate dateStartDriverLicense, String category) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.passport = passport;
        this.driverLicense = driverLicense;
        this.dateStartDriverLicense = dateStartDriverLicense;
        this.category = category;
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

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public LocalDate getDateStartDriverLicense() {
        return dateStartDriverLicense;
    }

    public void setDateStartDriverLicense(LocalDate dateStartDriverLicense) {
        this.dateStartDriverLicense = dateStartDriverLicense;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
