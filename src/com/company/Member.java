package com.company;

public class Member extends Person {
    private LibraryCard libraryCard;
    public Member(int personID, String name, String address, String emailAddress, LibraryCard libraryCard) {
        super(personID, name, address, emailAddress);
        this.libraryCard = libraryCard;
    }

    public boolean getIsActive() {
        return libraryCard.isActive();
    }

    public void setIsActive(boolean activeStatus) {
        libraryCard.setActive(activeStatus);
    }
}
