package com.company;

public class LibraryCard {
    private boolean active;

    public LibraryCard(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
