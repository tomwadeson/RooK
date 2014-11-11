package io.tew88.rook.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private final int id;
    private final String name;
    private final String email;
    
    @JsonCreator
    public User(@JsonProperty("id") final int id, @JsonProperty("name") final String name, @JsonProperty("email") final String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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