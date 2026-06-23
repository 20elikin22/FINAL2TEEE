package model;

import java.io.Serializable;
import enums.UserRole;

public abstract class User implements Serializable {

    protected int id;
    protected String name;
    protected String username;
    protected String password;
    protected UserRole role;

    public User(int id, String name, String username,
                String password, UserRole role) {

        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }

    public abstract int getBorrowLimit();
}