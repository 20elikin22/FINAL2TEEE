package model;

import enums.UserRole;

public class Librarian extends User {

    public Librarian(int id, String name,
                     String username, String password) {

        super(id, name, username, password, UserRole.LIBRARIAN);
    }

    @Override
    public int getBorrowLimit() {
        return 10;
    }
}