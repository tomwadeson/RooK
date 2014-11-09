package io.tew88.rook.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private int id;
    private String name;
    private String email;
    
    public User(final int id, final String name, final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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
}