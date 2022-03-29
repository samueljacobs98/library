package com.company;

public class Person {
    private long personID;
    private String name;
    private String address;
    private String emailAddress;

    public Person(long personID, String name, String address, String emailAddress) {
        this.personID = personID;
        this.name = name;
        this.address = address;
        this.emailAddress = emailAddress;
    }

    public long getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
