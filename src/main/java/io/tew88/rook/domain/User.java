package io.tew88.rook.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private int id;
    private String name;
    private String email;
    private String passwordHash;
    
    public User(final int id, final String name, final String email, final String passwordHash) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
    }
    
    public User() {
    }

    @JsonProperty
    public int getId() {
        return id;
    }
    
    @JsonProperty
    public String getName() {
        return name;
    }
    
    @JsonProperty
    public String getEmail() {
        return email;
    }
    
    @JsonProperty
    public String getPasswordHash() {
        return passwordHash;
    }
}