
package com.example.demo.Entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role {

    USER("Пользователь"),

    ADMIN("Администратор");

    private final String name;

    Role(String name) { this.name = name; }

    public String getName() { return name; }
}

