package com.example.library.dto;

public class AuthResponse {
    private String token;
    private String role;

    // ✅ Constructor accepting both token and role
    public AuthResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    // ✅ Default constructor (needed for JSON serialization)
    public AuthResponse() {}

    // ✅ Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
