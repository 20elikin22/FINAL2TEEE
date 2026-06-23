package model;

import enums.UserRole;

public class Student extends User {

    public Student(int id, String name,
                   String username, String password) {

        super(id, name, username, password, UserRole.STUDENT);
    }

    @Override
    public int getBorrowLimit() {
        return 5;
    }
}